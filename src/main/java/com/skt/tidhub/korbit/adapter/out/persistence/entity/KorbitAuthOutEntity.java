package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "인증 결과 Entity", value = "KorbitAuthOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitAuthOutEntity implements Serializable {
	
	private static final long serialVersionUID = 222706177923545659L;

	@ApiModelProperty(value="인증 구분 값",  example="Bearer")
    private String token_type;

	@ApiModelProperty(value="korbit 토큰 값",  example="IuqEWTK09eCLThRCZZSALA0oXC8EI7s")
    private String access_token;
	
	@ApiModelProperty(value="토큰 만료 시간",  example="3600")
    private int expires_in;
	
	@ApiModelProperty(value="korbit api 권한 룰",  example="VIEW,TRADE")
    private String scope;
	
	@ApiModelProperty(value="리플리시 토큰",  example="vn5xoOf4Pzckgn4jQSL9Sb3KxWJvYtm")
    private String refresh_token;

}
