package com.infybuzz.controller;

import com.infybuzz.request.InventoryDto;
import com.infybuzz.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/api/inventories")
    public void update(@RequestBody InventoryDto inventoryDto) {
        inventoryService.update(inventoryDto);
    }

}
