package com.sigabem.freight.controllers.dto;

import java.text.SimpleDateFormat;

import com.sigabem.freight.models.FreightModel;

public class FreightResponse {
    private String name_recipient;
    private String cep_sender;
    private String cep_recipient;
    private Double weight;
    private String date_expected;
    private String date_consultation;
    private Double total_value;

    public static FreightResponse fromFreightModel(FreightModel freight) {
        FreightResponse response = new FreightResponse();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        response.setCep_recipient(formatterCep(freight.getRecipientCep()));
        response.setCep_sender(formatterCep(freight.getSenderCep()));
        response.setName_recipient(freight.getRecipientName());
        response.setDate_consultation(formatter.format(freight.getConsultationDate()));
        response.setDate_expected(formatter.format(freight.getExpectedDate()));
        response.setWeight(freight.getWeight());
        response.setTotal_value(freight.getTotalValue());
        return response;
    }

    public Double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Double total_value) {
        this.total_value = total_value;
    }

    public String getName_recipient() {
        return name_recipient;
    }
    public void setName_recipient(String name_recipient) {
        this.name_recipient = name_recipient;
    }
    public String getCep_sender() {
        return cep_sender;
    }
    public void setCep_sender(String cep_sender) {
        this.cep_sender = cep_sender;
    }
    public String getCep_recipient() {
        return cep_recipient;
    }
    public void setCep_recipient(String cep_recipient) {
        this.cep_recipient = cep_recipient;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getDate_expected() {
        return date_expected;
    }
    public void setDate_expected(String date_expected) {
        this.date_expected = date_expected;
    }
    public String getDate_consultation() {
        return date_consultation;
    }
    public void setDate_consultation(String date_consultation) {
        this.date_consultation = date_consultation;
    }

    public static String formatterCep(String cep){
        return cep.substring(0, 5) + "-" + cep.substring(5);
        
    }
}
