package com.sigabem.freight.controllers;
import com.sigabem.freight.controllers.dto.AddressResponse;
import com.sigabem.freight.controllers.dto.FreightRequest;
import com.sigabem.freight.controllers.dto.FreightResponse;
import com.sigabem.freight.models.FreightModel;
import com.sigabem.freight.repositories.CepRepository;
import com.sigabem.freight.services.FreightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate-freight")
public class FreightController {
    
    CepRepository findCepRepository = new CepRepository();
    
    @Autowired
    FreightService service;

    @PostMapping("/")
    public ResponseEntity<FreightResponse> calculateFreight(@RequestBody FreightRequest freight) {
        try {
            if(!freight.isValid()){
                throw new Exception();
            }
            final AddressResponse addresssRecipient = findCepRepository.findCep(freight.getCepRecipient());
            final AddressResponse addressSender = findCepRepository.findCep(freight.getCepSender());
            
            FreightModel freightModel = freight.converter();
            service.calculateFreight(addresssRecipient, addressSender, freightModel);
            
            return new ResponseEntity<FreightResponse>(FreightResponse.fromFreightModel(freightModel), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<FreightResponse>(HttpStatus.BAD_REQUEST);
        }
        
    }

}
