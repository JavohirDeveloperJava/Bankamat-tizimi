package uz.pdp.bankamattizimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.bankamattizimi.entity.Bancomat;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.BancomatDto;
import uz.pdp.bankamattizimi.service.BancomatService;

import java.util.List;

@RestController
@RequestMapping("/api/bankamat")
public class BankomatController {
    @Autowired
    BancomatService bancomatService;

    @PostMapping
    public HttpEntity<?> creat(@RequestBody BancomatDto bancomatDto){
//        System.out.println(bancomatDto);
        ApiResponse creat = bancomatService.creatt(bancomatDto);
        return  ResponseEntity.status(creat.isSuccess()?201:409).body(creat);
    }



    @GetMapping
    public HttpEntity<?> get(){
        List<Bancomat> bancomats = bancomatService.get();
        return ResponseEntity.ok(bancomats);
    }
}
