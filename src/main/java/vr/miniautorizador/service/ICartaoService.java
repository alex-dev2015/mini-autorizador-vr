package vr.miniautorizador.service;

import java.math.BigDecimal;
import java.util.Optional;

import vr.miniautorizador.entity.Cartao;
import vr.miniautorizador.entity.form.CartaoFormulario;


public interface ICartaoService {
    /**
     * Cria um cartão e salva no banco de dados.
     *
     * @param form - Formulário referente aos dados para a criação de um Cartão no banco de dados.
     * @return - Cartão recém-criado.
     */
    Cartao criar(CartaoFormulario form);

    /**
     * Retorna um cartão que está no banco de dados de acordo com o seu número
     *
     * @param numberCard - Número do cartão.
     * @return - Dados do cartão.
     */
    Optional<BigDecimal> consultarSaldo(String numberCard);
}
