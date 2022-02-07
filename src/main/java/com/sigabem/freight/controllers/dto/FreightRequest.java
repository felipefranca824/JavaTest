package com.sigabem.freight.controllers.dto;

import com.sigabem.freight.models.FreightModel;

public class FreightRequest {
    private String nameRecipient;
    private String cepSender;
    private String cepRecipient;
    private Double weight;

    public FreightModel converter() {
        FreightModel freightModel = new FreightModel();
        freightModel.setRecipientCep(this.cepRecipient);
        freightModel.setSenderCep(this.cepSender);
        freightModel.setWeight(this.weight);
        freightModel.setRecipientName(this.nameRecipient);

        return freightModel;
    }

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

    public Boolean isValid(){
        return weightIsValid() && nameIsValid() && CepRecipientIsValid() && CepSenderIsValid();
    }

    private Boolean weightIsValid(){
        return this.weight > 0 && this.weight != null;
    }

    private Boolean nameIsValid(){
        return this.nameRecipient.length() >= 3 && this.nameRecipient != null;
    }

    private Boolean CepRecipientIsValid(){
        return this.cepRecipient.length() == 8 && this.cepRecipient != null;
    }

    private Boolean CepSenderIsValid(){
        return this.cepSender.length() == 8 && this.cepSender != null;
    }


}
