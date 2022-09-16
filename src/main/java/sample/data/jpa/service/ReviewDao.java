package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Hotel;
import sample.data.jpa.domain.Review;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ReviewDao extends JpaRepository<Review, Long> {

    public Review findReviewByIdx(Long id);

    Hotel findReviewByName(String name);

    void saveReview(Review review);

    void deleteReviewById(Long id);
}
