package uz.pdp.bankamattizimi.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class LoginDto {
    @NotNull
    @Email
    private String username;//user emaili

    @NotNull
    private String password;

    //eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZvaGlybmF6YXJhbGlldjAwMkBnbWFpbC5jb20iLCJpYXQiOjE2NTg5MTQxNjAsImV4cCI6MTY1ODkyMjgwMCwicm9sZXMiOltdfQ.mtNT1aFSP_x-1kfovDRxkaGfZJ93PFPJwrzmg3NHmgpuRR99oWkshm5ZD0MPWoq7XbK0p8A-4tSJlksJWTyEvA
}