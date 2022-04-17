package com.dev.mm.repository;

import com.dev.mm.entity.RecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<RecordEntity, Long> {

}
