package com.example.coursework6.service;

import com.example.coursework6.model.VisitStatistics;

import java.util.List;

public interface VisitStatisticsService {
    boolean saveVisitStatistics(VisitStatistics visitStatistics, int userId);
    List<VisitStatistics> getAllVisit(int offset, int limit);
    int getVisitsCount();

}
