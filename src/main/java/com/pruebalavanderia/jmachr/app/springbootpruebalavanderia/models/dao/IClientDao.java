package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import java.util.List;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;

public interface IClientDao {
    
    public List<Cliente> findAll();

    public void save(Cliente cliente);

    
}
