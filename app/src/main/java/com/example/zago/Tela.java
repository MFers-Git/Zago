package com.example.zago;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class Tela extends View {

    protected List<Componente> componentes;
    protected List<Botao> botoes;

    private boolean exibirMensagem;

    private Posicao posicoes;

    private Jogador jogador;

    protected List<Ser> componentesSelecao;

    protected List<Componente> componentesMensagem;
    protected List<Botao> botoesMensagem;
    private Componente selecionado;
    public Tela(Context context,Posicao posicoes, Jogador jogador) {

        super(context);

        componentes = new ArrayList<>();
        botoes = new ArrayList<>();

        componentesSelecao = new ArrayList<>();

        componentesMensagem = new ArrayList<>();
        botoesMensagem = new ArrayList<>();

        this.posicoes = posicoes;

        this.jogador = jogador;
    }

    public void onDraw(Canvas canvas){

        for(Componente c: componentes){

            c.draw(canvas);
        }

        if(selecionado != null){

            selecionado.draw(canvas);
        }

        for(Botao b: botoes){

            b.draw(canvas);
        }

        if(exibirMensagem){

            for(Componente c: componentesMensagem){
                c.draw(canvas);
            }

            for(Botao b: botoesMensagem){
                b.draw(canvas);
            }
        }

        invalidate();
    }

    public abstract void criarTela();

    public Botao getBotaoCoordenadas(double x, double y){

        if(exibirMensagem){

            for (Botao b : botoesMensagem) {

                if ((x <= b.getPosX() + b.getLargura() && x >= b.getPosX()) && (y <= b.getPosY() + b.getAltura() && y >= b.getPosY())) {

                    return b;

                }
            }
        }

        for (Botao b : botoes) {

            if ((x <= b.getPosX() + b.getLargura() && x >= b.getPosX()) && (y <= b.getPosY() + b.getAltura() && y >= b.getPosY())) {

                return b;

            }
        }

        return null;
    }


    //gets

    public List<Componente> getComponentes() {
        return componentes;
    }

    public List<Botao> getBotoes() {
        return botoes;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Posicao getPosicoes() {
        return posicoes;
    }

    public Componente getComponenteSelecionado(){

        return selecionado;
    }

    public List<Ser> getComponentesSelecao() {
        return componentesSelecao;
    }

    public boolean getExibirMensagem() {
        return exibirMensagem;
    }

    public List<Componente> getComponentesMensagem() {
        return componentesMensagem;
    }

    public List<Botao> getBotoesMensagem() {
        return botoesMensagem;
    }

    //sets

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    public void setBotoes(List<Botao> botoes) {
        this.botoes = botoes;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setExibirMensagem(boolean exibirMensagem) {
        this.exibirMensagem = exibirMensagem;
    }

    public void setComponentesMensagem(List<Componente> componentesMensagem) {
        this.componentesMensagem = componentesMensagem;
    }

    public void setBotoesMensagem(List<Botao> botoesMensagem) {
        this.botoesMensagem = botoesMensagem;
    }


    protected void setComponenteSelecionado(Componente selecionado) {

        this.selecionado = selecionado;
    }

    public void setComponenteSelecionadoPorNome(String nome) {

        for(Ser c: componentesSelecao){

            if(c.getNome().equals(nome)){
                selecionado = c;
                selecionado.setVisibilidade(true);
            }else {
                c.setVisibilidade(false);
            }
        }
    }


    public abstract void premiacao();

    public abstract List<Botao> getComponentesSelecionados();
}
