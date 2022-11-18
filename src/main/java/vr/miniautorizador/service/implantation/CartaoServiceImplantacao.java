package vr.miniautorizador.service.implantation;

import java.util.Optional;
import java.math.BigDecimal;

import vr.miniautorizador.entity.Cartao;
import org.springframework.stereotype.Service;
import vr.miniautorizador.utils.ValidacaoEnum;
import vr.miniautorizador.service.ICartaoService;
import vr.miniautorizador.exception.ManipulaExcecao;
import vr.miniautorizador.repository.CartaoRepository;
import vr.miniautorizador.entity.form.CartaoFormulario;
import vr.miniautorizador.entity.form.TransacaoFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartaoServiceImplantacao implements ICartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private ManipulaExcecao excecao;

    @Override
    public Cartao criar(CartaoFormulario form) {
        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(form.getNumeroCartao());
        cartao.setSenha(form.getSenha());
        cartao.setValor(new BigDecimal("500.00"));

        return cartaoRepository.save(cartao);
    }

    @Override
    public Optional<BigDecimal> consultarSaldo(String numeroCartao) {

        return cartaoRepository.consultarSaldoDoCartao(numeroCartao);
    }

    @Transactional
    @Override
    public String transacao(TransacaoFormulario transacao) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumeroCartao(transacao.getNumeroCartao());
        Object cartaoValido = cartaoOptional.isPresent() ? true : excecao.throwValidaExcecao(ValidacaoEnum.CARTAO_INEXISTENTE);

        Cartao cartao = cartaoOptional.get();
        cartaoValido = cartao.getSenha().equals(transacao.getSenha()) ? true : excecao.throwValidaExcecao(ValidacaoEnum.SENHA_INVALIDA);

        cartao.novoSaldo(transacao.getValor(), excecao);

        return "OK";
    }

}
