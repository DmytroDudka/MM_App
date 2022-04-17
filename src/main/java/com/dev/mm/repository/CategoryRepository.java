package com.dev.mm.repository;

import com.dev.mm.entity.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

  @Query(value = "Select * from \"category\" where \"category\" = ':category'", nativeQuery = true)
  CategoryEntity findByCategory(@Param("category") String category);

}
