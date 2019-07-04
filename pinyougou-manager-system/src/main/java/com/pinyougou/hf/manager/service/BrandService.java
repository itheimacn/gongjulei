package com.pinyougou.hf.manager.service;

import com.pinyougou.hf.framework.model.TbBrand;
import com.pinyougou.hf.framework.model.response.CommonCode;
import com.pinyougou.hf.framework.model.response.QueryResponseResult;
import com.pinyougou.hf.framework.model.response.QueryResult;
import com.pinyougou.hf.framework.model.response.ResponseResult;
import com.pinyougou.hf.framework.response.brand.BrandResponseResult;
import com.pinyougou.hf.manager.dao.BrandRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author NQ
 * @create 2019-06-09 15:31
 */
@Service
public class BrandService {

    @Autowired
    BrandRespository brandRespository;

    public  List<TbBrand> findAll() {
        return brandRespository.findAll();
    }

    // 带查询列表分页
    public QueryResponseResult<TbBrand> findByPage(TbBrand brand, Integer pageNum, Integer pageSize) {

        if (pageNum <= 0) {
            pageNum = 1;
        }
        pageNum = pageNum - 1;

        if (pageSize <= 0) {
            pageSize = 10;
        }

        Pageable pageable = PageRequest.of(pageNum, pageSize);

        Page<TbBrand> brandPage = brandRespository.findAll(pageable);

        QueryResult<TbBrand> queryResult = new QueryResult<>();
        queryResult.setTotal(brandPage.getTotalElements());
        queryResult.setList(brandPage.getContent());

        QueryResponseResult<TbBrand> responseResult = new QueryResponseResult<>(CommonCode.SUCCESS, queryResult);

        return responseResult;
    }
    // 添加或者修改
    public  BrandResponseResult save(TbBrand brand) {
        TbBrand save = brandRespository.save(brand);
        return new BrandResponseResult(CommonCode.SUCCESS, save);
    }
    // 查询一条
    public  BrandResponseResult findOne(Long id) {
        Optional<TbBrand> brandOptional = brandRespository.findById(id);

        if (brandOptional.isPresent()) {
            return new BrandResponseResult(CommonCode.SUCCESS, brandOptional.get());
        }

        return new BrandResponseResult(CommonCode.FAIL, null);

    }
    // 删除
    public ResponseResult deleteByIds(Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        for (Long id : list) {
            brandRespository.deleteById(id);
        }

        return new ResponseResult(CommonCode.SUCCESS);
    }
}
