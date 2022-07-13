package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "사용자 보유 자산 조회 Entity", value = "KorbitB2bAssetsOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAssetsOutEntity implements Serializable {
	
	private static final long serialVersionUID = 4276109970275418286L;
	
	@ApiModelProperty(value="보유 자산 데이터 오브젝트",  example="object")
    private KorbitB2bAssetsIdOutEntity assets;

}
