package com.skt.tidhub.information.adapter.out.repository.impl;

import java.util.List;
import java.util.stream.Collectors; 

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.skt.tidhub.information.adapter.in.entity.SearchNoticeEntity;
import com.skt.tidhub.information.adapter.out.dto.NoticeResultDto;
import com.skt.tidhub.information.adapter.out.entity.NoticeEntity;
import com.skt.tidhub.information.adapter.out.entity.QNoticeEntity;
import com.skt.tidhub.information.adapter.out.repository.NoticeRepositoryCustom;

public class NoticeRepositoryImpl implements NoticeRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	public NoticeRepositoryImpl(EntityManager em) {
		 this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public Page<NoticeResultDto> notices(Pageable pageable, SearchNoticeEntity search) {
		QNoticeEntity notice = QNoticeEntity.noticeEntity;

		List<NoticeEntity> list = queryFactory
				.selectFrom(notice)
				.where(eqPoc(search.getPoc())
						,likeKeyword(search.getKeyword())
						,eqTopFixed(search.isTop_fixed()))
				.orderBy(notice.seq.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch()
				;

		Long total = queryFactory
				.select(notice.count())
				.from(notice)
				.where(eqPoc(search.getPoc())
						,likeKeyword(search.getKeyword())
						,eqTopFixed(search.isTop_fixed()))
				.fetchOne();

		List<NoticeResultDto> content = list.stream()
				.map(n -> new NoticeResultDto(n))
				.collect(Collectors.toList());

	 	return new PageImpl<>(content, pageable, total);
	}

	@Override
	public NoticeResultDto noticesById(Integer id, SearchNoticeEntity search) {
		QNoticeEntity notice = QNoticeEntity.noticeEntity;
		NoticeEntity noticeEntity = queryFactory
				.selectFrom(notice)
				.where(eqId(id)
						,eqPoc(search.getPoc()))
				.fetchOne()
				;
		NoticeResultDto noticeResultDto = new NoticeResultDto(noticeEntity);
		return noticeResultDto;
	}

	@Override
	public NoticeResultDto noticesByType(Integer id, String type, SearchNoticeEntity search) {
		QNoticeEntity notice = QNoticeEntity.noticeEntity;
		NoticeEntity noticeEntity= queryFactory
					.selectFrom(notice)
					.where(eqPoc(search.getPoc())
							,ltgtId(id, type))
					.orderBy(notice.seq.desc())
					.limit(1)
					.fetchOne();

		NoticeResultDto noticeResultDto = new NoticeResultDto(noticeEntity);
		return noticeResultDto;
	}

	private BooleanExpression eqPoc(String poc) {
		if ("pc".equals(poc)) {
			return QNoticeEntity.noticeEntity.pcPocYn.eq("Y");
		} else if ("mw".equals(poc)) {
			return QNoticeEntity.noticeEntity.mwPocYn.eq("Y");
		} else if ("app".equals(poc)) {
			return QNoticeEntity.noticeEntity.appPocYn.eq("Y");
		} else {
			return null;
		}
	}

	private BooleanExpression likeKeyword(String keyword) {
		return keyword != null ? QNoticeEntity.noticeEntity.annceTitle.contains(keyword) : null;
	}

	private BooleanExpression eqTopFixed(Boolean topFixed) {
		String topFixedYn = (topFixed != null && topFixed) ? "Y" : "N";
		return topFixed != null ? QNoticeEntity.noticeEntity.topFixYn.eq(topFixedYn) : null;
	}

	private BooleanExpression eqId(Integer id) {
		return id != null ? QNoticeEntity.noticeEntity.seq.eq(id) : null;
	}

	private BooleanExpression ltgtId(Integer id, String type) {
		if ("prev".equals(type)) {
			return QNoticeEntity.noticeEntity.seq.eq(id-1);
		} else if ("next".equals(type)) {
			return QNoticeEntity.noticeEntity.seq.eq(id+1);
		}
		return null;
	}
}
