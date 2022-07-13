package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "입출금 지갑 정보 조회 결과 Entity", value = "KorbitAccountsOutEntity") 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitAccountsOutEntity implements Serializable {

	private static final long serialVersionUID = 3858479507340547669L;

	@ApiModelProperty(value="해당 화폐의 입금 주소.", example="3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy")
    private String address;

	@ApiModelProperty(value="XRP, XLM, EOS 거래에서 사용되는 destination tag. 존재하는 경우만 반환.", example="100022001")
    private String destination_tag;
}
