package vr.miniautorizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vr.miniautorizador.entity.Card;

public interface CardRepository extends JpaRepository<Card, String> {
}
