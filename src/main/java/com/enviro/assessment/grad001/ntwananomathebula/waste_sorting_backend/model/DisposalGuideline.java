package com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Represents a disposal guideline for a specific waste category.
 */

@Entity
public class DisposalGuideline {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Detailed guideline on how to dispose of a specific type of waste
        @Column(nullable = false)
        private String guideline;

        // The waste category this guideline is associated with
        @ManyToOne
        @JoinColumn(name = "waste_category_id", nullable = false)
        @JsonIgnore // Prevents infinite recursion when serializing WasteCategory
        private WasteCategory wasteCategory;

        // Getters and Setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getGuideline() {
                return guideline;
        }

        public void setGuideline(String guideline) {
                this.guideline = guideline;
        }

        public WasteCategory getWasteCategory() {
                return wasteCategory;
        }

        public void setWasteCategory(WasteCategory wasteCategory) {
                this.wasteCategory = wasteCategory;
        }

        @Override
        public String toString() {
                return "DisposalGuideline{" +
                        "id=" + id +
                        ", guideline='" + guideline + '\'' +
                        ", wasteCategory=" + wasteCategory +
                        '}';
        }
}
