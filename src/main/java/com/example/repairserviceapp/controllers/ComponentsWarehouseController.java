package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.services.ComponentsWarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/components-warehouse")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComponentsWarehouseController {

    private ComponentsWarehouseService componentsWarehouseService;

//    @GetMapping("")
//    public List<ComponentsWarehouse> readAll() {
//
//    }
}
