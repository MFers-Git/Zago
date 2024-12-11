package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaSilva extends Tela{
    public TelaSilva(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {
        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());
        //fundo

        Componente fundo = new Componente(getContext(), 0, 0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundos/tela cidade selecao.jpg"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);
        componentes.add(fundo);

        //Caixa de textos início

        CaixaTexto ctTitulo1 = new CaixaTexto(this.getContext(),getPosicoes().getP3().x-360,getPosicoes().getP3().y-180,"Mapa Silva",80);
        ctTitulo1.setVisibilidade(true);

        //botoes

        Botao morcego = new Botao(getContext(), getPosicoes().getP7().x, getPosicoes().getP7().y,150,150, Acao.TELABATALHAMORCEGO);
        List<Bitmap> amorcego = new ArrayList<>();
        amorcego.add(gi.criarImg("botoes/botao fase morcego.png" ));
        morcego.setAnimacao(amorcego);
        morcego.setVisibilidade(true);
        morcego.setTexto("Morcego");
        botoes.add(morcego);

        Botao campeao = null;

            if(getJogador().getCampeao().getNome().equals("jho")){

                //campeao = new Botao(context, ,150,150,"maria","Maria",, Acao.SELECAOCAMPEAO);
                campeao = new Botao(getContext(), getPosicoes().getP8().x, getPosicoes().getP8().y,150,150, Acao.TELABATALHAMARIA);
                List<Bitmap> aCompeao = new ArrayList<>();
                aCompeao.add(gi.criarImg("botoes/maria.png"));
                campeao.setAnimacao(aCompeao);
                campeao.setTexto("Maria");
                campeao.setVisibilidade(true);

            }else{

                campeao = new Botao(getContext(), getPosicoes().getP8().x, getPosicoes().getP8().y,150,150, Acao.TELABATALHAJHO);
                List<Bitmap> aCompeao = new ArrayList<>();
                aCompeao.add(gi.criarImg("botoes/jho.png"));
                campeao.setAnimacao(aCompeao);
                campeao.setTexto("Jho");
                campeao.setVisibilidade(true);
            }
        botoes.add(campeao);

        Botao aranha = new Botao(getContext(), getPosicoes().getP9().x, getPosicoes().getP9().y,150,150, Acao.TELABATALHAARANHA);

        List<Bitmap> aAranha = new ArrayList<>();
        aAranha.add(gi.criarImg("botoes/botao fase aranha.png"));
        aranha.setAnimacao(aAranha);
        aranha.setVisibilidade(true);
        aranha.setTexto("Aranha");
        botoes.add(aranha);


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
