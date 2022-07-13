package com.skt.tidhub.information.adapter.in.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skt.tidhub.information.adapter.in.entity.SearchBannerEntity;
import com.skt.tidhub.information.adapter.in.entity.SearchFaqListEntity;
import com.skt.tidhub.information.adapter.in.entity.SearchNoticeEntity;
import com.skt.tidhub.information.adapter.in.service.BoardService;
import com.skt.tidhub.information.adapter.out.dto.BannerResultDto;
import com.skt.tidhub.information.adapter.out.dto.FaqDetailDto;
import com.skt.tidhub.information.adapter.out.dto.NoticeResultDto;
import com.skt.tidhub.information.adapter.out.dto.QnaDetailDto;
import com.skt.tidhub.information.adapter.out.dto.QnaDto;
import com.skt.tidhub.information.adapter.out.dto.QnaStatusDto;

@Controller
public class InformationController {

	@Autowired
	BoardService customService;

	/**
     * 공지사항 목록조회
     * @param pageable
     * @param search
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/notices"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> serviceinformationNotices(Pageable pageable, SearchNoticeEntity search) throws Exception {
    	int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "seq"));
    	return customService.notices(pageable, search);
    }

    /**
     * 공지사항 상세조회
     * @param id
     * @param search
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/notice/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public NoticeResultDto noticeById(@PathVariable("id") Integer id, SearchNoticeEntity search) throws Exception {
    	return customService.noticesById(id, search);
    }

    /**
     * 공지사항 이전/이후
     * @param id
     * @param type
     * @param search
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/notice/{id}/{type}"}, method = RequestMethod.GET)
    @ResponseBody
    public NoticeResultDto noticesByType(@PathVariable("id") Integer id, @PathVariable("type") String type, SearchNoticeEntity search) throws Exception {
    	return customService.noticesByType(id, type, search);
    }

    /**
     * 메인 배너조회
     * @param searchBannerDTO
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/banners"}, method = RequestMethod.GET)
    @ResponseBody
    public List<BannerResultDto> serviceinformationBanner(SearchBannerEntity searchBannerDTO) throws Exception {
    	return customService.banners(searchBannerDTO);
    }

    /**
     * FAQ 조회
     * @param pageable
     * @param faqListDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/faqs"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> serviceinformationListFaq(Pageable pageable, SearchFaqListEntity faqListDto) throws Exception {
    	int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "seq"));
    	return customService.faqs(pageable,faqListDto);
    }

    /**
     * FAQ 상세 조회
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/faqs/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public FaqDetailDto serviceinformationListFaqDetail(@PathVariable Integer id) throws Exception {
    	return customService.faqDetail(id);
    }

    /**
     * 1대1 문의 저장
     * @param qnaDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/qna"}, method = RequestMethod.POST) //TODO 로그인 관련 컬럼 확인 return 유무
    @ResponseBody
    public void serviceinformationQnaWrite(QnaDto qnaDto) throws Exception {
    	customService.qnaWrite(qnaDto);
    }

    /**
     * 1대1 문의 내역 상태 조회
     * @param loginId
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/qna/status"}, method = RequestMethod.GET)
    @ResponseBody
    public QnaStatusDto serviceinformationQnaStatus() throws Exception {
    	String loginId = "testId";
    	return customService.qnaStatus(loginId);
    }

    /**
     * 1대1 문의 내역 리스트 조회
     * @param loginId
     * @param pageable
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/qnas"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> serviceinformationQnaList(Pageable pageable) throws Exception {
    	String loginId = "testId";
    	return customService.qnas(pageable,loginId);
    }

    /**
     * 1대1 문의 상세 조회
     * @param loginId
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/information/api/v10/serviceinformation/qna/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public QnaDetailDto serviceinformationQnaList(@PathVariable Integer id) throws Exception {
    	String loginId = "testId";
    	return customService.qnaDetail(id,loginId);
    }
}
