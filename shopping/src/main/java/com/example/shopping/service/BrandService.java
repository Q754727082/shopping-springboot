package com.example.shopping.service;

import com.example.shopping.model.Brand;

import com.example.shopping.utils.PageResult;

import com.example.shopping.utils.Result;

import java.util.List;

public interface BrandService {
    public List<Brand> findAll();
    public PageResult<Brand> findPage(Integer pageNo, Integer pageSize);
    public Result addBrand(Brand brand);
    public Brand findBrand(Integer id);
    public Result updateBrand(Brand brand);
    public Result deleteOne(Integer id);
    public Result deleteMany(Integer[] ids);
}
