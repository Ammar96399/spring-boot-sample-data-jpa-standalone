package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.City;

import javax.transaction.Transactional;

@Transactional
public interface CityDao extends JpaRepository<City, Long> {
    public City
}
