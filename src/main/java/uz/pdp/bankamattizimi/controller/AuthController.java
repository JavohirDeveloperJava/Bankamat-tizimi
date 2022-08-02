package uz.pdp.bankamattizimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.LoginDto;
import uz.pdp.bankamattizimi.payload.RegisterDto;
import uz.pdp.bankamattizimi.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

        @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto registerDto){
        ApiResponse register = authService.register(registerDto);
        return ResponseEntity.status(register.isSuccess()?201:409).body(register);
    }
    @PostMapping("/hodim")
    public HttpEntity<?> hodim(@RequestBody RegisterDto registerDto){
        ApiResponse register = authService.hodim(registerDto);
        return ResponseEntity.status(register.isSuccess()?201:409).body(register);
    }
    @PostMapping("/user")
    public HttpEntity<?> user(@RequestBody RegisterDto registerDto){
        ApiResponse register = authService.user(registerDto);
        return ResponseEntity.status(register.isSuccess()?201:409).body(register);
    }
    @GetMapping("/verifyemail")
    public HttpEntity<?> verifyEmail(@RequestParam String emailCode,@RequestParam String email){
        ApiResponse apiResponse=authService.verifyEmail(emailCode,email);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto){
        ApiResponse apiResponse=authService.login(loginDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:401).body(apiResponse);
    }
}
