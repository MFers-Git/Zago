package com.example.zago;

import android.content.Context;

public class Metodo extends Botao{

    private Cartao cTModificadorAcesso;

    private Cartao cTTipoRetornoMetodo;

    private Cartao cTNomeMetodo;

    private Cartao valorAtaqueCampeao;

    private Cartao valorDefesaOponente;

    private Cartao cTTipo;

    private Cartao cTNome;

    private Cartao cTOperadorAtribuicao;

    private Cartao cTValorVJogador;

    private Cartao cTOperadorConcatenacao;

    private Cartao cTValorVOponente;

    private Cartao cTReturn;

    private Cartao cTVariavelReturn;

    public boolean preenchida;


    public Metodo(Context context, int x, int y, int largura, int altura, Acao acao) {

        super(context, x, y, largura, altura, acao);

    }

    //gets
    public Cartao getcTModificadorAcesso() {
        return cTModificadorAcesso;
    }

    public Cartao getcTTipoRetornoMetodo() {
        return cTTipoRetornoMetodo;
    }

    public Cartao getcTNomeMetodo() {
        return cTNomeMetodo;
    }

    public Cartao getValorAtaqueCampeao() {
        return valorAtaqueCampeao;
    }

    public Cartao getValorDefesaOponente() {
        return valorDefesaOponente;
    }

    public Cartao getcTTipo() {
        return cTTipo;
    }

    public Cartao getcTNome() {
        return cTNome;
    }

    public Cartao getcTOperadorAtribuicao() {
        return cTOperadorAtribuicao;
    }

    public Cartao getcTValorVJogador() {
        return cTValorVJogador;
    }

    public Cartao getcTOperadorConcatenacao() {
        return cTOperadorConcatenacao;
    }

    public Cartao getcTValorVOponente() {
        return cTValorVOponente;
    }

    public Cartao getcTReturn() {
        return cTReturn;
    }

    public Cartao getcTVariavelReturn() {
        return cTVariavelReturn;
    }

    public boolean getPreenchida() {
        return preenchida;
    }

    //sets


    public void setPreenchida(boolean preenchida) {
        this.preenchida = preenchida;
    }


    public void setcTModificadorAcesso(Cartao cTModificadorAcesso) {
        this.cTModificadorAcesso = cTModificadorAcesso;
    }

    public void setcTTipoRetornoMetodo(Cartao cTTipoRetornoMetodo) {
        this.cTTipoRetornoMetodo = cTTipoRetornoMetodo;
    }

    public void setcTNomeMetodo(Cartao cTNomeMetodo) {
        this.cTNomeMetodo = cTNomeMetodo;
    }

    public void setValorAtaqueCampeao(Cartao valorAtaqueCampeao) {
        this.valorAtaqueCampeao = valorAtaqueCampeao;
    }

    public void setValorDefesaOponente(Cartao valorDefesaOponente) {
        this.valorDefesaOponente = valorDefesaOponente;
    }

    public void setcTTipo(Cartao cTTipo) {
        this.cTTipo = cTTipo;
    }

    public void setcTNome(Cartao cTNome) {
        this.cTNome = cTNome;
    }

    public void setcTOperadorAtribuicao(Cartao cTOperadorAtribuicao) {
        this.cTOperadorAtribuicao = cTOperadorAtribuicao;
    }

    public void setcTValorVJogador(Cartao cTValorVJogador) {
        this.cTValorVJogador = cTValorVJogador;
    }

    public void setcTOperadorConcatenacao(Cartao cTOperadorConcatenacao) {
        this.cTOperadorConcatenacao = cTOperadorConcatenacao;
    }

    public void setcTValorVOponente(Cartao cTValorVOponente) {
        this.cTValorVOponente = cTValorVOponente;
    }

    public void setcTReturn(Cartao cTReturn) {
        this.cTReturn = cTReturn;
    }

    public void setcTVariavelReturn(Cartao cTVariavelReturn) {
        this.cTVariavelReturn = cTVariavelReturn;
    }
}
