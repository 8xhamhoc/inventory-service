package com.infybuzz.service;

import com.infybuzz.entity.OrderInventory;
import com.infybuzz.repository.OrderInventoryRepository;
import com.infybuzz.request.InventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InventoryService {

    @Autowired
    private OrderInventoryRepository inventoryRepository;

    @PostConstruct
    public void initDB() {
        inventoryRepository.saveAll(Stream.of(
                new OrderInventory(1, 5),
                new OrderInventory(2, 10),
                new OrderInventory(3, 15)
                ).collect(Collectors.toList())
        );
    }

    @Transactional
    public void update(InventoryDto inventoryDto) {
        inventoryRepository.findById(inventoryDto.getProductId())
                .ifPresent(orderInventory -> {
                    orderInventory.setAvailableInventory(orderInventory.getAvailableInventory() - 1);
                });
    }
}
