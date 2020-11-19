package com.example.shopping.dao;

import com.example.shopping.model.SpecificationOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecificationOptionDao {
    public Integer insertOne(SpecificationOption option);
    public Integer deleteBySpecId(Long id);
    public List<SpecificationOption> selectOptionsBySpecId(Long specId);
}
