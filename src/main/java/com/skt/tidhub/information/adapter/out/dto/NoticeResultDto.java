package com.skt.tidhub.information.adapter.out.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.skt.tidhub.information.adapter.out.entity.NoticeEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeResultDto {

	private Integer notice_seq;
	private String title;
	private String content;
	private Boolean top_fiexed;
	private String notice_type;
	private String display_name;
	private String view_count;
	private Integer date_differences;
	private String register;
	private String registered_at;
	private String modifier;
	private String modified_at;
	private List<NoticeCttDto> row_contents = new ArrayList<>();

	public NoticeResultDto(NoticeEntity n) {

		this.notice_seq = n.getSeq();
		this.title = n.getAnnceTitle();
		this.content = n.getAnnceCtt();
		this.notice_type = n.getAnnceType();
		this.view_count = n.getReviewCnt();
		this.date_differences = 0; // TODO cyi
		this.register = n.getRgstrId();
		this.modifier = n.getAuditId();
		this.registered_at = n.getRgstrDtm().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.modified_at = n.getAuditDtm().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.row_contents = n.getNoticeCtts().stream().map(o -> new NoticeCttDto(o)).collect(Collectors.toList());

		if (n.getAnnceType().equals("in")) {
			this.display_name = "안내";
		}
//		if (n.getAnnceType() == "news") { //TODO varchar3 ??
//			this.display_name = "NEWS";
//		}
//		if (n.getAnnceType() == "event") {
//			this.display_name = "이벤트";
//		}
	}

}
