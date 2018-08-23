package com.sunarmy.cn.Dao;

import com.sunarmy.cn.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wb-wsj429645 on 2018/8/24.
 */
@Repository
public interface UserRepository extends CrudRepository<User,String>{
}
