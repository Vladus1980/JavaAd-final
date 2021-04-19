package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Entration;

@Repository
public interface EntrationRepository extends JpaRepository<Entration, Integer> {

}
