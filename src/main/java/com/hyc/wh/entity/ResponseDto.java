package com.hyc.wh.entity;

public class ResponseDto {

	private int errCode;

	private String errMsg;

	private String result;

	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public ResponseDto(int errCode, String errMsg) {
		this(errCode, errMsg, "");
	}

	public ResponseDto(int errCode, String errMsg, String result) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.result = result;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
