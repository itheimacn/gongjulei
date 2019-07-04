package com.pinyougou.hf.manager.dao;

import com.pinyougou.hf.framework.model.TbBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author NQ
 * @create 2019-06-09 15:25
 */
public interface BrandRespository extends JpaRepository<TbBrand,Long> , JpaSpecificationExecutor<TbBrand>{

}
