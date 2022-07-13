package com.skt.tidhub.information.adapter.out.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.skt.tidhub.board.entity.QFaqCttEntity;
import com.skt.tidhub.board.entity.QFaqEntity;
import com.skt.tidhub.information.adapter.in.entity.SearchFaqListEntity;
import com.skt.tidhub.information.adapter.out.dto.FaqDetailDto;
import com.skt.tidhub.information.adapter.out.dto.FaqListResultDto;
import com.skt.tidhub.information.adapter.out.entity.FaqEntity;
import com.skt.tidhub.information.adapter.out.repository.FaqRepositoryCustom;

public class FaqRepositoryImpl implements FaqRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	public FaqRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public Page<FaqListResultDto> findFaqs(Pageable pageable, SearchFaqListEntity searchFaqListDto) {
		QFaqEntity faq = QFaqEntity.faqEntity;
		QFaqCttEntity faqCtt = QFaqCttEntity.faqCttEntity;

		List<FaqEntity> results = queryFactory.selectFrom(faq)
				.where(faq.inq_title.contains(searchFaqListDto.getKeyword())
						,eqCategory(searchFaqListDto))
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
					.fetch();

		List<FaqListResultDto> content = results
				.stream()
				.map(o -> new FaqListResultDto(o))
				.collect(Collectors.toList());

		Long total = queryFactory.select(faq.count()).from(faq).fetchOne();

		return new PageImpl<>(content, pageable, total);
	}

	@Override
	public FaqDetailDto findByFaqId(Integer id) {
		QFaqEntity faq = QFaqEntity.faqEntity;

		FaqEntity results = queryFactory
				.selectFrom(faq)
				.where(faq.seq.eq(id))
				.fetchOne();

		return new FaqDetailDto(results);
	}

	private BooleanExpression eqCategory(SearchFaqListEntity searchFaqListDto) {
		if (StringUtils.isEmpty(searchFaqListDto.getFaq_category())) {
			return null;
		}
		if (searchFaqListDto.getFaq_category().equals("BT")) {
			return null;
		}
		
		return QFaqEntity.faqEntity.inq_typ_cd.eq(searchFaqListDto.getFaq_category());
	}

}
