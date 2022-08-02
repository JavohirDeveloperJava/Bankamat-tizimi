package uz.pdp.bankamattizimi.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class BancomatDto {

    private UUID bankId;

    private UUID cardType;

   private double balanceBank;

}
