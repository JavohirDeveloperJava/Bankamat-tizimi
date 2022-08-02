package uz.pdp.bankamattizimi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.bankamattizimi.entity.Bank;
import uz.pdp.bankamattizimi.entity.Card;
import uz.pdp.bankamattizimi.entity.CardType;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.CardDto;
import uz.pdp.bankamattizimi.repository.BankRepository;
import uz.pdp.bankamattizimi.repository.CardRepository;
import uz.pdp.bankamattizimi.repository.CardTypeRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    CardTypeRepository cardTypeRepository;

    public ApiResponse creat(CardDto cardDto){

        boolean exists = cardRepository.existsByNumber(cardDto.getNumber());
        if (exists){
            return new ApiResponse("Bunday user Mavjut",false);
        }
        Optional<Bank> bankOptional = bankRepository.findById(cardDto.getBankId());
        if (!bankOptional.isPresent()){
            return new ApiResponse("bank topilmadi tekshirib koring",false);
        }
        Bank bank = bankOptional.get();
        Timestamp data=new Timestamp(System.currentTimeMillis()+10000*10*60*60);

        Optional<CardType> cardTypeOptional = cardTypeRepository.findById(cardDto.getCardTypeId());
        if (!cardTypeOptional.isPresent()){
            return new ApiResponse("bunday car mavjut emas",false);
        }



        Card card=new Card();
        card.setNumber(cardDto.getNumber());
        card.setBankId(bank);
        card.setCode(cardDto.getCode());
        card.setFullName(cardDto.getFullName());
        card.setExpireDate(data);
        card.setParol(cardDto.getParol());
        card.setCardType(cardTypeOptional.get());
        card.setActive(true);
        cardRepository.save(card);
        return new ApiResponse("card muofaqiyatlik saqlandi",true);

    }

    public List<Card> getall(){
        return cardRepository.findAll();
    }

}
