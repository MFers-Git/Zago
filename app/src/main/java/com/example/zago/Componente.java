package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Componente extends View {

    private Context context;
    private Paint paint;
    private int posX, posY, contFrameAnimacao;
    private boolean visibilidade;

    private List<Bitmap> animacao;

    public Componente(Context context, int x, int y) {

        super(context);

        paint = new Paint();

        animacao = new ArrayList<>();

        this.posX = x;
        this.posY = y;

    }


    @Override
    public void onDraw(Canvas canvas) {

        if(visibilidade && animacao.size() != 0){
            int num = verificaNumeroFrame();

            canvas.drawBitmap(animacao.get(num), posX, posY, paint);

        }
        invalidate();
    }

    public int verificaNumeroFrame(){

        if(animacao.size()==1){
        //não faz nada obviamente
        }else{
            if(contFrameAnimacao+1==animacao.size()){
                contFrameAnimacao=0;

            }else{
                contFrameAnimacao++;
            }
        }


        return contFrameAnimacao;
    }

    //sets

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public void setAnimacao(List<Bitmap> animacao) {
        this.animacao = animacao;
    }


    //gets


    public Paint getPaint() {
        return paint;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean getVisibilidade() {
        return visibilidade;
    }

    public List<Bitmap> getAnimacao() {
        return animacao;
    }
}
