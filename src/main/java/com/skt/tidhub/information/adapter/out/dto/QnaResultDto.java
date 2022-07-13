package com.skt.tidhub.information.adapter.out.dto;

import java.time.format.DateTimeFormatter;

import com.skt.tidhub.information.adapter.out.entity.QnaEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QnaResultDto {
	
	private int inquiry_seq;
	private String register;
	private String registered_at;
	private String modifier;
	private String modified_at;
	private String title;
	private String content;
	private String inquiry_code;
	private String answer_status;
	private String answer_at;
	private String answer_content;
	private String inquiry_at;
	private String email;
	private String alarm_received;
	private String content_received;
	private String telecom;
	private String phone_number;
	private String privacy_accepted;
	
	
	public QnaResultDto(QnaEntity q) {
		this.register = q.getRgstr_id();
		this.registered_at = q.getRgstr_dtm().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.modifier = q.getAudit_id();
		this.modified_at = q.getAudit_dtm().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.title = q.getInq_title();
		this.content = q.getInq_ctt();
		this.inquiry_code = q.getInq_typ_cd();
		this.answer_status = q.getAnsw_st_cd();
		this.answer_at = q.getAnsw_dt();
		this.answer_content = q.getAnsw_ctt();
		this.inquiry_at = q.getInq_dt();
		this.inquiry_seq = q.getSeq();
		this.email = q.getEmail();
		this.alarm_received = q.getMbl_answ_rcv_alert_yn();
		this.content_received = q.getMbl_answ_rcv_ctt_yn();
		this.telecom = q.getComm_co_cd();
		this.phone_number = q.getMbl_phon_num();
		this.privacy_accepted = q.getPsnl_info_prtc_policy_agree_yn();
	}	
	

}
