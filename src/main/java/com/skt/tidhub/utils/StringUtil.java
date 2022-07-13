package com.skt.tidhub.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class StringUtil {
 
    public static <T> Map<String, java.lang.Object> getMap(T clazz) {
        if (ObjectUtils.isEmpty(clazz)) {
            return new HashMap<String, Object>();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(clazz, Map.class);
        return map;
    }
}