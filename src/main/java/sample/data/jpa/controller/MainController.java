package sample.data.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.Beneficiario;
import sample.data.jpa.repository.BeneficiarioRepository;
import sample.data.jpa.service.BeneficiarioService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        List<Beneficiario> result = new ArrayList<>();

        LOG.info(""+beneficiarioService.findAll().size());
        LOG.info(""+beneficiarioService.findOne(1L));

        Beneficiario entity = new Beneficiario();
        entity.setContrato("134059");
        entity.setCpf("23443212323");
        entity.setDataAdesao(new Date());
        entity.setEmail("temp@temp.com.br");
        entity.setNome("Joao");

        // Beneficiario beneficiario = beneficiarioService.create(entity);
        // if (beneficiario != null) LOG.info(beneficiario.getNome());

        System.out.println("-----");
        Beneficiario beneficiario = beneficiarioService.findOne(1L);
        LOG.info(""+beneficiario.getHandle());
        LOG.info(""+beneficiario.getNome());
        LOG.info(""+beneficiarioRepository.findOne(1L));
        LOG.info(""+beneficiarioRepository.findAll());
        System.out.println("-----");

        this.beneficiarioService.findAll().forEach(result::add);

        return "Total of records: "+result.size();
    }

}