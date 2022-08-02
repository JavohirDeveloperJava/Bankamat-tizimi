package uz.pdp.bankamattizimi.payload;

import lombok.Data;

import java.util.UUID;

@Data

public class CardanPulOlishDto {

    private UUID bancamatId;

    private UUID cartaId;

    private double summa;
}
