package com.example.coursework6.controller;


import com.example.coursework6.model.VisitStatistics;
import com.example.coursework6.service.VisitStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitStatistics")
public class VisitStatisticsController {

    @Autowired
    private VisitStatisticsService visitStatisticsService;

    @PostMapping("/add/{userId}")
    public boolean add(@RequestBody VisitStatistics visitStatistics, @PathVariable int userId){
        return  visitStatisticsService.saveVisitStatistics(visitStatistics, userId);

    }
    @GetMapping("/getAll")
    public List<VisitStatistics> getAll(@RequestParam int offset, @RequestParam int limit){
        return  visitStatisticsService.getAllVisit(offset, limit);

    }
    @GetMapping("/count")
    public int getVisitsCount(){
        return visitStatisticsService.getVisitsCount();
    }

}
