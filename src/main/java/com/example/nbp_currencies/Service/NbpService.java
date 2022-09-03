package com.example.nbp_currencies.Service;

import com.example.nbp_currencies.Model.LogRecord;
import com.example.nbp_currencies.Model.Root;
import com.example.nbp_currencies.Repository.nbpRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class NbpService {

    private final nbpRepository repository;
    private final RestTemplate rest;


    public NbpService(RestTemplate rest, nbpRepository repository) {
        this.rest = rest;
        this.repository = repository;
    }

    public Integer getResponseList(String firstDate, String lastDate, double mid) {
        var result = rest.getForEntity("http://api.nbp.pl/api/exchangerates/tables/A/" + firstDate + "/" + lastDate + "/?format=json", Root[].class);
        var currenciesList = result.getBody();
        HashMap<String, ArrayList<Double>> mediumMap = new HashMap<String, ArrayList<Double>>();
        for (var root: currenciesList) {
            for (var rate : root.rates) {
                if(mediumMap.containsKey(rate.code)) {
                    mediumMap.get(rate.code).add(rate.mid);
                }else {
                    ArrayList<Double> midArray = new ArrayList<>();
                    midArray.add(rate.mid);
                    mediumMap.put(rate.code, midArray);
                }
            }
        }

        HashMap<String, Double> calculatedMap = new HashMap<String, Double>();
        mediumMap.forEach((key, value) -> {
            double midValue = 0;
            for (var rateValue : value) {
                midValue += rateValue;
            }
            double finalValue = midValue / value.size();
            calculatedMap.put(key, finalValue);
        });

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(0);
        calculatedMap.forEach((key, value) -> {
            if(value > mid){
                var val = intList.get(0).intValue();
                val++;
                intList.clear();
                intList.add(val);
            }
        });
        Integer currenciesResoult = intList.get(0);

        var record = new LogRecord(mid, firstDate, lastDate, currenciesResoult, LocalDateTime.now());
        repository.save(record);
        return currenciesResoult;
    }

}
