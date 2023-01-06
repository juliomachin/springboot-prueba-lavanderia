package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.services.ICarroService;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.services.IClienteService;

@Controller
@SessionAttributes("carro")
public class CarroController {

    @Autowired
    private ICarroService carroService;

    @Autowired
    private IClienteService clienteService;


    @RequestMapping(value = "/addCarro")
	public String crear(Map<String, Object> model) {

		Carro carro = new Carro();
		model.put("carro", carro);
		model.put("titulo", "Formulario de Carro");
        model.put("clientes", clienteService.findAll());
		return "addCarro";
	}

	// TODO metodo guardar


	@RequestMapping(value = "/addCarro/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Carro carro = null;

		if (id > 0) {
			carro = carroService.findOne(id);
			if (carro == null) {
				flash.addFlashAttribute("error", "El ID del carro no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del carro no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("carro", carro);
		model.put("titulo", "Editar carro");
		return "form";
	}
    

	@RequestMapping(value = "/eliminarCarro/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {

			if (id > 0) {
				carroService.delete(id);
				flash.addFlashAttribute("success", "Carro eliminado con éxito!");

			}
			
		}
		return "redirect:/listarCarros";
	}
}
