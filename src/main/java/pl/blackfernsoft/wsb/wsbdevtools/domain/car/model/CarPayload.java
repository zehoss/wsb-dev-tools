package pl.blackfernsoft.wsb.wsbdevtools.domain.car.model;

import lombok.Value;

import java.time.LocalDate;

@Value
public class CarPayload {
    String name;
    String color;
    LocalDate registrationDate;
    String plateNumber;
}
