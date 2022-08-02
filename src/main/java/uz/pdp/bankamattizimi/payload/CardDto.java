package uz.pdp.bankamattizimi.payload;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import uz.pdp.bankamattizimi.entity.Bank;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.UUID;

@Data

public class CardDto {

//    @Size(min = 16,max = 16)
//    @NotNull
    private String number;

    private UUID bankId;

//    @Size(min = 3,max = 3)
    private String code;

    private String fullName;

//    @Size(min = 4,max = 4)
    private String parol;

    private UUID cardTypeId;


}
