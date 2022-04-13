package com.dbc.produtorconsumidor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDTO {

    @ApiModelProperty(required = true)
    private LocalDateTime localDateTime = LocalDateTime.now();

    @ApiModelProperty(required = true)
    private Double speed;

    @ApiModelProperty(required = true)
    private Integer rotation;

    @ApiModelProperty(required = true)
    private Boolean brakingSensor;
}
