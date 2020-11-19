package com.example.shopping.service;


import com.example.shopping.model.Specification;
import com.example.shopping.utils.PageResult;
import com.example.shopping.utils.Result;

/**
 * 品牌规格的服务
 */
public interface SpecificationService {
    public PageResult<Specification> findPage(Integer pageNo, Integer pageSize);
    public Result addOne(Specification specification);
    public Result deleteOne(Long id);
    public Specification findOne(Long id);
    public Result updateOne(Specification specification);
}
