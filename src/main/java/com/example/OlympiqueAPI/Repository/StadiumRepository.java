package com.example.OlympiqueAPI.Repository;

import com.example.OlympiqueAPI.Model.Stadium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long>{
    
}
