package com.example.OlympiqueAPI.Service;

import com.example.OlympiqueAPI.Model.Stadium;
import com.example.OlympiqueAPI.Repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public List<Stadium> findAll() {
        return stadiumRepository.findAll();
    }

    public Optional<Stadium> findById(Long id) {
        return stadiumRepository.findById(id);
    }

    public Stadium save(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public void delete(Long id) {
        stadiumRepository.deleteById(id);
    }
}
