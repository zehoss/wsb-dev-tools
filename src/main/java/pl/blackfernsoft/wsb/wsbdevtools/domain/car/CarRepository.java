package pl.blackfernsoft.wsb.wsbdevtools.domain.car;

import pl.blackfernsoft.wsb.wsbdevtools.domain.car.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> findAll();

    Optional<Car> findById(Integer carId);

    Car save(Car car);
}
