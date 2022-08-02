package uz.pdp.bankamattizimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.CardPulSolishDto;
import uz.pdp.bankamattizimi.service.CardPulSolishService;

@RestController
@RequestMapping("api/balans")
public class CardPulSolish {
    @Autowired
    CardPulSolishService cardPulSolishService;

    @PostMapping
    public HttpEntity<?> pulSolish(@RequestBody CardPulSolishDto dto){
        ApiResponse pul = cardPulSolishService.pul(dto);
        return ResponseEntity.status(pul.isSuccess()?201:409).body(pul);
    }
}
