package com.example.nbp_currencies.Service;

import com.example.nbp_currencies.Model.Rate;
import com.example.nbp_currencies.Model.Root;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NbpService {

    private final RestTemplate rest;

    public NbpService(RestTemplate rest) {
        this.rest = rest;
    }

    public Root[] getCurrenciesList(String firstDate, String lastDate, double mid) {
        var result = rest.getForEntity("http://api.nbp.pl/api/exchangerates/tables/A/" + firstDate + "/" + lastDate + "/?format=json", Root[].class);
        var currenciesList = result.getBody();
        return currenciesList;
    }
}
