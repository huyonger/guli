package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author huyong
 * @email huyong@gmail.com
 * @date 2023-07-16 17:23:53
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
