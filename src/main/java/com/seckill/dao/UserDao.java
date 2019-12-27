package com.seckill.dao;

import com.seckill.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
