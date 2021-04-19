package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
