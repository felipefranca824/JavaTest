package com.sigabem.freight.controllers;
import com.sigabem.freight.controllers.dto.EnderecoResponse;
import com.sigabem.freight.controllers.dto.FreightRequest;
import com.sigabem.freight.repositories.FreightRepository;
import com.sigabem.freight.services.FindCepService;
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
    @Autowired
    FreightRepository freightRepository;

    FindCepService findCepService = new FindCepService();

    @PostMapping("/")
    public ResponseEntity<EnderecoResponse> calculateFreight(@RequestBody FreightRequest freight) {
        final EnderecoResponse endereco = findCepService.findCep(freight.getCepRecipient());

        return new ResponseEntity<EnderecoResponse>(endereco, HttpStatus.OK);
    }

}
