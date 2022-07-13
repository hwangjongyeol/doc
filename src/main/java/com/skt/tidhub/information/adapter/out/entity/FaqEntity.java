package com.skt.tidhub.information.adapter.out.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "faq_board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FaqEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
	private Integer seq;            /* FAQ 순번 */
	private String inq_typ_cd;     /* 질문 유형 코드 */
	private String inq_title;      /* 질문 제목 */
	private String answ_ctt;       /* 답변 내용 */
	private String use_yn;         /* 사용 여부 */
	private String top7_yn;        /* TOP7 여부 */
	private int brws_cnt;       /* 조회수 */
	private String mw_poc_yn;      /* MW 노출 POC */
	private String app_poc_yn;     /* APP 노출 POC */
	private String rgstr_id;       /* 등록자 ID */
	private LocalDateTime rgstr_dtm;      /* 등록 일시 */
	private String audit_id;       /* 수정자 ID */
	private LocalDateTime audit_dtm;      /* 수정 일시 */
	
	@OneToMany(mappedBy = "faq", fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    private List<FaqCttEntity> faqCtts = new ArrayList<>();

    public void addFaqCtt(FaqCttEntity faqCtt) {
    	faqCtt.addFaq(this);
    	faqCtts.add(faqCtt);
    }

	public FaqEntity(String inq_typ_cd, String inq_title, String answ_ctt, String use_yn, String top7_yn,
			int brws_cnt, String mw_poc_yn, String app_poc_yn, String rgstr_id, LocalDateTime rgstr_dtm, String audit_id,
			LocalDateTime audit_dtm) {
		this.inq_typ_cd = inq_typ_cd;
		this.inq_title = inq_title;
		this.answ_ctt = answ_ctt;
		this.use_yn = use_yn;
		this.top7_yn = top7_yn;
		this.brws_cnt = brws_cnt;
		this.mw_poc_yn = mw_poc_yn;
		this.app_poc_yn = app_poc_yn;
		this.rgstr_id = rgstr_id;
		this.rgstr_dtm = rgstr_dtm;
		this.audit_id = audit_id;
		this.audit_dtm = audit_dtm;
	}

}
