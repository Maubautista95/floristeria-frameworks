package com.example.demo.Service;

import com.example.demo.Entities.Flor;
import com.example.demo.Repository.FlorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlorService {
    private final FlorRepository florRepository;

    public FlorService(FlorRepository florRepository){
        this.florRepository = florRepository;
    }

    public List<Flor> findAll(){
        return florRepository.findAll();
    }

    public Flor save(Flor flor){

        return florRepository.save(flor);
    }
}
