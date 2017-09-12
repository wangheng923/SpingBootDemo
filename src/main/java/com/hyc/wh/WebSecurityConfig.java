package com.hyc.wh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.google.gson.Gson;
import com.hyc.wh.entity.ResponseDto;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationProvider myAuthentication;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
				.authenticationProvider(myAuthentication)
				// .addFilter(new MyFilter())
				.exceptionHandling()
				.accessDeniedHandler(new accessDeniedHandler())
				.and().authorizeRequests()
				.antMatchers("/", "/login.html", "/js/*").permitAll()
				.antMatchers("/successAction").hasAuthority("user_view")
				.antMatchers("/user/modify").hasAuthority("user_modify")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/")
				// .failureHandler(authenticationFailureHandler)
				.loginProcessingUrl("/loginAction").defaultSuccessUrl("/successAction")
				// .permitAll()
				.and().logout().logoutUrl("/logout");
		;
		super.configure(http);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication()
		// .withUser("u").password("u").roles("USER")
		// .and().withUser("admin").password("admin").roles("ADMIN");
	}

	private class accessDeniedHandler implements AccessDeniedHandler {

		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response,
				AccessDeniedException accessDeniedException) throws IOException, ServletException {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			response.setStatus(HttpStatus.OK.value());
			response.getWriter().append(new Gson().toJson(new ResponseDto(403, "无权限")));
		}
	};
}
