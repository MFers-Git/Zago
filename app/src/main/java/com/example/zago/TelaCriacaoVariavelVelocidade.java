package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaCriacaoVariavelVelocidade extends Tela{

    private Cartao cJTipo;

    private Cartao cJNome;

    private Cartao cJValor;

    private Cartao cJOperador;

    private Cartao cTTipo;

    private Cartao cTNome;

    private Cartao cTOperador;

    private Cartao cTValor;

    public TelaCriacaoVariavelVelocidade(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {

        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());
        int x = 1269;
        //fundo
        Componente fundo = new Componente(getContext(), 0,0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("tela criacao variavel velocidade.png"));
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
        CaixaTexto ctTitulo = new CaixaTexto(getContext(),getPosicoes().getP1().x-140 , 70,"Criação de Variável Velocidade (fracionado)",70);
        ctTitulo.setVisibilidade(true);
        componentes.add(ctTitulo);

        CaixaTexto ctTipo = new CaixaTexto(getContext(),x+120,60,"Tipo de Variável", 50);
        ctTipo.setVisibilidade(true);
        componentes.add(ctTipo);

        CaixaTexto ctNome = new CaixaTexto(getContext(),x+120,310 ,"Nome Atribuído",50);
        ctNome.setVisibilidade(true);
        componentes.add(ctNome);

        CaixaTexto ctValor = new CaixaTexto(getContext(),x+120,560,"Operador Lógico",50);
        ctValor.setVisibilidade(true);
        componentes.add(ctValor);

        CaixaTexto ctOperador = new CaixaTexto(getContext(),x+120,810,"valor", 50);
        ctOperador.setVisibilidade(true);
        componentes.add(ctOperador);

        //cartões esquerda ----------------------------------------------------------------------------------------------------------->

        x = 100;
        int y = getPosicoes().getP6().y-110;


        List<Bitmap> aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao vermelho.png"));
        cTTipo = new Cartao(getContext(), x+30, y, 180, 180,"float",null, Acao.CARTAOTELA);
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
        cTValor = new Cartao(getContext(), x + 770, y, 180, 180 ,"valor fracionado",null,  Acao.CARTAOTELA);
        cTValor.setAnimacao(aniCartaoValor);
        cTValor.setVisibilidade(true);

        botoes.add(cTValor);

        CaixaTexto pontoEVirgula1 = new CaixaTexto(getContext(),x + 900+100, y+140,";", 170);
        pontoEVirgula1.setVisibilidade(true);
        componentes.add(pontoEVirgula1);

        x = 1269;

        //Cartoes direita _____________________________________________________________________________________________________________________________________________>

        cJTipo = new Cartao(getContext(), x + 230, 80, 180, 180,"float","float",Acao.CARTAOJOGADOR);
        List<Bitmap> aniCartaoTipo2 = new ArrayList<>();
        aniCartaoTipo2.add(gi.criarImg("cartoes/cartao vermelho.png"));
        cJTipo.setAnimacao(aniCartaoTipo2);
        cJTipo.setVisibilidade(true);

        botoes.add(cJTipo);

        cJNome = new Cartao(getContext(), x + 230, 330, 180, 180,"nome","Vel.",Acao.CARTAOJOGADOR);
        List<Bitmap> aniCartaoNome2 = new ArrayList<>();
        aniCartaoNome2.add(gi.criarImg("cartoes/cartao roxo.png"));
        cJNome.setAnimacao(aniCartaoNome2);
        cJNome.setVisibilidade(true);

        botoes.add(cJNome);

        cJOperador = new Cartao(getContext(), x + 230, 580, 180, 180,"operador atribuicao","=",Acao.CARTAOJOGADOR);
        List<Bitmap> aniCartaoOperador2 = new ArrayList<>();
        aniCartaoOperador2.add(gi.criarImg("cartoes/cartao amarelo.png"));
        cJOperador.setAnimacao(aniCartaoOperador2);
        cJOperador.setVisibilidade(true);

        botoes.add(cJOperador);

        cJValor = new Cartao(getContext(), x + 230, 820, 180, 180,"valor fracionado","2.1",Acao.CARTAOJOGADOR);
        List<Bitmap> aniCartaoValor2 = new ArrayList<>();
        aniCartaoValor2.add(gi.criarImg("cartoes/cartao azul.png"));
        cJValor.setAnimacao(aniCartaoValor2);
        cJValor.setVisibilidade(true);

        botoes.add(cJValor);

        Botao finalizar = new Botao(getContext(),getPosicoes().getP12().x + 100, getPosicoes().getP14().y,180,180,Acao.CONFIRMARCRIACAOVARIAVELVELOCIDADE);
        finalizar.setTexto("Criar");
        List<Bitmap> ac = new ArrayList<>();
        ac.add(gi.criarImg("botao padrao.png"));
        finalizar.setAnimacao(ac);
        finalizar.setVisibilidade(true);
        botoes.add(finalizar);
//10 força,5 defesa,100 vida,2 levocidade
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
}
