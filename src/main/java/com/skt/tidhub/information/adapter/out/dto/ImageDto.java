package com.skt.tidhub.information.adapter.out.dto;

import com.skt.tidhub.information.adapter.out.entity.ImageEntity;

import lombok.Data;

@Data
public class ImageDto {

//	private String imgId;
//	private String imgUrl;
//	private String imgWidth;
//	private String imgHeight;
//	private String imgNm;
//	private String orgNm;
//
//	public ImageDto(ImageEntity o) {
//		this.imgId = o.getImgId();
//		this.imgUrl = o.getImgUrl();
//		this.imgWidth = o.getImgWidth();
//		this.imgHeight = o.getImgHeight();
//		this.imgNm = o.getImgNm();
//		this.orgNm = o.getOrgNm();
//	}
	
	private String file_url;
	private String image_width;
	private String image_height;
	private String original_name;

	public ImageDto(ImageEntity o) {
		this.file_url = o.getImgUrl();
		this.image_width = o.getImgWidth();
		this.image_height = o.getImgHeight();
		this.original_name = o.getOrgNm();
	}
}
