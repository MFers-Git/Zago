package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Morcego extends Ser{

private GeradorDeImagens gi;
    public Morcego(Context context, int posX, int posY, String nome) {
        super(context, posX, posY, nome);
    }

    public Morcego(Context context, int posX, int posY, int numForca, int numDef, double numVida, double numVel) {
        super(context, posX, posY, "morcego", numForca, numDef, numVida, numVel);

    }

    @Override
    public List<Cartao> getProvaveisRecompensas() {

        gi = new GeradorDeImagens(getContext());

        List<Cartao> provaveisRecompensas = new ArrayList<>();
        List<Bitmap> ac1 = new ArrayList<>();
        ac1.add(gi.criarImg("cartoes/cartao azul.png"));
        Cartao c1 = new Cartao(getContext(),0,0,150,150,"valor inteiro","1~3",Acao.INFOVALOR);
        c1.setAnimacao(ac1);

        List<Bitmap> ac2 = new ArrayList<>();
        ac2.add(gi.criarImg("cartoes/cartao vermelho.png"));
        Cartao c2 = new Cartao(getContext(),0,0,150,150,"inteiros","int",Acao.INFOINT);
        c2.setAnimacao(ac2);

        provaveisRecompensas.add(c1);
        provaveisRecompensas.add(c2);

        return provaveisRecompensas;
    }

    @Override
    public Cartao getRecompensa() {

        Cartao c = null;

        Random r = new Random();

        gi = new GeradorDeImagens(getContext());

        List<Bitmap> rec = new ArrayList<>();

        int n = r.nextInt(4) + 1;

        if (n == 1) {

            c = new Cartao(getContext(),0,0,150,150,"inteiros","1", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if(n == 2){
            c = new Cartao(getContext(),0,0,150,150,"inteiros","2", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if( n == 3){
            c = new Cartao(getContext(),0,0,150,150,"inteiros","3", Acao.INFOVALOR);
            rec.add(gi.criarImg("cartoes/cartao azul.png"));
            c.setAnimacao(rec);
        }
        if(n == 4 ){

            c = new Cartao(getContext(),0,0,150,150,"operador concatenacao","+", Acao.INFOOPERADORCONCATENACAO);
            rec.add(gi.criarImg("cartoes/cartao amarelo.png"));
            c.setAnimacao(rec);
        }


        return c;
    }
}
