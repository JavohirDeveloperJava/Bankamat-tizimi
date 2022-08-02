package uz.pdp.bankamattizimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.bankamattizimi.entity.Input;
import uz.pdp.bankamattizimi.service.InputService;

@RestController
@RequestMapping("/api/input")
public class InputController {
    @Autowired
    InputService inputService;


}
