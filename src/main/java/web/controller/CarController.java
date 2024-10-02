package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

import java.util.PrimitiveIterator;

@Controller
@RequestMapping (value = "/cars")
public class CarController {

    private final CarDao carDao;
    @Autowired
    public CarController(CarDao carsDao) {
        this.carDao = carsDao;
    }

    @GetMapping
    public String printSomeCars(@RequestParam(required = false, name = "count") Integer count, ModelMap model) {
        if (count != null) {
            model.addAttribute( "someCars", carDao.getSomeCars(count));
        } else {
            model.addAttribute("someCars",carDao.getAllCars());
        }
        return "/cars";
    }
}