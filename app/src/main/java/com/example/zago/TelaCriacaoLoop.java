package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaCriacaoLoop extends Tela{

    //tela
    private Cartao ctTipo;
    private Cartao ctNome1;
    private Cartao ctOperador1;
    private Cartao ctValor1;
    private Cartao ctNome2;
    private Cartao ctOperador2;
    private Cartao ctNome3;
    private Cartao ctNome4;
    private Cartao ctOperador3;
    private Cartao ctOperador4;
    private Cartao ctValor2;
    private Cartao ctOperador5;
    private Cartao ctValor3;
    private Cartao ctOperador6;
    private Cartao ctValor4;

    //jogador

    private Variavel cjVariavelForca;
    private Variavel cjVariavelVida;
    private Variavel cjVariavelDefesa;
    private Variavel cjVariavelVel;
    private Cartao cjValorInteiro;

    public TelaCriacaoLoop(Context context, Posicao posicoes, Jogador jogador) {
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
        CaixaTexto ctTitulo = new CaixaTexto(getContext(),getPosicoes().getP1().x+100 , 70,"Criação de loop (for)",70);
        ctTitulo.setVisibilidade(true);
        componentes.add(ctTitulo);

        CaixaTexto ctValor = new CaixaTexto(getContext(),x+230,90,"Variáveis",50);
        ctValor.setVisibilidade(true);
        componentes.add(ctValor);

        CaixaTexto ctOperador = new CaixaTexto(getContext(),x+250,590,"Valor", 50);
        ctOperador.setVisibilidade(true);
        componentes.add(ctOperador);

//------------------------------------------------------------------------------------------------------------------------------------------------->

        int deslocamento = 185;

        x= 190;
        int y =140;

//componentes esquerda_____________________________________________________________________________________________________________________>

        CaixaTexto ctFor = new CaixaTexto(getContext(),x-140, y+110,"for", 80);
        ctFor.setVisibilidade(true);
        componentes.add(ctFor);

        CaixaTexto colchete1 = new CaixaTexto(getContext(),+x-35, y+110,"(", 80);
        colchete1.setVisibilidade(true);
        componentes.add(colchete1);

        List<Bitmap> aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao vermelho.png"));

        ctTipo = new Cartao(getContext(), x, y, 180, 180,"inteiro","int", Acao.CARTAOTELA);
        ctTipo.setAnimacao(aniCartaoTipo);
        ctTipo.setVisibilidade(true);
        botoes.add(ctTipo);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao roxo.png"));

        ctNome1 = new Cartao(getContext(), x+deslocamento, y, 180, 180,"nome","x", Acao.CARTAOTELA);
        ctNome1.setAnimacao(aniCartaoTipo);
        ctNome1.setVisibilidade(true);
        botoes.add(ctNome1);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao amarelo.png"));

        ctOperador1 = new Cartao(getContext(), x+(deslocamento*2), y, 180, 180,"operador atribuicao","=", Acao.CARTAOTELA);
        ctOperador1.setAnimacao(aniCartaoTipo);
        ctOperador1.setVisibilidade(true);
        botoes.add(ctOperador1);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao azul.png"));

        ctValor1 = new Cartao(getContext(), x+(deslocamento*3), y, 180, 180,"inteiro","0", Acao.CARTAOTELA);
        ctValor1.setAnimacao(aniCartaoTipo);
        ctValor1.setVisibilidade(true);
        botoes.add(ctValor1);

        CaixaTexto pontoVirgula1 = new CaixaTexto(getContext(),+x+(deslocamento*4)+10,y+100,";", 80);
        pontoVirgula1.setVisibilidade(true);
        componentes.add(pontoVirgula1);

//------------------------------------------------------------------------------------------------------------------------------------------------------------------>

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao roxo.png"));

        ctNome2 = new Cartao(getContext(), x+deslocamento, y+deslocamento, 180, 180,"nome",null, Acao.CARTAOTELA);
        ctNome2.setAnimacao(aniCartaoTipo);
        ctNome2.setTexto("x");
        ctNome2.setVisibilidade(true);
        botoes.add(ctNome2);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao amarelo.png"));

        ctOperador2 = new Cartao(getContext(), x+(deslocamento*2), y+deslocamento, 180, 180,"operador menor que",null, Acao.CARTAOTELA);
        ctOperador2.setTexto("<");
        ctOperador2.setAnimacao(aniCartaoTipo);
        ctOperador2.setVisibilidade(true);
        botoes.add(ctOperador2);

        //variável do jogador

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao azul.png"));

        ctNome3 = new Cartao(getContext(), x+(deslocamento*3), y+deslocamento, 180, 180,"inteiro",null, Acao.CARTAOTELA);
        ctNome3.setAnimacao(aniCartaoTipo);
        ctNome3.setVisibilidade(true);
        botoes.add(ctNome3);

        CaixaTexto pontoVirgula2 = new CaixaTexto(getContext(),x+(deslocamento*4)+10,y+deslocamento+100,";", 80);
        pontoVirgula2.setVisibilidade(true);
        componentes.add(pontoVirgula2);

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao roxo.png"));

        ctNome4 = new Cartao(getContext(), x+deslocamento, y+(deslocamento*2), 180, 180,"nome","x", Acao.CARTAOTELA);
        ctNome4.setAnimacao(aniCartaoTipo);
        ctNome4.setVisibilidade(true);
        botoes.add(ctNome4);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao amarelo.png"));

        ctOperador3 = new Cartao(getContext(), x+(deslocamento*2), y+(deslocamento*2), 180, 180,"operador concatenacao","+", Acao.CARTAOTELA);
        ctOperador3.setAnimacao(aniCartaoTipo);
        ctOperador3.setVisibilidade(true);
        botoes.add(ctOperador3);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao amarelo.png"));

        ctOperador4 = new Cartao(getContext(), x+(deslocamento*3), y+(deslocamento*2), 180, 180,"operador concatenacao","+", Acao.CARTAOTELA);
        ctOperador4.setAnimacao(aniCartaoTipo);
        ctOperador4.setVisibilidade(true);
        botoes.add(ctOperador4);

        CaixaTexto couchete2 = new CaixaTexto(getContext(),x+(deslocamento*4)+10,y+(deslocamento*2)+100,")", 90);
        couchete2.setVisibilidade(true);
        componentes.add(couchete2);

        CaixaTexto chaves1 = new CaixaTexto(getContext(),x+(deslocamento*4)+40,y+(deslocamento*2)+100,"{", 90);
        chaves1.setVisibilidade(true);
        componentes.add(chaves1);
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------->


        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao azul.png"));

        ctValor2 = new Cartao(getContext(), x, y+(deslocamento*3), 180, 180,"inteiro",null, Acao.CARTAOTELA);
        ctValor2.setAnimacao(aniCartaoTipo);
        ctValor2.setVisibilidade(true);
        botoes.add(ctValor2);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao amarelo.png"));

        ctOperador5 = new Cartao(getContext(), x+(deslocamento), y+(deslocamento*3), 180, 180,"operador atribuicao","=", Acao.CARTAOTELA);
        ctOperador5.setAnimacao(aniCartaoTipo);
        ctOperador5.setVisibilidade(true);
        botoes.add(ctOperador5);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao azul.png"));

        ctValor3 = new Cartao(getContext(), x+(deslocamento*2), y+(deslocamento*3), 180, 180,"valor inteiro",null, Acao.CARTAOTELA);
        ctValor3.setAnimacao(aniCartaoTipo);
        ctValor3.setVisibilidade(true);
        botoes.add(ctValor3);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao amarelo.png"));

        ctOperador6 = new Cartao(getContext(), x+(deslocamento*3), y+(deslocamento*3), 180, 180,"operador concatenacao","+", Acao.CARTAOTELA);
        ctOperador6.setAnimacao(aniCartaoTipo);
        ctOperador6.setVisibilidade(true);
        botoes.add(ctOperador6);

        aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gi.criarImg("cartoes/cartao azul.png"));

        ctValor4 = new Cartao(getContext(), x+(deslocamento*4), y+(deslocamento*3), 180, 180,"valor inteiro","1", Acao.CARTAOTELA);
        ctValor4.setAnimacao(aniCartaoTipo);
        ctValor4.setVisibilidade(true);
        botoes.add(ctValor4);

        CaixaTexto potoEVirgula3 = new CaixaTexto(getContext(),x+(deslocamento*4)+200, y+(deslocamento*3)+100,";", 90);
        potoEVirgula3.setVisibilidade(true);
        componentes.add(potoEVirgula3);

        CaixaTexto chaves2 = new CaixaTexto(getContext(),x,y+(deslocamento*4)+100,"}", 90);
        chaves2.setVisibilidade(true);
        componentes.add(chaves2);

        Botao finalizar = new Botao(getContext(),getPosicoes().getP12().x + 100, getPosicoes().getP14().y+100,180,180,Acao.CONFIRMARCRIACAOVARIAVEL);
        finalizar.setTexto("Criar");
        List<Bitmap> ac = new ArrayList<>();
        ac.add(gi.criarImg("botao padrao.png"));
        finalizar.setAnimacao(ac);
        finalizar.setVisibilidade(true);
        botoes.add(finalizar);

        Botao voltar = new Botao(getContext(),getPosicoes().getP13().x + 100, getPosicoes().getP13().y+100,180,180,Acao.TELACRIACAO);
        voltar.setTexto("Voltar");
        List<Bitmap> aniVoltar = new ArrayList<>();
        aniVoltar.add(gi.criarImg("botao padrao.png"));
        voltar.setAnimacao(aniVoltar);
        voltar.setVisibilidade(true);
        botoes.add(voltar);

        Botao proximo = new Botao(getContext(),getPosicoes().getP15().x+30, getPosicoes().getP15().y+60,170,110,Acao.PROXIMO);
        //proximo.setTexto("Próximo");
        List<Bitmap> acProximo = new ArrayList<>();
        acProximo.add(gi.criarImg("seta direita.png"));
        proximo.setAnimacao(acProximo);
        proximo.setVisibilidade(true);
        botoes.add(proximo);

        Botao anterior = new Botao(getContext(),getPosicoes().getP14().x-140, getPosicoes().getP14().y+60,170,110,Acao.ANTERIOR);
        //anterior.setTexto("Anterior");
        List<Bitmap> acAnterior = new ArrayList<>();
        acAnterior.add(gi.criarImg("seta esquerda.png"));
        anterior.setAnimacao(acAnterior);
        anterior.setVisibilidade(true);
        botoes.add(anterior);

        //direita


        Posicao pos = new Posicao();

        cjVariavelForca = getJogador().getCampeao().getVariavelForca();
        if(cjVariavelForca==null){

            List<Bitmap> aniFor = new ArrayList<>();
            cjVariavelForca = new Variavel(getContext(),x + 1200, 80, 180, 180,  Acao.CARTAOJOGADORVARIAVEL);
            aniFor.add(gi.criarImg("icone forca desabilitado.png"));
            cjVariavelForca.setAnimacao(aniFor);
            cjVariavelForca.setVisibilidade(true);

        }else{

            List<Bitmap> aniFor = new ArrayList<>();
            aniFor.add(gi.criarImg("icone forca.png"));
            cjVariavelForca.setPosX(x + 1200);
            cjVariavelForca.setPosY(80);
            cjVariavelForca.setAcao(Acao.CARTAOJOGADORVARIAVEL);
            cjVariavelForca.setAnimacao(aniFor);

        }
        botoes.add(cjVariavelForca);

        cjVariavelVida = getJogador().getCampeao().getVariavelVida();

        if(cjVariavelVida==null){

            List<Bitmap> aniVida = new ArrayList<>();
            cjVariavelVida = new Variavel(getContext(), x + 1400, 80, 180, 180, Acao.CARTAOJOGADORVARIAVEL);
            aniVida.add(gi.criarImg("icone vida desabilitado.png"));
            cjVariavelVida.setAnimacao(aniVida);
            cjVariavelVida.setVisibilidade(true);

        }else{

            List<Bitmap> aniVida = new ArrayList<>();
            aniVida.add(gi.criarImg("icone vida.png"));
            cjVariavelVida.setPosX(x + 1400);
            cjVariavelVida.setPosY(80);
            cjVariavelVida.setAcao(Acao.CARTAOJOGADORVARIAVEL);
            cjVariavelVida.setAnimacao(aniVida);
        }
        botoes.add(cjVariavelVida);

        cjVariavelDefesa = getJogador().getCampeao().getVariavelDefesa();
        if(cjVariavelDefesa==null){

            cjVariavelDefesa = new Variavel(getContext(), x + 1200, 320,180,180, Acao.CARTAOJOGADORVARIAVEL);
            List<Bitmap> aniDef = new ArrayList<>();
            aniDef.add(gi.criarImg("icone defesa desabilitado.png"));
            cjVariavelDefesa.setAnimacao(aniDef);
            cjVariavelDefesa.setVisibilidade(true);

        }else{

            List<Bitmap> aniDef = new ArrayList<>();
            aniDef.add(gi.criarImg("icone escudo.png"));
            cjVariavelDefesa.setPosX(x + 1200);
            cjVariavelDefesa.setPosY(320);
            cjVariavelDefesa.setAcao(Acao.CARTAOJOGADORVARIAVEL);
            cjVariavelDefesa.setAnimacao(aniDef);

        }
        botoes.add(cjVariavelDefesa);

        cjVariavelVel = getJogador().getCampeao().getVariavelVel();
        if(cjVariavelVel==null){

            cjVariavelVel  = new Variavel(getContext(), x + 1400, 320,180,180, Acao.CARTAOJOGADORVARIAVEL);
            List<Bitmap> aniVel = new ArrayList<>();
            aniVel.add(gi.criarImg("icone vel desabilitado.png"));
            cjVariavelVel.setAnimacao(aniVel);
            cjVariavelVel.setVisibilidade(true);

        }else{

            List<Bitmap> aniVel = new ArrayList<>();
            aniVel.add(gi.criarImg("icone vel.png"));
            cjVariavelVel.setPosX(x + 1400);
            cjVariavelVel.setPosY(320);
            cjVariavelVel.setAcao(Acao.CARTAOJOGADORVARIAVEL);
            cjVariavelVel.setAnimacao(aniVel);
        }
        botoes.add(cjVariavelVel);

        cjValorInteiro = getJogador().getCartaoValorInteiro();
        if(cjValorInteiro == null){

            aniCartaoTipo = new ArrayList<>();
            aniCartaoTipo.add(gi.criarImg("cartoes/cartao branco.png"));

            cjValorInteiro = new Cartao(getContext(), x + 1300, 600, 180, 180,"valor inteiro",null, Acao.CARTAOJOGADOR);
            cjValorInteiro.setAnimacao(aniCartaoTipo);
            cjValorInteiro.setVisibilidade(true);
            botoes.add(cjValorInteiro);
        }else{

            cjValorInteiro.setPosX(x +1300);
            cjValorInteiro.setPosY(600);
            cjValorInteiro.setVisibilidade(true);
        }
        botoes.add(cjValorInteiro);







    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
