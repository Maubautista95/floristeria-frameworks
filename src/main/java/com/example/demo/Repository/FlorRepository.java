package com.example.demo.Repository;
import com.example.demo.Entities.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Long>{


}
