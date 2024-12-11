package com.example.zago;

import android.content.Context;

public class Cartao extends Botao{

    private String tipo;
    private boolean info;

    public Cartao(Context context, int x, int y, int largura, int altura, String tipo, String texto, Acao acao) {

        super(context,x,y,largura,altura,acao);

        this.tipo = tipo;

        setTexto(texto);

    }

    //gets
    public String getTipo() {
        return tipo;
    }

    public boolean getVisibilidadeInfo(){

        return info;
    }

    //sets
    public void setVisibilidadeInfo(boolean info){

        this.info = info;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
