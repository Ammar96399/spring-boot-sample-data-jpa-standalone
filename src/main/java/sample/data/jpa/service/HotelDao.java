package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface HotelDao extends JpaRepository<Hotel, Long> {
}
