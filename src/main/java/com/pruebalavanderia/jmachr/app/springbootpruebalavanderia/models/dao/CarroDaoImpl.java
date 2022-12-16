package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

@Repository
public class CarroDaoImpl implements ICarroDao{

    @PersistenceContext
    private EntityManager eM;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    @Override
    public List<Carro> findAll() {
        
        return eM.createQuery("from Carro").getResultList();
    }

    @Override
    @Transactional
    public void save(Carro carro) {
        if(carro.getId() != null && carro.getId() > 0 ){
            eM.merge(carro);
        }else{
             eM.persist(carro);
        }
        
    }

    @Override
    @Transactional(readOnly = true)
    public Carro findOne(Long id) {
        return eM.find(Carro.class, id);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        eM.remove(findOne(id));
        
    }
    
}
