package com.skt.tidhub.information.adapter.out.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skt.tidhub.information.adapter.in.entity.SearchNoticeEntity;
import com.skt.tidhub.information.adapter.out.dto.NoticeResultDto;

public interface NoticeRepositoryCustom {

	Page<NoticeResultDto> notices(Pageable pageable, SearchNoticeEntity search);

	NoticeResultDto noticesById(Integer id, SearchNoticeEntity search);

	NoticeResultDto noticesByType(Integer id, String type, SearchNoticeEntity search);

}
