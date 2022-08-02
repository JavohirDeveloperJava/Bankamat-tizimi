package uz.pdp.bankamattizimi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.bankamattizimi.entity.Bancomat;
import uz.pdp.bankamattizimi.entity.Card;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.CardPulSolishDto;
import uz.pdp.bankamattizimi.payload.CardanPulOlishDto;
import uz.pdp.bankamattizimi.repository.BancomatRepositrory;
import uz.pdp.bankamattizimi.repository.CardRepository;

import java.util.Optional;

@Service
public class CartadanPulolishService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BancomatRepositrory bancomatRepositrory;

    static final Double COMMISSION = 0.01;

    public ApiResponse pul(CardanPulOlishDto dto) {

        Optional<Card> cardOptional = cardRepository.findById(dto.getCartaId());
        if (!cardOptional.isPresent()) {
            return new ApiResponse("Bunday card mavjut emas", false);
        }
        Optional<Bancomat> optionalBancomat = bancomatRepositrory.findById(dto.getBancamatId());
        if (!optionalBancomat.isPresent()) {
            return new ApiResponse("Bunday bancamat yoq", false);
        }


        Card card = cardOptional.get();
        card.setBalanceCard(card.getBalanceCard()-dto.getSumma()*(COMMISSION+1));

        Bancomat bancomat = optionalBancomat.get();
        bancomat.setBalanceBancamat(bancomat.getBalanceBancamat()+1);

        cardRepository.save(card);
        bancomatRepositrory.save(bancomat);
        return new ApiResponse("muofaqiyatlik pul olindi",true);


    }

}
