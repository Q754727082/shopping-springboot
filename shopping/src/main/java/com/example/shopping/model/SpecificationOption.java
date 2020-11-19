package com.example.shopping.model;

/**
 * 规格选项
 */
public class SpecificationOption {
    private Long id;
    private String optionName;
    //引用了规格
    private Specification specification;
    private Integer order;

    public SpecificationOption() {
    }

    public SpecificationOption(Long id, String optionName, Specification specification, Integer order) {
        this.id = id;
        this.optionName = optionName;
        this.specification = specification;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
