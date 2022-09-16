package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.City;
import sample.data.jpa.service.CityDao;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDao cityDao;

    @RequestMapping("/create")
    @ResponseBody
    public String create(City city) {
        String cityId = "";
        try {
            cityDao.save(city);
            cityId = String.valueOf(city.getId());
        } catch (Exception ex) {
            return "Error creating the city: " + ex.toString();
        }

        return "City successfully created with id = " + cityId;
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
    public String getById(@PathVariable("id") Long id) {
        String cityId = "";
        try {
            City city = cityDao.findCityById(id);
            cityId = String.valueOf(city.getId());
        } catch (Exception ex) {
            return "City not found";
        }
        return "The city id is: " + cityId;
    }
}


