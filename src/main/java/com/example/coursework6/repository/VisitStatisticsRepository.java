package com.example.coursework6.repository;

import com.example.coursework6.model.Order;
import com.example.coursework6.model.VisitStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitStatisticsRepository extends JpaRepository<VisitStatistics, Integer> {
    VisitStatistics findById(int id);
}
