package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.service;

import java.util.List;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Empresa;
/**
 * IEmpresaService
 */
public interface IEmpresaService {

    public List<Empresa> findAll();

    public void save(Empresa company);

    public Empresa findOne(Long id);

    public void delete(Long id);
    
}