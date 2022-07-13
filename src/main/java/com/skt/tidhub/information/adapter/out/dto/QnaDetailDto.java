package com.skt.tidhub.information.adapter.out.dto;

import com.skt.tidhub.information.adapter.out.entity.QnaEntity;

import lombok.Data;

@Data
public class QnaDetailDto {
	
	private String title;
	private String content;
	private String inquiry_code;
	private String answer_status;
	private String answer_at;
	private String answer_content;
	private String inquiry_at;
	
	public QnaDetailDto(QnaEntity q) {
		this.title = q.getInq_title();
		this.content = q.getInq_ctt();
		this.inquiry_code = q.getInq_typ_cd();
		this.answer_status = q.getAnsw_st_cd();
		this.answer_at = q.getAnsw_dt();
		this.answer_content = q.getAnsw_ctt();
		this.inquiry_at = q.getInq_dt();
	}

}
