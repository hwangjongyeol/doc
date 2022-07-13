package com.skt.tidhub.information.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skt.tidhub.information.adapter.out.entity.QnaEntity;

public interface QnaRepository extends JpaRepository<QnaEntity, Long>, QnaRepositoryCustom{

}
