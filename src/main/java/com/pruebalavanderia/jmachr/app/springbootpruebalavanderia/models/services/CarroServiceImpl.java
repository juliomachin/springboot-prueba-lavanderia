package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.ICarroDao;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

@Service
public class CarroServiceImpl implements ICarroService {

    @Autowired
    private ICarroDao carroDao;

    @Override
    public List<Carro> findAll() {
        // TODO Auto-generated method stub
        return (List<Carro>) carroDao.findAll();
}

    @Override
    public Page<Carro> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return carroDao.findAll(pageable);
    }

    @Override
    public void save(Carro carro) {
        // TODO Auto-generated method stub
        carroDao.save(carro);
        
    }

    @Override
    public Carro findOne(Long id) {
        // TODO Auto-generated method stub
        return carroDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        carroDao.deleteById(id);
        
    }
    
}
