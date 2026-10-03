package com.api.constant;

public enum Platform {
	FST(3),
	FRONT_DESK(2);

	int code;

	private Platform(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
