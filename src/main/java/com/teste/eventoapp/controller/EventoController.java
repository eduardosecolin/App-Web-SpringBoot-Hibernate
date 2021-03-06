package com.teste.eventoapp.controller;

import com.teste.eventoapp.models.Evento;
import com.teste.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value = "/registerController", method = RequestMethod.GET)
    public String form(){
        return "Event/formEvent";
    }

    @RequestMapping(value = "/registerController", method = RequestMethod.POST)
    public String form(Evento evento){
        eventoRepository.save(evento);
        return "redirect:/registerController";
    }

    @RequestMapping("/eventos")
    public ModelAndView listEvents(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = eventoRepository.findAll();
        mv.addObject("eventoapp", eventos);
        return mv;
    }
}
