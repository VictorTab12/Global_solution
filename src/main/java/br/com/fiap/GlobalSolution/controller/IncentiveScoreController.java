package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.domainmodel.IncentiveScore;
import br.com.fiap.GlobalSolution.service.IncentiveScoreService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class IncentiveScoreController {

    @Autowired
    private @Setter IncentiveScoreService service;

    @GetMapping("/addNewIncentiveScore")
    public String addNewIncentiveScore( Model model ){
        IncentiveScore add = new IncentiveScore();
        model.addAttribute("incentiveScore", add);
        return "newIncentiveScore";
    }

    @PostMapping("/saveIncentiveScore")
    public String save( @ModelAttribute("incentiveScore") IncentiveScore incentiveScore ){
        this.service.save( incentiveScore );
        return "redirect:/incentiveScore";
    }

    @GetMapping("/deleteIncentiveScore/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/incentiveScore";
    }

    @GetMapping("/incentiveScore")
    public String viewHomePageAsList(Model model){
        List<IncentiveScore> incentiveScoreList = this.service.findAll();
        model.addAttribute("allIncentiveScoreList", incentiveScoreList);
        return "indexIncentiveScore";
    }

    @GetMapping("/showFormForUpdateIncentiveScore/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<IncentiveScore> incentiveScore  = this.service.findById(id);
        if(incentiveScore.isPresent())
            model.addAttribute("incentiveScore", incentiveScore.get());
        else
            System.out.println("Error");
        return "updateIncentiveScore";

    }

    @PostMapping("/updateIncentiveScore")
    public String update( @ModelAttribute("incentiveScore") IncentiveScore incentiveScore ){
        this.service.save( incentiveScore );
        return "redirect:/incentiveScore";
    }
}
