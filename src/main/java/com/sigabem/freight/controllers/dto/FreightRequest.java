package com.sigabem.freight.controllers.dto;

public class FreightRequest {
    private String nameRecipient;
    private String cepSender;
    private String cepRecipient;
    private Double weight;
    public String getNameRecipient() {
        return nameRecipient;
    }
    public void setNameRecipient(String nameRecipient) {
        this.nameRecipient = nameRecipient;
    }
    public String getCepSender() {
        return cepSender;
    }
    public void setCepSender(String cepSender) {
        this.cepSender = cepSender;
    }
    public String getCepRecipient() {
        return cepRecipient;
    }
    public void setCepRecipient(String cepRecipent) {
        this.cepRecipient = cepRecipent;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
