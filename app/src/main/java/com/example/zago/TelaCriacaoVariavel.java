package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaCriacaoVariavel extends Tela{


    private Cartao cJTipoInteiros;
    private Cartao cJTipoFracionados;

    private Cartao cJNome;

    private Cartao cJValorInteiro;
    private Cartao cJValorFracionado;

    private Cartao cJOperador;

    private Cartao cTTipo;

    private Cartao cTNome;

    private Cartao cTOperador;

    private Cartao cTValor;

    public TelaCriacaoVariavel(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {

        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());
        int x = 1269;
        //fundo
        Componente fundo = new Componente(getContext(), 0,0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundo padrao.png"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);
        componentes.add(fundo);

        //componentes
        Componente moldura = new Componente(getContext(), x, 0);
        List<Bitmap> aniMoldura = new ArrayList<>();
        aniMoldura.add(gi.criarImg("moldurabolsa.png"));
        moldura.setAnimacao(aniMoldura);
        moldura.setVisibilidade(true);
        componentes.add(moldura);

        //Caixa de textos início
        CaixaTexto ctTitulo = new CaixaTexto(getContext(),getPosicoes().getP1().x+100 , 70,"Criação de Variável",70);
        ctTitulo.setVisibilidade(true);
        componentes.add(ctTitulo);

        CaixaTexto ctTipo = new CaixaTexto(getContext(),x+120,60,"Tipo de Variável", 50);
        ctTipo.setVisibilidade(true);
        componentes.add(ctTipo);

        CaixaTexto ctNome = new CaixaTexto(getContext(),x+120,310 ,"Nome Atribuído",50);
        ctNome.setVisibilidade(true);
        componentes.add(ctNome);

        CaixaTexto ctValor = new CaixaTexto(getContext(),x+230,560,"Operador Lógico",50);
        ctValor.setVisibilidade(true);
        componentes.add(ctValor);

        CaixaTexto ctOperador = new CaixaTexto(getContext(),x+120,810,"Valores", 50);
        ctOperador.setVisibilidade(true);
        componentes.add(ctOperador);

        //cartões esquerda

        x = 100;
        int y = getPosicoes().getP6().y-110;

            List<Bitmap> aniCartaoTipo = new ArrayList<>();
            aniCartaoTipo.add(gi.criarImg("cartoes/cartao vermelho.png"));
            cTTipo = new Cartao(getContext(), x+30, y, 180, 180,"inteiros",null, Acao.CARTAOTELA);
            cTTipo.setAnimacao(aniCartaoTipo);
            cTTipo.setVisibilidade(true);
        botoes.add(cTTipo);

            List<Bitmap> aniCartaoNome = new ArrayList<>();
            aniCartaoNome.add(gi.criarImg("cartoes/cartao roxo.png"));
            cTNome = new Cartao(getContext(), x + 270, y, 180, 180,"nome",null, Acao.CARTAOTELA);
            cTNome.setAnimacao(aniCartaoNome);
            cTNome.setVisibilidade(true);
        botoes.add(cTNome);

            List<Bitmap> aniCartaoOperador = new ArrayList<>();
            aniCartaoOperador.add(gi.criarImg("cartoes/cartao amarelo.png"));
            cTOperador = new Cartao(getContext(), x + 520, y, 180, 180,"operador atribuicao", null,  Acao.CARTAOTELA);
            cTOperador.setAnimacao(aniCartaoOperador);
            cTOperador.setVisibilidade(true);
        botoes.add(cTOperador);

            List<Bitmap> aniCartaoValor = new ArrayList<>();
            aniCartaoValor.add(gi.criarImg("cartoes/cartao azul.png"));
            cTValor = new Cartao(getContext(), x + 770, y, 180, 180 ,"valor inteiro",null,  Acao.CARTAOTELA);
            cTValor.setAnimacao(aniCartaoValor);
            cTValor.setVisibilidade(true);
        botoes.add(cTValor);

        CaixaTexto pontoEVirgula1 = new CaixaTexto(getContext(),x + 900+100, y+140,";", 170);
        pontoEVirgula1.setVisibilidade(true);
        componentes.add(pontoEVirgula1);

        x = 1269;

        //Cartoes direita _____________________________________________________________________________________________________________________________________________>

        cJTipoInteiros = getJogador().getCartaoTipoInteiros();

        if(cJTipoInteiros == null){
            cJTipoInteiros = new Cartao(getContext(), x + 130, 80, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJTipoInteiros = new ArrayList<>();
            anicJTipoInteiros.add(gi.criarImg("cartoes/cartao branco.png"));
            cJTipoInteiros.setAnimacao(anicJTipoInteiros);
            cJTipoInteiros.setVisibilidade(true);
        }else{

            cJTipoInteiros.setPosX(x + 130);
            cJTipoInteiros.setPosY(80);
            cJTipoInteiros.setVisibilidade(true);
        }
        botoes.add(cJTipoInteiros);

        cJTipoFracionados = getJogador().getCartaoTipoFracionados();

        if(cJTipoFracionados == null){
            cJTipoFracionados = new Cartao(getContext(), x + 330, 80, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJTipoFracionados = new ArrayList<>();
            anicJTipoFracionados.add(gi.criarImg("cartoes/cartao branco.png"));
            cJTipoFracionados.setAnimacao(anicJTipoFracionados);
            cJTipoFracionados.setVisibilidade(true);
        }else{

            cJTipoFracionados.setPosX(x + 330);
            cJTipoFracionados.setPosY(80);
            cJTipoFracionados.setVisibilidade(true);
        }
        botoes.add(cJTipoFracionados);

        cJNome = getJogador().getCartaoNomeVariavel();

        if(cJNome == null){
            cJNome = new Cartao(getContext(), x + 230, 330, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJNome = new ArrayList<>();
            anicJNome.add(gi.criarImg("cartoes/cartao branco.png"));
            cJNome.setAnimacao(anicJNome);
            cJNome.setVisibilidade(true);
        }else{

            cJNome.setPosX(x + 230);
            cJNome.setPosY(330);
            cJNome.setVisibilidade(true);
        }
        botoes.add(cJNome);

        cJOperador = getJogador().getCartaoOperadorAtribuicao();

        if(cJOperador == null){
            cJOperador = new Cartao(getContext(), x + 230, 580, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJOperador = new ArrayList<>();
            anicJOperador.add(gi.criarImg("cartoes/cartao branco.png"));
            cJOperador.setAnimacao(anicJOperador);
            cJOperador.setVisibilidade(true);
        }else{

            cJOperador.setPosX(x + 230);
            cJOperador.setPosY(580);
            cJOperador.setVisibilidade(true);
        }
        botoes.add(cJOperador);

        cJValorInteiro = getJogador().getCartaoValorInteiro();

        if(cJValorInteiro == null){
            cJValorInteiro = new Cartao(getContext(), x + 130, 820, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJValorInteiro = new ArrayList<>();
            anicJValorInteiro.add(gi.criarImg("cartoes/cartao branco.png"));
            cJValorInteiro.setAnimacao(anicJValorInteiro);
            cJValorInteiro.setVisibilidade(true);
        }else{

            cJValorInteiro.setPosX(x + 130);
            cJValorInteiro.setPosY(820);
            cJValorInteiro.setVisibilidade(true);
        }
        botoes.add(cJValorInteiro);

        cJValorFracionado = getJogador().getCartaoValorFracionado();

        if(cJValorFracionado == null){
            cJValorFracionado = new Cartao(getContext(), x + 330, 820, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJValorFracionado = new ArrayList<>();
            anicJValorFracionado.add(gi.criarImg("cartoes/cartao branco.png"));
            cJValorFracionado.setAnimacao(anicJValorFracionado);
            cJValorFracionado.setVisibilidade(true);
        }else{

            cJValorFracionado.setPosX(x + 330);
            cJValorFracionado.setPosY(820);
            cJValorFracionado.setVisibilidade(true);
        }
        botoes.add(cJValorFracionado);

        Botao finalizar = new Botao(getContext(),getPosicoes().getP12().x + 100, getPosicoes().getP14().y,180,180,Acao.CONFIRMARCRIACAOVARIAVEL);
        finalizar.setTexto("Criar");
        List<Bitmap> ac = new ArrayList<>();
        ac.add(gi.criarImg("botao padrao.png"));
        finalizar.setAnimacao(ac);
        finalizar.setVisibilidade(true);
        botoes.add(finalizar);

        Botao voltar = new Botao(getContext(),getPosicoes().getP13().x + 100, getPosicoes().getP13().y,180,180,Acao.TELACRIACAO);
        voltar.setTexto("Voltar");
        List<Bitmap> aniVoltar = new ArrayList<>();
        aniVoltar.add(gi.criarImg("botao padrao.png"));
        voltar.setAnimacao(aniVoltar);
        voltar.setVisibilidade(true);
        botoes.add(voltar);

        Botao proximo = new Botao(getContext(),getPosicoes().getP15().x+30, getPosicoes().getP15().y-390,170,110,Acao.PROXIMO);
        //proximo.setTexto("Próximo");
        List<Bitmap> acProximo = new ArrayList<>();
        acProximo.add(gi.criarImg("seta direita.png"));
        proximo.setAnimacao(acProximo);
        proximo.setVisibilidade(true);
        botoes.add(proximo);

        Botao anterior = new Botao(getContext(),getPosicoes().getP14().x-140, getPosicoes().getP14().y-390,170,110,Acao.ANTERIOR);
        //anterior.setTexto("Anterior");
        List<Bitmap> acAnterior = new ArrayList<>();
        acAnterior.add(gi.criarImg("seta esquerda.png"));
        anterior.setAnimacao(acAnterior);
        anterior.setVisibilidade(true);
        botoes.add(anterior);

        //------------------------------>

    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {

        List<Botao> cmps = new ArrayList<>();

        cmps.add(cTTipo);
        cmps.add(cTNome);
        cmps.add(cTOperador);
        cmps.add(cTValor);

        return cmps;
    }

    //gets


    public Cartao getcTTipo() {
        return cTTipo;
    }

    public Cartao getcTNome() {
        return cTNome;
    }

    public Cartao getcTOperador() {
        return cTOperador;
    }

    public Cartao getcTValor() {
        return cTValor;
    }
}
