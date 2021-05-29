package com.jamesmcgarr.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class JwtApplication {

	@Value("${defaultUser}")
	private String defaultUser;

	@Value("${defaultPass}")
	private String defaultPass;

	@Bean
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder()
					.username(defaultUser)
					.password(defaultPass)
					.roles("USER")
					.build());
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
