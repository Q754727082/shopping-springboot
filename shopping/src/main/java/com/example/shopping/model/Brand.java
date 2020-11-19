package com.example.shopping.model;

/**
 * 品牌类
 */
public class Brand {
    private Long id;
    private String name;
    private String firstChar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    public Brand() {
    }

    public Brand(Long id, String name, String firstChar) {
        this.id = id;
        this.name = name;
        this.firstChar = firstChar;
    }
}
