package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface IClientDao extends PagingAndSortingRepository<Cliente, Long>{


}


