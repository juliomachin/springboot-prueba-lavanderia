package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.IClientDao;;


@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClientDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

}