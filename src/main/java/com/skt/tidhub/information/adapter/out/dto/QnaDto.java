package com.skt.tidhub.information.adapter.out.dto;

import java.time.LocalDateTime;

import com.skt.tidhub.information.adapter.out.entity.QnaEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QnaDto {
	
	@ApiModelProperty(value="문의내용", required=true, example="문의내용입니다.", dataType="String")
	private String content;
	
	@ApiModelProperty(value="답변내용받기(Y,N)", required=false, example="N", dataType="String")
	private String content_received;
	
	@ApiModelProperty(value="이메일", required=true, example="test@gamil.com", dataType="String")
	private String email;
	
	@ApiModelProperty(value="답변알림받기(Y,N)", required=false, example="N", dataType="String")
	private String alarm_received;
	
	@ApiModelProperty(value="질문주제(AU:App이용, JC:가입/전화, LI:로그인, IP:아이디찾기/비밀번호재설정, MS:회원정보관리/보안설정, WD:탈퇴, LS:연계서비스, EF:기타)", required=true, example="AU", dataType="String")
	private String inquiry_code;
	
	@ApiModelProperty(value="휴대폰(SKT,KT...)", required=false, example="0", dataType="String")
	private String telecom;
	
	@ApiModelProperty(value="휴대폰번호", required=false, example="01070007000", dataType="String")
	private String phone_number;
	
	@ApiModelProperty(value="개인정보 보호 방침 동의여부(Y/N)", required=true, example="Y", dataType="String")
	private String privacy_accepted;
	
	@ApiModelProperty(value="제목", required=true, example="질문입니다", dataType="String")
	private String title;
	
	@ApiModelProperty(value="답변상태", required=false, example="", dataType="String")
	private String answer_status;
	
	@ApiModelProperty(value="답변상태", required=false, example="", dataType="String")
	private LocalDateTime answer_at;
	
	@ApiModelProperty(value="답변내용", required=false, example="", dataType="String")
	private String answer_content;
	
	public QnaEntity toEntity() {
		QnaEntity qnas = QnaEntity.builder()
				.email(email)
				.inq_title(title)
				.inq_dt(content)
				.comm_co_cd(telecom)
				.inq_typ_cd(inquiry_code)
				.mbl_answ_rcv_alert_yn(alarm_received)
				.mbl_answ_rcv_ctt_yn(content_received)
				.mbl_phon_num(phone_number)
				.psnl_info_prtc_policy_agree_yn(privacy_accepted)
				.answ_st_cd(answer_status)
				.audit_dtm(LocalDateTime.now())
				.rgstr_dtm(LocalDateTime.now())//TODO JMS null false
				.answ_ctt(answer_content)
				.rgstr_id("test_rgstr_id")
				.audit_id("test_audit_id")//TODO JMS null false
				.build();
		return qnas;
 	}

}
