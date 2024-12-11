package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaBolsa extends Tela{

    private Cartao ctvalorInteiro1;
    private Cartao ctvalorInteiro2;
    private Cartao ctvalorFracionado1;
    private Cartao ctvalorFracionado2;
    private Cartao ctOperadorAtribuicao;
    private Cartao ctOperadorConcatenacao;
    private Cartao ctNomeMetodo;
    private Cartao ctNomeVariavel;
    private Cartao ctTipoInteiros;
    private Cartao ctTipoFracionados;
    public TelaBolsa(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {

        GeradorDeImagens gi = new GeradorDeImagens(getContext());

        int x = 100;
        int y = 200;
        int espacamento = 200;

        //fundo

        Componente fundo = new Componente(getContext(), 0, 0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundo padrao.png"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);

        componentes.add(fundo);

        //caixa de textos início

        CaixaTexto ct = new CaixaTexto(getContext(),getPosicoes().getP3().x-100,80,"Bolsa",80);
        ct.setVisibilidade(true);
        componentes.add(ct);


        ctvalorInteiro1 = getJogador().getCartaoValorInteiro();
        if(ctvalorInteiro1==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctvalorInteiro1 = new Cartao(getContext(),x , y, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctvalorInteiro1.setAnimacao(aniFor);
            ctvalorInteiro1.setVisibilidade(true);

        }else{

            ctvalorInteiro1.setPosX(x);
            ctvalorInteiro1.setPosY(y);

        }
        botoes.add(ctvalorInteiro1);

        ctvalorInteiro2 = getJogador().getCartaoValorInteiro();
        if(ctvalorInteiro2==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctvalorInteiro2 = new Cartao(getContext(),x+espacamento , y, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctvalorInteiro2.setAnimacao(aniFor);
            ctvalorInteiro2.setVisibilidade(true);

        }else{

            ctvalorInteiro2.setPosX(x+espacamento);
            ctvalorInteiro2.setPosY(y);

        }
        botoes.add(ctvalorInteiro2);

        ctOperadorAtribuicao = getJogador().getCartaoOperadorAtribuicao();
        if(ctOperadorAtribuicao==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctOperadorAtribuicao = new Cartao(getContext(),x+(espacamento*2) +200, y, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctOperadorAtribuicao.setAnimacao(aniFor);
            ctOperadorAtribuicao.setVisibilidade(true);

        }else{

            ctOperadorAtribuicao.setPosX(x+(espacamento*2) +200);
            ctOperadorAtribuicao.setPosY(y);

        }
        botoes.add(ctOperadorAtribuicao);

        ctNomeMetodo = getJogador().getCartaoNomeMetodo();
        if(ctNomeMetodo==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctNomeMetodo = new Cartao(getContext(),x+(espacamento*3)+400 , y, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctNomeMetodo.setAnimacao(aniFor);
            ctNomeMetodo.setVisibilidade(true);

        }else{

            ctNomeMetodo.setPosX(x+(espacamento*3)+400);
            ctNomeMetodo.setPosY(y);

        }
        botoes.add(ctNomeMetodo);

        ctTipoInteiros = getJogador().getCartaoTipoInteiros();
        if(ctTipoInteiros==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctTipoInteiros = new Cartao(getContext(),x+(espacamento*4) +600, y, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctTipoInteiros.setAnimacao(aniFor);
            ctTipoInteiros.setVisibilidade(true);

        }else{

            ctTipoInteiros.setPosX(x+(espacamento*4) +600);
            ctTipoInteiros.setPosY(y);

        }
        botoes.add(ctTipoInteiros);
//-------------------------------------------------------------------------------------------------------------------------------------------------------->

        ctvalorFracionado1 = getJogador().getCartaoValorFracionado();
        if(ctvalorFracionado1==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctvalorFracionado1 = new Cartao(getContext(),x , y+espacamento+30+140, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctvalorFracionado1.setAnimacao(aniFor);
            ctvalorFracionado1.setVisibilidade(true);

        }else{

            ctvalorFracionado1.setPosX(x);
            ctvalorFracionado1.setPosY(y+espacamento+30+140);

        }
        botoes.add(ctvalorFracionado1);

        ctvalorFracionado2 = getJogador().getCartaoValorFracionado();
        if(ctvalorFracionado2==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctvalorFracionado2 = new Cartao(getContext(),x+espacamento , y+espacamento+30+140, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctvalorFracionado2.setAnimacao(aniFor);
            ctvalorFracionado2.setVisibilidade(true);

        }else{

            ctvalorFracionado2.setPosX(x+espacamento);
            ctvalorFracionado2.setPosY(y+espacamento+30+140);

        }
        botoes.add(ctvalorFracionado2);

        ctOperadorConcatenacao = getJogador().getCartaoOperadorConcatenacao();
        if(ctOperadorConcatenacao==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctOperadorConcatenacao = new Cartao(getContext(),x+(espacamento*2) +200, y+espacamento+30+140, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctOperadorConcatenacao.setAnimacao(aniFor);
            ctOperadorConcatenacao.setVisibilidade(true);

        }else{

            ctOperadorConcatenacao.setPosX(x+(espacamento*2) +200);
            ctOperadorConcatenacao.setPosY(y+espacamento+30+140);

        }
        botoes.add(ctOperadorConcatenacao);

        ctNomeVariavel = getJogador().getCartaoNomeVariavel();
        if(ctNomeVariavel==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctNomeVariavel = new Cartao(getContext(),x+(espacamento*3) +400, y+espacamento+30+140, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctNomeVariavel.setAnimacao(aniFor);
            ctNomeVariavel.setVisibilidade(true);

        }else{

            ctNomeVariavel.setPosX(x+(espacamento*3) +400);
            ctNomeVariavel.setPosY(y+espacamento+30+140);

        }
        botoes.add(ctNomeVariavel);

        ctTipoFracionados = getJogador().getCartaoTipoFracionados();
        if(ctTipoFracionados==null){

            List<Bitmap> aniFor = new ArrayList<>();
            ctTipoFracionados = new Cartao(getContext(),x+(espacamento*4)+600 , y+espacamento+30+140, 180, 180, null,null, Acao.NULL);
            aniFor.add(gi.criarImg("cartoes/cartao branco.png"));
            ctTipoFracionados.setAnimacao(aniFor);
            ctTipoFracionados.setVisibilidade(true);

        }else{

            ctTipoFracionados.setPosX(x+(espacamento*4)+600);
            ctTipoFracionados.setPosY(y+espacamento+30+140);

        }
        botoes.add(ctTipoFracionados);


        //caixa de textos

        int tamanhoTexto = 40;

        CaixaTexto txt1 = new CaixaTexto(getContext(),150,130,"valores inteiros", tamanhoTexto);
        txt1.setVisibilidade(true);
        componentes.add(txt1);

        CaixaTexto txt2 = new CaixaTexto(getContext(),150,530,"valores fracionados", tamanhoTexto);
        txt2.setVisibilidade(true);
        componentes.add(txt2);

        CaixaTexto txt3 = new CaixaTexto(getContext(),650,130,"operador atibuição", tamanhoTexto);
        txt3.setVisibilidade(true);
        componentes.add(txt3);

        CaixaTexto txt4 = new CaixaTexto(getContext(),650,530,"operador concatenação", tamanhoTexto);
        txt4.setVisibilidade(true);
        componentes.add(txt4);

        CaixaTexto txt5 = new CaixaTexto(getContext(),1100,130 ,"nomes métodos", tamanhoTexto);
        txt5.setVisibilidade(true);
        componentes.add(txt5);

        CaixaTexto txt6 = new CaixaTexto(getContext(),1100,530,"nome variável", tamanhoTexto);
        txt6.setVisibilidade(true);
        componentes.add(txt6);

        CaixaTexto txt7 = new CaixaTexto(getContext(),1500,130,"tipos inteiros", tamanhoTexto);
        txt7.setVisibilidade(true);
        componentes.add(txt7);

        CaixaTexto txt8 = new CaixaTexto(getContext(),1500,530,"tipos fracionados", tamanhoTexto);
        txt8.setVisibilidade(true);
        componentes.add(txt8);

        Botao proximo = new Botao(getContext(),getPosicoes().getP15().x-640, getPosicoes().getP15().y,180,180,Acao.PROXIMO);
        //proximo.setTexto("Próximo");getPosicoes().getP15().x, getPosicoes().getP15().y
        List<Bitmap> acProximo = new ArrayList<>();
        acProximo.add(gi.criarImg("seta direita.png"));
        proximo.setAnimacao(acProximo);
        proximo.setVisibilidade(true);
        botoes.add(proximo);

        Botao anterior = new Botao(getContext(),getPosicoes().getP13().x-350, getPosicoes().getP13().y,180,180,Acao.ANTERIOR);
        //anterior.setTexto("Anterior");
        List<Bitmap> acAnterior = new ArrayList<>();
        acAnterior.add(gi.criarImg("seta esquerda.png"));
        anterior.setAnimacao(acAnterior);
        anterior.setVisibilidade(true);
        botoes.add(anterior);

        Botao bVoltar = new Botao(getContext(), getPosicoes().getP14().x-600,getPosicoes().getP14().y,180,180,Acao.TELAMUNDO);
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
