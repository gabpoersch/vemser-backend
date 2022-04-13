package com.dbc.produtorconsumidor.repository;

import com.dbc.produtorconsumidor.entity.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleEntity, String> {
}