package com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.service;

import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.WasteCategory;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    public WasteCategory createCategory(WasteCategory category) {
        return repository.save(category);
    }

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public WasteCategory getCategoryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public WasteCategory updateCategory(Long id, WasteCategory updatedCategory) {
        WasteCategory existingCategory = getCategoryById(id);
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());
        return repository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
