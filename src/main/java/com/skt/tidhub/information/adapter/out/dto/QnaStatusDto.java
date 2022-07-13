package com.skt.tidhub.information.adapter.out.dto;

import lombok.Data;

@Data
public class QnaStatusDto {
	private int total_count;
	private int ongoing_count;
	private int answered_count;
	
	public QnaStatusDto(int total, int ongoing, int answered) {
		this.total_count = total;
		this.ongoing_count = ongoing;
		this.answered_count = answered;
	}
	
}
