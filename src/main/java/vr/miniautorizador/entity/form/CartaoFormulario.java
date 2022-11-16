package vr.miniautorizador.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoFormulario {

    private String numeroCartao;

    private String senha;

    private BigDecimal saldo;

}
