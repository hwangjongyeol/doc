package com.skt.tidhub.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class MultiValueMapConverter {

    public static MultiValueMap<String, String> methodPostConvert(ObjectMapper objectMapper, Object dto) { // (2)
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            
            Map<String, String> map = objectMapper.convertValue(dto, new TypeReference<Map<String, String>>() {}); // (3)
            Map<String, String> reduceMap = new HashMap<String, String>();
            
            for(Map.Entry<String, String> entry : map.entrySet()) {
            	if (StringUtils.isNotEmpty(String.valueOf(entry.getValue()))) {
        			reduceMap.put(entry.getKey(), entry.getValue());
        		}
            }
            params.setAll(reduceMap); // (4)

            return params;
        } catch (Exception e) {
            throw new IllegalStateException("Url Parameter 변환중 오류가 발생했습니다.");
        }
    }
    
    public static MultiValueMap<String, String> methodGetConvert(ObjectMapper objectMapper, Object dto) { // (2)
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        if (ObjectUtils.isEmpty(dto)) {
            return params;
        }
        try {
            
            Map<String, String> map = objectMapper.convertValue(dto, new TypeReference<Map<String, String>>() {}); // (3)
            Map<String, String> reduceMap = new HashMap<String, String>();
            
            for(Map.Entry<String, String> entry : map.entrySet()) {
        		if (StringUtils.isNotEmpty(entry.getValue())) {
        			reduceMap.put(entry.getKey(), entry.getValue());
        		}
            }
            params.setAll(reduceMap); // (4)

            return params;
        } catch (Exception e) {
            throw new IllegalStateException("Url Parameter 변환중 오류가 발생했습니다.");
        }
    }
}