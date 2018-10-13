package io.khasang.ba.service.impl;

import io.khasang.ba.dao.FoxDao;
import io.khasang.ba.entity.Fox;
import io.khasang.ba.service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxServiceImpl implements FoxService {

    @Autowired
    private FoxDao foxDao;

    @Override
    public Fox addFox(Fox fox) {
        return foxDao.add(fox);
    }

    @Override
    public Fox getFoxById(long id) {
        return foxDao.getById(id);
    }

    @Override
    public List<Fox> getAllFoxes() {
        return foxDao.getAll();
    }

    @Override
    public Fox updateFox(Fox fox) {
        return foxDao.update(fox);
    }

    @Override
    public Fox deleteFox(long id) {
        return foxDao.delete(getFoxById(id));
    }
}
