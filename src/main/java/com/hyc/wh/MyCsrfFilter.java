//package com.hyc.wh;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
////@Component
////@WebFilter
//public class MyCsrfFilter extends OncePerRequestFilter {
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//		if (csrf != null) {
//			Cookie cookie = null;
//			Cookie cookies[] = request.getCookies();
//			for (Cookie cookiee : cookies) {
//				if (cookiee.getName().equals("X-CSRF-TOKEN")) {
//					cookie = cookiee;
//				}
//			}
//			String token = csrf.getToken();
//			if (cookie == null || token != null && !token.equals(cookie.getValue())) {
//				cookie = new Cookie("X-CSRF-TOKEN", token);
//				cookie.setPath("/");
//				response.addCookie(cookie);
//			}
//			filterChain.doFilter(request, response);
//		}
//
//	}
//
//}
