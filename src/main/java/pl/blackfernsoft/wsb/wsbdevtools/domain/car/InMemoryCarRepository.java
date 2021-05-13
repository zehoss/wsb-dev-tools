package pl.blackfernsoft.wsb.wsbdevtools.domain.car;

import org.springframework.stereotype.Repository;
import pl.blackfernsoft.wsb.wsbdevtools.domain.car.model.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class InMemoryCarRepository implements CarRepository {

    private final Map<Integer, Car> cars = Stream.of(
            Car.of(1, "Fiat", "red", LocalDate.of(2020, 10, 5), "DW 12345"),
            Car.of(2, "Fiat", "red", LocalDate.of(1995, 8, 12), "DWR 54645"),
            Car.of(3, "Fiat", "red", LocalDate.of(2012, 6, 23), "DW 65656"),
            Car.of(4, "Fiat", "red", LocalDate.of(2021, 5, 5), "DW 114112"),
            Car.of(5, "Fiat", "red", LocalDate.of(2017, 2, 21), "DW 234233")
    ).collect(Collectors.toMap(Car::getId, car -> car));

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public Optional<Car> findById(Integer carId) {
        return Optional.ofNullable(cars.get(carId));
    }

    @Override
    public Car save(Car car) {
        Integer id = cars.size() + 1;
        return cars.put(id, car.asEntity(id));
    }
}
