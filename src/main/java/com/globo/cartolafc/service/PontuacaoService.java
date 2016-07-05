package com.globo.cartolafc.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.globo.cartolafc.domain.Atleta;
import com.globo.cartolafc.domain.LoginRequest;
import com.globo.cartolafc.domain.Pontuacao;
import com.globo.cartolafc.repository.AtletaRepository;
import com.globo.cartolafc.repository.PontuacaoRepository;

@Order(value = 2)
@Controller
public class PontuacaoService implements CommandLineRunner {
    
    private static final String HEADER_TOKEN = "X-GLB-Token";

	@Autowired
    private LoginService loginService;
	@Autowired
	private AtletaRepository atletaRepository;
	@Autowired
	private PontuacaoRepository pontuacaoRepository;

    private static final Logger LOG = Logger.getLogger(PontuacaoService.class);
    private static final String URL = "https://api.cartolafc.globo.com/auth/mercado/atleta/%s/pontuacao";

	@Override
	public void run(String... args) throws Exception {
		String token = loginService.getToken();
		LOG.info("TOKEN: " + token);
		
		HttpHeaders requestHeaders = new HttpHeaders();
    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    	requestHeaders.set(HEADER_TOKEN, token);
    	RestTemplate restTemplate = new RestTemplate();
		HttpEntity<LoginRequest> request = new HttpEntity<>(null, requestHeaders);
		List<Atleta> atletas = atletaRepository.findAll();
		for(Atleta atleta : atletas) {
			String newUrl = String.format(URL, atleta.getId());
			LOG.info("NEW URL: " + newUrl);
			try {
				ResponseEntity<List<Pontuacao>> pontuacaoResponse = restTemplate.exchange(newUrl, HttpMethod.GET, request, new ParameterizedTypeReference<List<Pontuacao>>(){});
				for (Pontuacao pontuacao : pontuacaoResponse.getBody()) {
					pontuacao.setAtleta(atleta);
				}
				pontuacaoRepository.save(pontuacaoResponse.getBody());
			} catch (Exception ex){
				LOG.warn(String.format("ATLETA %s NÃO ENCONTRADO", atleta.getId()));
			}
		}
	}

}