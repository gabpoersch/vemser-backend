package com.dbc.produtorconsumidor.service;

import com.dbc.produtorconsumidor.dto.VehicleDTO;
import com.dbc.produtorconsumidor.entity.VehicleEntity;
import com.dbc.produtorconsumidor.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ObjectMapper objectMapper;

    public VehicleDTO create(VehicleDTO vehicleDTO) {
        VehicleEntity vehicle = objectMapper.convertValue(vehicleDTO, VehicleEntity.class);
        VehicleEntity saveVehicle = vehicleRepository.save(vehicle);
        VehicleDTO savedVehicleDTO = objectMapper.convertValue(saveVehicle, VehicleDTO.class);
        return savedVehicleDTO;
    }

    public List<VehicleDTO> list() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
    }

    public Integer count() {
        return Math.toIntExact(vehicleRepository.count());
    }

    public Double averageSpeed() throws Exception {
        return vehicleRepository.findAll()
                .stream()
                .mapToDouble(vehicle -> vehicle.getSpeed())
                .average()
                .orElseThrow(() -> new Exception("Não foi possível calcular a média de velocidade."));
    }

    public Double averageRotation() throws Exception {
    return vehicleRepository.findAll()
            .stream()
            .mapToDouble(vehicle -> vehicle.getRotation())
            .average()
            .orElseThrow(() -> new Exception("Não foi possível calcular a média de velocidade."));
    }
}
