package com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.repository;

import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

}
