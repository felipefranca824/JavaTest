package com.sigabem.freight.repositories;

import java.util.HashMap;
import java.util.Map;

import com.sigabem.freight.controllers.dto.AddressResponse;
import org.springframework.web.client.RestTemplate;

public class CepRepository {
    private RestTemplate restTemplate = new RestTemplate();
    
    public AddressResponse findCep(String cep){
        String uri = "https://viacep.com.br/ws/{cep}/json/";

        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep); 

        try {
            final AddressResponse endereco = restTemplate.getForObject(uri, AddressResponse.class, params);
            return endereco;
        } catch (Exception e) {
            throw e;
        }
        
    }
}
