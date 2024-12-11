package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaSelecaoCampeao extends Tela{

    private Ser oponente;
    public TelaSelecaoCampeao(Context context, Posicao posicoes, Jogador jogador, Ser oponente) {
        super(context, posicoes, jogador);

        this.oponente = oponente;
    }

    @Override
    public void criarTela() {

        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());

        //Fundo início

        Componente fundo = new Componente(getContext(), 0, 0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundo padrao.png"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);

        componentes.add(fundo);

        //------------------------------>

        //Caixa de textos início

        CaixaTexto ctTitulo1 = new CaixaTexto(getContext(),getPosicoes().getP3().x-320,getPosicoes().getP3().y-200,"Seleção de Personagem",80);
        ctTitulo1.setVisibilidade(true);
        componentes.add(ctTitulo1);
        CaixaTexto ctTitulo2 = new CaixaTexto(getContext(),getPosicoes().getP8().x,getPosicoes().getP8().y-100,"VS",50);
        ctTitulo2.setVisibilidade(true);
        componentes.add(ctTitulo2);
        CaixaTexto ctTitulo3 = new CaixaTexto(getContext(),getPosicoes().getP13().x-200,getPosicoes().getP13().y-100-90,"Possíveis recompensas",50);
        ctTitulo3.setVisibilidade(true);
        componentes.add(ctTitulo3);

        //botoes
        Acao acao = null;
        if(oponente.getNome().equals("morcego")){

            acao = Acao.BATALHAMORCEGO;
        }

        Botao bConfirmar = new Botao(getContext(), getPosicoes().getP14().x,getPosicoes().getP14().y,150,150,acao);
        List<Bitmap> ac = new ArrayList<>();
        ac.add(gi.criarImg("botao padrao.png"));
        bConfirmar.setAnimacao(ac);
        bConfirmar.setVisibilidade(true);
        botoes.add(bConfirmar);

        Botao bVoltar = new Botao(getContext(), getPosicoes().getP14().x+200,getPosicoes().getP14().y,150,150,Acao.TELAMUNDO);
        List<Bitmap> av = new ArrayList<>();
        av.add(gi.criarImg("botao padrao.png"));
        bVoltar.setAnimacao(av);
        bVoltar.setVisibilidade(true);
        botoes.add(bVoltar);


        int dis = 200;

        //prováveis recompensas

        Cartao c1 = oponente.getProvaveisRecompensas().get(0);
        c1.setPosX(getPosicoes().getP13().x+200-dis);
        c1.setPosY(getPosicoes().getP13().y+200-dis+40);
        c1.setVisibilidade(true);
        componentes.add(c1);

        Cartao c2 = oponente.getProvaveisRecompensas().get(1);
        c2.setPosX(getPosicoes().getP13().x+400-dis);
        c2.setPosY(getPosicoes().getP13().y+200-dis+40);
        c2.setVisibilidade(true);
        componentes.add(c2);

        //animaçoes

        Ser j = getJogador().getCampeao();
        j.criarAnimacaoFrenteRepouso();
        j.setPosX(getPosicoes().getP3().x- 300);
        j.setPosY(getPosicoes().getP3().y-100);
        j.setVisibilidade(true);
        componentes.add(j);

        oponente.criarAnimacaoFrenteRepouso();
        oponente.setPosX(getPosicoes().getP3().x+ 60);
        oponente.setPosY(getPosicoes().getP3().y-100);
        oponente.setVisibilidade(true);
        componentes.add(oponente);


    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
