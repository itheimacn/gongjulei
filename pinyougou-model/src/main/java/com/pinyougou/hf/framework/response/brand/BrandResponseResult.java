package com.pinyougou.hf.framework.response.brand;

import com.pinyougou.hf.framework.model.TbBrand;
import com.pinyougou.hf.framework.model.response.ResponseResult;
import com.pinyougou.hf.framework.model.response.ResultCode;
import lombok.Data;

/**
 * @author NQ
 * @create 2019-06-09 14:39
 */
@Data
public class BrandResponseResult extends ResponseResult {

    private TbBrand brand;

    public BrandResponseResult(ResultCode resultCode, TbBrand brand) {
        super(resultCode);
        this.brand = brand;
    }


}
