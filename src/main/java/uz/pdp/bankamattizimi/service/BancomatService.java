package uz.pdp.bankamattizimi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.bankamattizimi.entity.Bancomat;
import uz.pdp.bankamattizimi.entity.Bank;
import uz.pdp.bankamattizimi.entity.CardType;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.BancomatDto;
import uz.pdp.bankamattizimi.repository.BancomatRepositrory;
import uz.pdp.bankamattizimi.repository.BankRepository;
import uz.pdp.bankamattizimi.repository.CardTypeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BancomatService {
    @Autowired
    BancomatRepositrory bancomatRepositrory;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    CardTypeRepository cardTypeRepository;

    public ApiResponse creatt(BancomatDto bancomatDto){

        Optional<Bank> bankOptional = bankRepository.findById(bancomatDto.getBankId());
        if (!bankOptional.isPresent()){
            return new ApiResponse("Buday bank yoq",false);
        }

        Optional<CardType> optionalCardType = cardTypeRepository.findById(bancomatDto.getCardType());
        if (!optionalCardType.isPresent()){
            return new ApiResponse("Bunday cart type yoq",false);
        }
        CardType cardType = optionalCardType.get();


        Bancomat bancomat=new Bancomat();
        bancomat.setBankId(bankOptional.get());
        bancomat.setCardType(Collections.singleton(cardType));
        bancomat.setBalanceBancamat(bancomatDto.getBalanceBank());
        bancomatRepositrory.save(bancomat);
        return new ApiResponse("Bancamat saqlandi",true);
    }

    public List<Bancomat> get(){
        List<Bancomat> all = bancomatRepositrory.findAll();
        return all;
    }


}
