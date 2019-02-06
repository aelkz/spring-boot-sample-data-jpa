package sample.data.jpa.service;

import sample.data.jpa.domain.Beneficiario;

import java.util.Date;
import java.util.List;

public interface BeneficiarioService {

    List<Beneficiario> findAll();

    Beneficiario findOne(Long id);

    Beneficiario create(Beneficiario beneficiario);

}
