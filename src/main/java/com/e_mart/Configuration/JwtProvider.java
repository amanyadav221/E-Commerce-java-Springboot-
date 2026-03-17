package com.e_mart.Configuration;

import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
	private SecretKey key=Keys.hmacShaKeyFor(JwtConstant.secretKey.getBytes());
	
	public String generateToken(Authentication auth) {
		
		Collection<? extends GrantedAuthority> authorities=auth.getAuthorities();
		String roles=populateAuthorities(authorities);
//		String jwt=Jwts.builder().setIssuedAt(new Date(0))
//				.setExpiration((new Date(new Date(0).getTime()+86400000)))
//				.claim("username", auth.getName())
//				.claim("authorities", roles)
//				.signWith(key)
//				.compact();
		System.out.println("Name from jwt provider "+auth.getPrincipal());
		String jwt=Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .claim("username", auth.getName())
                .claim("authorities", populateAuthorities(auth.getAuthorities()))
                .signWith(key)
                .compact();
		return jwt;
	}
	
	private String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
		Set<String> auth=new HashSet<>();
		for(GrantedAuthority authority : authorities) {
			auth.add(authority.getAuthority());
		}
		return String.join(",",auth);
	}
	public String getUsernameFromJwtToken(String jwt) {
		jwt=jwt.substring(7);
		Claims claims=Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		return String.valueOf(claims.get("username"));
		
	}

}
