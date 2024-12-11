package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaCriacaoConcatenacao extends Tela{

//cartoes jogador
    private Cartao cJValorInteiro;
    private Cartao cJValorFracionado;
    private Cartao cJOperador;
//cartoes tela
    private Cartao cTValor1;
    private Cartao cTOperador;
    private Cartao cTValor2;

    public TelaCriacaoConcatenacao(Context context, Posicao posicoes, Jogador jogador) {
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
        CaixaTexto ctTitulo = new CaixaTexto(getContext(),getPosicoes().getP1().x+140 , 70,"Concatenação",70);
        ctTitulo.setVisibilidade(true);
        componentes.add(ctTitulo);

        CaixaTexto ctTipo = new CaixaTexto(getContext(),x+120,150,"Valores", 50);
        ctTipo.setVisibilidade(true);
        componentes.add(ctTipo);

        CaixaTexto ctNome = new CaixaTexto(getContext(),x+120,450 ,"Operador lógico",50);
        ctNome.setVisibilidade(true);
        componentes.add(ctNome);

        //cartões esquerda

        x = 250;
        int y = getPosicoes().getP6().y-110;

        List<Bitmap> aniCartaoValor1 = new ArrayList<>();
        aniCartaoValor1.add(gi.criarImg("cartoes/cartao azul.png"));
        cTValor1 = new Cartao(getContext(), x+30, y, 180, 180,"inteiros",null, Acao.CARTAOTELA);
        cTValor1.setAnimacao(aniCartaoValor1);
        cTValor1.setVisibilidade(true);
        botoes.add(cTValor1);

        List<Bitmap> aniCartaoOperadorLogico1 = new ArrayList<>();
        aniCartaoOperadorLogico1.add(gi.criarImg("cartoes/cartao amarelo.png"));
        cTOperador = new Cartao(getContext(), x + 270, y, 180, 180,"nome",null, Acao.CARTAOTELA);
        cTOperador.setAnimacao(aniCartaoOperadorLogico1);
        cTOperador.setVisibilidade(true);
        botoes.add(cTOperador);

        List<Bitmap> aniCartaoOperadorLogico2 = new ArrayList<>();
        aniCartaoOperadorLogico2.add(gi.criarImg("cartoes/cartao azul.png"));
        cTValor2 = new Cartao(getContext(), x + 520, y, 180, 180,"operador atribuicao", null,  Acao.CARTAOTELA);
        cTValor2.setAnimacao(aniCartaoOperadorLogico2);
        cTValor2.setVisibilidade(true);
        botoes.add(cTValor2);

        CaixaTexto pontoEVirgula1 = new CaixaTexto(getContext(),x + 700, y+140,";", 170);
        pontoEVirgula1.setVisibilidade(true);
        componentes.add(pontoEVirgula1);

        x = 1269;
        y = 200;

        //Cartoes direita _____________________________________________________________________________________________________________________________________________>

        cJValorInteiro = getJogador().getCartaoValorInteiro();
        if(cJValorInteiro == null){
            cJValorInteiro = new Cartao(getContext(), x + 130, y, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJTipoInteiros = new ArrayList<>();
            anicJTipoInteiros.add(gi.criarImg("cartoes/cartao branco.png"));
            cJValorInteiro.setAnimacao(anicJTipoInteiros);
            cJValorInteiro.setVisibilidade(true);
        }else{

            cJValorInteiro.setPosX(x + 130);
            cJValorInteiro.setPosY(y);
            cJValorInteiro.setVisibilidade(true);
        }
        botoes.add(cJValorInteiro);

        cJValorFracionado = getJogador().getCartaoValorFracionado();
        if(cJValorFracionado == null){
            cJValorFracionado = new Cartao(getContext(), x + 330, y, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJTipoFracionados = new ArrayList<>();
            anicJTipoFracionados.add(gi.criarImg("cartoes/cartao branco.png"));
            cJValorFracionado.setAnimacao(anicJTipoFracionados);
            cJValorFracionado.setVisibilidade(true);
        }else{

            cJValorFracionado.setPosX(x + 330);
            cJValorFracionado.setPosY(y);
            cJValorFracionado.setVisibilidade(true);
        }
        botoes.add(cJValorFracionado);

        cJOperador = getJogador().getCartaoOperadorConcatenacao();
        if(cJOperador == null){
            cJOperador = new Cartao(getContext(), x + 230, y*2+60, 180, 180,null,null,Acao.CARTAOJOGADOR);
            List<Bitmap> anicJOperador = new ArrayList<>();
            anicJOperador.add(gi.criarImg("cartoes/cartao branco.png"));
            cJOperador.setAnimacao(anicJOperador);
            cJOperador.setVisibilidade(true);
        }else{

            cJOperador.setPosX(x + 230);
            cJOperador.setPosY(y*2+60);
            cJOperador.setVisibilidade(true);
        }
        botoes.add(cJOperador);


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

        //------------------------------>

            Botao proximo = new Botao(getContext(),getPosicoes().getP15().x, getPosicoes().getP15().y+90,170,110,Acao.PROXIMO);
            //proximo.setTexto("Próximo");
            List<Bitmap> acProximo = new ArrayList<>();
            acProximo.add(gi.criarImg("seta direita.png"));
            proximo.setAnimacao(acProximo);
            proximo.setVisibilidade(true);
            botoes.add(proximo);

            Botao anterior = new Botao(getContext(),getPosicoes().getP14().x-90, getPosicoes().getP14().y+90,170,110,Acao.ANTERIOR);
            //anterior.setTexto("Anterior");
            List<Bitmap> acAnterior = new ArrayList<>();
            acAnterior.add(gi.criarImg("seta esquerda.png"));
            anterior.setAnimacao(acAnterior);
            anterior.setVisibilidade(true);
            botoes.add(anterior);

    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {

        List<Botao> cmps = new ArrayList<>();

        cmps.add(cTValor1);
        cmps.add(cTOperador);
        cmps.add(cTValor2);

        return cmps;
    }
}
