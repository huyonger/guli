package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author huyong
 * @email huyong@gmail.com
 * @date 2023-07-16 17:38:57
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
