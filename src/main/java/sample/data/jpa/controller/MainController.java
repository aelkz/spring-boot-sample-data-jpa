package sample.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.Beneficiario;
import sample.data.jpa.service.BeneficiarioService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping("/")
    @ResponseBody
    @Transactional(readOnly = true)
    public String helloWorld() {
        List<Beneficiario> result = new ArrayList<>();
        this.beneficiarioService.findAll().forEach(result::add);

        System.out.println(beneficiarioService.findAll().size());
        System.out.println(beneficiarioService.findOne(1L));
        System.out.println(beneficiarioService.findOne(2L));
        System.out.println(beneficiarioService.findOne(3L));

        Beneficiario entity = new Beneficiario();
        entity.setContrato("134059");
        entity.setCpf("23443212323");
        entity.setDataAdesao(new Date());
        entity.setEmail("temp@temp.com.br");
        entity.setNome("Joao");

        beneficiarioService.create(entity);

        System.out.println("@@@@@");
        System.out.println(beneficiarioService.findAll().size());
        Beneficiario beneficiario = beneficiarioService.findOne(4L);

        if (beneficiario != null)
            System.out.println(beneficiario.getNome());
        System.out.println("@@@@@");

        return "Total of records: "+result.size();
    }

}