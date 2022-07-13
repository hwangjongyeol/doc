package com.skt.tidhub.information.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skt.tidhub.information.adapter.out.entity.BannerEntitiy;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntitiy, Integer>, BannerRepositoryCustom{
	
}
