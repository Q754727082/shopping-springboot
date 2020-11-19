package com.example.shopping.service.impl;

import com.example.shopping.dao.BrandDao;
import com.example.shopping.model.Brand;
import com.example.shopping.service.BrandService;
import com.example.shopping.utils.PageResult;
import com.example.shopping.utils.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;
    @Override
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    @Override
    public PageResult<Brand> findPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Page<Brand> page=(Page<Brand>) brandDao.findAll();
        PageResult<Brand> pageResult=new PageResult<>(page.getTotal(),page.getResult());
        return pageResult;
    }

    @Override
    public Result addBrand(Brand brand) {
        Result result;
        Integer ret=brandDao.insertOne(brand);
        if(ret>=1)
            result=new Result(true,"品牌添加成功");
        else
            result=new Result(false,"品牌添加失败");
        return  result;
    }

    @Override
    public Brand findBrand(Integer id) {
        return brandDao.selectOne(id);
    }

    @Override
    public Result updateBrand(Brand brand) {
        Result result;
        Integer ret=brandDao.updateOne(brand);
        if(ret>=1)
            result=new Result(true,"品牌添加成功");
        else
            result=new Result(false,"品牌添加失败");
        return  result;
    }

    @Override
    public Result deleteOne(Integer id) {
        Integer res=brandDao.deleteOne(id);
        Result result;
        if(res<=0)
            result=new Result(false,"删除失败");
        else
            result=new Result(true,"删除成功");
        return result;
    }

    @Override
    public Result deleteMany(Integer[] ids) {
        Result result;
        try{
            for(Integer id:ids){
                deleteOne(id);
            }
            result=new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new Result(false,"删除失败");
        }
        return result;
    }
}
