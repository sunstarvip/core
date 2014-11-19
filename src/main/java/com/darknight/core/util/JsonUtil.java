package com.darknight.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import java.io.StringWriter;

/**
 * Created by DarKnight on 2014/8/17.
 */
public class JsonUtil {
//    private static final Log log = LogFactory.getLog(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();
//    public static String jsonFromObject(Object object) {
//        StringWriter writer = new StringWriter();
//        try {
//            mapper.writeValue(writer, object);
//        } catch (RuntimeException e) {
//            throw e;
//        } catch (Exception e) {
//            log.error("Unable to serialize to json: " + object, e);
//            return null;
//        }
//        return writer.toString();
//    }
//
//    static <T> T objectFromJson(String json, Class<T> klass) {
//        T object;
//        try {
//            object = mapper.readValue(json, klass);
//        } catch (RuntimeException e) {
//            log.error("Runtime exception during deserializing "
//                            + klass.getSimpleName() + " from "
//                            + StringUtils.abbreviate(json, 80));
//            throw e;
//        } catch (Exception e) {
//            log.error("Exception during deserializing " + klass.getSimpleName()
//                            + " from " + StringUtils.abbreviate(json, 80));
//            return null;
//        }
//        return object;
//    }
}
