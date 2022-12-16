package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.dao.IEmpresaDao;
import com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity.Empresa;

@Controller
public class EmpresaController {

    @Autowired
    private IEmpresaDao empresaDao;

    @RequestMapping(value="/listarEmpresas", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Empresas");
        model.addAttribute("companies", empresaDao.findAll());
        return "listarEmpresas";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model){
        Empresa company = new Empresa();
        model.put("company", company);
        model.put("titulo", "Formulario de Empresa");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Empresa company, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("titulo",  "Formulario de Empresa");
            return "form";
        }
        empresaDao.save(company);
        return "redirect:listarEmpresas";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model){
        
        Empresa company = null;

        if(id > 0){
            company = empresaDao.findOne(id);
        }else{
            return "redirect:/form";
        }

        model.put("company", company);
        model.put("titulo", "Editar cliente");
        return "form";

    }

    @RequestMapping(value = "/deleteCompany/{id}")
    public String delete(@PathVariable(value="id") Long id){
        if(id > 0){
            empresaDao.delete(id);
        }

        return "redirect:/listarEmpresas";
    }
    
}
