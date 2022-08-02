package uz.pdp.bankamattizimi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.bankamattizimi.repository.OutputRepository;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
}
