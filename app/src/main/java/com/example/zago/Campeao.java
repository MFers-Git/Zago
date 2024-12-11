package com.example.zago;

import android.content.Context;

import java.util.List;

public class Campeao extends Ser{

    private Variavel variavelForca, variavelVida, variavelDef, variavelVel,variavelSelecionada;

    private Metodo metodoAtacar, metodoDefender, metodoSelecionado;

    public Campeao(Context context, int posX, int posY, String nome) {
        super(context, posX, posY, nome);

        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());
        Posicao pos = new Posicao();
    }
    public Campeao(Context context, int posX, int posY,String nome, int numForca, int numDef, double numVida, double numVel) {
        super(context, posX, posY, nome, numForca, numDef, numVida, numVel);
    }

    @Override
    public List<Cartao> getProvaveisRecompensas() {
        return null;
    }

    @Override
    public Cartao getRecompensa() {
        return null;
    }

    //sets


    public void setVariavelForca(Variavel variavelForca) {
        this.variavelForca = variavelForca;
        super.setNumForca(Integer.parseInt(variavelForca.getCartaoValor().getTexto()));
    }

    public void setVariavelVida(Variavel variavelVida) {
        this.variavelVida = variavelVida;
        super.setNumVida(Double.parseDouble(variavelVida.getCartaoValor().getTexto()));
    }

    public void setVariavelDef(Variavel variavelDef) {
        this.variavelDef = variavelDef;
        super.setNumDef(Integer.parseInt(variavelDef.getCartaoValor().getTexto()));
    }

    public void setVariavelVel(Variavel variavelVel) {
        this.variavelVel = variavelVel;
        super.setNumVel(Double.parseDouble(variavelVel.getCartaoValor().getTexto()));
    }

    public void setMetodoAtacar(Metodo metodoAtacar) {
        this.metodoAtacar = metodoAtacar;
    }

    public void setMetodoDefender(Metodo metodoDefender) {
        this.metodoDefender = metodoDefender;
    }

    public void setVariavelSelecionada(Variavel variavelSelecionada) {
        this.variavelSelecionada = variavelSelecionada;
    }
    public void setMetodoSelecionado(Metodo metodoSelecionado) {
        this.metodoSelecionado = metodoSelecionado;
    }

    //gets


    public Variavel getVariavelSelecionada() {
        return variavelSelecionada;
    }

    public Variavel getVariavelForca() {
        return variavelForca;
    }

    public Variavel getVariavelVida() {
        return variavelVida;
    }

    public Variavel getVariavelDefesa() {
        return variavelDef;
    }

    public Variavel getVariavelVel() {
        return variavelVel;
    }

    public Metodo getMetodoAtacar() {
        return metodoAtacar;
    }

    public Metodo getMetodoDefender() {
        return metodoDefender;
    }

    public Metodo getmetodoSelecionado() {

        return metodoSelecionado;
    }
}

