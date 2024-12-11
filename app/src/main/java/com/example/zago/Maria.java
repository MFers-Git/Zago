package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maria extends Campeao {

    private GeradorDeImagens gi;
    public Maria(Context context, int posX, int posY, String nome) {
        super(context, posX, posY, nome);
        gi = new GeradorDeImagens(context);
    }

    public Maria(Context context, int posX, int posY, int numForca, int numDef, double numVida, double numVel) {
        super(context, posX, posY, "maria", numForca, numDef, numVida, numVel);
        gi = new GeradorDeImagens(context);
    }

    @Override
    public List<Cartao> getProvaveisRecompensas() {
        return null;
    }

    @Override
    public Cartao getRecompensa() {

        Cartao c = null;

        Random r = new Random();

        gi = new GeradorDeImagens(getContext());

        List<Bitmap> rec = new ArrayList<>();

        int n = r.nextInt(4) + 1;

        if (n == 1) {

            c = new Cartao(getContext(),0,0,180,180,"fracionado","3.2", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if(n == 2){
            c = new Cartao(getContext(),0,0,180,180,"fracionado","4.1", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if( n == 3){
            c = new Cartao(getContext(),0,0,180,180,"fracionado","5.6", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if(n == 4 ){

            c = new Cartao(getContext(),0,0,180,180,"nome metodo","defender", Acao.INFOOPERADORNOMEMETODO);
            rec.add(gi.criarImg("cartoes/cartao verde.png"));
            c.setAnimacao(rec);
        }


        return c;
    }


}
