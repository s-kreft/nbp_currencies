package com.example.nbp_currencies.Repository;

import com.example.nbp_currencies.Model.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface nbpRepository extends JpaRepository<LogRecord, Long> {
}
