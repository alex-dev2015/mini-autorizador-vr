package vr.miniautorizador.entity.form;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor

public class TransacaoFormulario {

    private String numeroCartao;

    private String senha;

    private BigDecimal valor;

    public TransacaoFormulario(String numeroCartao, String senha, BigDecimal valor) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.valor = valor;
    }


}
