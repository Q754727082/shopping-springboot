package com.example.shopping.controller;

import com.example.shopping.model.Specification;
import com.example.shopping.service.SpecificationService;
import com.example.shopping.utils.PageResult;
import com.example.shopping.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @RequestMapping("/findPage")
    public PageResult<Specification> findPage(Integer pageNo, Integer pageSize){
        PageResult<Specification> pageResult=null;
        if(pageNo==null||pageSize==null)
            pageResult=new PageResult<>(-1L,null);
        else {
            if(pageNo<=0)
                pageNo=1;
            if(pageSize<=0)
                pageSize=10;
            pageResult=specificationService.findPage(pageNo,pageSize);
        }
        return pageResult;
    }
    @RequestMapping("/saveOne")
    public Result saveOne(@RequestBody Specification specification){
        Result result=null;
        if(specification==null)
            result=new Result(false,"保存数据不能为空");
        else {
            //判断从前端传过来的是否有id
            if(specification.getId()==null) {
                result = specificationService.addOne(specification);
            }else {
                result=specificationService.updateOne(specification);
            }
        }
        return result;
    }
    @RequestMapping("/deleteOne")
    public Result deleteOne(Long id){
        Result result=null;
        if(id<=0){
            result=new Result(false,"输入的id必须合法");
        }else {
            result=specificationService.deleteOne(id);
        }
        return result;
    }
    @RequestMapping("/findOne")
    public Specification findOne(Long id){
        Specification specification=null;
        if(id<=0){
            specification=new Specification(-1L,"输入数据有误");
        }else {
            specification=specificationService.findOne(id);
        }
        return specification;
    }
}
