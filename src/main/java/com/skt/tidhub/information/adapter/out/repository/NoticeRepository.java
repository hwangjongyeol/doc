package com.skt.tidhub.information.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skt.tidhub.information.adapter.out.entity.NoticeEntity;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer>, NoticeRepositoryCustom {

}
