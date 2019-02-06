package sample.data.jpa.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sample.data.jpa.domain.Beneficiario;
import sample.data.jpa.repository.BeneficiarioRepository;

import java.util.List;

@Component("beneficiarioService")
@Transactional
public class BeneficiarioServiceImpl implements BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    BeneficiarioServiceImpl(BeneficiarioRepository beneficiarioRepositoryy) {
        this.beneficiarioRepository = beneficiarioRepositoryy;
    }

    @Override
    public List<Beneficiario> findAll() {
        return beneficiarioRepository.findAll();
    }

    @Override
    public Beneficiario findOne(Long id) {
        return beneficiarioRepository.findOne(id);
    }

    @Override
    public Beneficiario create(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }
}
