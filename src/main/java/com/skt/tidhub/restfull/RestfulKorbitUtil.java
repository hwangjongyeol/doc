package com.skt.tidhub.restfull;

import java.net.URI;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skt.tidhub.config.enums.ResultMessageCodeEnum;
import com.skt.tidhub.domain.common.ResponseMessage;
import com.skt.tidhub.utils.MessageAccessUtil;
import com.skt.tidhub.utils.MultiValueMapConverter;

@Component
public class RestfulKorbitUtil {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
    private MessageAccessUtil messageUtil;

    public <T> ResponseMessage getRestApi(HttpMethod method, String path, Map<String, Object> param, String authorization, Class<T> classType) throws Exception {

        try {
        	ResponseEntity<T> responseEntity = null;
        	
        	// 헤더
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
            
            if(StringUtils.isNotEmpty(authorization)) {
            	headers.add("Authorization", authorization);
            }
            
            if (method == HttpMethod.GET) {
                MultiValueMap<String, String> getParam = MultiValueMapConverter.methodGetConvert(new ObjectMapper(), param);
                URI uri = UriComponentsBuilder.newInstance().fromUriString(path).queryParams(getParam).build().encode().toUri();
                HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(null, headers);
                responseEntity = restTemplate.exchange(uri, method, entity, classType);

            } else if (method == HttpMethod.POST) {
                MultiValueMap<String, String> postParam = MultiValueMapConverter.methodPostConvert(new ObjectMapper(), param);
                URI uri = UriComponentsBuilder.newInstance().fromUriString(path).build().encode().toUri();
                HttpEntity<MultiValueMap<String, String>> postEntity = new HttpEntity<>(postParam, headers);
                responseEntity = restTemplate.postForEntity(uri, postEntity, classType);
            } else if (method == HttpMethod.PUT) {
                String jsonParms  = ObjectTojsonFormat(param);
                URI uri = UriComponentsBuilder.newInstance().fromUriString(path).build().encode().toUri();
                HttpEntity<String> putEntity = new HttpEntity<>(jsonParms, headers);
                responseEntity = restTemplate.exchange(uri, method, putEntity, classType);
            }else if (method == HttpMethod.PATCH) {
                String jsonParms  = ObjectTojsonFormat(param);
                URI uri = UriComponentsBuilder.newInstance().fromUriString(path).build().encode().toUri();
                HttpEntity<String> patchEntity = new HttpEntity<>(jsonParms, headers);
                responseEntity = restTemplate.exchange(uri, method, patchEntity, classType);
            } else if (method == HttpMethod.DELETE) {
                String jsonParms  = ObjectTojsonFormat(param);
                URI uri = UriComponentsBuilder.newInstance().fromUriString(path).build().encode().toUri();
                HttpEntity<String> deleteEntity = new HttpEntity<>(jsonParms, headers);
                responseEntity = restTemplate.exchange(uri, method, deleteEntity, classType);
            }

            return ResponseMessage.builder()
                    .data(responseEntity.getBody())
                    .resultCode(Integer.toString(HttpStatus.OK.value()))
                    .resultDetailCode(ResultMessageCodeEnum.SUCCESS.toString())
                    .resultMessage(null)
                    .build();
			
		} catch (Exception e) {
			return ResponseMessage.builder()
                    .data(null)
                    .resultCode(Integer.toString(HttpStatus.BAD_REQUEST.value()))
                    .resultDetailCode(ResultMessageCodeEnum.KORBIT_ERROR_1001.code())
                    .resultMessage(messageUtil.getMessage(ResultMessageCodeEnum.KORBIT_ERROR_1001.value(), null))
                    .build();
		}
        
    }

    public <T> String ObjectTojsonFormat(T param) throws Exception {
        ObjectMapper obm  = new ObjectMapper();
        String jsonParms = obm.writeValueAsString(param);
        return jsonParms;
    }

    public <T> T getConvertFromMapToData(Class<T> clazz, ResponseMessage body) {
        ObjectMapper mapper = new ObjectMapper();
        return clazz.cast(mapper.convertValue(body, clazz));
    }
}