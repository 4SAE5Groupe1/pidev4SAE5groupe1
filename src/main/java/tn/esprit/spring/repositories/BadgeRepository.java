package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.Badge;
@Repository
public interface BadgeRepository extends JpaRepository<Badge,Integer> {
}
