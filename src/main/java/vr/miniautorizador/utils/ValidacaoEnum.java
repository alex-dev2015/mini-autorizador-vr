package vr.miniautorizador.utils;

public enum ValidacaoEnum {
    SALDO_INSUFICIENTE {
        @Override
        public String getMensagem() {
            return "SALDO_INSUFICIENTE";
        }
    },
    SENHA_INVALIDA {
        @Override
        public String getMensagem() {
            return "SENHA_INVALIDA";
        }
    },
    CARTAO_INEXISTENTE {
        @Override
        public String getMensagem() {
            return "CARTAO_INEXISTENTE ";
        }
    };

    public abstract String getMensagem();
}
