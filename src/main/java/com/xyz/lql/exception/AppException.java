package com.xyz.lql.exception;

/**
 * 业务异常类
 * @author lql
 * @Description: TODO
 * @date 2019-1-30 15:21
 */
public class AppException extends RuntimeException {
	private Integer errCode;
	private String errMsg;

	public AppException(Integer errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
