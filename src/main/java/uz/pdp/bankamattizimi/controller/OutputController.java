package uz.pdp.bankamattizimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.bankamattizimi.entity.Output;
import uz.pdp.bankamattizimi.service.OutputService;

@RestController
@RequestMapping("/api/output")
public class OutputController {
    @Autowired
    OutputService outputService;

}
