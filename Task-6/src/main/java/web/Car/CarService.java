package web.Car;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final List<Car> cars = Arrays.asList(
            new Car("Jaguar", "F", 3.5),
            new Car("Mercedes-Benz", "C-AMG", 5.0),
            new Car("Audi", "RS-6", 4.4),
            new Car("Toyota", "Supra", 3.7),
            new Car("Nissan", "R-34", 3.0));

    public List<Car> getCars(int count) {
        if (count >= cars.size() || count <= 0) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
