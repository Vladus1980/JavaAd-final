package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
