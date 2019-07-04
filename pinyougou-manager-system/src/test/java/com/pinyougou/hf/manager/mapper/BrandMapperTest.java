package com.pinyougou.hf.manager.mapper;

import com.pinyougou.hf.framework.model.TbBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author NQ
 * @create 2019-06-09 15:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BrandMapperTest {

    @Autowired
    BrandMapper brandMapper;

    @Test
    public void test01() throws Exception{

        List<TbBrand> all = brandMapper.findAll();
        System.out.println(all.size());

    }

}