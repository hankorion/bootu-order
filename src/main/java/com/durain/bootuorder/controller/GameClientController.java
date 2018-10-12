package com.durain.bootuorder.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durain.bootuorder.client.GameServiceClient;
import com.durain.bootuorder.dataobject.GameInfo;
import com.durain.bootuorder.dto.CartDTO;

@RestController
public class GameClientController {

	@Autowired
	private GameServiceClient gameServiceClient;

	@GetMapping("/getGameMsg")
	public String getGameMsg() {
		return gameServiceClient.gameMsg();
	}

	@GetMapping("/listFromOrder")
	public String listFromOrder() {

		List<GameInfo> gameInfoList = gameServiceClient
				.listFromOrder(Arrays.asList("Blizzard Entertainment - Diablo III"));

		return "" + gameInfoList.size();
	}

	@GetMapping("/gameDecreaseStock")
	public String gameDecreaseStock() {
		CartDTO cardto = new CartDTO("Blizzard Entertainment - Diablo III", 1);
		gameServiceClient.decreaseGameStock(Arrays.asList(cardto));
		return "ok";
	}
}
