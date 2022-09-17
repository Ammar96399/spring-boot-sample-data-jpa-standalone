package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Hotel;
import sample.data.jpa.service.HotelDao;

import java.util.Objects;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelDao hotelDao;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Hotel hotel) {
        if (Objects.nonNull(hotel)) {
            hotelDao.save(hotel);
            var headers = new HttpHeaders();
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "X-Custom-ID");
            headers.add("X-Custom-ID", String.valueOf(hotel.getId()));
            headers.setContentType(MediaType.APPLICATION_JSON);
            return ResponseEntity.ok().headers(headers).body(hotel);
        } else {
            return ResponseEntity.badRequest().body("Cannot add hotel to the DB - operation failed");
        }
    }

    @RequestMapping("{id}/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        var hotel = hotelDao.findById(id);
        if (hotel.isPresent()) {
            hotelDao.deleteHotelById(id);
            return ResponseEntity.ok("Hotel successfully deleted!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        var hotel = hotelDao.findById(id);
        if (hotel.isPresent()) {
            return ResponseEntity.ok(hotel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


