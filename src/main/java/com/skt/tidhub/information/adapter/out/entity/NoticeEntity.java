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

import org.hibernate.annotations.BatchSize;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "annce_board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"seq", "annceTitle", "annceCtt", "topFixYn", "annceType", "pcPocYn", "mwPocYn", "appPocYn"
		, "reviewCnt", "useYn", "rgstrId", "rgstrDtm", "auditId", "auditDtm"})
public class NoticeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
	private Integer seq;				/* 공지사항번호	*/
    @Column(name = "annce_title")
    private String annceTitle;		/* 공지제목	*/
    @Column(name = "annce_ctt")
    private String annceCtt;		/* 공지내용	*/
    @Column(name = "top_fix_yn")
    private String topFixYn;		/* 상단고정여부	*/
    @Column(name = "annce_type")
	private String annceType;		/* 공지사항타입 */
    @Column(name = "pc_poc_yn")
	private String pcPocYn;
    @Column(name = "mw_poc_yn")
	private String mwPocYn;			/* 노출 poc  */
    @Column(name = "app_poc_yn")
	private String appPocYn;		/* 노출 poc  */
    @Column(name = "review_cnt")
	private String reviewCnt;			/* 조회수	*/
    @Column(name = "use_yn")
    private String useYn;			/* 사용여부	*/
    @Column(name = "rgstr_id")
	private String rgstrId;			/* 등록자id	*/
    @Column(name = "rgstr_dtm")
	private LocalDateTime rgstrDtm;	/* 등록일시	*/
    @Column(name = "audit_id")
	private String auditId;			/* 최종변경자id	*/
    @Column(name = "audit_dtm")
	private LocalDateTime auditDtm;	/* 최종변경일시	*/
    @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY)
    @BatchSize(size = 1000)
    private List<NoticeCttEntity> noticeCtts = new ArrayList<>();

	public NoticeEntity(String annceTitle, String annceCtt, String topFixYn, String annceType, String pcPocYn,
			String mwPocYn, String appPocYn, String reviewCnt, String useYn, String rgstrId, LocalDateTime rgstrDtm,
			String auditId, LocalDateTime auditDtm) {
		this.annceTitle = annceTitle;
		this.annceCtt = annceCtt;
		this.topFixYn = topFixYn;
		this.annceType = annceType;
		this.pcPocYn = pcPocYn;
		this.mwPocYn = mwPocYn;
		this.appPocYn = appPocYn;
		this.reviewCnt = reviewCnt;
		this.useYn = useYn;
		this.rgstrId = rgstrId;
		this.rgstrDtm = rgstrDtm;
		this.auditId = auditId;
		this.auditDtm = auditDtm;
	}
}
