package com.bhawnesh.angular.crud.repository;

import com.bhawnesh.angular.crud.model.SampleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleModelRepository extends JpaRepository<SampleModel,Long> {

}
