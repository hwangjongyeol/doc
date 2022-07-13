package com.skt.tidhub.information.adapter.out.dto;

import com.skt.tidhub.information.adapter.out.entity.FaqCttEntity;

import lombok.Data;


@Data
public class FaqCttDto {

	private int faq_seq;
	private int faq;
    private String row_type_cd;
    private String row_content;
    private String link_type_cd;
    private String link_url;
	private ImageDto file_info;
    
	public FaqCttDto(FaqCttEntity c) {
		this.faq_seq = c.getFaq().getSeq();
		this.faq = c.getSeq();
		this.row_type_cd = c.getRowTypCd();
		this.row_content = c.getRowCtt();
		this.link_type_cd = c.getLinkTypCd();
		this.link_url = c.getLinkUrl();
		this.file_info = new ImageDto(c.getImage());

	}
}
