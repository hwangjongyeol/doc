package com.skt.tidhub.information.adapter.out.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.skt.tidhub.information.adapter.out.entity.FaqEntity;

import lombok.Data;

@Data
public class FaqDetailDto {

	private String content;
	private String title;
	private List<FaqCttDto> row_contents = new ArrayList<>();
	
	public FaqDetailDto(FaqEntity c) {
		this.content = c.getAnsw_ctt();
		this.title = c.getInq_title();
		this.row_contents = c.getFaqCtts().stream()
				.map(o -> new FaqCttDto(o))
				.collect(Collectors.toList());
		}	
	
}
