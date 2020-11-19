package com.example.shopping.service.impl;

import com.example.shopping.dao.SpecificationDao;
import com.example.shopping.dao.SpecificationOptionDao;
import com.example.shopping.model.Specification;
import com.example.shopping.model.SpecificationOption;
import com.example.shopping.service.SpecificationService;
import com.example.shopping.utils.PageResult;
import com.example.shopping.utils.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Resource
    private SpecificationDao specificationDao;
    @Resource
    private SpecificationOptionDao specificationOptionDao;
    @Override
    public PageResult<Specification> findPage(Integer pageNo, Integer pageSize) {
        //设置分页查询
        PageHelper.startPage(pageNo,pageSize);
        //执行分页查询
        Page<Specification> page=(Page<Specification>)specificationDao.findAll();
        //构造返回分页结果
        PageResult<Specification> pageResult=new PageResult<>(page.getTotal(),page.getResult());
        return pageResult;
    }

    @Override
    public Result addOne(Specification specification) {
        Result result=null;
        try {
            specificationDao.insertOne(specification);
            for(SpecificationOption option: specification.getOptions()){
                //specification中有没有id
                //对option进行关联specification
                option.setSpecification(specification);
                specificationOptionDao.insertOne(option);
            }
            result=new Result(true,"保存成功");
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Result deleteOne(Long id) {
        Result result;
        //两个步骤：先删除options,删除specification,
        try{
            specificationOptionDao.deleteBySpecId(id);
            specificationDao.deleteOneById(id);
            result=new Result(true,"删除成功");
        }catch (Exception e){
            result=new Result(false,"数据库操作失败");
        }
        return result;
    }

    @Override
    public Specification findOne(Long id) {
        Specification specification;
        specification=specificationDao.selectOne(id);
        return specification;
    }

    @Override
    public Result updateOne(Specification specification) {
        Result result;
        try{
            //先删除option
            specificationOptionDao.deleteBySpecId(specification.getId());
            //更改speicification
            specificationDao.updateOne(specification);
            //插入options
            for(SpecificationOption option:specification.getOptions()){
                option.setSpecification(specification);
                specificationOptionDao.insertOne(option);
            }
            result=new Result(false,"数据库操作成功");
        }catch (Exception e){
            result=new Result(false,"数据库操作失败");
        }
        return result;
    }

}
