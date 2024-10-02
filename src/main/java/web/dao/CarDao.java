package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao {
    private static int CARS_COUNT = 0;
    private static final List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(++CARS_COUNT, "Audi", "Q7"));
        cars.add(new Car(++CARS_COUNT, "Lada", "Priora"));
        cars.add(new Car(++CARS_COUNT, "BMW", "M5F90"));
        cars.add(new Car(++CARS_COUNT, "Dodge", "Challenger"));
        cars.add(new Car(++CARS_COUNT, "Lamborghini", "Aventador"));

    }

    public List<Car> getSomeCars(int count) {
        if (count > cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }

    public List<Car> getAllCars() {
        return cars;

    }
}