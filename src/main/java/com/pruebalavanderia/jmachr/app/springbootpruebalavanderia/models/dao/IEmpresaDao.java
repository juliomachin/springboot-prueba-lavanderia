package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Empresa;

public interface IEmpresaDao extends CrudRepository <Empresa, Long> {
    
    
}
