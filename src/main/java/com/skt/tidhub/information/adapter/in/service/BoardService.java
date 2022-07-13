package com.skt.tidhub.information.adapter.in.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skt.tidhub.information.adapter.in.entity.SearchBannerEntity;
import com.skt.tidhub.information.adapter.in.entity.SearchFaqListEntity;
import com.skt.tidhub.information.adapter.in.entity.SearchNoticeEntity;
import com.skt.tidhub.information.adapter.out.dto.BannerResultDto;
import com.skt.tidhub.information.adapter.out.dto.FaqDetailDto;
import com.skt.tidhub.information.adapter.out.dto.FaqListResultDto;
import com.skt.tidhub.information.adapter.out.dto.NoticeResultDto;
import com.skt.tidhub.information.adapter.out.dto.QnaDetailDto;
import com.skt.tidhub.information.adapter.out.dto.QnaDto;
import com.skt.tidhub.information.adapter.out.dto.QnaResultDto;
import com.skt.tidhub.information.adapter.out.dto.QnaStatusDto;
import com.skt.tidhub.information.adapter.out.repository.BannerRepository;
import com.skt.tidhub.information.adapter.out.repository.FaqRepository;
import com.skt.tidhub.information.adapter.out.repository.NoticeRepository;
import com.skt.tidhub.information.adapter.out.repository.QnaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

	private final NoticeRepository noticeRepository;

	private final BannerRepository bannerRepository;

	private final FaqRepository faqRepository;

	private final QnaRepository qnaRepository;

	public Map<String, Object> notices(Pageable pageable, SearchNoticeEntity search) {
		Page<NoticeResultDto> notices = noticeRepository.notices(pageable, search);
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("total_count", notices.getTotalElements());
		result.put("page_count", notices.getTotalPages());
		result.put("notices", notices.getContent());
		return result;
	}

	public NoticeResultDto noticesById(Integer id, SearchNoticeEntity search) {
		return noticeRepository.noticesById(id, search);
	}

	public NoticeResultDto noticesByType(Integer id, String type, SearchNoticeEntity search) {
		return noticeRepository.noticesByType(id, type, search);
	}

	public List<BannerResultDto> banners(SearchBannerEntity searchBannerDTO) {
		return bannerRepository.findBanners(searchBannerDTO);
	}

	public Map<String, Object> faqs(Pageable pageable, SearchFaqListEntity faqListDto) {
		Page<FaqListResultDto> faqs = faqRepository.findFaqs(pageable,faqListDto);
		Map<String, Object> result = new HashMap<>();
		result.put("faqs", faqs.getContent());
		result.put("page_count", faqs.getNumber());
		result.put("total_count", faqs.getTotalPages());
		return result;
	}

	public FaqDetailDto faqDetail(Integer id) {
		return faqRepository.findByFaqId(id);
	}

	@Transactional
	public void qnaWrite(QnaDto qnaDto){
		qnaRepository.save(qnaDto.toEntity());
	}

	public QnaStatusDto qnaStatus(String loginId) {
		return qnaRepository.findByLoginId(loginId);
	}

	public Map<String, Object> qnas(Pageable pageable, String loginId) {
		Page<QnaResultDto> qnas = qnaRepository.findQnas(pageable,loginId);
		Map<String, Object> result = new HashMap<>();
		result.put("inquiries", qnas.getContent());
		result.put("page_count", qnas.getNumber());
		result.put("total_count", qnas.getTotalPages());

		return result;
	}

	public QnaDetailDto qnaDetail(Integer id, String loginId) {
		return qnaRepository.findByQnaId(id,loginId);
	}

}
