package com.sigabem.freight.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "freight")
public class FreightModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_value")
    private Double totalValue;

    private Double weight;

    @Column(name = "expected_date")
    private Calendar expectedDate;

    
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserModel sender;

    @OneToOne(mappedBy = "freight")
    private QueryModel query;

    public Long getId() {
        return id;
    }

    public QueryModel getQuery() {
        return query;
    }

    public void setQuery(QueryModel query) {
        this.query = query;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Calendar getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Calendar expectedDate) {
        this.expectedDate = expectedDate;
    }

    public UserModel getSenderID() {
        return sender;
    }

    public void setSenderID(UserModel senderID) {
        this.sender = senderID;
    }

    

}
