package com.sigabem.freight.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Date expectedDate;
    
    @Column(name="consultation_date")
    private Date consultationDate;

    @Column(name="recipient_cep")
    private String recipientCep;

    @Column(name="sender_cep")
    private String senderCep;

    @Column(name="recipient_name")
    private String recipientName;

    public Long getId() {
        return id;
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

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }
    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }
    public String getRecipientCep() {
        return recipientCep;
    }
    public void setRecipientCep(String recipientCep) {
        this.recipientCep = recipientCep;
    }
    public String getSenderCep() {
        return senderCep;
    }
    public void setSenderCep(String senderCep) {
        this.senderCep = senderCep;
    }
    public String getRecipientName() {
        return recipientName;
    }
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
  

}
