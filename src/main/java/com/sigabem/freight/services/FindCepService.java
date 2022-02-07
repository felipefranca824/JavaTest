package com.sigabem.freight.services;

import java.util.HashMap;
import java.util.Map;

import com.sigabem.freight.controllers.dto.EnderecoResponse;
import org.springframework.web.client.RestTemplate;

public class FindCepService {
    private RestTemplate restTemplate = new RestTemplate();
    
    public EnderecoResponse findCep(String cep){
        String uri = "https://viacep.com.br/ws/{cep}/json/";

        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep); 

        try {
            final EnderecoResponse endereco = restTemplate.getForObject(uri, EnderecoResponse.class, params);
            return endereco;
        } catch (Exception e) {
            throw e;
        }
        
    }
}
