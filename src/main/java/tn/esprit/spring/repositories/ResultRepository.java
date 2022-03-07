package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

}