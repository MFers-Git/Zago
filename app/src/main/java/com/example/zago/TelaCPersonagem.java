package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.PaintDrawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TelaCPersonagem extends Tela{


    public TelaCPersonagem(Context context, Posicao posicoes, Jogador jogador) {
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

        //Caixa de textos início

        CaixaTexto ctTitulo1 = new CaixaTexto(this.getContext(),getPosicoes().getP3().x-360,getPosicoes().getP3().y-180,"Criação de Personagem",80);
        ctTitulo1.setVisibilidade(true);
        CaixaTexto ctTitulo2 = new CaixaTexto(this.getContext(),getPosicoes().getP3().x-250,getPosicoes().getP3().y-120,"Escolha o seu campeão",50);
        ctTitulo2.setVisibilidade(true);

        componentes.add(ctTitulo1);
        componentes.add(ctTitulo2);
        //------------------------------>

        //Componente campeões
                        //Context context,int posX, int posY, String nome
        Ser jho = new Campeao(getContext(), getPosicoes().getP3().x-205,getPosicoes().getP3().y-50,"jho");
        jho.criarAnimacaoFrenteRepouso();

        jho.setVisibilidade(true);

        //componentes.add(jho);

        Ser maria = new Campeao(getContext(), getPosicoes().getP3().x-205,getPosicoes().getP3().y-50,"maria");
        maria.criarAnimacaoFrenteRepouso();

        maria.setVisibilidade(false);

        //componentes.add(maria);

        //------------------------------>

        //Botões início

        GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
        List<Bitmap> iconeJho = new ArrayList<>();
        iconeJho.add(gImgs.criarImg("botoes/jho.png"));

        Botao bj = new Botao(getContext(), getPosicoes().getP2().x,getPosicoes().getP2().y,150,150, Acao.JHOSELECAO);
        bj.setAnimacao(iconeJho);

        bj.setVisibilidade(true);

        botoes.add(bj);

        List<Bitmap> iconeMaria = new ArrayList<>();
        iconeMaria.add(gImgs.criarImg("botoes/maria.png"));

        Botao bm = new Botao(getContext(), getPosicoes().getP7().x,getPosicoes().getP7().y,150,150,Acao.MARIASELECAO);
        bm.setAnimacao(iconeMaria);

        bm.setVisibilidade(true);

        botoes.add(bm);

        List<Bitmap> bOk = new ArrayList<>();
        bOk.add(gImgs.criarImg("botoes/ok.png"));

        Botao bconfirmar = new Botao(getContext(), getPosicoes().getP13().x-30, getPosicoes().getP13().y,150,150,Acao.CONFIRMARCRIACAOPERSONAGEM);

        bconfirmar.setAnimacao(bOk);

        bconfirmar.setVisibilidade(true);

        botoes.add(bconfirmar);

        super.getComponentesSelecao().add(jho);
        super.getComponentesSelecao().add(maria);
        super.setComponenteSelecionado(jho);

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
