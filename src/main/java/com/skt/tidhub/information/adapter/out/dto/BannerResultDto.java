package com.skt.tidhub.information.adapter.out.dto;

import com.skt.tidhub.information.adapter.out.entity.BannerEntitiy;

import lombok.Data;

@Data
public class BannerResultDto {

	private Integer seq;
	
	private String title;
	
	private String banner_typ_cd;
	
	private String banner_position_typ_cd;
	
	private String web_target_type;
	
	private String web_target_url;
	
	private String app_target_type;
	
	private String app_target_url;
	
	private String bg_color;
		
	private String img_id;
	
	private String img_url;
	
	public BannerResultDto(BannerEntitiy b) {
		this.seq = b.getSeq();
		this.title = b.getTitle();
		this.banner_typ_cd = b.getBannerTypCd();
		this.banner_position_typ_cd = b.getBannerPositionTypCd();
		this.web_target_type = b.getWebTargetType();
		this.web_target_url = b.getWebTargetUrl();
		this.app_target_type = b.getAppTargetType();
		this.app_target_url = b.getAppTargetUrl();
		this.bg_color = b.getBgColor();
		this.img_id = b.getImage().getImgId();
		this.img_url = b.getImage().getImgUrl();
	}


}