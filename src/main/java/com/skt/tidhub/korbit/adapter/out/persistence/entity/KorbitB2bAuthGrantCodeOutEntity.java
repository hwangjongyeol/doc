package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "인증코드(grant_code) 발급 - b2b용 Entity", value = "KorbitB2bAuthGrantCodeOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAuthGrantCodeOutEntity implements Serializable {
	
	private static final long serialVersionUID = 8889368822672846966L;
	
	@ApiModelProperty(value="인증 코드", example="7uh4kbdqxqu3ocumgq5qf0u", dataType="String")
    private String code;

}
