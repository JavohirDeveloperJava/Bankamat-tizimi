package uz.pdp.bankamattizimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.bankamattizimi.entity.Card;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.CardDto;
import uz.pdp.bankamattizimi.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;


    @PostMapping("/creat")
    public HttpEntity<?> creat(@RequestBody CardDto cardDto){
        ApiResponse creat = cardService.creat(cardDto);
        return ResponseEntity.status(creat.isSuccess()?201:409).body(creat);
    }



    @GetMapping
    public HttpEntity<?> getall(){
        List<Card> getall = cardService.getall();
        return ResponseEntity.ok(getall);
    }






    /*
    "number":"1234567891012345",
    "bankId":"74d84da6-d0ee-437f-894a-3fa571b92ba3",
    "code":"123",
    "fullName":"Cartani egasi",
    "parol":"1234",
    "cardTypeId":"96f35067-47be-4562-9e88-4517ad8266f3"
     */
}
