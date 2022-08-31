package com.example.nbp_currencies.Controller;

import com.example.nbp_currencies.Model.Rate;
import com.example.nbp_currencies.Model.Root;
import com.example.nbp_currencies.Service.NbpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nbp")
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @RequestMapping("/get")
    public ResponseEntity<Root[]> getCurrencies(@RequestParam String firstDay, @RequestParam String lastDay, @RequestBody double mid) {
    return ResponseEntity.ok(nbpService.getCurrenciesList(firstDay, lastDay, mid));
    }

}
