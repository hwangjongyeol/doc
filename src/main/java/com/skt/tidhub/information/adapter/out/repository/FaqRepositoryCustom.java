package com.skt.tidhub.information.adapter.out.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skt.tidhub.information.adapter.in.entity.SearchFaqListEntity;
import com.skt.tidhub.information.adapter.out.dto.FaqDetailDto;
import com.skt.tidhub.information.adapter.out.dto.FaqListResultDto;

public interface FaqRepositoryCustom {

	Page<FaqListResultDto> findFaqs(Pageable pageable, SearchFaqListEntity searchFaqListDto);
	
	FaqDetailDto findByFaqId(Integer id);
}
