package pl.blackfernsoft.wsb.wsbdevtools.domain.car.exception;

public class CarNotFoundException extends RuntimeException {
    private final Integer carId;

    public CarNotFoundException(Integer carId) {
        super(String.format("Car of id %d not found", carId));
        this.carId = carId;
    }
}
