package vr.miniautorizador.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardForm {

    private String numberCard;

    private String passwordCard;

    private BigDecimal value;

}
