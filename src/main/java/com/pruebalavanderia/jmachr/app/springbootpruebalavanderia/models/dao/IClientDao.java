package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;

public interface IClientDao extends CrudRepository<Cliente, Long>{


}
