package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaGlacies extends Tela{
    public TelaGlacies(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {
        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());
        //fundo

        Componente fundo = new Componente(getContext(), 0, 0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundos/tela glacies.png"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);
        componentes.add(fundo);

        //Caixa de textos início

        CaixaTexto ctTitulo1 = new CaixaTexto(this.getContext(),getPosicoes().getP3().x-360,getPosicoes().getP3().y-180,"Mapa Silva",80);
        ctTitulo1.setVisibilidade(true);

        //botoes

        Botao lobo = new Botao(getContext(), getPosicoes().getP7().x, getPosicoes().getP7().y,150,150, Acao.TELABATALHALOBO);
        List<Bitmap> amorcego = new ArrayList<>();
        amorcego.add(gi.criarImg("botoes/botao fase lobo.png" ));
        lobo.setAnimacao(amorcego);
        lobo.setVisibilidade(true);
        //lobo.setTexto("Esqueleto");
        botoes.add(lobo);

        Botao suzy = new Botao(getContext(), getPosicoes().getP8().x, getPosicoes().getP8().y,150,150, Acao.TELABATALHASUZY);
        List<Bitmap> aCompeao = new ArrayList<>();
        aCompeao.add(gi.criarImg("botoes/botao fase suzy.png"));
        suzy.setAnimacao(aCompeao);
        //suzy.setTexto("Suzy");
        suzy.setVisibilidade(true);
        botoes.add(suzy);

        Botao ogroGelo = new Botao(getContext(), getPosicoes().getP9().x, getPosicoes().getP9().y,150,150, Acao.TELABATALHAOGROGELO);

        List<Bitmap> aAranha = new ArrayList<>();
        aAranha.add(gi.criarImg("botoes/botao fase ogro 2.png"));
        ogroGelo.setAnimacao(aAranha);
        ogroGelo.setVisibilidade(true);
        //ogroGelo.setTexto("Ogro de gelo");
        botoes.add(ogroGelo);


        Botao bVoltar = new Botao(getContext(), getPosicoes().getP14().x+200,getPosicoes().getP14().y,150,150,Acao.TELAMUNDO);
        List<Bitmap> aVoltar = new ArrayList<>();
        aVoltar.add(gi.criarImg("botao padrao.png"));
        bVoltar.setTexto("Voltar");
        bVoltar.setAnimacao(aVoltar);
        bVoltar.setVisibilidade(true);
        botoes.add(bVoltar);

    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
