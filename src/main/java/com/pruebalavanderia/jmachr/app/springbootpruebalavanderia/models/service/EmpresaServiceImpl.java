package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.IEmpresaDao;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Empresa;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    private IEmpresaDao empresaDao;

    @Transactional(readOnly=true)
    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) empresaDao.findAll();
    }

    @Override
    @Transactional()
    public void save(Empresa company) {
        // TODO Auto-generated method stub
        empresaDao.save(company);
    }

    @Override
    @Transactional(readOnly=true)
    public Empresa findOne(Long id) {
        // TODO Auto-generated method stub
        return empresaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public void delete(Long id) {
        // TODO Auto-generated method stub
        empresaDao.deleteById(id);
    }
    
}
