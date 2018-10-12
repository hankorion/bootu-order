package com.durain.bootuorder.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.durain.bootuorder.dataobject.GameInfo;
import com.durain.bootuorder.dto.CartDTO;

@FeignClient(name = "DURAIN-GAMES")
public interface GameServiceClient {

	@GetMapping("/game/msg")
	String gameMsg();
	
	@PostMapping("/game/listFromOrder")
	public List<GameInfo> listFromOrder(@RequestBody List<String> productIdList);
	
	@PostMapping("/game/decreaseGameStock")
	public void decreaseGameStock(@RequestBody List<CartDTO> cardDTOList);
}
