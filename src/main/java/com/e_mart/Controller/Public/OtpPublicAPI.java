package com.e_mart.Controller.Public;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.Entity.User.MyUser;
import com.e_mart.Service.EmailService;
import com.e_mart.Service.MyUserService;

@RestController
@RequestMapping("/public/otp")
public class OtpPublicAPI {

    @Autowired
    private MyUserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // In-memory store for OTPs: email -> otp
    private final Map<String, String> otpCache = new ConcurrentHashMap<>();

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody Map<String, String> request) {
        String identifier = request.get("email");
        if (identifier == null || identifier.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email or Username is required!");
        }

        identifier = identifier.trim().toLowerCase();
        MyUser user = userService.getUserByEmail(identifier);
        if (user == null) {
            user = userService.getUserByUsername(identifier);
        }

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User account not found!");
        }

        String recipientEmail = user.getEmail();
        if (recipientEmail == null || recipientEmail.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("No valid email registered for this account.");
        }

        // Generate 6-digit OTP
        String otp = String.format("%06d", new Random().nextInt(900000) + 100000);
        otpCache.put(recipientEmail.toLowerCase(), otp);

        // Send email via JavaMailSender
        boolean emailSent = emailService.sendOtpEmail(recipientEmail, otp);

        if (emailSent) {
            return ResponseEntity.ok("Real OTP sent successfully to your Gmail inbox (" + recipientEmail + ")!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send OTP to Gmail inbox. Please check server SMTP configuration.");
        }
    }

    @PostMapping("/verify-reset-password")
    public ResponseEntity<?> verifyAndResetPassword(@RequestBody Map<String, String> request) {
        String identifier = request.get("email");
        String enteredOtp = request.get("otp");
        String newPassword = request.get("newPassword");

        if (identifier == null || enteredOtp == null || newPassword == null) {
            return ResponseEntity.badRequest().body("All fields (email, otp, newPassword) are required!");
        }

        identifier = identifier.trim().toLowerCase();
        MyUser user = userService.getUserByEmail(identifier);
        if (user == null) {
            user = userService.getUserByUsername(identifier);
        }

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

        String cachedOtp = otpCache.get(user.getEmail().toLowerCase());

        if (cachedOtp == null || !cachedOtp.equals(enteredOtp.trim())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP!");
        }

        // OTP is valid - reset password
        user.setPassword(passwordEncoder.encode(newPassword));
        userService.addNewUser(user);

        // Remove OTP from cache
        otpCache.remove(user.getEmail().toLowerCase());

        return ResponseEntity.ok("Password reset successfully! You can now login with your new password.");
    }
}
