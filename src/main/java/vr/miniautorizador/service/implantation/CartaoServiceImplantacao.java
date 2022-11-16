package vr.miniautorizador.service.implantation;

import java.util.Optional;
import java.math.BigDecimal;

import vr.miniautorizador.entity.Cartao;
import org.springframework.stereotype.Service;
import vr.miniautorizador.service.ICartaoService;
import vr.miniautorizador.repository.CartaoRepository;
import vr.miniautorizador.entity.form.CartaoFormulario;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CartaoServiceImplantacao implements ICartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public Cartao criar(CartaoFormulario form) {
        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(form.getNumeroCartao());
        cartao.setSenha(form.getSenha());
        cartao.setSaldo(new BigDecimal("500.00"));

        return cartaoRepository.save(cartao);
    }

    @Override
    public Optional<BigDecimal> consultarSaldo(String numeroCartao) {

        Optional<BigDecimal> saldo = cartaoRepository.consultarSaldoDoCartao(numeroCartao);
        return saldo;
    }

}
