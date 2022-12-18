package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.ICarroDao;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

@Service
public class CarroServiceImpl implements ICarroService{

    @Autowired
    private ICarroDao carroDao;

    @Transactional(readOnly=true)
    @Override
    public List<Carro> findAll() {
        // TODO Auto-generated method stub
        return (List<Carro>) carroDao.findAll();
    }

    @Transactional()
    @Override
    public void save(Carro carro) {
        // TODO Auto-generated method stub
        carroDao.save(carro);
    }

    @Transactional(readOnly=true)
    @Override
    public Carro findOne(Long id) {
        // TODO Auto-generated method stub
        return carroDao.findById(id).orElse(null);
    }

    @Transactional()
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        carroDao.deleteById(id);
    }
    
}
