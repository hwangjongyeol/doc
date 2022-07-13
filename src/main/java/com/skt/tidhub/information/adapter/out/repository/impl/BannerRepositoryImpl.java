package com.skt.tidhub.information.adapter.out.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.skt.tidhub.board.entity.QBannerEntitiy;
import com.skt.tidhub.board.entity.QImageEntity;
import com.skt.tidhub.information.adapter.in.entity.SearchBannerEntity;
import com.skt.tidhub.information.adapter.out.dto.BannerResultDto;
import com.skt.tidhub.information.adapter.out.repository.BannerRepositoryCustom;

public class BannerRepositoryImpl implements BannerRepositoryCustom{

	private final JPAQueryFactory queryFactory;
	
	public BannerRepositoryImpl(EntityManager em) {
		 this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public List<BannerResultDto> findBanners(SearchBannerEntity searchBannerDTO) {
		QBannerEntitiy banner = QBannerEntitiy.bannerEntitiy;
		QImageEntity image = QImageEntity.imageEntity;
		
		List<BannerResultDto> bannerEntitiy = queryFactory
				.select(Projections.constructor(BannerResultDto.class, banner))
				.from(banner)
				.where(banner.dispPoc.eq(searchBannerDTO.getDispPoc()),banner.bannerPositionTypCd.eq(searchBannerDTO.getBannerPositionTypCd()))
				.leftJoin(banner.image, image)
				.fetchJoin()
				.fetch();
						
		return bannerEntitiy;
	}
}
