package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaCriacaoMetodo extends Tela{

    //jogador
    private Cartao cJTipo;

    private Cartao cJNomeVariavel;

    private Cartao cJOperadorAtribuicao;
    private Cartao cJOperadorConcatenacao;

    private Cartao cJModificadorAcesso;

    private Cartao cJReturn;

    private Cartao cJNomeMetodo;

    //tela
    private Cartao cTModificadorAcesso;

    private Cartao cTTipoRetornoMetodo;

    private Cartao cTNomeMetodo;

    private Cartao valorAtaqueCampeao;

    private Cartao valorDefesaOponente;

    private Cartao cTTipo;

    private Cartao cTNome;

    private Cartao cTOperadorAtribuicao;

    private Cartao cTValorVJogador;

    private Cartao cTOperadorConcatenacao;

    private Cartao cTValorVOponente;

    private Cartao cTReturn;

    private Cartao cTVariavelReturn;



    public TelaCriacaoMetodo(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {

        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());
        int x = 1310;
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
        CaixaTexto ctTitulo = new CaixaTexto(getContext(),getPosicoes().getP1().x-50 , 70,"Criação de método",70);
        ctTitulo.setVisibilidade(true);
        componentes.add(ctTitulo);

        CaixaTexto ctTipo = new CaixaTexto(getContext(),x+120,60,"Tipo", 45);
        ctTipo.setVisibilidade(true);
        componentes.add(ctTipo);

        CaixaTexto ctNome = new CaixaTexto(getContext(),x+320,60 ,"Nome Variavel",50);
        ctNome.setVisibilidade(true);
        componentes.add(ctNome);

        CaixaTexto ctValor = new CaixaTexto(getContext(),x+120,310,"Operador",45);
        ctValor.setVisibilidade(true);
        componentes.add(ctValor);

        CaixaTexto ctMacesso = new CaixaTexto(getContext(),x+320,310,"Mod. Acesso",50);
        ctMacesso.setVisibilidade(true);
        componentes.add(ctMacesso);

        CaixaTexto ctOperador = new CaixaTexto(getContext(),x+120,540,"retorno", 45);
        ctOperador.setVisibilidade(true);
        componentes.add(ctOperador);

        CaixaTexto ctRetorno = new CaixaTexto(getContext(),x+320,540,"Nome Método", 45);
        ctRetorno.setVisibilidade(true);
        componentes.add(ctRetorno);


        //cartões esquerda

        int xIni = 75;
        int yIni = 150;
        int deslocamento = 200;

        int tamanhoTexto = 40;

        cTModificadorAcesso = new Cartao(getContext(),xIni,yIni,180,180,"modificador",null,Acao.CARTAOTELA);
        List<Bitmap> anicTModificadorAcesso = new ArrayList<>();
        anicTModificadorAcesso.add(gi.criarImg("cartoes/cartao rosa.png"));
        cTModificadorAcesso.setAnimacao(anicTModificadorAcesso);
        cTModificadorAcesso.setVisibilidade(true);
        botoes.add(cTModificadorAcesso);

        cTTipoRetornoMetodo = new Cartao(getContext(),xIni+deslocamento,yIni,180,180,"inteiros",null,Acao.CARTAOTELA);
        List<Bitmap> anicTTipoRetornoMetodo = new ArrayList<>();
        anicTTipoRetornoMetodo.add(gi.criarImg("cartoes/cartao vermelho.png"));
        cTTipoRetornoMetodo.setAnimacao(anicTTipoRetornoMetodo);
        cTTipoRetornoMetodo.setVisibilidade(true);
        botoes.add(cTTipoRetornoMetodo);

        cTNomeMetodo = new Cartao(getContext(),xIni+(deslocamento * 2),yIni,180,180,"nome metodo",null,Acao.CARTAOTELA);
        List<Bitmap> anicTNomeMetodo = new ArrayList<>();
        anicTNomeMetodo.add(gi.criarImg("cartoes/cartao verde.png"));
        cTNomeMetodo.setAnimacao(anicTNomeMetodo);
        cTNomeMetodo.setVisibilidade(true);
        botoes.add(cTNomeMetodo);

        CaixaTexto colcheteEsquerda = new CaixaTexto(getContext(),xIni+(deslocamento * 3),yIni+130,"(", 170);
        colcheteEsquerda.setVisibilidade(true);
        componentes.add(colcheteEsquerda);

        valorAtaqueCampeao = new Cartao(getContext(),xIni+(deslocamento * 3)+60,yIni,180,180,null,null,Acao.CARTAOTELA);
        List<Bitmap> anivalorAtaqueCampeao = new ArrayList<>();
        anivalorAtaqueCampeao.add(gi.criarImg("cartoes/cartao azul.png"));
        valorAtaqueCampeao.setAnimacao(anivalorAtaqueCampeao);
        valorAtaqueCampeao.setTamanhoTexto(tamanhoTexto);
        valorAtaqueCampeao.setTexto("variável1");
        valorAtaqueCampeao.setVisibilidade(true);
        botoes.add(valorAtaqueCampeao);

        CaixaTexto virgula = new CaixaTexto(getContext(),xIni+(deslocamento * 3)+238,yIni+155,",", 170);
        virgula.setVisibilidade(true);
        componentes.add(virgula);

        valorDefesaOponente = new Cartao(getContext(),xIni+(deslocamento * 4)+75,yIni,180,180,null,null,Acao.CARTAOTELA);
        List<Bitmap> anivalorDefesaOponente = new ArrayList<>();
        anivalorDefesaOponente.add(gi.criarImg("cartoes/cartao azul.png"));
        valorDefesaOponente.setAnimacao(anivalorDefesaOponente);
        valorDefesaOponente.setTamanhoTexto(tamanhoTexto);
        valorDefesaOponente.setTexto("variável2");
        valorDefesaOponente.setVisibilidade(true);
        botoes.add(valorDefesaOponente);

        CaixaTexto colcheteDireita = new CaixaTexto(getContext(),xIni+(deslocamento * 3)+460,yIni+130,")", 170);
        colcheteDireita.setVisibilidade(true);
        componentes.add(colcheteDireita);

        CaixaTexto chavesEsquerda = new CaixaTexto(getContext(),xIni+(deslocamento * 3)+510,yIni+130,"{", 170);
        chavesEsquerda.setVisibilidade(true);
        componentes.add(chavesEsquerda);

        cTTipo = new Cartao(getContext(),xIni,yIni+deslocamento,180,180,"",null,Acao.CARTAOTELA);
        List<Bitmap> anicTTipo = new ArrayList<>();
        anicTTipo.add(gi.criarImg("cartoes/cartao vermelho.png"));
        cTTipo.setAnimacao(anicTTipo);
        cTTipo.setVisibilidade(true);
        botoes.add(cTTipo);

        cTNome = new Cartao(getContext(),xIni+deslocamento,yIni+(deslocamento),180,180,"nome",null,Acao.CARTAOTELA);
        List<Bitmap> anicTNome = new ArrayList<>();
        anicTNome.add(gi.criarImg("cartoes/cartao roxo.png"));
        cTNome.setAnimacao(anicTNome);
        cTNome.setVisibilidade(true);
        botoes.add(cTNome);

        cTOperadorAtribuicao = new Cartao(getContext(),xIni+(deslocamento*2),yIni+(deslocamento),180,180,"operador atribuicao",null,Acao.CARTAOTELA);
        List<Bitmap> anicTOperadorAtribuicao = new ArrayList<>();
        anicTOperadorAtribuicao.add(gi.criarImg("cartoes/cartao amarelo.png"));
        cTOperadorAtribuicao.setAnimacao(anicTOperadorAtribuicao);
        cTOperadorAtribuicao.setVisibilidade(true);
        botoes.add(cTOperadorAtribuicao);

        cTValorVJogador = new Cartao(getContext(),xIni+(deslocamento*3),yIni+(deslocamento),180,180,null,null,Acao.CARTAOTELA);
        List<Bitmap> anicTValorVJogador = new ArrayList<>();
        anicTValorVJogador.add(gi.criarImg("cartoes/cartao azul.png"));
        cTValorVJogador.setAnimacao(anicTValorVJogador);
        cTValorVJogador.setTamanhoTexto(tamanhoTexto);
        cTValorVJogador.setTexto("variável1");
        cTValorVJogador.setVisibilidade(true);
        botoes.add(cTValorVJogador);

        cTOperadorConcatenacao = new Cartao(getContext(),xIni+(deslocamento*4),yIni+(deslocamento),180,180,"operador subtracao",null,Acao.CARTAOTELA);
        List<Bitmap> anicTOperadorConcatenacao = new ArrayList<>();
        anicTOperadorConcatenacao.add(gi.criarImg("cartoes/cartao amarelo.png"));
        cTOperadorConcatenacao.setAnimacao(anicTOperadorConcatenacao);
        cTOperadorConcatenacao.setVisibilidade(true);
        botoes.add(cTOperadorConcatenacao);

        cTValorVOponente = new Cartao(getContext(),xIni+(deslocamento*5),yIni+(deslocamento),180,180,null,null,Acao.CARTAOTELA);
        List<Bitmap> anicTValorVOponente = new ArrayList<>();
        anicTValorVOponente.add(gi.criarImg("cartoes/cartao azul.png"));
        cTValorVOponente.setAnimacao(anicTValorVOponente);
        cTValorVOponente.setTamanhoTexto(tamanhoTexto);
        cTValorVOponente.setTexto("variável2");
        cTValorVOponente.setVisibilidade(true);
        botoes.add(cTValorVOponente);

        CaixaTexto pontoEVirgula1 = new CaixaTexto(getContext(),xIni+(deslocamento*5)+190,yIni+(deslocamento)+150,";", 170);
        pontoEVirgula1.setVisibilidade(true);
        componentes.add(pontoEVirgula1);

        cTReturn = new Cartao(getContext(),xIni,yIni+(deslocamento * 2),180,180,"return",null,Acao.CARTAOTELA);
        List<Bitmap> anicTReturn = new ArrayList<>();
        anicTReturn.add(gi.criarImg("cartoes/cartao cinza.png"));
        cTReturn.setAnimacao(anicTReturn);
        cTReturn.setVisibilidade(true);
        botoes.add(cTReturn);

        cTVariavelReturn = new Cartao(getContext(),xIni+deslocamento,yIni+(deslocamento * 2),180,180,null,null,Acao.CARTAOTELA);
        List<Bitmap> anicTVariavelReturn = new ArrayList<>();
        anicTVariavelReturn.add(gi.criarImg("cartoes/cartao roxo.png"));
        cTVariavelReturn.setAnimacao(anicTVariavelReturn);
        cTVariavelReturn.setVisibilidade(true);
        botoes.add(cTVariavelReturn);

        CaixaTexto pontoEVirgula2 = new CaixaTexto(getContext(),xIni+deslocamento+190,yIni+(deslocamento * 2)+150,";", 170);
        pontoEVirgula2.setVisibilidade(true);
        componentes.add(pontoEVirgula2);

        CaixaTexto chavesDireita = new CaixaTexto(getContext(),xIni,yIni+(deslocamento * 3)+120,"}", 170);
        chavesDireita.setVisibilidade(true);
        componentes.add(chavesDireita);


        //Cartoes direita _____________________________________________________________________________________________________________________________________________>

        cJTipo = getJogador().getCartaoTipoInteiros();

        if(cJTipo == null){
            cJTipo = new Cartao(getContext(), x + 100, 80, 180, 180,null,null,Acao.NULL);
            List<Bitmap> aniCartaoTipo = new ArrayList<>();
            aniCartaoTipo.add(gi.criarImg("cartoes/cartao branco.png"));
            cJTipo.setAnimacao(aniCartaoTipo);
            cJTipo.setVisibilidade(true);
        }else{

            cJTipo.setPosX(x + 100);
            cJTipo.setPosY(80);
            cJTipo.setVisibilidade(true);
        }
        botoes.add(cJTipo);

        cJNomeVariavel = getJogador().getCartaoNomeVariavel();

        if(cJNomeVariavel == null){
            cJNomeVariavel = new Cartao(getContext(), x + 310, 80, 180, 180,null,null,Acao.NULL);
            List<Bitmap> aniCartaoNome = new ArrayList<>();
            aniCartaoNome.add(gi.criarImg("cartoes/cartao branco.png"));
            cJNomeVariavel.setAnimacao(aniCartaoNome);
            cJNomeVariavel.setVisibilidade(true);
        }else{

            cJNomeVariavel.setPosX(x + 310);
            cJNomeVariavel.setPosY(80);
            cJNomeVariavel.setVisibilidade(true);
        }
        botoes.add(cJNomeVariavel);

        cJOperadorAtribuicao = getJogador().getCartaoOperadorAtribuicao();

        if(cJOperadorAtribuicao == null){
            cJOperadorAtribuicao = new Cartao(getContext(), x + 100, 320, 180, 180,null,null,Acao.NULL);
            List<Bitmap> aniCartaoOperador = new ArrayList<>();
            aniCartaoOperador.add(gi.criarImg("cartoes/cartao branco.png"));
            cJOperadorAtribuicao.setAnimacao(aniCartaoOperador);
            cJOperadorAtribuicao.setVisibilidade(true);
        }else{

            cJOperadorAtribuicao.setPosX(x + 100);
            cJOperadorAtribuicao.setPosY(320);
            cJOperadorAtribuicao.setVisibilidade(true);
        }
        botoes.add(cJOperadorAtribuicao);

////////////////////////////////////////////

        cJModificadorAcesso = getJogador().getCartaoModificadorAcesso();

        if(cJModificadorAcesso == null){
            cJModificadorAcesso = new Cartao(getContext(), x + 310, 320, 180, 180,null,null,Acao.NULL);
            List<Bitmap> anicJModificadorAcesso = new ArrayList<>();
            anicJModificadorAcesso.add(gi.criarImg("cartoes/cartao branco.png"));
            cJModificadorAcesso.setAnimacao(anicJModificadorAcesso);
            cJModificadorAcesso.setVisibilidade(true);
        }else{

            cJModificadorAcesso.setPosX(x + 310);
            cJModificadorAcesso.setPosY(320);
            cJModificadorAcesso.setVisibilidade(true);
        }
        botoes.add(cJModificadorAcesso);
//////////////////////////////////////////////////////
        cJReturn = getJogador().getCartaoReturn();

        if(cJReturn == null){
            cJReturn = new Cartao(getContext(), x + 100, 550, 180, 180,null,null,Acao.NULL);
            List<Bitmap> anicJReturn = new ArrayList<>();
            anicJReturn.add(gi.criarImg("cartoes/cartao branco.png"));
            cJReturn.setAnimacao(anicJReturn);
            cJReturn.setVisibilidade(true);
        }else{

            cJReturn.setPosX(x + 100);
            cJReturn.setPosY(550);
            cJReturn.setVisibilidade(true);
        }
        botoes.add(cJReturn);

////////////////////////////////////////////////////////////
        cJNomeMetodo = getJogador().getCartaoNomeMetodo();

        if(cJNomeMetodo == null){
            cJNomeMetodo = new Cartao(getContext(), x + 310, 550, 180, 180,null,null,Acao.NULL);
            List<Bitmap> anicJNomeMetodo = new ArrayList<>();
            anicJNomeMetodo.add(gi.criarImg("cartoes/cartao branco.png"));
            cJNomeMetodo.setAnimacao(anicJNomeMetodo);
            cJNomeMetodo.setVisibilidade(true);
        }else{

            cJNomeMetodo.setPosX(x + 310);
            cJNomeMetodo.setPosY(550);
            cJNomeMetodo.setVisibilidade(true);
        }
        botoes.add(cJNomeMetodo);

        cJOperadorConcatenacao = getJogador().getCartaoOperadorConcatenacao();

        if(cJOperadorConcatenacao == null){
            cJOperadorConcatenacao = new Cartao(getContext(), x + 210, 750, 180, 180,null,null,Acao.NULL);
            List<Bitmap> aniCartaoOperador = new ArrayList<>();
            aniCartaoOperador.add(gi.criarImg("cartoes/cartao branco.png"));
            cJOperadorConcatenacao.setAnimacao(aniCartaoOperador);
            cJOperadorConcatenacao.setVisibilidade(true);
        }else{

            cJOperadorConcatenacao.setPosX(x + 210);
            cJOperadorConcatenacao.setPosY(750);
            cJOperadorConcatenacao.setVisibilidade(true);
        }
        botoes.add(cJOperadorConcatenacao);

        //botões
        Botao finalizar = new Botao(getContext(),getPosicoes().getP12().x + 100, getPosicoes().getP14().y+50,180,180,Acao.CONFIRMARCRIACAOVARIAVEL);
        finalizar.setTexto("Criar");
        List<Bitmap> ac = new ArrayList<>();
        ac.add(gi.criarImg("botao padrao.png"));
        finalizar.setAnimacao(ac);
        finalizar.setVisibilidade(true);
        botoes.add(finalizar);

        Botao voltar = new Botao(getContext(),getPosicoes().getP13().x + 100, getPosicoes().getP13().y+50,180,180,Acao.TELACRIACAO);
        voltar.setTexto("Voltar");
        List<Bitmap> aniVoltar = new ArrayList<>();
        aniVoltar.add(gi.criarImg("botao padrao.png"));
        voltar.setAnimacao(aniVoltar);
        voltar.setVisibilidade(true);
        botoes.add(voltar);

        Botao proximo = new Botao(getContext(),getPosicoes().getP15().x+50, getPosicoes().getP15().y+60,170,110,Acao.PROXIMO);
        //proximo.setTexto("Próximo");
        List<Bitmap> acProximo = new ArrayList<>();
        acProximo.add(gi.criarImg("seta direita.png"));
        proximo.setAnimacao(acProximo);
        proximo.setVisibilidade(true);
        botoes.add(proximo);

        Botao anterior = new Botao(getContext(),getPosicoes().getP14().x-120, getPosicoes().getP14().y+60,170,110,Acao.ANTERIOR);
        //anterior.setTexto("Anterior");
        List<Bitmap> acAnterior = new ArrayList<>();
        acAnterior.add(gi.criarImg("seta esquerda.png"));
        anterior.setAnimacao(acAnterior);
        anterior.setVisibilidade(true);
        botoes.add(anterior);

            /*Botao proximo = new Botao(getContext(),getPosicoes().getP15().x-10, getPosicoes().getP15().y+80,170,110,Acao.CONFIRMARCRIACAOVARIAVEL);
            //proximo.setTexto("Próximo");
            List<Bitmap> acProximo = new ArrayList<>();
            acProximo.add(gi.criarImg("seta direita.png"));
            proximo.setAnimacao(acProximo);
            proximo.setVisibilidade(true);
            botoes.add(proximo);

            Botao anterior = new Botao(getContext(),getPosicoes().getP14().x-40, getPosicoes().getP14().y+80,170,110,Acao.CONFIRMARCRIACAOVARIAVEL);
            //anterior.setTexto("Anterior");
            List<Bitmap> acAnterior = new ArrayList<>();
            acAnterior.add(gi.criarImg("seta esquerda.png"));
            anterior.setAnimacao(acAnterior);
            anterior.setVisibilidade(true);
            botoes.add(anterior);*/

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
