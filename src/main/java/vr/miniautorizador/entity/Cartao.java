package vr.miniautorizador.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vr.miniautorizador.entity.form.CartaoFormulario;
import vr.miniautorizador.exception.ManipulaExcecao;
import vr.miniautorizador.utils.ValidacaoEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_cartao", uniqueConstraints = @UniqueConstraint(columnNames = "numeroCartao"))
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCartao;

    private String senha;

    private BigDecimal valor;

    public Cartao(CartaoFormulario cartaoFormulario)
    {
        this.numeroCartao = cartaoFormulario.getNumeroCartao();
        this.senha = cartaoFormulario.getSenha();
        this.valor = new BigDecimal("500.00");
    }
    public void novoSaldo(BigDecimal valor,  ManipulaExcecao excecao) {

        BigDecimal saldoAtual  = new BigDecimal(String.valueOf(this.valor));
        BigDecimal valorDebito = new BigDecimal(String.valueOf(valor));

        int resultado = saldoAtual.compareTo(valorDebito);

        BigDecimal bigDecimal = resultado >= 0
                ? this.valor = saldoAtual.subtract(valorDebito)
                : (BigDecimal) excecao.throwValidaExcecao(ValidacaoEnum.SALDO_INSUFICIENTE);

    }
}
