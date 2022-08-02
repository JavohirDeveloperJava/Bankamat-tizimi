package uz.pdp.bankamattizimi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Output_Money {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private Input inputId;

    private String key;

    private Double value;
}
