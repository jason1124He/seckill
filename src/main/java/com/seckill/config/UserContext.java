package com.seckill.config;

import com.seckill.entity.SeckillUserEntity;

public class UserContext {

    private static ThreadLocal<SeckillUserEntity> userHolder = new ThreadLocal<SeckillUserEntity>();

    public static void setUser(SeckillUserEntity user) {
        userHolder.set(user);
    }

    public static SeckillUserEntity getUser() {
        return userHolder.get();
    }

}
