package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.put("titulo", "Añadir un Carro Prueba");
        model.put("empresas", empresaDao.findAll());
        
        return "formCarro";
    }

    @RequestMapping(value = "/formCarro", method = RequestMethod.POST)
    public String guardar(@Valid Carro carro, BindingResult result, Model model){
    
        if (result.hasErrors()) {
            model.addAttribute("titulo",  "Añadir un Carro");
            model.addAttribute("empresas", empresaDao.findAll());
            return "formCarro";
        }
        carroDao.save(carro);
        return "redirect:listarCarros";
    }

    @GetMapping("/editCarro/{id}")
    public String editarCarro(@PathVariable(value="id") Long id, Map<String, Object> model){

        Carro carro = null;
        

        if(id > 0){
            carro = carroDao.findOne(id);
        }else{
            return "redirect:/listarCarro";
        }

        model.put("carro", carro);
        model.put("titulo", "Editar carro");
        model.put("empresas", empresaDao.findAll());


        return "editCarro";
    } 

    @RequestMapping(value = "/deleteCarro/{id}")
    public String delete(@PathVariable(value="id") Long id){
        
        if(id > 0){
            carroDao.delete(id);
        }

        return "redirect:/listarCarros";
    }
    
}
