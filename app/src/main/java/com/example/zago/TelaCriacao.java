package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaCriacao extends Tela {


    public TelaCriacao(Context context, Posicao posicoes, Jogador jogador) {
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

        //caixa de textos
        CaixaTexto ctTitulo1 = new CaixaTexto(this.getContext(),getPosicoes().getP3().x - 190, 70,"Criação",80);
        ctTitulo1.setVisibilidade(true);
        componentes.add(ctTitulo1);

        //Botões

        int variacao1 = 200;
        int variacao2 = 50;

        Botao criacaoVariavel = new Botao(this.getContext(),getPosicoes().getP1().x-variacao1,getPosicoes().getP1().y-variacao1,800,400,Acao.TELACRIACAOVARIAVEL);
        List<Bitmap> aniCriacaoVariavel = new ArrayList<>();
        aniCriacaoVariavel.add(gi.criarImg("botao variavel.png"));
        criacaoVariavel.setAnimacao(aniCriacaoVariavel);
        criacaoVariavel.setTexto("Variável");
        criacaoVariavel.setVisibilidade(true);
        botoes.add(criacaoVariavel);

        Botao criacaoMetodo = new Botao(this.getContext(),getPosicoes().getP3().x+variacao2-130,getPosicoes().getP1().y-variacao1,800,400,Acao.TELACRIACAOMETODO);
        List<Bitmap> aniCriacaoMetodo = new ArrayList<>();
        aniCriacaoMetodo.add(gi.criarImg("botao metodo.png"));
        criacaoMetodo.setAnimacao(aniCriacaoMetodo);
        criacaoMetodo.setVisibilidade(true);
        criacaoMetodo.setTexto("Método");
        botoes.add(criacaoMetodo);

        Botao criacaoConcatenacao = new Botao(this.getContext(),getPosicoes().getP1().x-variacao1,getPosicoes().getP8().y+variacao2-80,800,400,Acao.TELACRIACAOCONCATENACAO);
        List<Bitmap> aniCriacaoConcatenacao = new ArrayList<>();
        aniCriacaoConcatenacao.add(gi.criarImg("botao concatenacao.png"));
        criacaoConcatenacao.setAnimacao(aniCriacaoConcatenacao);
        criacaoConcatenacao.setTexto("Concatenação");
        criacaoConcatenacao.setVisibilidade(true);
        botoes.add(criacaoConcatenacao);

        Botao criacaoLoop = new Botao(this.getContext(),getPosicoes().getP3().x+variacao2-130,getPosicoes().getP8().y+variacao2-80,800,400,Acao.TELACRIACAOLOOP);
        List<Bitmap> aniCriacaoLoop = new ArrayList<>();
        aniCriacaoLoop.add(gi.criarImg("botao loop.png"));
        criacaoLoop.setAnimacao(aniCriacaoLoop);
        criacaoLoop.setTexto("Loop - Repetição");
        criacaoLoop.setVisibilidade(true);
        botoes.add(criacaoLoop);

        Botao mundo = new Botao(this.getContext(),getPosicoes().getP15().x,getPosicoes().getP15().y,180,180,Acao.TELAMUNDO);
        List<Bitmap> aniMundo = new ArrayList<>();
        aniMundo.add(gi.criarImg("botao padrao.png"));
        mundo.setAnimacao(aniMundo);
        mundo.setTexto("Voltar");
        mundo.setVisibilidade(true);
        botoes.add(mundo);

        //------------------------------>
    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
