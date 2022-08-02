package uz.pdp.bankamattizimi.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.pdp.bankamattizimi.entity.Employee;


import java.util.Optional;
import java.util.UUID;

public class KimYozganiniBilish implements AuditorAware<UUID> {
    @Override
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null&&
                authentication.isAuthenticated()&&!
                authentication.getPrincipal().equals("anonymousUser")){
           Employee user=(Employee) authentication.getPrincipal();
           return Optional.of(user.getId());
        }
        return Optional.empty();
    }
}
