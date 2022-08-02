package uz.pdp.bankamattizimi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.bankamattizimi.entity.Input;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Input_Money {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    private Input inputId;

    private String key;

    private Double value;

}
