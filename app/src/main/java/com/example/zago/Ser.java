package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.util.Property;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class Ser extends Componente {

    private String nome;
    private List<Bitmap> aniFrenteRepouso;
    private List<Bitmap> aniFrenteDetalhe;

    private List<Bitmap> aniLadoDireitaRepouso;
    private List<Bitmap> aniLadoDireitaAtaque;
    private List<Bitmap> aniLadoDireitaDefesa;

    private List<Bitmap> aniLadoEsquerdaRepouso;
    private List<Bitmap> aniLadoEsquerdaAtaque;
    private List<Bitmap> aniLadoEsquerdaDefesa;

    private int numForca, numDef;
    private double numVida, numVel;
    private List<Cartao> provaveisRecompensas;

    private double vidaAtual, vidaMaxima;

    private GeradorDeImagens gi;

    private boolean batalhando;
    private boolean atacando;
    private int aux;

    public Ser(Context context,int posX, int posY, String nome) {

        super(context,posX,posY);

        this.nome = nome;
        
        gi = new GeradorDeImagens(context);

        provaveisRecompensas = new ArrayList<>();

    }

    public Ser(Context context,int posX, int posY, String nome,int numForca, int numDef,double numVida, double numVel ) {

        this(context,posX,posY,nome);

        this.numForca = numForca;
        this.numDef = numDef;
        this.numVida = numVida;
        this.numVel = numVel;

    }

    public void onDraw(Canvas canvas){

        if(batalhando){

            Bitmap barraDeVida = null;

            double vidaAux = calcularPorcentagemVida(vidaAtual,vidaMaxima);
            //Log.d("Ser", "Valor vidaAux: "+vidaAux);
            if(vidaAux >= 100){

                barraDeVida = gi.criarImg( "vida100.png");
                
            }else if(vidaAux >= 90){

                barraDeVida = gi.criarImg( "vida90.png");
            }else if(vidaAux >= 80){

                barraDeVida = gi.criarImg( "vida80.png");
            }else if(vidaAux >= 70){

                barraDeVida = gi.criarImg( "vida70.png");
            }else if(vidaAux >= 60){

                barraDeVida = gi.criarImg( "vida60.png");
            }else if(vidaAux >= 50){

                barraDeVida = gi.criarImg( "vida50.png");
            }else if(vidaAux >= 40){

                barraDeVida = gi.criarImg( "vida40.png");
            }else if(vidaAux >= 30){

                barraDeVida = gi.criarImg( "vida30.png");
            }else if(vidaAux >= 20){

                barraDeVida = gi.criarImg( "vida20.png");
            }else if(vidaAux >= 10){

                barraDeVida = gi.criarImg("vida10.png");
            }else {//if(vidaAux >= 0){

                barraDeVida = gi.criarImg( "vida0.png");
            }

            canvas.drawBitmap(barraDeVida, getPosX(), getPosY()+50, getPaint());

        }
        if(atacando){

            if(aux > 60){
                aux = 0;
                atacando = false;
            }

            aux++;
        }

        super.onDraw(canvas);
    }
    private double calcularPorcentagemVida(double vidaAtual, double vidaMaxima) {

        return ((double) vidaAtual / vidaMaxima) * 100;
    }

    //animações
    public void criarAnimacaoFrenteRepouso() {

        if(aniFrenteRepouso == null){

            GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
            aniFrenteRepouso = new ArrayList<>();
            for (int x = 0; x < 60; x++) {
                if (x < 10) {
                    aniFrenteRepouso.add(gImgs.criarImg("Ser/frente/" + nome + "/repouso/" + nome + " frente repouso " + "0000" + x + ".png"));

                } else {
                    aniFrenteRepouso.add(gImgs.criarImg("Ser/frente/" + nome + "/repouso/" + nome + " frente repouso " + "000" + x + ".png"));

                }

            }
            super.setAnimacao(aniFrenteRepouso);

            aniFrenteDetalhe = null;

            aniLadoDireitaRepouso= null;
            aniLadoDireitaAtaque= null;
            aniLadoDireitaDefesa= null;

            aniLadoEsquerdaRepouso= null;
            aniLadoEsquerdaAtaque= null;
            aniLadoEsquerdaDefesa= null;
        }

    }

    public void criarAnimacaoFrenteDetalhe() {

        if(aniFrenteDetalhe == null){
            GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
            aniFrenteDetalhe = new ArrayList<>();
            for (int x = 0; x < 60; x++) {
                if (x < 10) {
                    aniFrenteDetalhe.add(gImgs.criarImg("Ser/frente/"+nome+"/detalhe/"+nome+" frente detalhe " + "0000" + x + ".png"));


                } else {
                    aniFrenteDetalhe.add(gImgs.criarImg("Ser/frente/"+nome+"/detalhe/"+nome+" frente detalhe " + "000" + x + ".png"));

                }

            }

            super.setAnimacao(aniFrenteDetalhe);

            aniFrenteRepouso = null;

            aniLadoDireitaRepouso= null;
            aniLadoDireitaAtaque= null;
            aniLadoDireitaDefesa= null;

            aniLadoEsquerdaRepouso= null;
            aniLadoEsquerdaAtaque= null;
            aniLadoEsquerdaDefesa= null;
        }


    }

    public void criarAnimacaoDireitaRepouso(){

        if(aniLadoDireitaRepouso == null){

            GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
            aniLadoDireitaRepouso = new ArrayList<>();
            for (int x = 0; x < 60; x++) {
                if (x < 10) {
                    aniLadoDireitaRepouso.add(gImgs.criarImg("Ser/direita/"+nome+"/repouso/"+nome+" direita repouso " + "0000" + x + ".png"));


                } else {
                    aniLadoDireitaRepouso.add(gImgs.criarImg("Ser/direita/"+nome+"/repouso/"+nome+" direita repouso " + "000" + x + ".png"));

                }

            }

            super.setAnimacao(aniLadoDireitaRepouso);

            aniFrenteRepouso = null;
            aniFrenteDetalhe = null;

            aniLadoDireitaAtaque= null;
            aniLadoDireitaDefesa= null;

            aniLadoEsquerdaRepouso= null;
            aniLadoEsquerdaAtaque= null;
            aniLadoEsquerdaDefesa= null;
        }


    }

    public void criarAnimacaoDireitaAtaque() {

        if(aniLadoDireitaAtaque == null){

            GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
            aniLadoDireitaAtaque = new ArrayList<>();
            for (int x = 0; x < 60; x++) {
                if (x < 10) {
                    aniLadoDireitaAtaque.add(gImgs.criarImg("Ser/direita/"+nome+"/ataque/"+nome+" direita ataque " + "0000" + x + ".png"));


                } else {
                    aniLadoDireitaAtaque.add(gImgs.criarImg("Ser/direita/"+nome+"/ataque/"+nome+" direita ataque " + "000" + x + ".png"));

                }

            }
            super.setAnimacao(aniLadoDireitaAtaque);

            aniFrenteRepouso = null;
            aniFrenteDetalhe = null;

            aniLadoDireitaRepouso= null;
            aniLadoDireitaDefesa= null;

            aniLadoEsquerdaRepouso= null;
            aniLadoEsquerdaAtaque= null;
            aniLadoEsquerdaDefesa= null;
        }


    }

    public void criarAnimacaoEsquerdaRepouso() {

        if(aniLadoEsquerdaRepouso == null){

            GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
            aniLadoEsquerdaRepouso = new ArrayList<>();
            for (int x = 0; x < 60; x++) {
                if (x < 10) {
                    aniLadoEsquerdaRepouso.add(gImgs.criarImg("Ser/esquerda/"+nome+"/repouso/"+nome+" esquerda repouso " + "0000" + x + ".png"));


                } else {
                    aniLadoEsquerdaRepouso.add(gImgs.criarImg("Ser/esquerda/"+nome+"/repouso/"+nome+" esquerda repouso " + "000" + x + ".png"));

                }

            }
            super.setAnimacao(aniLadoEsquerdaRepouso);

            aniFrenteRepouso = null;
            aniFrenteDetalhe = null;

            aniLadoDireitaRepouso= null;
            aniLadoDireitaAtaque= null;
            aniLadoDireitaDefesa= null;

            aniLadoEsquerdaAtaque= null;
            aniLadoEsquerdaDefesa= null;
        }

    }

    public void criarAnimacaoEsquerdaAtaque() {

        if(aniLadoEsquerdaAtaque == null){

            GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
            aniLadoEsquerdaAtaque = new ArrayList<>();
            for (int x = 0; x < 60; x++) {
                if (x < 10) {
                    aniLadoEsquerdaAtaque.add(gImgs.criarImg("Ser/esquerda/"+nome+"/ataque/"+nome+" esquerda ataque " + "0000" + x + ".png"));


                } else {
                    aniLadoEsquerdaAtaque.add(gImgs.criarImg("Ser/esquerda/"+nome+"/ataque/"+nome+" esquerda ataque " + "000" + x + ".png"));

                }

            }
            super.setAnimacao(aniLadoEsquerdaAtaque);

            aniFrenteRepouso = null;
            aniFrenteDetalhe = null;

            aniLadoDireitaRepouso= null;
            aniLadoDireitaAtaque= null;
            aniLadoDireitaDefesa= null;

            aniLadoEsquerdaRepouso= null;
            aniLadoEsquerdaDefesa= null;
        }

    }

    //gets

    public String getNome() {
        return nome;
    }

    public int getNumForca() {
        return numForca;
    }

    public int getNumDef() {
        return numDef;
    }

    public double getNumVida() {
        return numVida;
    }

    public double getNumVel() {
        return numVel;
    }

    public abstract List<Cartao> getProvaveisRecompensas();

    public abstract Cartao getRecompensa();

    public double getVidaAtual() {
        return vidaAtual;
    }

    //sets

    public void setNumForca(int numForca) {
        this.numForca = numForca;
    }

    public void setNumDef(int numDef) {
        this.numDef = numDef;
    }

    public void setNumVida(double numVida) {
        this.numVida = numVida;
    }

    public void setNumVel(double numVel) {
        this.numVel = numVel;
    }

    public void setVidaAtual(double vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public void setVidaMaxima(double vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setBatalhando(boolean batalhando){

        if(batalhando){

            vidaAtual = numVida;
            vidaMaxima = numVida;
        }

        this.batalhando = batalhando;
    }

    public void setAtacando(boolean atacando) {

        this.atacando = atacando;
    }
}
