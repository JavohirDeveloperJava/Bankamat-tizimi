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
public class Input {
    @Id
    @GeneratedValue
    private UUID id;

    private String code;

    @ManyToOne
    private Employee employeeId;

    @OneToOne
    private ValyutaType valyutaType;




}
