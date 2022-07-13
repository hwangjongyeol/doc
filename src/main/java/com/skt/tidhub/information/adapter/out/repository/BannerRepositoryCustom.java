package com.skt.tidhub.information.adapter.out.repository;

import java.util.List;

import com.skt.tidhub.information.adapter.in.entity.SearchBannerEntity;
import com.skt.tidhub.information.adapter.out.dto.BannerResultDto;

public interface BannerRepositoryCustom {
	List<BannerResultDto> findBanners(SearchBannerEntity searchBannerDTO);
}
