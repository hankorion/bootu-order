package com.durain.bootuorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durain.bootuorder.client.GameServiceClient;

@RestController
public class GameClientController {

	@Autowired
	private GameServiceClient gameServiceClient;

	@GetMapping("/getGameMsg")
	public String getGameMsg() {
		return gameServiceClient.gameMsg();
	}
}
