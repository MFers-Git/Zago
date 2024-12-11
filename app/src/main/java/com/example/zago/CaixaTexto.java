package com.example.zago;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

public class CaixaTexto extends Componente{

    private String texto;
    private int tamanho;

    public CaixaTexto(Context context, int x, int y, String texto,int tamanho) {

        super(context, x, y);
        this.texto = texto;
        this.tamanho = tamanho;
    }

    public void onDraw(Canvas canvas){

        if(getVisibilidade()){
            getPaint().setTypeface(Typeface.DEFAULT_BOLD);
            getPaint().setTextSize(tamanho);
            canvas.drawText(texto, getPosX(), getPosY(), getPaint());
        }
    }
}
