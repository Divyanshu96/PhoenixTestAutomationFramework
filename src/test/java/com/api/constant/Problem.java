package com.api.constant;

public enum Problem {

	SMARTPHONE_IS_RUNNING_SLOW(1), POOR_BATTERY_LIFE(2), PHONE_OR_APP_CRASHES(3), SYNC_ISSUE(4),
	MICRO_SD_CARD_IS_NOT_WORKING_ON_YOUR_PHONE(5), OVERHEATING(6);

	int code;

	private Problem(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
