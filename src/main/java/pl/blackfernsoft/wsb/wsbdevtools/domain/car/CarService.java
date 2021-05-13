package pl.blackfernsoft.wsb.wsbdevtools.domain.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.blackfernsoft.wsb.wsbdevtools.domain.car.exception.CarNotFoundException;
import pl.blackfernsoft.wsb.wsbdevtools.domain.car.model.Car;
import pl.blackfernsoft.wsb.wsbdevtools.domain.car.model.CarPayload;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Integer carId) {
        return carRepository.findById(carId).orElseThrow(() -> new CarNotFoundException(carId));
    }

    public void createCar(CarPayload carPayload) {
        Car carEntity = Car.of(carPayload);
        carRepository.save(carEntity);
    }
}
