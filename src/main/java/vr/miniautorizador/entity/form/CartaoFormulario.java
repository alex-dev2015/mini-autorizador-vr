package vr.miniautorizador.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoFormulario {

    @NotEmpty(message = "Preencha o campo corretamente")
    @Size(min = 16, max = 16, message = "O número do cartão precisa ser de {max} números.")
    private String numeroCartao;

    @NotEmpty(message = "Preencha o campo corretamente")
    @Size(min = 4, max = 4, message = "A senha do cartão deve ser de {max} caracteres.")
    private String senha;

    private BigDecimal saldo;

}
