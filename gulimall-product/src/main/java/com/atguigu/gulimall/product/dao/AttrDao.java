package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author huyong
 * @email huyong@gmail.com
 * @date 2023-07-16 17:27:43
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
