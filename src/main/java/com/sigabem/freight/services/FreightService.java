package com.sigabem.freight.services;

import java.util.Calendar;
import java.util.Date;

import com.sigabem.freight.controllers.dto.AddressResponse;
import com.sigabem.freight.models.FreightModel;
import com.sigabem.freight.repositories.CepRepository;
import com.sigabem.freight.repositories.FreightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreightService {
    
    @Autowired
    FreightRepository freightRepository;

    CepRepository findCepRepository = new CepRepository();

    public void calculateFreight(FreightModel freight) {
        AddressResponse addresssRecipient = findAddressByCep(freight.getRecipientCep());
        AddressResponse addressSender = findAddressByCep(freight.getSenderCep());
        
        freight.setTotalValue(freight.getWeight());
        if(addressSender.getDdd().equals(addresssRecipient.getDdd())){
            freight.setTotalValue(calculateDiscount(freight, 50));
            freight.setConsultationDate(Calendar.getInstance().getTime());
            freight.setExpectedDate(addDaysFreight(1, freight));
        }else if(addressSender.getUf().equals(addresssRecipient.getUf())){
            freight.setTotalValue(calculateDiscount(freight, 75));
            freight.setConsultationDate(Calendar.getInstance().getTime());
            freight.setExpectedDate(addDaysFreight(3, freight));
        } else{
            freight.setConsultationDate(Calendar.getInstance().getTime());
            freight.setExpectedDate(addDaysFreight(10, freight));
        }
        try {
            freightRepository.save(freight);
        } catch (Exception e) {
            throw e;
        }
        
        
    }

    private Date addDaysFreight(int days, FreightModel freight){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(freight.getConsultationDate());
        calendar.add(Calendar.DATE, days);

        return calendar.getTime();
    }

    private Double calculateDiscount(FreightModel freight, double percent){
        return freight.getTotalValue() - (freight.getTotalValue() * percent / 100.00);
    }

    private AddressResponse findAddressByCep(String cep){
        try {
            return findCepRepository.findCep(cep);
        } catch (Exception e) {
            throw e;
        }
    }
}
