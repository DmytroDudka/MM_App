package com.dev.mm.repository;

import com.dev.mm.entity.RecordEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, Long> {

  @Query(value = "SELECT SUM(amount) FROM record WHERE category_id = :categoryId", nativeQuery = true)
  Optional<Double> getSumByCategory(@Param("categoryId") Long categoryId);

  @Query(value = "SELECT SUM(amount) FROM record WHERE type_id = :flowtypeId", nativeQuery = true)
  Optional<Double> getSumByFlowType(@Param("flowtypeId") Long flowtypeId);

}
