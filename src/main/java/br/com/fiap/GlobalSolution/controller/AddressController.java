package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.domainmodel.Address;
import br.com.fiap.GlobalSolution.service.AddressService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AddressController {

    @Autowired
    private @Setter AddressService service;

    @GetMapping("/addNewAddress")
    public String addNewAddress( Model model ){
        Address add = new Address();
        model.addAttribute("address", add);
        return "newAddress";
    }

    @PostMapping("/saveAddress")
    public String save( @ModelAttribute("address") Address address ){
        this.service.save( address );
        return "redirect:/address";
    }

    @GetMapping("/deleteAddress/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/address";
    }

    @GetMapping("/address")
    public String viewHomePageAsList(Model model){
        List<Address> addressList = this.service.findAll();
        model.addAttribute("allAddressList", addressList);
        return "indexAddress";
    }

    @GetMapping("/showFormForUpdateAddress/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Address> address  = this.service.findById(id);
        if(address.isPresent())
            model.addAttribute("address", address.get());
        else
            System.out.println("Error");
        return "updateAddress";

    }

    @PostMapping("/updateAddress")
    public String update( @ModelAttribute("address") Address address ){
        this.service.save( address );
        return "redirect:/address";
    }
}
