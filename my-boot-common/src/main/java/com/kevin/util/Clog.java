package com.kevin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geyh
 * @create 2017-07-27 13:27
 */
public class Clog {

    private static final Logger LOGGER = LoggerFactory.getLogger(Clog.class);

    public static String getTagsStr(String message, Map<String, String> tags) {
        StringBuilder stringBuilder = new StringBuilder();
        Boolean bool = false;
        stringBuilder.append("[[");
        for (Map.Entry<String, String> entry : tags.entrySet()) {
            if (bool) {
                stringBuilder.append(",");
                bool = true;
            }
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }

        stringBuilder.append("]]");
        stringBuilder.append("  ");
        stringBuilder.append(message);
        return stringBuilder.toString();
    }
    
    public static void info(String message) {
        LOGGER.info(message);
    }
    
    public static void info(String message, Map<String, String> tags) {
        if (LOGGER.isInfoEnabled())
            LOGGER.info(getTagsStr(message, tags));
    }
    

    public static void info(String title, String message) {
        if (LOGGER.isInfoEnabled()) {
            Map<String, String> tags = new HashMap<String, String>();
            tags.put("title", title);
            LOGGER.info(getTagsStr(message, tags));
        }
    }
    public static void warn(String title, String message) {
        if (LOGGER.isWarnEnabled()) {
            Map<String, String> tags = new HashMap<String, String>();
            tags.put("title", title);
            LOGGER.warn(getTagsStr(message, tags));
        }
    }


    public static void warn(String message, Map<String, String> tags) {
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(getTagsStr(message, tags));
        }
    }

    public static void warn(String title, Throwable throwable) {
        LOGGER.warn(title, throwable);
    }

    public static void warn(String title, Throwable throwable, Object... objects) throws Exception {
        if (LOGGER.isWarnEnabled()) {
            Map<String, String> tags = new HashMap<String, String>();
            tags.put("title", title);
            LOGGER.warn(getTagsStr(getObjsStr(objects), tags), throwable);
        }
    }

    public static void error(String title, String message) {
        if (LOGGER.isErrorEnabled()) {
            Map<String, String> tags = new HashMap<String, String>();
            tags.put("title", title);
            LOGGER.error(getTagsStr(message, tags));
        }
    }

    public static void error(String title, Throwable throwable) {
        LOGGER.error(title, throwable);
    }

    public static void error(String title, Throwable throwable, Object... objects) throws Exception {
        if (LOGGER.isErrorEnabled()) {
            Map<String, String> tags = new HashMap<String, String>();
            tags.put("title", title);
            LOGGER.error(getTagsStr(getObjsStr(objects), tags), throwable);
        }
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void error(String message, Map<String, String> tags) {
        if (LOGGER.isErrorEnabled()) {
            LOGGER.error(getTagsStr(message, tags));
        }
    }
    public static String getObjsStr(Object... objects) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        if (objects.length % 2 != 0)
            throw new Exception("参数不正确");

        int obLen = objects.length / 2;
        stringBuilder.append("\r\n");
        for (int i = 0; i < obLen; i++) {
            stringBuilder.append(objects[i * 2]);
            stringBuilder.append(":");
            Object value = objects[i * 2 + 1];
            if (value == null) {
                stringBuilder.append("<null>");
            } else if (value instanceof String) {
                stringBuilder.append(value);
            } else {
                stringBuilder.append(JsonUtil.toJSONString(value));
            }
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }

    
}
