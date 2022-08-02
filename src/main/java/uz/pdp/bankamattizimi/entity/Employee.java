package uz.pdp.bankamattizimi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;//userning takrorlanmas raqami

    @Column(nullable = false,length = 50)
    private String fullName;

    @Column(nullable = false,unique = true)
    private String email;


    @Column(nullable = false)
    private String password;


    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;//qachon royhatdan otganligi

    @UpdateTimestamp
    private Timestamp updateAt;//qachon tahrirlanganligi


    @ManyToMany
    private Set<Role> roles;

    private boolean accountNonExpired=true;//userning amal qilish muddati otmagan

    private boolean accountNonLocked=true;//bu user bloclanmaganligi

    private boolean credentialsNonExpired=true;//

    private boolean enabled;

    private String emailCode;


    //---------------BU USER DETAILSNING METHODLARI------------//

    //Bu userning huquqlar royhati
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.roles;
    }

    //usernung usernameni waqaytaradi
    @Override
    public String getUsername() {
        return this.email;
    }

    //accauntni amal qilish muddatini qaytaradi
    @Override
    public boolean isAccountNonExpired() {//accauntning muddati
        return this.accountNonExpired;
    }

    //accaunt bloclanganligi holatini qaytaradi
    @Override
    public boolean isAccountNonLocked() {//accaunt yopiq emas
        return this.accountNonLocked;
    }

    //accauntning ishinchlilik muddati tugagan yoki tugamagan holati
    @Override
    public boolean isCredentialsNonExpired() {//ishonlimi
        return this.credentialsNonExpired;
    }

    //accauntning yoniq yoki ochiqligini qaytaradi`
    @Override
    public boolean isEnabled() {//yoniqmi
        return this.enabled;
    }
}
