package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.City;
import sample.data.jpa.service.CityDao;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDao cityDao;

    @PostMapping(value = "/create")
    public ResponseEntity create(@RequestBody City city) {

        System.out.println(city.getCountry());
        String cityId = "";
            cityDao.save(city);
            cityId = String.valueOf(city.getId());

        return ResponseEntity.ok(city);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        try {
            cityDao.deleteCityById(id);
        } catch (Exception ex) {
            return "Error deleting the city: " + ex;
        }
        return "City successfully deleted!";
    }

    @RequestMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        String cityId = "";
        try {
            return new ResponseEntity(cityDao.findCityById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("City not found", HttpStatus.BAD_REQUEST);
        }
    }
}


