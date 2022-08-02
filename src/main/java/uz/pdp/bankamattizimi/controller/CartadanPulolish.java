package uz.pdp.bankamattizimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.CardanPulOlishDto;
import uz.pdp.bankamattizimi.service.CartadanPulolishService;

@RestController
@RequestMapping("/api/olish")
public class CartadanPulolish {
    @Autowired
    CartadanPulolishService cartadanPulolishService;
    @PostMapping
    public HttpEntity<?> olish(@RequestBody CardanPulOlishDto dto){
        System.out.println(dto);
        ApiResponse pul = cartadanPulolishService.pul(dto);
        return ResponseEntity.status(pul.isSuccess()?201:409).body(pul);
    }

}
