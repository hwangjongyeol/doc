package com.skt.tidhub.information.adapter.out.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skt.tidhub.information.adapter.out.dto.QnaDetailDto;
import com.skt.tidhub.information.adapter.out.dto.QnaResultDto;
import com.skt.tidhub.information.adapter.out.dto.QnaStatusDto;

public interface QnaRepositoryCustom {
	
	QnaStatusDto findByLoginId(String loginId);
	
	Page<QnaResultDto> findQnas(Pageable pageable, String loginId);
	
	QnaDetailDto findByQnaId(Integer id, String loginId);
}
