package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Empresa;

@Repository
public class EmpresaDaoImpl implements IEmpresaDao{

    @PersistenceContext
    private EntityManager eM;


    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    @Override
    public List<Empresa> findAll() {

        return eM.createQuery("from Empresa").getResultList();
    }

    @Override
    @Transactional
    public void save(Empresa company) {
        if(company.getId() != null && company.getId() > 0 ){
            eM.merge(company);
        }else{
             eM.persist(company);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public Empresa findOne(Long id) {
        return eM.find(Empresa.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        eM.remove(findOne(id));
        
    }
    
}
