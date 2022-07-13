package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "인증 b2b용 Entity", value = "KorbitB2bAuthOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAuthOutEntity implements Serializable {
	
	private static final long serialVersionUID = -8065915840374601585L;

	@ApiModelProperty(value="토큰타입(Bearer 고정)", example="Bearer", dataType="String")
    private String token_type;

	@ApiModelProperty(value="토큰 만료 기간", example="360", dataType="String")
    private Integer expires_in;
	
	@ApiModelProperty(value="액세스 토큰", example="87304729328471214034871", dataType="String")
    private String access_token;
	
	@ApiModelProperty(value="리프레시 토큰", example="95092392458972744959397", dataType="String")
    private String refresh_token;

}
