package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer>{

}
