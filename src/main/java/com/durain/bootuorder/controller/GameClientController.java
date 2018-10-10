package com.durain.bootuorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GameClientController {

	// Option 2
//	@Autowired
//	private LoadBalancerClient loandBalancerClient;

	// Option 3
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getGameMsg")
	public String getGameMsg() {

		// Optiion 1
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject("http://localhost:8080/game/msg", String.class);

		// Option 2
//		RestTemplate restTemplate = new RestTemplate();
//		ServiceInstance serviceInstance = loandBalancerClient.choose("DURAIN-GAMES");
//		String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort())+"/game/msg";
//		String result = restTemplate.getForObject(url, String.class);

		// option 3 (use @LoadBalanced for RestTemplateConfig)
		String result = restTemplate.getForObject("http://DURAIN-GAMES/game/msg", String.class);

		return result;
	}
}
