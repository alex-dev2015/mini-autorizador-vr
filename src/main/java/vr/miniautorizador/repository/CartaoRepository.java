package vr.miniautorizador.repository;

import java.util.Optional;
import java.math.BigDecimal;

import vr.miniautorizador.entity.Cartao;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
    @Query("SELECT c.valor FROM Cartao c WHERE c.numeroCartao = :numeroDoCartao")
    Optional<BigDecimal> consultarSaldoDoCartao(String numeroDoCartao);

    Optional<Cartao> findByNumeroCartao(String numero);
}
