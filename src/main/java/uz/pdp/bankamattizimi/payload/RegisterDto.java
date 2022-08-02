package uz.pdp.bankamattizimi.payload;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class RegisterDto {

    @NotNull
    @Length(min = 3,max = 50)
    private String fullName;//familyasi

    @NotNull
    @Email
    private String email;//user emaili

    @NotNull
        private String password;
}
