package com.example.shopping.dao;

import com.example.shopping.model.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandDao {
    public List<Brand> findAll();
    public Integer insertOne(Brand brand);
    public Brand selectOne(Integer id);
    public Integer updateOne(Brand brand);
    public Integer deleteOne(Integer id);

}

