package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.ICarroDao;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.IEmpresaDao;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Carro;

@Controller
public class CarroController {

    @Autowired
    private ICarroDao carroDao;

    @Autowired
    private IEmpresaDao empresaDao;

    @RequestMapping(value="/listarCarros", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de carros");
        model.addAttribute("carros", carroDao.findAll());
        return "listarCarros";
    }

    @RequestMapping(value = "/formCarro")
    public String crear(Map<String, Object> model){
        Carro carro = new Carro();
        model.put("carro", carro);
        model.put("titulo", "Añadir un Carro");
        
        return "formCarro";
    }

    @RequestMapping(value = "/formCarro", method = RequestMethod.POST)
    public String guardar(@Valid Carro carro, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("titulo",  "Añadir un Carro");
            model.addAttribute("companies", empresaDao.findAll());
            return "formCarro";
        }
        carroDao.save(carro);
        return "redirect:listarCarros";
    }
    
    
}
