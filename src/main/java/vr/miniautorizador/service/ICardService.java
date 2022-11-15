package vr.miniautorizador.service;

import vr.miniautorizador.entity.Card;
import vr.miniautorizador.entity.form.CardForm;

public interface ICardService {
    /**
     * Cria um cartão e salva no banco de dados.
     * @param form - Formulário referente aos dados para a criação de um Cartão no banco de dados.
     * @return - Cartão recém-criado.
     */
    Card create(CardForm form);

    /**
     * Retorna um cartão que está no banco de dados de acordo com o seu número
     * @param numberCard - Número do cartão.
     * @return - Dados do cartão.
     */
    Card get(String numberCard);
}
