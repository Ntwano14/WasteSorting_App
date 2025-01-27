package com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.controller;

import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.DisposalGuideline;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.RecyclingTip;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model.WasteCategory;
import com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing waste categories, disposal guidelines, and recycling tips.
 * This controller provides endpoints for CRUD operations on waste categories and the addition of disposal guidelines and recycling tips.
 */

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    /**
     * Endpoint to create a new waste category.
     * @param category The waste category object to be created.
     * @return ResponseEntity with the created waste category.
     */
    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategory category) {
        return ResponseEntity.ok(wasteCategoryService.addWasteCategory(category));
    }

    /**
     * Endpoint to retrieve all waste categories.
     * @return ResponseEntity with a list of all waste categories.
     */
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        return ResponseEntity.ok(wasteCategoryService.getAllCategories());
    }

    /**
     * Endpoint to retrieve a specific waste category by its ID.
     * @param id The ID of the waste category to retrieve.
     * @return ResponseEntity with the waste category.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.getCategoryById(id));
    }

    /**
     * Endpoint to update an existing waste category by its ID.
     * @param id The ID of the waste category to update.
     * @param category The updated waste category object.
     * @return ResponseEntity with the updated waste category.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        return ResponseEntity.ok(wasteCategoryService.updateCategory(id, category));
    }

    /**
     * Endpoint to delete a specific waste category by its ID.
     * @param id The ID of the waste category to delete.
     * @return ResponseEntity with no content indicating successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint to add a disposal guideline to a specific waste category.
     * @param categoryId The ID of the waste category.
     * @param guideline The disposal guideline to add.
     * @return ResponseEntity with the added disposal guideline.
     */
    @PostMapping("/{categoryId}/disposal-guidelines")
    public ResponseEntity<DisposalGuideline> addDisposalGuideline(@PathVariable Long categoryId, @RequestBody DisposalGuideline guideline) {
        return ResponseEntity.ok(wasteCategoryService.addDisposalGuideline(categoryId, guideline));
    }

    /**
     * Endpoint to add a recycling tip to a specific waste category.
     * @param categoryId The ID of the waste category.
     * @param tip The recycling tip to add.
     * @return ResponseEntity with the added recycling tip.
     */
    @PostMapping("/{categoryId}/recycling-tips")
    public ResponseEntity<RecyclingTip> addRecyclingTip(@PathVariable Long categoryId, @RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(wasteCategoryService.addRecyclingTip(categoryId, tip));
    }

    /**
     * Endpoint to retrieve all disposal guidelines for a specific waste category.
     * @param categoryId The ID of the waste category.
     * @return ResponseEntity with the list of disposal guidelines for the given waste category.
     */
    @GetMapping("/{categoryId}/disposal-guidelines")
    public ResponseEntity<List<DisposalGuideline>> getDisposalGuidelines(@PathVariable Long categoryId) {
        return ResponseEntity.ok(wasteCategoryService.getDisposalGuidelinesByCategory(categoryId));
    }

    /**
     * Endpoint to retrieve all recycling tips for a specific waste category.
     * @param categoryId The ID of the waste category.
     * @return ResponseEntity with the list of recycling tips for the given waste category.
     */
    @GetMapping("/{categoryId}/recycling-tips")
    public ResponseEntity<List<RecyclingTip>> getRecyclingTips(@PathVariable Long categoryId) {
        return ResponseEntity.ok(wasteCategoryService.getRecyclingTipsByCategory(categoryId));
    }
}
