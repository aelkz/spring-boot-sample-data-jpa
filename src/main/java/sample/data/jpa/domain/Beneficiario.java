package sample.data.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="BENEFICIARIO", schema = "CONVENIO")
public class Beneficiario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BENEFICIARIO_SEQ")
    @SequenceGenerator(sequenceName = "beneficiario_seq", allocationSize = 1, name = "BENEFICIARIO_SEQ")
    public Long handle;

    @Column(name = "nome", length = 250, nullable = false, precision = 0)
    public String nome;

    @Column(name = "email", length = 250, nullable = false)
    public String email;

    @Column(name = "dt_adesao", nullable = true)
    public Date dataAdesao;

    @Column(name = "nu_cpf", length = 11, nullable = false)
    public String cpf;

    @Column(name = "nu_contrato", length = 20, nullable = false)
    public String contrato;

    public Long getHandle() {
        return handle;
    }

    public void setHandle(Long handle) {
        this.handle = handle;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAdesao() {
        return dataAdesao;
    }

    public void setDataAdesao(Date dataAdesao) {
        this.dataAdesao = dataAdesao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    // Class constructors

    public Beneficiario() { }

    public Beneficiario(String nome, String email, Date dataAdesao, String cpf, String contrato) {
        this.nome = nome;
        this.email = email;
        this.dataAdesao = dataAdesao;
        this.cpf = cpf;
        this.contrato = contrato;
    }

    // TODO - equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiario that = (Beneficiario) o;
        return getHandle().equals(that.getHandle()) &&
                getNome().equals(that.getNome()) &&
                getCpf().equals(that.getCpf()) &&
                Objects.equals(getContrato(), that.getContrato());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHandle(), getNome(), getCpf(), getContrato());
    }
}
