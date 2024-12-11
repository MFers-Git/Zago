package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaSelecaoMetodo extends Tela{
    public TelaSelecaoMetodo(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {


        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());


        //fundo
        Componente fundo = new Componente(getContext(), 0,0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundo padrao.png"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);
        componentes.add(fundo);

        //caixa de texto
        CaixaTexto ctTitulo = new CaixaTexto(getContext(),getPosicoes().getP1().x+400 , 70,"Seleção de método",70);
        ctTitulo.setVisibilidade(true);
        componentes.add(ctTitulo);

        //botoes

        int espacamento = 180;

        Botao mAtacar = new Botao(getContext(),getPosicoes().getP1().x-espacamento,getPosicoes().getP1().y-espacamento,900,900,Acao.TELACRIACAOMETODOATACAR);
        mAtacar.setTexto("Atacar");
        List<Bitmap> aniMAtacar = new ArrayList<>();
        aniMAtacar.add(gi.criarImg("botao metodo atacar.png"));
        mAtacar.setAnimacao(aniMAtacar);
        mAtacar.setVisibilidade(true);
        botoes.add(mAtacar);

        Botao mDefender = new Botao(getContext(),getPosicoes().getP4().x-espacamento-250, getPosicoes().getP4().y-espacamento,900,900,Acao.TELACRIACAOMETODODEFENDER);
        mDefender.setTexto("Defender");
        List<Bitmap> aniMDefender = new ArrayList<>();
        aniMDefender.add(gi.criarImg("botao metodo defender.png"));
        mDefender.setAnimacao(aniMDefender);
        mDefender.setVisibilidade(true);
        botoes.add(mDefender);

        Botao voltar = new Botao(getContext(),getPosicoes().getP15().x, getPosicoes().getP15().y,180,180,Acao.TELACRIACAO);
        voltar.setTexto("Voltar");
        List<Bitmap> aniVoltar = new ArrayList<>();
        aniVoltar.add(gi.criarImg("botao padrao.png"));
        voltar.setAnimacao(aniVoltar);
        voltar.setVisibilidade(true);
        botoes.add(voltar);
    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
