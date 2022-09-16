package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.Review;
import sample.data.jpa.service.ReviewDao;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewDao reviewDao;

    @RequestMapping("/create")
    @ResponseBody
    public String create(Review review) {
        String reviewId = "";
        try {
            reviewDao.save(review);
            reviewId = String.valueOf(review.getId());
        } catch (Exception ex) {
            return "Error creating the review: " + ex.toString();
        }

        return "Review successfully created with id = " + reviewId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        try {
            reviewDao.deleteReviewById(id);
        } catch (Exception ex) {
            return "Error deleting the review: " + ex;
        }
        return "Review successfully deleted!";
    }

    @RequestMapping("{id}")
    @ResponseBody
    public String getById(@PathVariable("id") Long id) {
        String reviewId = "";
        try {
            Review review = reviewDao.findReviewByIdx(id);
            reviewId = String.valueOf(review.getId());
        } catch (Exception ex) {
            return "City not found";
        }
        return "The city id is: " + reviewId;
    }
}


