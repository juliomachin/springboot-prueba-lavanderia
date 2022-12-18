package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

public interface ICarroDao extends CrudRepository <Carro, Long> {
    
}