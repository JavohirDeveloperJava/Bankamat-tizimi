package uz.pdp.bankamattizimi.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class TransferDto {
    private UUID bancamatId;
    private UUID cardId;
    private Double summa;
}
