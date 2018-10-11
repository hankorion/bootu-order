package com.durain.bootuorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "DURAIN-GAMES")
public interface GameServiceClient {

	@GetMapping("/game/msg")
	String gameMsg();
}
