package com.example.zago;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;

public class Botao extends Componente {

    private Acao acao;

    private int tamanhoTexto;
    private String texto;
    private int largura,altura;

    public Botao(Context context, int x, int y, int largura, int altura, Acao acao) {

        super(context, x, y);

        this.altura = altura;
        this.largura = largura;
        this.acao = acao;

        tamanhoTexto = 60;
    }

    @Override
    public void onDraw(Canvas canvas) {

        if(getVisibilidade() && getAnimacao().size() != 0){

            canvas.drawBitmap(getAnimacao().get(verificaNumeroFrame()), getPosX(), getPosY(), getPaint());
            if(texto != null){
                getPaint().setTypeface(Typeface.DEFAULT_BOLD);
                getPaint().setTextSize(tamanhoTexto);
                canvas.drawText(texto,getPosX()+10, getPosY()+getAltura()/2, getPaint());
            }

        }
    }

    //gets
    public Acao getAcao() {
        return acao;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public String getTexto() {
        return texto;
    }

    //sets

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public void setTamanhoTexto(int tamanhoTexto){

        this.tamanhoTexto = tamanhoTexto;
    }

    public void setTexto(String texto) {

        this.texto = texto;
    }
}
