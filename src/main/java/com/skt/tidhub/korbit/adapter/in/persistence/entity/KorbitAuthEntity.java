package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "인증 Entity", value = "KorbitAuthEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitAuthEntity implements Serializable {
	
	private static final long serialVersionUID = 8994232389625926177L;
	
	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="인증 구분 값", required=true, example="client_credentials", dataType="String")
    private String grant_type;

	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="korbit api key 값", required=true, example="8a4aEMYmRz4yV8N9AaHi1rbI2HFL4cfkK3pV1sQd16mSFKVXdmIYmM5BApfDS", dataType="String")
    private String client_id;
	
	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="korbit secret key 값", required=true, example="sA7FbdiotoLi2xOixuxeT9y82ftwmmbV5Klh001gKpmE0qizqyUQ4rBTAsnE3", dataType="String")
    private String client_secret;

}
