package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;
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
		List<Cliente> clientes = clienteService.findAll();
		model.put("carro", carro);
		model.put("titulo", "Formulario de Carro");
        model.put("clientes", clientes);
		return "addCarro";
	}

	// TODO metodo guardar
	@RequestMapping(value = "/addCarro", method = RequestMethod.POST)
	public String guardar(@Valid Carro carro, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
		if(result.hasErrors()){
			model.addAttribute("titulo", "Formulario de Carro");
			return "addCarro";
		}
		String mensajeFlash = (carro.getId() != null) ? "Carro editado con exito!" : "Carro creado correctamente!";

		carroService.save(carro);
		System.out.println(carro.getCliente().getId());
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listarCarros";
	}


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
