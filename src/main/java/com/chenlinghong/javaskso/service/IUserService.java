package com.chenlinghong.javaskso.service;

import com.chenlinghong.javaskso.controller.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 0:36
 */
@Service
public interface IUserService {

    public User getById(int id);
}