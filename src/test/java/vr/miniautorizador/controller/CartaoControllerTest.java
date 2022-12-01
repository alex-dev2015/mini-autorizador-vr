package vr.miniautorizador.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import vr.miniautorizador.entity.Cartao;
import vr.miniautorizador.service.implantation.CartaoServiceImplantacao;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CartaoControllerTest {

    @InjectMocks
    private CartaoController controller;

    @Mock
    private CartaoServiceImplantacao service;

    public void consultarCartaoSemSaldo(){
        String cartao = "1234";
        Mockito.when(service.consultarSaldo(cartao));
    }
}
