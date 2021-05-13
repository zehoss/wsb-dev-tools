package pl.blackfernsoft.wsb.wsbdevtools.domain.car;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsb.wsbdevtools.domain.car.model.Car;
import pl.blackfernsoft.wsb.wsbdevtools.domain.car.model.CarPayload;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping
    public List<Car> getCars() {
        return service.findAll();
    }

    @GetMapping("/{carId}")
    public Car findCarById(@PathVariable("carId") Integer carId) {
        return service.findById(carId);
    }

    @PostMapping
    public void createCar(@RequestBody CarPayload car) {
        service.createCar(car);
    }
}
