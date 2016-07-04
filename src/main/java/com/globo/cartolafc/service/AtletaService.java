package com.globo.cartolafc.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.globo.cartolafc.domain.AtletaResponse;
import com.globo.cartolafc.domain.LoginRequest;
import com.globo.cartolafc.repository.AtletaRepository;

@Order(value = 1)
@Controller
public class AtletaService implements CommandLineRunner {
    
    private static final String HEADER_TOKEN = "X-GLB-Token";

	@Autowired
    private LoginService loginService;
	@Autowired
	private AtletaRepository atletaRepository;

    private static final Logger LOG = Logger.getLogger(AtletaService.class);
    private static final String URL = "https://api.cartolafc.globo.com/atletas/mercado";

	@Override
	public void run(String... args) throws Exception {
		String token = loginService.getToken();
		LOG.info("TOKEN: " + token);
		LOG.info("CONSULTANDO ATLETAS");
		HttpHeaders requestHeaders = new HttpHeaders();
    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    	requestHeaders.set(HEADER_TOKEN, token);
    	RestTemplate restTemplate = new RestTemplate();
		HttpEntity<LoginRequest> request = new HttpEntity<>(null, requestHeaders);
    	ResponseEntity<AtletaResponse> atletaResponse = restTemplate.postForEntity(URL, request, AtletaResponse.class);
    	LOG.info("SALVANDO ATLETAS");
    	atletaRepository.save(atletaResponse.getBody().getAtletas());
	}

}