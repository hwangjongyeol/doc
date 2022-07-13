package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "액세스 토큰 검증 - b2b용 Entity", value = "KorbitB2bAuthVerifyTokenEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAuthVerifyTokenEntity implements Serializable {
	
	private static final long serialVersionUID = 7268183287489225658L;

	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="사용자의 고유 UUID", required=true, example="8a4aEMYmRz4yV8N9AaHi1rbI2HFL", dataType="String")
    private String user_uuid;
	
	@NotBlank(message = "필수 값입니다.")
	@ApiModelProperty(value="korbit 토큰 값", required=true, example="IuqEWTK09eCLThRCZZSALA0oXC8EI7s", dataType="String")
    private String access_token;

}
