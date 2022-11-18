package vr.miniautorizador.entity.form;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartaoFormulario {

    private String numeroCartao;

    private String senha;

    private BigDecimal valor;


}
