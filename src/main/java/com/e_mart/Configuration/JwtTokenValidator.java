
package com.e_mart.Configuration;

import java.io.IOException;
import java.util.List;

import javax.crypto.SecretKey;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtTokenValidator extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/auth") || path.startsWith("/public");
    }
    

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
    	if (request.getServletPath().equals("/error")) {
    	    chain.doFilter(request, response);
    	    return;
    	}
    	 if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
    	        chain.doFilter(request, response);
    	        return;
    	    }

        String header = request.getHeader("Authorization");
        System.out.println(header);
        if (header != null && header.startsWith("Bearer ")) {
            try {
                String token = header.substring(7);
                SecretKey key = Keys.hmacShaKeyFor(JwtConstant.secretKey.getBytes());
                System.out.println("Testing 1");
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
                
                System.out.println("Testing...2");
                String username = claims.get("username", String.class);
                String roles = claims.get("authorities", String.class);
                
                List<GrantedAuthority> authorities =
                        AuthorityUtils.commaSeparatedStringToAuthorityList(roles);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username, null, authorities);

               SecurityContext context = SecurityContextHolder.createEmptyContext();
                context.setAuthentication(auth);
                SecurityContextHolder.setContext(context);
                System.out.println("PATCH Authenticated User: " + SecurityContextHolder.getContext().getAuthentication());
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
            	System.out.println(e.getMessage());
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
