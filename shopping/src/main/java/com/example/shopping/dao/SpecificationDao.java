package com.example.shopping.dao;

import com.example.shopping.model.Specification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SpecificationDao {
    public List<Specification> findAll();
    public Integer insertOne(Specification specification);
    public Integer deleteOneById(Long id);
    public Specification selectOne(Long id);
    public Integer updateOne(Specification specification);
}
