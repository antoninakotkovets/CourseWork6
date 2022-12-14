package com.example.coursework6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
public class VisitStatistics extends IdField{
    private String login;
    private String timeVisit;

    @ManyToOne
    User user;

    public VisitStatistics(){}

    public  VisitStatistics(VisitStatistics visitStatistics){
        this.setId(visitStatistics.getId());
        this.login = visitStatistics.getLogin();
        this.timeVisit = visitStatistics.getTimeVisit();
        this.user = visitStatistics.getUser();
    }
    public VisitStatistics(String login, String timeVisit, User user){
        this.login = login;
        this.timeVisit = timeVisit;
        this.user = user;
    }
}
