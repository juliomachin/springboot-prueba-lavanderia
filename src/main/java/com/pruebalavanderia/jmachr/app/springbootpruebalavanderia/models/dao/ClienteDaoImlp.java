package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;

@Repository
public class ClienteDaoImlp implements IClientDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }
    
}
