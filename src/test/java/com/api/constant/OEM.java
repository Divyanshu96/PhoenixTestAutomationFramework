package com.api.constant;

public enum OEM {
	GOOGLE(1), APPLE(2);

	private int code;

	private OEM(int code) {
		this.code = code;
	}

	public int getcode() {
		return code;
	}

}
