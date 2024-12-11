package com.example.zago;

import android.content.Context;
import android.util.Log;

public class Variavel extends Botao {

    private Cartao cartaoTipo, cartaoNome,cartaoOperador,cartaoValor;
    private boolean preenchida;

    public Variavel(Context context, int x, int y, int largura, int altura, Acao acao) {
        super(context, x, y, largura, altura, acao);
    }


    //gets

    public int getValorInt(){

        if(cartaoValor==null){
            return 0;
        }else{
            //Log.d("Variavel", "Valor int: "+cartaoValor.getTexto());
            return Integer.parseInt(cartaoValor.getTexto());
        }

    }
    public double getValorDouble() {

        if (cartaoValor == null) {
            return 0.0;
        } else {
            return Double.parseDouble(cartaoValor.getTexto());
        }
    }

    public Cartao getCartaoTipo() {
        return cartaoTipo;
    }

    public Cartao getCartaoNome() {
        return cartaoNome;
    }

    public Cartao getCartaoOperador() {
        return cartaoOperador;
    }

    public Cartao getCartaoValor() {
        return cartaoValor;
    }

    public boolean getPreenchida() {
        return preenchida;
    }

    //sets


    public void setPreenchida(boolean preenchida) {
        this.preenchida = preenchida;
    }

    public void setCartaoTipo(Cartao cartaoTipo) {
        this.cartaoTipo = cartaoTipo;
    }

    public void setCartaoNome(Cartao cartaoNome) {
        this.cartaoNome = cartaoNome;
    }

    public void setCartaoOperador(Cartao cartaoOperador) {
        this.cartaoOperador = cartaoOperador;
    }

    public void setCartaoValor(Cartao cartaoValor) {
        this.cartaoValor = cartaoValor;
    }
}
