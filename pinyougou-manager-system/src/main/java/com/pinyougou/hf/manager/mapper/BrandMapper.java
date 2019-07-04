package com.pinyougou.hf.manager.mapper;

import com.pinyougou.hf.framework.model.TbBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author NQ
 * @create 2019-06-09 15:52
 */
@Mapper
public interface BrandMapper {

    public List<TbBrand> findAll();

}
