package com.kevin.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * @author geyh
 * @create 2017-05-26 20:28
 */
public class JsonUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Gson gson =new GsonBuilder().serializeNulls().disableHtmlEscaping().setDateFormat(DATE_FORMAT).create();

    /**
     * 对象转换为JSON-with GSON
     * @param obj
     * @return
     */
    public static <T> String t2Gson(T obj) {
        return gson.toJson(obj);
    }

    /**
     * json字符串转为对象-with GSON
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T gson2T(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString,clazz);
    }

    /**
     * JSON转为List-with fastjson
     * @param src
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> json2List(String src, Class<T> clazz) {
        return JSONArray.parseArray(src, clazz);
    }

    /**
     * obj转为json-with fastjson
     * @param obj
     * @return
     */
    public static String toJSONString(Object obj) {
        return JSONObject.toJSONString(obj, SoaPropertyFilter.getInstance(), SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * ctrip soa obj转为json-with fastjson
     * @param obj
     * @return
     */
    public static String toJSONCtripString(Object obj) {
        return JSONObject.toJSONString(obj, SoaPropertyFilter.getInstance(), SerializerFeature.WriteDateUseDateFormat);
    }

    static class SoaPropertyFilter implements PropertyFilter{
        private static SoaPropertyFilter soaPropertyFilter = null;

        public static synchronized SoaPropertyFilter getInstance() {
            if (soaPropertyFilter == null)
                soaPropertyFilter = new SoaPropertyFilter();
            return soaPropertyFilter;
        }

        public boolean apply(Object o, String name, Object o1) {
            if (name.equalsIgnoreCase("schema")) {
                //false表示last字段将被排除在外
                return false;
            }
            return true;
        }
    }

}
