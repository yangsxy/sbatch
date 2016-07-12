package cn.yuan.web.util;

import java.util.UUID;

public class LogMessageUtils {
	
	public final static String KEY_MEESAGE_ID="log_message_point_id";
	/**
	 * 移除埋点
	 */
	public static final void removeMessagePoint() {
		try {
			org.slf4j.MDC.remove(KEY_MEESAGE_ID);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public static final String createUUID() {
		return "OL" + UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static final void setMessagePoint() {
		setMessagePoint(createUUID());
	}

	public static final void setMessagePoint(String uuid) {
		if (uuid == null || uuid.trim().length() == 0) {
			uuid = createUUID();
		}
		if (org.slf4j.MDC.get(KEY_MEESAGE_ID) == null) {
			org.slf4j.MDC.put(KEY_MEESAGE_ID, uuid);
		}
	}

	public static final String getMessagePoint() {
		String point = org.slf4j.MDC.get(KEY_MEESAGE_ID);
		if (point == null || point.trim().length() == 0) {
			return createUUID();
		} else {
			return point;
		}
	}
}
