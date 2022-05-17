package com.dev.mm.repository;

import com.dev.mm.entity.CategoryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

  @Query(value = "select id, category from category c where c.category = :category", nativeQuery = true)
  Optional<CategoryEntity> getByCategory(@Param("category") String category);

}
