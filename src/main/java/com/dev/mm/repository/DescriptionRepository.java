package com.dev.mm.repository;

import com.dev.mm.entity.DescriptionEntity;
import com.dev.mm.entity.FlowTypeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends CrudRepository<DescriptionEntity, Long> {

  @Query(value = "select id, description from description ds where ds.description = :description", nativeQuery = true)
  Optional<DescriptionEntity> getByDescription(@Param("description") String description);
}
