package com.enviro.assessment.grad001.ntwananomathebula.waste_sorting_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Represents a recycling tip for a specific waste category.
 * This class is used to store recycling tips related to particular waste categories.
 */

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A tip or advice on how to recycle a specific type of waste
    @Column(nullable = false)
    private String tip;

    // The waste category this recycling tip is associated with
    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false)
    @JsonIgnore
    private WasteCategory wasteCategory;

    // Default constructor
    public RecyclingTip() {
    }

    // Constructor with parameters to initialize a RecyclingTip object
    public RecyclingTip(Long id, String tip, WasteCategory wasteCategory) {
        this.id = id;
        this.tip = tip;
        this.wasteCategory = wasteCategory;
    }

    // Getter and Setter methods for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter methods for the tip
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    // Getter and Setter methods for wasteCategory
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    // Override toString method for easy string representation of RecyclingTip object
    @Override
    public String toString() {
        return "RecyclingTip{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", wasteCategory=" + wasteCategory +
                '}';
    }
}
