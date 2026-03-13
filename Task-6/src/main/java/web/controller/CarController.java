package web.controller;

import web.Car.Car;
import web.Car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    public CarService carService;
        @GetMapping("/cars")
        public String getCars(@RequestParam(defaultValue = "5") int count, Model model){
            List<Car> cars = carService.getCars(count);
            model.addAttribute("cars", cars);
            return "cars";
        }



}
