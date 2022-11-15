package vr.miniautorizador.service.implantation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vr.miniautorizador.entity.Card;
import vr.miniautorizador.entity.form.CardForm;
import vr.miniautorizador.repository.CardRepository;
import vr.miniautorizador.service.ICardService;

import java.math.BigDecimal;

@Service
public class CardServiceImplantation implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card create(CardForm form) {
        Card card = new Card();
        card.setNumberCard(form.getNumberCard());
        card.setPasswordCard(form.getPasswordCard());
        card.setValue(new BigDecimal("500.00"));

        return cardRepository.save(card);
    }

    @Override
    public Card get(String numberCard) {
        return cardRepository.findById(numberCard).get();
    }
}
