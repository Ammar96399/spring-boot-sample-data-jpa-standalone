package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.City;
import sample.data.jpa.service.CityDao;

import java.util.Objects;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDao cityDao;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody City city) {
        if (Objects.nonNull(city)) {
            cityDao.save(city);
            // Add header to return id in headers.
            // If we remove the @JsonIgnore annotation over id in PO, then the id will be contained in returned object
            // Therefore this fragment could be considered useless
            var headers = new HttpHeaders();
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "X-Custom-ID");
            headers.add("X-Custom-ID", String.valueOf(city.getId()));
            headers.setContentType(MediaType.APPLICATION_JSON);
            return ResponseEntity.ok().headers(headers).body(city);
        } else {
            return ResponseEntity.badRequest().body("Cannot add city to the DB - operation failed");
        }
    }

    @DeleteMapping("/{id}/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        var city = cityDao.findById(id);
        if (city.isPresent()) {
            cityDao.deleteCityById(id);
            return ResponseEntity.ok("City successfully deleted!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        var city = cityDao.findById(id);
        if (city.isPresent()) {
            return ResponseEntity.ok(city.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


