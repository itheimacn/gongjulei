package com.pinyougou.hf.manager.controller;

import com.pinyougou.hf.api.brand.BrandControllerApi;
import com.pinyougou.hf.framework.model.TbBrand;
import com.pinyougou.hf.framework.model.response.QueryResponseResult;
import com.pinyougou.hf.framework.model.response.ResponseResult;
import com.pinyougou.hf.framework.response.brand.BrandResponseResult;
import com.pinyougou.hf.manager.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author NQ
 * @create 2019-06-09 11:47
 */
@RestController
@RequestMapping("brand")
//@CrossOrigin  //(origins = {"http://localhost:8081"})
public class BrandController implements BrandControllerApi{


    @Autowired
    BrandService brandService;

    @Override
    @GetMapping("findAll")
    public List<TbBrand> findAll() {
       return brandService.findAll();
    }

    @Override
    @PostMapping("findByPage/{page}/{size}")
//    @CrossOrigin  //(origins = "http://127.0.0.1:8081",allowCredentials="true")
    public QueryResponseResult<TbBrand> findByPage(TbBrand brand, @PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        return brandService.findByPage(brand, page, size);
    }

    @Override
    @PostMapping("save")
    public BrandResponseResult save(@RequestBody  TbBrand brand) {
        return brandService.save(brand);
    }

    @Override
    @GetMapping("findOne/{id}")
    public BrandResponseResult findOne(@PathVariable("id") Long id) {
        return brandService.findOne(id);
    }

    @Override
    @DeleteMapping("deleteByIds")
    public ResponseResult deleteByIds(Long[] ids) {
        return brandService.deleteByIds(ids);
    }

}
