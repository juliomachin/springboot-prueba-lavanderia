package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import java.util.List;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

public interface ICarroDao {

    public List<Carro> findAll();

    public void save(Carro carro);
    
}