package com.example.shopping.model;

import java.util.List;

/**
 * 品牌规则
 */
public class Specification {
    private Long id;
    private String specName;
    //多个规格选项
    private List<SpecificationOption> options;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<SpecificationOption> getOptions() {
        return options;
    }

    public void setOptions(List<SpecificationOption> options) {
        this.options = options;
    }

    public Specification() {
    }

    public Specification(Long id, String specName) {
        this.id = id;
        this.specName = specName;
    }

    public Specification(Long id, String specName, List<SpecificationOption> options) {
        this.id = id;
        this.specName = specName;
        this.options = options;
    }
}
