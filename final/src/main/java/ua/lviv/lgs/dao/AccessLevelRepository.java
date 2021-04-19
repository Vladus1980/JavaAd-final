package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.AccessLevel;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Integer> {

}
