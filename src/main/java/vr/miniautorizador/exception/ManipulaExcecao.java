package vr.miniautorizador.exception;

import org.springframework.stereotype.Component;
import vr.miniautorizador.utils.ValidacaoEnum;

@Component
public class ManipulaExcecao {
    public Object throwValidaExcecao(ValidacaoEnum erro) {
        switch (erro) {
            case SALDO_INSUFICIENTE:
                throw new SaldoException();
            case SENHA_INVALIDA:
                throw new SenhaException();
            case CARTAO_INEXISTENTE:
                throw new CartaoException();
            case CARTAO_EXISTENTE:
                throw new ExistenteException();
            default:
                return null;
        }
    }
}
