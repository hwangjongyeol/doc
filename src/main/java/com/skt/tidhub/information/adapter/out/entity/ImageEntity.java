package com.skt.tidhub.information.adapter.out.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "image_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"imgId", "imgUrl", "imgWidth", "imgHeight", "imgNm", "orgNm"})
public class ImageEntity {
    @Id
    @Column(name = "img_id")
	private String imgId;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "img_width")
    private String imgWidth;
    @Column(name = "img_height")
    private String imgHeight;
    @Column(name = "img_nm")
    private String imgNm;
    @Column(name = "org_nm")
    private String orgNm;

	public ImageEntity(String imgUrl, String imgWidth, String imgHeight, String imgNm, String orgNm) {
		this.imgUrl = imgUrl;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.imgNm = imgNm;
		this.orgNm = orgNm;
	}

}
