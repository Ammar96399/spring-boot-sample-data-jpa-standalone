package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Hotel;
import sample.data.jpa.domain.Review;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ReviewDao extends JpaRepository<Review, Long> {

    public Review findReviewById(Long id);

    Hotel findReviewByTitle(String title);

    void deleteReviewById(Long id);
}
