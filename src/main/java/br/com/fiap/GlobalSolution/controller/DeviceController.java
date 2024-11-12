package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.domainmodel.Device;
import br.com.fiap.GlobalSolution.service.DeviceService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DeviceController {

    @Autowired
    private @Setter DeviceService service;

    @GetMapping("/addNewDevice")
    public String addNewDevice( Model model ){
        Device add = new Device();
        model.addAttribute("device", add);
        return "newDevice";
    }

    @PostMapping("/saveDevice")
    public String save( @ModelAttribute("device") Device device ){
        this.service.save( device );
        return "redirect:/device";
    }

    @GetMapping("/deleteDevice/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/device";
    }

    @GetMapping("/device")
    public String viewHomePageAsList(Model model){
        List<Device> deviceList = this.service.findAll();
        model.addAttribute("allDeviceList", deviceList);
        return "indexDevice";
    }

    @GetMapping("/showFormForUpdateDevice/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Device> device  = this.service.findById(id);
        if(device.isPresent())
            model.addAttribute("device", device.get());
        else
            System.out.println("Error");
        return "updateDevice";

    }

    @PostMapping("/updateDevice")
    public String update( @ModelAttribute("device") Device device ){
        this.service.save( device );
        return "redirect:/device";
    }
}
