package uz.pdp.bankamattizimi.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class CardPulSolishDto {

    private UUID bancamatId;

    private UUID cardId;

    private double summa;


}
