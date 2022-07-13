package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "인증코드(grant_code) 발급 - b2b용 Entity", value = "KorbitB2bAuthGrantCodeEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAuthGrantCodeEntity implements Serializable {
	
	private static final long serialVersionUID = -6269950720062086826L;
	
	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="사용자의 고유 UUID", required=true, example="8a4aEMYmRz4yV8N9AaHi1rbI2HFL", dataType="String")
    private String user_uuid;

}
