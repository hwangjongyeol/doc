package com.skt.tidhub.information.adapter.out.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.skt.tidhub.information.adapter.out.entity.FaqEntity;

import lombok.Data;

@Data
public class FaqListResultDto {

	private Integer faq_seq;            /* FAQ 순번 */
	private String faq_code;     /* 질문 유형 코드 */
	private String title;      /* 질문 제목 */
	private String content;       /* 답변 내용 */
	private String modified_at;
	private int view_count;
	private String best;
	private String modifier;
	private String register;
	private String registered_at;
	private List<FaqCttDto> row_contents = new ArrayList<>();

	public FaqListResultDto(FaqEntity c) {
		this.faq_seq = c.getSeq();
		this.faq_code = c.getInq_typ_cd();
		this.title = c.getInq_title();
		this.content = c.getAnsw_ctt();
		this.view_count = c.getBrws_cnt();
		this.best = c.getTop7_yn();
		this.modified_at = c.getAudit_dtm().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.modifier = c.getAudit_id();
		this.register = c.getRgstr_id();
		this.registered_at = c.getRgstr_dtm().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.row_contents = c.getFaqCtts().stream()
				.map(o -> new FaqCttDto(o))
				.collect(Collectors.toList());
		}	
}
