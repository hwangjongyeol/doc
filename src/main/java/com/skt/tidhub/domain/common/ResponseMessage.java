package com.skt.tidhub.domain.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage<T> {
    @ApiModelProperty(value="요청 처리 결과 Object", required=false)
    T data;
    String resultCode;
	@ApiModelProperty(value="처리 상태 상세 코드", required=true, example="0000")
	String resultDetailCode;
	@ApiModelProperty(value="처리 결과 메세지", required=false, example="정상처리 되었습니다.")
    String resultMessage;
	
	public <T> T getConvertFromMapToData(Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        return clazz.cast(mapper.convertValue(this.data, clazz));
    }
}
