package uz.pdp.bankamattizimi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uz.pdp.bankamattizimi.entity.Bank;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue
    private UUID id;//userning takrorlanmas raqami

//    @Column(nullable = false,length = 16)
    private String number;//16 honalik raqam


    @ManyToOne
    private Bank bankId;

//    @Column(nullable = false,length = 3)
    private String code;

//    @Column(nullable = false)
    private String fullName;

    private double balanceCard;

//    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp expireDate;//card ning amal qilish muddati

//    @Column(nullable = false,length = 4)
    private String parol;//4 xonali maxsus paroli

    @ManyToOne(fetch = FetchType.LAZY)
    private CardType cardType;//Plastik turi (HUMO, UZCARD, VISA)

    private boolean active=true;

}
