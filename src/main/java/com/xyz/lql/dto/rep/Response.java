package com.xyz.lql.dto.rep;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lql
 * @Description: 数据响应类
 * 响应格式：{
 *   "data": {},
 *   "errCode": 0,
 *   "errMsg": "请求成功"
 * }
 * @date 2019-1-30 16:24
 */
@Getter
@Setter
// 排除空数据
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Response {
	//请求成功返回码为：0
	private static final Integer successCode = 0;
	//返回数据
	private Object data;
	//返回码
	private Integer errCode;
	//返回描述
	private String errMsg;

	public Response(Object o){
		this.errCode = successCode;
		this.errMsg = "请求成功";
		this.data = o;
	}
}
