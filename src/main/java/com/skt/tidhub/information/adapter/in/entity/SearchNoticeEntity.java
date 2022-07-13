package com.skt.tidhub.information.adapter.in.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "공지 목록 조회 Entity", value = "SearchNoticeDto")
@Data
public class SearchNoticeEntity {
	@ApiModelProperty(value="노출디바이스(PC, MW)",  example="PC")
	private String poc;
	
	@ApiModelProperty(value="검색어",  example="테스트")
	private String keyword;
	
	@ApiModelProperty(value="상단고정여부(true, false)",  example="false")
	private boolean top_fixed;
}
