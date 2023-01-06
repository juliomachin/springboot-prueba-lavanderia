package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICarroDao extends PagingAndSortingRepository<Carro, Long> {
    
}
