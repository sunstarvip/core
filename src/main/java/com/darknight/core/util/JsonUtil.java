package com.darknight.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.StringWriter;

/**
 * Created by DarKnight on 2014/8/17.
 */
public class JsonUtil {
    private static final Log log = LogFactory.getLog(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final StringWriter writer = new StringWriter();
    //private static final UTF8Writer writerUTF8 = new UTF8Writer();

    /**
     * 获得将Java Bean对象, Map或者List对象转换成JSON字符串后的输出流
     * @param obj
     * @return StringWriter对象
     */
    public static StringWriter getObjToJsonWriter(Object obj) {
        try {
            mapper.writeValue(writer, obj);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unable to serialize to json: " + obj, e);
            return null;
        }
        return writer;
    }

    /**
     * 利用Jackson框架将Java Bean对象, Map或者List对象转换成JSON字符数组
     * 字符编码将使用UTF-8, 且高效
     * @param obj
     * @return
     */
    public static byte[] objToJsonBytes(Object obj) {
        byte[] jsonBytes = null;
        try {
            jsonBytes = mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize to a json byte array: " + obj, e);
        }
        return jsonBytes;
    }

    /**
     * 利用Jackson框架将Java Bean对象, Map或者List对象转换成JSON字符串
     * 比通过getObjToJsonWriter()方法获得输出流后输出更有效率的方法
     * @param obj
     * @return
     */
    public static String objToJsonString(Object obj) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize to a json string: " + obj, e);
        }
        return jsonStr;
    }

    /**
     * 利用Jackson框架将JSON字符串转换成Java Bean对象, Map或者List对象
     * @param json
     * @param obj
     * @param <T>
     * @return
     */
    static <T> T jsonToObj(String json, Class<T> obj) {
        T object;
        try {
            object = mapper.readValue(json, obj);
        } catch (RuntimeException e) {
            log.error("Runtime exception during deserializing "
                            + obj.getSimpleName() + " from "
                            + StringUtils.abbreviate(json, 80));
            throw e;
        } catch (Exception e) {
            log.error("Exception during deserializing " + obj.getSimpleName()
                            + " from " + StringUtils.abbreviate(json, 80));
            return null;
        }
        return object;
    }


}
