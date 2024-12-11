package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aranha extends Ser{
    public Aranha(Context context, int posX, int posY,  int numForca, int numDef, double numVida, double numVel) {
        super(context, posX, posY, "aranha", numForca, numDef, numVida, numVel);
    }

    @Override
    public List<Cartao> getProvaveisRecompensas() {
        return null;
    }

    @Override
    public Cartao getRecompensa() {

        Cartao c = null;

        Random r = new Random();

        GeradorDeImagens gi = new GeradorDeImagens(getContext());

        List<Bitmap> rec = new ArrayList<>();

        int n = r.nextInt(4) + 1;

        if (n == 1) {

            c = new Cartao(getContext(),0,0,150,150,"inteiros","2", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if(n == 2){
            c = new Cartao(getContext(),0,0,150,150,"inteiros","3", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if( n == 3){
            c = new Cartao(getContext(),0,0,150,150,"inteiros","4", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if(n == 4 ){

            c = new Cartao(getContext(),0,0,150,150,"operador atribuicao","=", Acao.INFOOPERADORCONCATENACAO);
            rec.add(gi.criarImg("cartoes/cartao amarelo.png"));
            c.setAnimacao(rec);
        }


        return c;
    }
}
