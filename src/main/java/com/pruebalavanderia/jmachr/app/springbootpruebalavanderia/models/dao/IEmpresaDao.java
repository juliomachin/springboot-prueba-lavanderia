package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import java.util.List;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Empresa;

public interface IEmpresaDao {
    
    public List<Empresa> findAll();

    public void save(Empresa company);
}
