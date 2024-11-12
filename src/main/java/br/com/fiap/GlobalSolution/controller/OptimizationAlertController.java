package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.domainmodel.OptimizationAlert;
import br.com.fiap.GlobalSolution.service.OptimizationAlertService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class OptimizationAlertController {

    @Autowired
    private @Setter OptimizationAlertService service;

    @GetMapping("/addNewOptimizationAlert")
    public String addNewOptimizationAlert( Model model ){
        OptimizationAlert add = new OptimizationAlert();
        model.addAttribute("optimizationAlert", add);
        return "newOptimizationAlert";
    }

    @PostMapping("/saveOptimizationAlert")
    public String save( @ModelAttribute("optimizationAlert") OptimizationAlert optimizationAlert ){
        this.service.save( optimizationAlert );
        return "redirect:/optimizationAlert";
    }

    @GetMapping("/deleteOptimizationAlert/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/optimizationAlert";
    }

    @GetMapping("/optimizationAlert")
    public String viewHomePageAsList(Model model){
        List<OptimizationAlert> optimizationAlertList = this.service.findAll();
        model.addAttribute("allOptimizationAlertList", optimizationAlertList);
        return "indexOptimizationAlert";
    }

    @GetMapping("/showFormForUpdateOptimizationAlert/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<OptimizationAlert> optimizationAlert  = this.service.findById(id);
        if(optimizationAlert.isPresent())
            model.addAttribute("optimizationAlert", optimizationAlert.get());
        else
            System.out.println("Error");
        return "updateOptimizationAlert";

    }

    @PostMapping("/updateOptimizationAlert")
    public String update( @ModelAttribute("optimizationAlert") OptimizationAlert optimizationAlert ){
        this.service.save( optimizationAlert );
        return "redirect:/optimizationAlert";
    }
}
