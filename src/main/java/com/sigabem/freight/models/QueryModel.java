package com.sigabem.freight.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "query")
public class QueryModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consultation_date")
    private Calendar consultationDate;

    
    @OneToOne
    @JoinColumn(name = "freight_id")
    private FreightModel freight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Calendar consultationDate) {
        this.consultationDate = consultationDate;
    }

    public FreightModel getFreight() {
        return freight;
    }

    public void setFreight(FreightModel freight) {
        this.freight = freight;
    }
}
