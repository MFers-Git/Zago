package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaInicial extends Tela {


    public TelaInicial(Context context, Posicao posicoes, Jogador jogador) {

        super(context, posicoes, jogador);


    }

    @Override
    public void criarTela() {

        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());

        //fundo
        Componente fundo = new Componente(getContext(), 0,0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundos/fundo tela entrar.png"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);
        componentes.add(fundo);

        //botoes
/*

        Botao entrar = new Botao(getContext(),getPosicoes().getP13().x - 200,getPosicoes().getP13().y,180,180,Acao.TELACRIACAO);
        entrar.setTexto("Entrar");
        List<Bitmap> ae = new ArrayList<>();
        ae.add(gi.criarImg("botao padrao.png"));
        entrar.setAnimacao(ae);
        entrar.setVisibilidade(true);
        botoes.add(entrar);
*/

        Botao criar = new Botao(getContext(),getPosicoes().getP13().x, getPosicoes().getP14().y,180,180,Acao.TELACRIARPERSONAGEM);
        criar.setTexto("Criar");
        List<Bitmap> ac = new ArrayList<>();
        ac.add(gi.criarImg("botao padrao.png"));
        criar.setAnimacao(ac);
        criar.setVisibilidade(true);
        botoes.add(criar);


    }

    @Override
    public void premiacao() {

        GeradorDeImagens gi = new GeradorDeImagens(getContext());

        List<Bitmap> aniInfo = new ArrayList<>();
        aniInfo.add(gi.criarImg("intro zago.png"));
        Componente info = new Componente(getContext(),0,0);
        info.setAnimacao(aniInfo);
        info.setVisibilidade(true);
        getComponentesMensagem().add(info);

        List<Bitmap> aniBotaoOkPremiacao = new ArrayList<>();
        aniBotaoOkPremiacao.add(gi.criarImg("botao padrao.png"));
        Botao botaoOkPremiacao = new Botao(getContext(),0,0,180,180,Acao.OKPREMIACAO);
        botaoOkPremiacao.setAnimacao(aniBotaoOkPremiacao);
        botaoOkPremiacao.setTexto("Ok");
        botaoOkPremiacao.setTamanhoTexto(70);
        botaoOkPremiacao.setVisibilidade(true);
        botaoOkPremiacao.setPosX(getPosicoes().getP13().x);
        botaoOkPremiacao.setPosY(getPosicoes().getP13().y);
        getBotoesMensagem().add(botaoOkPremiacao);



    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
