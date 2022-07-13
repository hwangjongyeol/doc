package com.skt.tidhub.information.adapter.out.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "main_banner_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BannerEntitiy {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq; /* 배너 id	*/
	
	private String title; /* 배너 제목 */
	
	@Column(name = "banner_typ_cd") /* 배너 유형 코드	*/
	private String bannerTypCd;
	
	@Column(name = "banner_position_typ_cd") /* 배너 위치 유형 코드	*/
	private String bannerPositionTypCd;
	
	@Column(name = "web_target_type") /* 웹타겟유형	*/
	private String webTargetType;
	
	@Column(name = "web_target_url") /* 웹타겟 URL	*/
	private String webTargetUrl;
	
	@Column(name = "app_target_type") /* 웹타겟유형	*/
	private String appTargetType;
	
	@Column(name= "app_target_url")
	private String appTargetUrl;
	
	@Column(name = "bg_color")
	private String bgColor;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "img_id")
	private ImageEntity image;
	
	@Column(name = "disp_yn") /* 노출여부	*/
	private String dispYn;
	
	@Column(name = "disp_priority") /* 노출우선순서	*/
	private int dispPriority;
	
	@Column(name = "disp_typ_cd") /* 노출 유형 코드	*/
	private String dispTypCd;
	
	@Column(name = "disp_start")
	private String dispStart;
	
	@Column(name = "disp_end")
	private String dispEnd;
	
	@Column(name = "disp_poc") /* 노출 poc	*/
	private String dispPoc;
	
	@Column(name = "banner_desc")
	private String bannerDesc;

	@Column(name = "audit_desc") /* 수정내용	*/
	private String auditDesc;
	
    @Column(name = "rgstr_id")
	private String rgstrId;			/* 등록자id	*/
    
    @Column(name = "rgstr_dtm")
	private LocalDateTime rgstrDtm;	/* 등록일시	*/
    
    @Column(name = "audit_id")
	private String auditId;			/* 최종변경자id	*/
    
    @Column(name = "audit_dtm")
	private LocalDateTime auditDtm;	/* 최종변경일시	*/
    
//    public void addImage(ImageEntity image) {
//    	image.addBanner(this);
//    	this.image = image;
//    }
}
