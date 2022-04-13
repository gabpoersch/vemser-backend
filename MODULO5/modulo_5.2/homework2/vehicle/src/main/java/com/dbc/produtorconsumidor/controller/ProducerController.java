package com.dbc.produtorconsumidor.controller;

import com.dbc.produtorconsumidor.dto.VehicleDTO;
import com.dbc.produtorconsumidor.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/send")
    private void send(@RequestBody VehicleDTO vehicleDTO) throws JsonProcessingException {
        producerService.sendVehicle(vehicleDTO);
    }
}