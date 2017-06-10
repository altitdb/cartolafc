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
import com.globo.cartolafc.domain.Destaque;
import com.globo.cartolafc.domain.LoginRequest;
import com.globo.cartolafc.repository.AtletaRepository;
import com.globo.cartolafc.repository.DestaqueRepository;

@Order(value = 3)
@Controller
public class DestaqueService implements CommandLineRunner {
    
	@Autowired
	private AtletaRepository atletaRepository;
	@Autowired
	private DestaqueRepository destaqueRepository;

    private static final Logger LOG = Logger.getLogger(DestaqueService.class);
    private static final String URL = "https://api.cartolafc.globo.com/mercado/destaques";

	@Override
	public void run(String... args) throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    	RestTemplate restTemplate = new RestTemplate();
		HttpEntity<LoginRequest> request = new HttpEntity<>(null, requestHeaders);
		try {
			ResponseEntity<List<Destaque>> pontuacaoResponse = restTemplate.exchange(URL, HttpMethod.GET, request, new ParameterizedTypeReference<List<Destaque>>(){});
			destaqueRepository.deleteAll();
			Long posicao = 1L;
			for (Destaque destaque : pontuacaoResponse.getBody()) {
			    destaque.setId(posicao);
			    Atleta atletaAtualizado = atletaRepository.findByNome(destaque.getAtleta().getNome());
			    destaque.setAtleta(atletaAtualizado);
				destaqueRepository.save(destaque);
				posicao++;
			}
		} catch (Exception ex){
			LOG.warn("ERRO AO SALVAR DESTAQUE", ex);
		}
	}

}