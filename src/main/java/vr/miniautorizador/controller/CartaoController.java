package vr.miniautorizador.controller;

import java.util.Optional;
import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import vr.miniautorizador.exception.ExistenteException;
import vr.miniautorizador.utils.ValidacaoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vr.miniautorizador.exception.SaldoException;
import vr.miniautorizador.exception.SenhaException;
import vr.miniautorizador.exception.CartaoException;
import vr.miniautorizador.entity.form.CartaoFormulario;
import vr.miniautorizador.entity.form.TransacaoFormulario;
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

    @PostMapping("/transacoes")
    public ResponseEntity<String> transacao(@RequestBody TransacaoFormulario formulario){
        try {
            return new ResponseEntity<String>(service.transacao(formulario), HttpStatus.CREATED);
        }
        catch (CartaoException e){
            return new ResponseEntity<String>(ValidacaoEnum.CARTAO_INEXISTENTE.getMensagem(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (SenhaException e){
            return new ResponseEntity<String>(ValidacaoEnum.SENHA_INVALIDA.getMensagem(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (SaldoException e) {
            return new ResponseEntity<String>(ValidacaoEnum.SALDO_INSUFICIENTE.getMensagem(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (ExistenteException e) {
            return new ResponseEntity<String>(ValidacaoEnum.CARTAO_EXISTENTE.getMensagem(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
