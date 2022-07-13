package com.skt.tidhub.information.adapter.out.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mbr_inq_board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class QnaEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
	private int seq;
	
	private String mbr_num;
	private String login_id;
	private String inq_dt;
	private String inq_title;
	private String inq_typ_cd;
	private String email;
	private String mbl_answ_rcv_alert_yn;
	private String mbl_answ_rcv_ctt_yn;
	private String comm_co_cd;
	private String mbl_phon_num;
	private String psnl_info_prtc_policy_agree_yn;
	private String answ_st_cd;
	private String answ_dt;
	private String rgstr_id;
	private LocalDateTime rgstr_dtm;
	private String audit_id;
	private LocalDateTime audit_dtm;
	private String inq_ctt;
	private String answ_ctt;
	private String dvc_os_cd;
	private String dvc_os_ver;
	private String dvc_model;
	private String app_version;
	private String dvc_nickname;

}
