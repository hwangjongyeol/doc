package com.skt.tidhub.information.adapter.out.dto;

import com.skt.tidhub.information.adapter.out.entity.NoticeCttEntity;

import lombok.Data;

@Data
public class NoticeCttDto {

	private Integer seq;
	private Integer notice_seq;
	private String row_type_cd;
	private String row_content;
	private String link_type_cd;
	private String link_url;
	private ImageDto file_info;

	public NoticeCttDto(NoticeCttEntity o) {
		this.seq = o.getSeq();
		this.notice_seq = o.getNotice().getSeq();
		this.row_type_cd = o.getRowTypCd();
		this.row_content = o.getRowCtt();
		this.link_type_cd = o.getLinkTypCd();
		this.link_url = o.getLinkUrl();
		this.file_info = new ImageDto(o.getImage());
	}
}
