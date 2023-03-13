package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoImp implements CarDao {
    private static long CAR_ID;

    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CAR_ID, "Lada", 12));
        cars.add(new Car(++CAR_ID, "Mercedes", 666));
        cars.add(new Car(++CAR_ID, "Lamborghini", 777));
        cars.add(new Car(++CAR_ID, "KAMAZ", 999));
        cars.add(new Car(++CAR_ID, "BELAZ", 555));
    }

    @Override
    public List<Car> showCars(int count) {
        if (count == 0 || count > cars.size()) {
            count = cars.size();
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
