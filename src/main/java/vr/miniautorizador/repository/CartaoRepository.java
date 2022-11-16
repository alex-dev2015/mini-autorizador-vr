package vr.miniautorizador.repository;

import java.util.Optional;

import vr.miniautorizador.entity.Cartao;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
    @Query("SELECT c.saldo FROM Cartao c WHERE c.numeroCartao = :numeroDoCartao")
    Optional<Double> consultarSaldoDoCartao(String numeroDoCartao);

}
