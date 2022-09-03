package com.example.nbp_currencies.Controller;

import com.example.nbp_currencies.Model.Root;
import com.example.nbp_currencies.Service.NbpService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation("Returns sum of currencies with mid price specified by user for specified period")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful response from NBP API"), @ApiResponse(code = 404, message = "Invalid parameters on some other error occured on the NBP's side")})
    @RequestMapping("/get")
    public ResponseEntity<Integer> getCurrencies(@ApiParam("Starting date") @RequestParam String firstDay,@ApiParam("Ending Date") @RequestParam String lastDay,@ApiParam("Mid price provided by user") @RequestBody double mid) {
    return ResponseEntity.ok(nbpService.getResponseList(firstDay, lastDay, mid));
    }

}
