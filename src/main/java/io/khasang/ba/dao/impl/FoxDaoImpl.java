package io.khasang.ba.dao.impl;

import io.khasang.ba.dao.FoxDao;
import io.khasang.ba.entity.Fox;

public class FoxDaoImpl extends BasicDaoImpl<Fox> implements FoxDao {
    public FoxDaoImpl(Class<Fox> entityClass) {
        super(entityClass);
    }
}
