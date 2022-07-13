package com.skt.tidhub.information.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skt.tidhub.information.adapter.out.entity.FaqEntity;

public interface FaqRepository extends JpaRepository<FaqEntity, Integer>, FaqRepositoryCustom{

}
