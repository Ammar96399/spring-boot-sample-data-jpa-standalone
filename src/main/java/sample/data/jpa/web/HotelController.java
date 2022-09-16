package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.Hotel;
import sample.data.jpa.service.HotelDao;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelDao hotelDao;

    @RequestMapping("/create")
    @ResponseBody
    public String create(Hotel hotel) {
        String hotelId = "";
        try {
            hotelDao.save(hotel);
            hotelId = String.valueOf(hotel.getId());
        } catch (Exception ex) {
            return "Error creating the hotel: " + ex.toString();
        }

        return "Hotel successfully created with id = " + hotelId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        try {
            hotelDao.deleteHotelById(id);
        } catch (Exception ex) {
            return "Error deleting the hotel: " + ex;
        }
        return "Hotel successfully deleted!";
    }

    @RequestMapping("{id}")
    @ResponseBody
    public String getById(@PathVariable("id") Long id) {
        String hotelId = "";
        try {
            Hotel hotel = hotelDao.findHotelById(id);
            hotelId = String.valueOf(hotel.getId());
        } catch (Exception ex) {
            return "Hotel not found";
        }
        return "The hotel id is: " + hotelId;
    }
}


