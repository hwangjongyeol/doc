package com.skt.tidhub.information.adapter.out.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "annce_board_ctt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"seq", "rowTypCd", "rowCtt", "linkTypCd", "rgstrId", "rgstrDtm", "auditId", "auditDtm"})
public class NoticeCttEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
	private Integer seq;
    @Column(name = "row_typ_cd")
    private String rowTypCd;
    @Column(name = "row_ctt")
    private String rowCtt;
    @Column(name = "link_typ_cd")
    private String linkTypCd;
    @Column(name = "link_url")
    private String linkUrl;
    @Column(name = "rgstr_id")
	private String rgstrId;			/* 등록자id	*/
    @Column(name = "rgstr_dtm")
	private LocalDateTime rgstrDtm;	/* 등록일시	*/
    @Column(name = "audit_id")
	private String auditId;			/* 최종변경자id	*/
    @Column(name = "audit_dtm")
	private LocalDateTime auditDtm;	/* 최종변경일시	*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "annce_seq")
    @JsonIgnore
    private NoticeEntity notice;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    @JsonIgnore
    private ImageEntity image;



	public NoticeCttEntity(String rowTypCd, String rowCtt, String linkTypCd, String linkUrl,
			String rgstrId, LocalDateTime rgstrDtm, String auditId, LocalDateTime auditDtm) {
		this.rowTypCd = rowTypCd;
		this.rowCtt = rowCtt;
		this.linkTypCd = linkTypCd;
		this.linkUrl = linkUrl;
		this.rgstrId = rgstrId;
		this.rgstrDtm = rgstrDtm;
		this.auditId = auditId;
		this.auditDtm = auditDtm;
	}

}
