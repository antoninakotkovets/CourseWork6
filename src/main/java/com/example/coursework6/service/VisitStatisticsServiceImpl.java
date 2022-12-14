package com.example.coursework6.service;


import com.example.coursework6.model.VisitStatistics;
import com.example.coursework6.repository.UsersRepository;
import com.example.coursework6.repository.VisitStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitStatisticsServiceImpl implements  VisitStatisticsService{

    @Autowired
    private VisitStatisticsRepository visitStatisticsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean saveVisitStatistics(VisitStatistics visitStatistics, int userId){
        visitStatistics.setUser(usersRepository.findById(userId));
        visitStatisticsRepository.save(visitStatistics);
        return true;
    }

    @Override
    public List<VisitStatistics> getAllVisit(int offset, int limit){
        List<VisitStatistics> result = new ArrayList<>();
        Page<VisitStatistics> res = visitStatisticsRepository.findAll(PageRequest.of(offset, limit));
        result.addAll(res.getContent());
        return result;
    }

    @Override
    public int getVisitsCount() {
        return (int) visitStatisticsRepository.count();
    }
}
