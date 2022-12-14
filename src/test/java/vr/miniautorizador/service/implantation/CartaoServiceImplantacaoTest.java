package vr.miniautorizador.service.implantation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import vr.miniautorizador.entity.Cartao;
import vr.miniautorizador.entity.form.CartaoFormulario;
import vr.miniautorizador.entity.form.TransacaoFormulario;
import vr.miniautorizador.exception.CartaoException;
import vr.miniautorizador.exception.SaldoException;
import vr.miniautorizador.exception.SenhaException;
import vr.miniautorizador.repository.CartaoRepository;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartaoServiceImplantacaoTest {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartaoServiceImplantacao servicoImplantacao;

    private void Inicializar() {
        CartaoFormulario form = new CartaoFormulario("1234123412341234", "1234", new BigDecimal("400.00"));
        Cartao cartao = new Cartao(form);
        cartaoRepository.saveAndFlush(cartao);
    }

    @Test
    public void quandoMetodoCriarCartaoForChamadoDeveRetornarSucesso() {
        Inicializar();

        // Cenário
        CartaoFormulario cartaoFormulario = new CartaoFormulario("1234567812345678", "1234", new BigDecimal("500.00"));

        // Excecução
        Cartao novoCartao = servicoImplantacao.criar(cartaoFormulario);
        Optional<Cartao> verificaCartao = cartaoRepository.findByNumeroCartao("1234567812345678");

        Optional<BigDecimal> valor = Optional.of(new BigDecimal("500.00"));
        // Verificação
        assertEquals( valor , cartaoRepository.consultarSaldoDoCartao(novoCartao.getNumeroCartao()));

    }

    @Test
    public void quandoBuscarSaldoECartaoForInexistenteDeveRetornarNumeroInexistente(){
        Inicializar();
        String numeroDeCartaoInexistente = "111111111";

        Optional<BigDecimal> saldoCartao = servicoImplantacao.consultarSaldo(numeroDeCartaoInexistente);

        assertFalse(saldoCartao.isPresent());

    }

    @Test
    public void quandoMetodoDeTransacaoForChamadoUsandoSaldoInsuficienteDeveRetornarErro(){
        Inicializar();
        TransacaoFormulario operacao = new TransacaoFormulario("1234123412341234", "1234", new BigDecimal("10000.00"));

        try {
            String resultado = servicoImplantacao.transacao(operacao);
            fail();
        }catch (Exception e){
            assertSame(e.getClass(), SaldoException.class);
        }
    }

    @Test
    public void quandoMetodoDeTransacaoForChamadoUsandoSenhaIncorretaDeveRetornarErro(){
        Inicializar();
        TransacaoFormulario operacao = new TransacaoFormulario("1234123412341234", "00000", new BigDecimal("100.00"));

        try {
            String resultado = servicoImplantacao.transacao(operacao);
            fail();
        }catch (Exception e){
            assertSame(e.getClass(), SenhaException.class);
        }
    }
}
