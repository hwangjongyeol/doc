package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "자산 목록 조회 Entity", value = "KorbitB2bExchangeOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bExchangeOutEntity implements Serializable {

	
	private static final long serialVersionUID = -6403278402505542430L;
	@ApiModelProperty(value="자산 목록 데이터 오브젝트",  example="object")
    private KorbitB2bExchangeListingsOutEntity listings;


}
