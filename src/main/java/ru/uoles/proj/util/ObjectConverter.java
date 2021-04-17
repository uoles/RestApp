package ru.uoles.proj.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ObjectConverter {

    private static final Logger logger = LoggerFactory.getLogger(ObjectConverter.class);

    public static String toJson(Object object) {
        String result = "";
        ObjectWriter ow = new ObjectMapper().writer();
        try {
            result = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Error: {}", e.getMessage());
        }
        return result;
    }
}
