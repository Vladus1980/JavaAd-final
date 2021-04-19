package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.AccessLevel;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Integer> {
	
	@Query("select a.role from AccesslEVEL a, user b where b.userName=? and a.userId=b.userId")
	public List<String> findRolesByUserName(String username);

}
