package com.dev.mm.repository;

import com.dev.mm.entity.DescriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends CrudRepository<DescriptionEntity, Long> {

}
