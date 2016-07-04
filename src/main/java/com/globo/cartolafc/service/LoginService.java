package com.globo.cartolafc.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.globo.cartolafc.domain.LoginRequest;
import com.globo.cartolafc.domain.LoginResponse;

@Controller
public class LoginService {
    
    private static final String URL = "https://login.globo.com/api/authentication";
    private static final Logger LOG = Logger.getLogger(LoginService.class);
    @Autowired
    private Environment environment;

    public String getToken() {
    	LOG.info("EFETUANDO LOGIN");
    	HttpHeaders requestHeaders = new HttpHeaders();
    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    	RestTemplate restTemplate = new RestTemplate();
    	LoginRequest loginRequest = new LoginRequest();
    	loginRequest.setEmail(environment.getProperty("cartola.email"));
    	loginRequest.setPassword(environment.getProperty("cartola.password"));
		HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, requestHeaders);
    	LoginResponse loginResponse = restTemplate.postForObject(URL, request, LoginResponse.class);
    	return loginResponse.getGlbId();
    }
}