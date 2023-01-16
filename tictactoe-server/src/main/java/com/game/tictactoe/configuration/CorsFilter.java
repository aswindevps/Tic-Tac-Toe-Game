package com.game.tictactoe.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        httpResponse.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "OPTIONS, GET, POST, DELETE, PUT, PATCH");
        httpResponse.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Authorization");


        if (!"OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            filterChain.doFilter(request, response);
        }
    }
}
