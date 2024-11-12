package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.domainmodel.Telephone;
import br.com.fiap.GlobalSolution.service.TelephoneService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TelephoneController {

    @Autowired
    private  @Setter TelephoneService service;

    @GetMapping("/addNewTelephone")
    public String addNewTelephone( Model model ){
        Telephone tel = new Telephone();
        model.addAttribute("telephone", tel);
        return "newTelephone";
    }

    @PostMapping("/saveTelephone")
    public String save( @ModelAttribute("telephone") Telephone telephone ){
        this.service.save( telephone );
        return "redirect:/telephone";
    }

    @GetMapping("/deleteTelephone/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/telephone";
    }

    @GetMapping("/telephone")
    public String viewHomePageAsList(Model model){
        List<Telephone> telephoneList = this.service.findAll();
        model.addAttribute("allTelephoneList", telephoneList);
        return "indexTelephone";
    }

    @GetMapping("/showFormForUpdateTelephone/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Telephone> telephone  = this.service.findById(id);
        if(telephone.isPresent())
            model.addAttribute("telephone", telephone.get());
        else
            System.out.println("Error");
        return "updateTelephone";

    }

    @PostMapping("/updateTelephone")
    public String update( @ModelAttribute("telephone") Telephone telephone ){
        this.service.save( telephone );
        return "redirect:/telephone";
    }
}
