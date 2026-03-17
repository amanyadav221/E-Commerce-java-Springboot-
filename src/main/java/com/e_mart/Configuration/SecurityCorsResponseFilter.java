package com.e_mart.Configuration;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Integer.MIN_VALUE)
public class SecurityCorsResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,,PATCH,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(req, res);
    }
}
