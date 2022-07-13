package com.skt.tidhub.information.adapter.out.entity;
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
@Table(name = "faq_board_ctt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"seq", "rowTypCd", "rowCtt", "linkTypCd"})
public class FaqCttEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
	private int seq;
    @Column(name = "row_typ_cd")
    private String rowTypCd;
    @Column(name = "row_ctt")
    private String rowCtt;
    @Column(name = "link_typ_cd")
    private String linkTypCd;
    @Column(name = "link_url")
    private String linkUrl;
    @Column(name = "rgstr_id")
    private String rgstrId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faq_seq")
    @JsonIgnore
    private FaqEntity faq;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    @JsonIgnore
    private ImageEntity image;

    public void addFaq(FaqEntity faq) {
    	this.faq = faq;
    }

//    public void addImage(ImageEntity image) {
//    	image.addFaqCtt(this);
//    	this.image = image;
//    }

	public FaqCttEntity(String rowTypCd, String rowCtt, String linkTypCd, String linkUrl) {
		this.rowTypCd = rowTypCd;
		this.rowCtt = rowCtt;
		this.linkTypCd = linkTypCd;
		this.linkUrl = linkUrl;
	}

}
