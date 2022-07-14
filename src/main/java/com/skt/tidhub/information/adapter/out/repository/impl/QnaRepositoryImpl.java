package com.skt.tidhub.information.adapter.out.repository.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors; 

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.skt.tidhub.information.adapter.out.dto.QnaDetailDto;
import com.skt.tidhub.information.adapter.out.dto.QnaResultDto;
import com.skt.tidhub.information.adapter.out.dto.QnaStatusDto;
import com.skt.tidhub.information.adapter.out.entity.QQnaEntity;
import com.skt.tidhub.information.adapter.out.entity.QnaEntity;
import com.skt.tidhub.information.adapter.out.repository.QnaRepositoryCustom;

public class QnaRepositoryImpl implements QnaRepositoryCustom{
	
	private final JPAQueryFactory queryFactory;

	public QnaRepositoryImpl(EntityManager em) {
		 this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public QnaStatusDto findByLoginId(String loginId) {
		QQnaEntity qna = QQnaEntity.qnaEntity;
		
		List<String> total = queryFactory
				.select(qna.answ_st_cd)
				.from(qna)
				.where(qna.login_id.eq(loginId))
				.fetch();
		
		List<String> ongoing = queryFactory
				.select(qna.answ_st_cd)
				.from(qna)
				.where(qna.answ_st_cd.eq("on")
						.and(qna.login_id.eq(loginId)))
				.fetch();
		
		List<String> answered = queryFactory
				.select(qna.answ_st_cd)
				.from(qna)
				.where(qna.answ_st_cd.eq("an")
						.and(qna.login_id.eq(loginId)))
				.fetch();
		
		return new QnaStatusDto(total.size(), ongoing.size(), answered.size());
	}

	@Override
	public Page<QnaResultDto> findQnas(Pageable pageable, String loginId) {
		QQnaEntity qnas = QQnaEntity.qnaEntity;
		
		List<QnaEntity> list = queryFactory
				.selectFrom(qnas)
				.where(qnas.login_id.eq(loginId)
						.and(qnas.rgstr_dtm.after(LocalDateTime.now().minusMonths(3))) //TODO 3개월 기준?
						)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch()
				;

		Long total = queryFactory
				.select(qnas.count())
				.from(qnas)
				.where(qnas.login_id.eq(loginId))
				.fetchOne();

		List<QnaResultDto> content = list.stream()
				.map(q -> new QnaResultDto(q))
				.collect(Collectors.toList());

	 	return new PageImpl<>(content, pageable, total);
	}

	@Override
	public QnaDetailDto findByQnaId(Integer id, String loginId) {
		QQnaEntity qnas = QQnaEntity.qnaEntity;

		QnaEntity results = queryFactory
				.selectFrom(qnas)
				.where(qnas.seq.eq(id)
						.and(qnas.login_id.eq(loginId)))
				.fetchOne();
		
		return new QnaDetailDto(results);
	}	

}
