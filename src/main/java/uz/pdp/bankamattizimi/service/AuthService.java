package uz.pdp.bankamattizimi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.bankamattizimi.entity.Employee;
import uz.pdp.bankamattizimi.entity.enums.RoleName;
import uz.pdp.bankamattizimi.payload.ApiResponse;
import uz.pdp.bankamattizimi.payload.LoginDto;
import uz.pdp.bankamattizimi.payload.RegisterDto;
import uz.pdp.bankamattizimi.repository.EmployeeRepository;
import uz.pdp.bankamattizimi.repository.RoleRepository;
import uz.pdp.bankamattizimi.security.JwtProvider;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    public ApiResponse register(RegisterDto registerDto){
        boolean exists = employeeRepository.existsByEmail(registerDto.getEmail());
        if (exists){
            return new ApiResponse("Bunday email mavjut",false);
        }

        Employee employee=new Employee();
        employee.setFullName(registerDto.getFullName());
        employee.setEmail(registerDto.getEmail());
        employee.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        employee.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_DIRECTOR)));
        employee.setEmailCode(UUID.randomUUID().toString());
        employeeRepository.save(employee);
        sendEmail(employee.getEmail(), employee.getEmailCode());
        return new ApiResponse("muofaqiyatlik royhatdan otdingiz Director saqlandi accauntingizni tasdiqlang",true);



    }

    public ApiResponse hodim(RegisterDto registerDto){
        boolean exists = employeeRepository.existsByEmail(registerDto.getEmail());
        if (exists){
            return new ApiResponse("Bunday email mavjut",false);
        }

        Employee employee=new Employee();
        employee.setFullName(registerDto.getFullName());
        employee.setEmail(registerDto.getEmail());
        employee.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        employee.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_HODIM)));
        employee.setEmailCode(UUID.randomUUID().toString());
        employeeRepository.save(employee);
        sendEmail(employee.getEmail(), employee.getEmailCode());
        return new ApiResponse("muofaqiyatlik royhatdan otdingiz Hodim saqlandi accauntingizni tasdiqlang",true);



    }

    public ApiResponse user(RegisterDto registerDto){
        boolean exists = employeeRepository.existsByEmail(registerDto.getEmail());
        if (exists){
            return new ApiResponse("Bunday email mavjut",false);
        }

        Employee employee=new Employee();
        employee.setFullName(registerDto.getFullName());
        employee.setEmail(registerDto.getEmail());
        employee.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        employee.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_USER)));
        employee.setEmailCode(UUID.randomUUID().toString());
        employeeRepository.save(employee);
        sendEmail(employee.getEmail(), employee.getEmailCode());
        return new ApiResponse("muofaqiyatlik royhatdan otdingiz User  saqlandi accauntingizni tasdiqlang",true);



    }

    public Boolean sendEmail(String sendingEmail,String emailCode){
        try{
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom("Test@pdpgmail.com");
            mailMessage.setTo(sendingEmail);
            mailMessage.setSubject("Accauntni tasdiqlash");
            mailMessage.setText("<a href='http://localhost:8080/api/auth/verifyemail?emailCode="+emailCode+"&email="+sendingEmail+"'>Tasdiqlang</a>");
            javaMailSender.send(mailMessage);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    public ApiResponse verifyEmail(String emailCode, String email) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmailAndEmailCode(email, emailCode);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setEnabled(true);
            employee.setEmailCode(null);
            employeeRepository.save(employee);
            return new ApiResponse("Accaunt tasdiqlandi",true);
        }
        return new ApiResponse("Accaunt allaqachon tasdiqlangan",false);

    }

    public ApiResponse login(LoginDto loginDto) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken
                            (loginDto.getUsername(), loginDto.getPassword()));
            Employee user=(Employee) authenticate.getPrincipal();
            String token = jwtProvider.generateToken(loginDto.getUsername(), user.getRoles());
            return new ApiResponse("Token",true,token);
        }catch (BadCredentialsException badCredentialsException){
            return new ApiResponse("Parol yoki login hato",false);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Employee> byEmail = employeeRepository.findByEmail(username);
        if (byEmail.isPresent()){
            return byEmail.get();
        }
        throw new UsernameNotFoundException(username+" topilmadi");

//        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username+" topilmadi"));
    }
}
