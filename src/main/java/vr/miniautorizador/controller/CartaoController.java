package vr.miniautorizador.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vr.miniautorizador.entity.form.CartaoFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import vr.miniautorizador.service.implantation.CartaoServiceImplantacao;


@RestController
@RequestMapping
public class CartaoController {

    @Autowired
    private CartaoServiceImplantacao service;

    @PostMapping("/cartoes")
    public ResponseEntity<Object> criar(@RequestBody CartaoFormulario form) {
        try {
            return new ResponseEntity<Object>(service.criar(form), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Object>(form, HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @GetMapping("/cartoes/{numeroCartao}")
    public ResponseEntity<BigDecimal> consultar(@PathVariable(required = true) String numeroCartao) {
        Optional<BigDecimal> saldo = service.consultarSaldo(numeroCartao);

        return saldo.isPresent()
                ? new ResponseEntity<BigDecimal>(saldo.get(), HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

}
