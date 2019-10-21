package com.xyz.lql.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常类，只要作用在@RequestMapping上，所有的异常都会被捕获
 *
 * @author lql
 * @Description: TODO
 * @date 2019-1-30 15:25
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionAdvice {
	private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity errorHandle(Exception e) {
		e.printStackTrace();
		logger.error(e.getMessage(), e);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errCode", -1);
		if (e instanceof HttpRequestMethodNotSupportedException) {
			map.put("errMsg", "运行错误:请求方法不支持");
		} else if (e instanceof MissingServletRequestParameterException) {
			map.put("errMsg", "运行错误:请求参数不完整");
		} else if (e instanceof NullPointerException) {
			map.put("errMsg", "运行错误:空值异常");
		} else {
			map.put("errMsg", "运行错误:其他运行错误");
		}
		return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = AppException.class)
	public Map<String, Object> errorHandle(AppException e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errCode", e.getErrCode());
		map.put("errMsg", e.getErrMsg());
		logger.error(e.getErrMsg());
		logger.error(e.getMessage(), e);
		return map;
	}
}
