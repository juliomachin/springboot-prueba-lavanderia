package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.services.ICarroService;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.util.paginator.PageRender;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;




@Controller
@SessionAttributes("carro")
public class HomeController {

    @Autowired
    private ICarroService carroService;

    @RequestMapping(value={"/", "/listarCarros"}, method = RequestMethod.GET)
    public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Carro> carros = carroService.findAll(pageRequest);

		PageRender<Carro> pageRender = new PageRender<Carro>("/listarCarros", carros);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("carros", carros);
		model.addAttribute("page", pageRender);
		return "listarCarros";
	}

    
    
    
}
