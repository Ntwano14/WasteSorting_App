package com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.service;

import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.DisposalGuideline;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.RecyclingTip;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.WasteCategory;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service layer for managing waste categories, disposal guidelines, and recycling tips.
 */

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    /**
     * Add a new waste category.
     * @param wasteCategory The waste category to be added.
     * @return The added waste category.
     */
    public WasteCategory addWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory); // Save the category and return it
    }

    /**
     * Retrieve all waste categories.
     * @return List of all waste categories.
     */
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll(); // Retrieve and return all categories
    }

    /**
     * Retrieve a waste category by its ID.
     * @param id The ID of the waste category.
     * @return The waste category associated with the given ID.
     * @throws RuntimeException if the category is not found.
     */
    public WasteCategory getCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found")); // Throw exception if not found
    }

    /**
     * Update an existing waste category.
     * @param id The ID of the category to update.
     * @param updatedCategory The updated waste category.
     * @return The updated waste category.
     * @throws RuntimeException if the category to update is not found.
     */
    public WasteCategory updateCategory(Long id, WasteCategory updatedCategory) {
        WasteCategory existingCategory = getCategoryById(id); // Retrieve the existing category
        existingCategory.setName(updatedCategory.getName()); // Update name
        existingCategory.setDescription(updatedCategory.getDescription()); // Update description
        return wasteCategoryRepository.save(existingCategory); // Save and return the updated category
    }

    /**
     * Delete a waste category by its ID.
     * @param id The ID of the category to delete.
     */
    public void deleteCategory(Long id) {
        wasteCategoryRepository.deleteById(id); // Delete category by ID
    }

    /**
     * Add a disposal guideline to a specific waste category.
     * @param categoryId The ID of the waste category.
     * @param guideline The disposal guideline to be added.
     * @return The added disposal guideline.
     * @throws RuntimeException if the waste category is not found.
     */
    public DisposalGuideline addDisposalGuideline(Long categoryId, DisposalGuideline guideline) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));
        guideline.setWasteCategory(category); // Set the waste category for the guideline
        return disposalGuidelineRepository.save(guideline); // Save and return the guideline
    }

    /**
     * Add a recycling tip to a specific waste category.
     * @param categoryId The ID of the waste category.
     * @param tip The recycling tip to be added.
     * @return The added recycling tip.
     * @throws RuntimeException if the waste category is not found.
     */
    public RecyclingTip addRecyclingTip(Long categoryId, RecyclingTip tip) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));
        tip.setWasteCategory(category); // Set the waste category for the recycling tip
        return recyclingTipRepository.save(tip); // Save and return the recycling tip
    }

    /**
     * Retrieve all disposal guidelines for a specific waste category.
     * @param categoryId The ID of the waste category.
     * @return List of disposal guidelines associated with the category.
     * @throws RuntimeException if the waste category is not found.
     */
    public List<DisposalGuideline> getDisposalGuidelinesByCategory(Long categoryId) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));
        return category.getDisposalGuidelines(); // Return all guidelines for the category
    }

    /**
     * Retrieve all recycling tips for a specific waste category.
     * @param categoryId The ID of the waste category.
     * @return List of recycling tips associated with the category.
     * @throws RuntimeException if the waste category is not found.
     */
    public List<RecyclingTip> getRecyclingTipsByCategory(Long categoryId) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));
        return category.getRecyclingTips(); // Return all recycling tips for the category
    }
}
