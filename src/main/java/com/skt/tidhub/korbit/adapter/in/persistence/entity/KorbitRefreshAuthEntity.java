package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "refresh token Entity", value = "KorbitRefreshAuthEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitRefreshAuthEntity implements Serializable {
	
	private static final long serialVersionUID = -8884415963330319487L;

	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="인증 구분 값", required=true, example="refresh_token", dataType="String")
    private String grant_type;
	
	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="korbit api key 값", required=true, example="8a4aEMYmRz4yV8N9AaH31rbI2H2L4cfkK3pV1sQd16mSFKVXdmIYfM5BApfDD", dataType="String")
    private String client_id;
	
	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="korbit secret key 값", required=true, example="dA7FbdiotoLf2xOixu4eT9y82ftw4mbV5Klh001gKpmE0qizqyUh4rBTAgnE3", dataType="String")
    private String client_secret;
	
	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="korbit refresh token 값", required=true, example="gW4c1Yt4OZKG8r5155zyH1Afi5CyKIefJgx9sZpH7HrRtD2te9TT6NloejuZs", dataType="String")
    private String refresh_token;

}
