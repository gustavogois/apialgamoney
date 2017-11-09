package com.example.algamoney.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		
		adicionarMethodLocation(recursoCriadoEvent.getResponse(), recursoCriadoEvent.getCodigo());
	}

	private void adicionarMethodLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").
				buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
