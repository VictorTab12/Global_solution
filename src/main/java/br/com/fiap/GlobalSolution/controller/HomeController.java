package br.com.fiap.GlobalSolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/indexUsers")
    public String indexUsers() {
        return "indexUsers";
    }

    @GetMapping("/indexAddress")
    public String indexAddress() {
        return "indexAddress";
    }

    @GetMapping("/indexTelephone")
    public String indexTelephone() {
        return "indexTelephone";
    }

    @GetMapping("/indexDevice")
    public String indexDevice() {
        return "indexDevice";
    }

    @GetMapping("/indexIncentiveScore")
    public String indexIncentiveScore() {
        return "indexIncentiveScore";
    }

    @GetMapping("/indexOptimizationAlert")
    public String indexOptimizationAlert() {
        return "indexOptimizationAlert";
    }

    @GetMapping("/indexEnergyReading")
    public String indexEnergyReading() {
        return "indexEnergyReading";
    }

}