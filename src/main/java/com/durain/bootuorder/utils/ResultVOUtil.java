package com.durain.bootuorder.utils;

import com.durain.bootuorder.VO.ResultVO;

public class ResultVOUtil {
	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("success");
		resultVO.setData(object);
		return resultVO;
	}
}
