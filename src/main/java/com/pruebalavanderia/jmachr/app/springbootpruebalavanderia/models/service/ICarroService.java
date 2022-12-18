package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.service;

import java.util.List;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

public interface ICarroService {
    
    public List<Carro> findAll();

    public void save(Carro carro);

    public Carro findOne(Long id);

    public void delete(Long id);
    
}
