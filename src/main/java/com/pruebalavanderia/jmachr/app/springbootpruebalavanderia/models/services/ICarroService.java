package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

public interface ICarroService {
    
    public List<Carro> findAll();
	
	public Page<Carro> findAll(Pageable pageable);

	public void save(Carro cliente);
	
	public Carro findOne(Long id);
	
	public void delete(Long id);
}
