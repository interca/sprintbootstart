package com.it.dao.impl;

import com.it.dao.Dao;
import org.springframework.stereotype.Component;

@Component
public class bookdao implements Dao {
    @Override
    public void save() {
        System.out.println("nihao");
    }
}
