package sample.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import sample.data.jpa.domain.Beneficiario;

import java.util.List;

public interface BeneficiarioRepository extends CrudRepository<Beneficiario, Long> {

    List<Beneficiario> findAll();

    Beneficiario findOne(Long id);

    Beneficiario save(Beneficiario beneficiario);
}
