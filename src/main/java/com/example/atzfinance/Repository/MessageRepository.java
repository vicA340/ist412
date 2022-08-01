package com.example.atzfinance.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.example.atzfinance.Model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Override
    Optional<Message> findById(Long id);
}
