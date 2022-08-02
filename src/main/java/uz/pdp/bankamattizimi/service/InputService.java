package uz.pdp.bankamattizimi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.bankamattizimi.entity.Input;
import uz.pdp.bankamattizimi.repository.InputRepository;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;


}
