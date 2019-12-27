package com.seckill.service.impl;

import com.seckill.entity.UserEntity;
import com.seckill.dao.UserDao;
import com.seckill.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

}
