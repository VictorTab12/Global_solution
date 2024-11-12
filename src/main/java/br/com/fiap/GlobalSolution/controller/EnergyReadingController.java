package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.domainmodel.EnergyReading;
import br.com.fiap.GlobalSolution.service.EnergyReadingService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EnergyReadingController {

    @Autowired
    private @Setter EnergyReadingService service;

    @GetMapping("/addNewEnergyReading")
    public String addNewEnergyReading( Model model ){
        EnergyReading add = new EnergyReading();
        model.addAttribute("energyReading", add);
        return "newEnergyReading";
    }

    @PostMapping("/saveEnergyReading")
    public String save( @ModelAttribute("energyReading") EnergyReading energyReading ){
        this.service.save( energyReading );
        return "redirect:/energyReading";
    }

    @GetMapping("/deleteEnergyReading/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/energyReading";
    }

    @GetMapping("/energyReading")
    public String viewHomePageAsList(Model model){
        List<EnergyReading> energyReadingList = this.service.findAll();
        model.addAttribute("allEnergyReadingList", energyReadingList);
        return "indexEnergyReading";
    }

    @GetMapping("/showFormForUpdateEnergyReading/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<EnergyReading> energyReading  = this.service.findById(id);
        if(energyReading.isPresent())
            model.addAttribute("energyReading", energyReading.get());
        else
            System.out.println("Error");
        return "updateEnergyReading";

    }

    @PostMapping("/updateEnergyReading")
    public String update( @ModelAttribute("energyReading") EnergyReading energyReading ){
        this.service.save( energyReading );
        return "redirect:/energyReading";
    }
}
