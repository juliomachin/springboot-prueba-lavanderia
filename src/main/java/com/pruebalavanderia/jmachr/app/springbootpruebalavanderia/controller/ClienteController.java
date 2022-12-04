package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.IClientDao;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Cliente;

@Controller
public class ClienteController {

    @Autowired
    private IClientDao clientDao;


    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clientDao.findAll());
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente){
        clientDao.save(cliente);
        return "redirect:listar";
    }
    
}
