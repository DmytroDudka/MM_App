package com.dev.mm.repository;

import com.dev.mm.entity.FlowTypeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<FlowTypeEntity, Long> {

  @Query(value = "select id, flow_type from flow_type ft where ft.flow_type = :flowType", nativeQuery = true)
  Optional<FlowTypeEntity> getByType(@Param("flowType") String flowType);

}
