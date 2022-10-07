package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Hotel;

import javax.transaction.Transactional;

@Transactional
public interface HotelDao extends JpaRepository<Hotel, Long> {

    Hotel findHotelById(Long id);

    Hotel findHotelByName(String name);

    void deleteHotelById(Long id);

    void deleteHotelByName(String name);
}
