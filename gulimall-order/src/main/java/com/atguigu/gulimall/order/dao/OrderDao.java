package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author huyong
 * @email huyong@gmail.com
 * @date 2023-07-16 17:46:34
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
