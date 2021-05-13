package pl.blackfernsoft.wsb.wsbdevtools.domain.car.model;

import lombok.Value;

import java.time.LocalDate;

@Value(staticConstructor = "of")
public class Car {
    Integer id;
    String name;
    String color;
    LocalDate registrationDate;
    String plateNumber;

    public static Car of(CarPayload carPayload) {
        return Car.of(null, carPayload.getName(), carPayload.getColor(), carPayload.getRegistrationDate(), carPayload.getPlateNumber());
    }

    public Car asEntity(Integer id) {
        return Car.of(id, name, color, registrationDate, plateNumber);
    }
}
