package com.example.shopping.controller;

import com.example.shopping.model.Brand;
import com.example.shopping.service.BrandService;
import com.example.shopping.utils.PageResult;
import com.example.shopping.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult<Brand> findPage(Integer pageNo, Integer pageSize){
        if(pageNo<=0)
            pageNo=1;
        if( pageSize<=0)
            pageSize=10;
        return brandService.findPage(pageNo,pageSize);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody Brand brand){
        Result result;
        //有Id的用来修改，没有ID用来添加
        if(brand!=null&&brand.getId()!=null&&brand.getId()>0)
            result=brandService.updateBrand(brand);
        else
            result=brandService.addBrand(brand);
        return result;
    }
    @RequestMapping("/findOne")
    public Brand findOne(Integer id){
        Brand brand;
        if(id<=0)
            brand=new Brand(-1L,"输入数据出错","S");
        else
            brand=brandService.findBrand(id);
        return brand;
    }
    @RequestMapping("/deleteOne")
    public Result deleteOne(Integer id){
        Result result=null;
        if(id<=0)
            result=new Result(false,"请输入正确的id");
        else {
            result=brandService.deleteOne(id);
        }
        return result;
    }
    @RequestMapping("/deleteMany")
    public Result deleteMany(Integer[] ids){
        Result result=null;
        if(ids!=null&&ids.length>0){
            result=brandService.deleteMany(ids);
        }else
            result=new Result(false,"请输入要删除的数据！");
        return result;
    }
}
