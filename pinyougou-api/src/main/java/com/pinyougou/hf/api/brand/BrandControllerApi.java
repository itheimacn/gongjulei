package com.pinyougou.hf.api.brand;

import com.pinyougou.hf.framework.model.TbBrand;
import com.pinyougou.hf.framework.model.response.QueryResponseResult;
import com.pinyougou.hf.framework.model.response.ResponseResult;
import com.pinyougou.hf.framework.response.brand.BrandResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 接口开发：
 *  * 要求我们无论 CRUD的 操作， 都必须要 返回 当前操作的提示信息
 * @author NQ
 * @create 2019-06-09 14:33
 */
@Api(value = "品牌管理接口", description = "品牌管理接口， 提供CRUD的操作")
public interface BrandControllerApi {

    @ApiOperation("查询所有品牌列表")
    List<TbBrand> findAll();
    // 带查询列表分页
    @ApiOperation("根据条件查询品牌列表带分页")
    QueryResponseResult<TbBrand> findByPage(TbBrand brand , Integer page
            , Integer size);
    // 添加或者修改
    @ApiOperation("添加品牌")
    BrandResponseResult save(TbBrand brand);
    // 查询一条
    @ApiOperation("根据ID查询品牌")
    BrandResponseResult findOne(Long id);
    // 删除
    @ApiOperation("批量删除品牌")
    ResponseResult deleteByIds(Long[] ids);

}
