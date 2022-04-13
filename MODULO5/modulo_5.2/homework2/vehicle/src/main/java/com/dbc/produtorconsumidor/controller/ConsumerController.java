package com.dbc.produtorconsumidor.controller;

import com.dbc.produtorconsumidor.dto.VehicleDTO;
import com.dbc.produtorconsumidor.service.VehicleService;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consumer")
public class ConsumerController {
    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<VehicleDTO> listAll() {
        return vehicleService.list();
    }

    @GetMapping("/vehicles/amount")
    public Integer amount() {
        return vehicleService.count();
    }

    @GetMapping("/vehicles/averagespeed")
    public Double avgSpeed() throws Exception {
        return vehicleService.averageSpeed();
    }

    @GetMapping("/vehicles/averageRotation")
    public Double avgRotation() throws Exception {
        return vehicleService.averageRotation();
    }
}
