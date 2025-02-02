package com.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateOrderId {
	public static String generatOrderId() {
		String orderId;
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyMMdd/HHmmss");
		String fomatedCurrentDatetime = pattern.format(currentDateTime);
		orderId = "FA/ORD-" + fomatedCurrentDatetime;
		return orderId;
	}
}
