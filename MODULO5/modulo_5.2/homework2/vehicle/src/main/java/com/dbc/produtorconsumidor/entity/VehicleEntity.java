package com.dbc.produtorconsumidor.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.apache.tomcat.jni.Local;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("vehicle")
public class VehicleEntity {

    @Id
    private String id;
    private Integer rotation;
    private Double speed;
    private Boolean brakingSensor;
    private String dateAndTime = String.valueOf(LocalDateTime.now());
}
