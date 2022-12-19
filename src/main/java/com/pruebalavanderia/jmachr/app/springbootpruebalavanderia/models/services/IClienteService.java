package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.services;
import java.util.List;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;


public interface IClienteService {
	
	public List<Cliente> findAll();

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
	
}
