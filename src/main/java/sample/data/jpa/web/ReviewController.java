package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.Review;
import sample.data.jpa.service.ReviewDao;

import java.util.Objects;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewDao reviewDao;

    @RequestMapping("/create")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Review review) {
        if (Objects.nonNull(review)) {
            reviewDao.save(review);
            var headers = new HttpHeaders();
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "X-Custom-ID");
            headers.add("X-Custom-ID", String.valueOf(review.getId()));
            headers.setContentType(MediaType.APPLICATION_JSON);
            return ResponseEntity.ok().headers(headers).body(review);
        } else {
            return ResponseEntity.badRequest().body("Cannot add review to the DB - operation failed");
        }
    }

    @RequestMapping("{id}/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Long id) {
        var review = reviewDao.findById(id);
        if (review.isPresent()) {
            reviewDao.deleteReviewById(id);
            return ResponseEntity.ok("Review successfully deleted!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        var review = reviewDao.findById(id);
        if (review.isPresent()) {
            return ResponseEntity.ok(review.get());
        } else  {
            return ResponseEntity.notFound().build();
        }
    }
}


