package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TelaDetalhe extends Tela {

    public TelaDetalhe(Context context, Posicao posicoes, Jogador jogador) {
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
                int forca = 0;
        if(getJogador().getCampeao().getVariavelForca() != null){

            forca = getJogador().getCampeao().getVariavelForca().getValorInt();
        }
                double vida = 0;
        if(getJogador().getCampeao().getVariavelVida() !=null){
            vida = getJogador().getCampeao().getVariavelVida().getValorDouble();
        }
                int def = 0;
        if(getJogador().getCampeao().getVariavelDefesa() !=null){
            def = getJogador().getCampeao().getVariavelDefesa().getValorInt();
        }
                double vel = 0;
        if(getJogador().getCampeao().getVariavelVel() !=null){
            vel = getJogador().getCampeao().getVariavelVel().getValorDouble();
        }


    double pc = forca + vida + def + vel;



        CaixaTexto ctTitulo1 = new CaixaTexto(this.getContext(),getPosicoes().getP3().x - 280, 70,"Detalhe do campeão",60);
        ctTitulo1.setVisibilidade(true);

        CaixaTexto ctTitulo2 = new CaixaTexto(this.getContext(),getPosicoes().getP3().x - 380, 160,"Poder de Combate: "+pc,80);
        ctTitulo2.setVisibilidade(true);



        componentes.add(ctTitulo1);
        componentes.add(ctTitulo2);

        //campeao do jogador

        Campeao campeao = getJogador().getCampeao();
        campeao.setPosX(getPosicoes().getP2().x+250);
        campeao.setPosY(getPosicoes().getP2().y+160);
        campeao.criarAnimacaoFrenteDetalhe();
        campeao.setVisibilidade(true);

        //Botões
        Posicao pos = new Posicao();

        Variavel vForca = getJogador().getCampeao().getVariavelForca();
        if(vForca==null){

            List<Bitmap> aniFor = new ArrayList<>();
            vForca = new Variavel(getContext(),pos.getP2().x, pos.getP2().y, 180, 180,  Acao.CRIARVARIAVELFORCA);
            aniFor.add(gi.criarImg("icone forca desabilitado.png"));
            vForca.setAnimacao(aniFor);
            vForca.setVisibilidade(true);

        }else{

            List<Bitmap> aniFor = new ArrayList<>();
            aniFor.add(gi.criarImg("icone forca.png"));
            vForca.setAnimacao(aniFor);

        }
        botoes.add(vForca);

        Variavel vVida = getJogador().getCampeao().getVariavelVida();

        if(vVida==null){

            List<Bitmap> aniVida = new ArrayList<>();
            vVida = new Variavel(getContext(), pos.getP4().x - 150, pos.getP4().y, 180, 180, Acao.CRIARVARIAVELVIDA);
            aniVida.add(gi.criarImg("icone vida desabilitado.png"));
            vVida.setAnimacao(aniVida);
            vVida.setVisibilidade(true);

        }else{

            List<Bitmap> aniVida = new ArrayList<>();
            aniVida.add(gi.criarImg("icone vida.png"));
            vVida.setAnimacao(aniVida);
        }
        botoes.add(vVida);

        Variavel vDef = getJogador().getCampeao().getVariavelDefesa();
        if(vDef==null){

            vDef = new Variavel(getContext(), pos.getP7().x,pos.getP7().y,180,180, Acao.CRIARVARIAVELDEF);
            List<Bitmap> aniDef = new ArrayList<>();
            aniDef.add(gi.criarImg("icone defesa desabilitado.png"));
            vDef.setAnimacao(aniDef);
            vDef.setVisibilidade(true);

        }else{

            List<Bitmap> aniDef = new ArrayList<>();
            aniDef.add(gi.criarImg("icone escudo.png"));
            vDef.setAnimacao(aniDef);

        }

        Variavel vVel = getJogador().getCampeao().getVariavelVel();
        if(vVel==null){

            vVel  = new Variavel(getContext(), pos.getP9().x - 150,pos.getP9().y,180,180, Acao.CRIARVARIAVELVEL);
            List<Bitmap> aniVel = new ArrayList<>();
            aniVel.add(gi.criarImg("icone vel desabilitado.png"));
            vVel.setAnimacao(aniVel);
            vVel.setVisibilidade(true);

        }else{

            List<Bitmap> aniVel = new ArrayList<>();
            aniVel.add(gi.criarImg("icone vel.png"));
            vVel.setAnimacao(aniVel);
        }


        Metodo mAtacar = getJogador().getCampeao().getMetodoAtacar();
        if(mAtacar==null){                                                                            //TELACRIACAOMETODOATACAR
            mAtacar = new Metodo(getContext(), pos.getP12().x,pos.getP12().y,180,180, Acao.TELACRIACAOMETODOATACAR);
            List<Bitmap> aniMetodoAtacar = new ArrayList<>();
            aniMetodoAtacar.add(gi.criarImg("icone atacar desabilitado.png"));
            mAtacar.setAnimacao(aniMetodoAtacar);
            mAtacar.setVisibilidade(true);

        }else{

            List<Bitmap> aniMetodoAtacarrr = new ArrayList<>();
            aniMetodoAtacarrr.add(gi.criarImg("icone atacar.png"));
            mAtacar.setAnimacao(aniMetodoAtacarrr);
        }
        botoes.add(mAtacar);

        Metodo mDefesa = getJogador().getCampeao().getMetodoDefender();
        if(mDefesa==null){
            mDefesa = new Metodo(getContext(), pos.getP14().x - 150,pos.getP14().y,180,180, Acao.TELACRIACAOMETODODEFENDER);
            List<Bitmap> aniMetodoDefender = new ArrayList<>();
            aniMetodoDefender.add(gi.criarImg("icone defender desabilitado.png"));
            mDefesa.setAnimacao(aniMetodoDefender);
            mDefesa.setVisibilidade(true);

        }else{

            List<Bitmap> aniMetodoDefender = new ArrayList<>();
            aniMetodoDefender.add(gi.criarImg("icone defender.png"));
            mDefesa.setAnimacao(aniMetodoDefender);
        }
        botoes.add(mDefesa);


        Botao mundo = new Botao(this.getContext(),getPosicoes().getP15().x,getPosicoes().getP15().y,180,180,Acao.CONFIRMACAODETALHE);
        List<Bitmap> aniMundo = new ArrayList<>();
        aniMundo.add(gi.criarImg("botao padrao.png"));
        mundo.setAnimacao(aniMundo);
        mundo.setTexto("Mundo");
        mundo.setVisibilidade(true);

        componentes.add(campeao);


        botoes.add(vDef);
        botoes.add(vVel);


        botoes.add(mundo);

        //------------------------------>

    }

    @Override
    public void premiacao() {

        getComponentesMensagem().clear();
        getBotoesMensagem().clear();

        Posicao posicoes = new Posicao();

        int inicioX = 500;
        int inicioY = 100;

        int tamanho = 180;

        int distancia = 50;

        GeradorDeImagens gImgs = new GeradorDeImagens(getContext());

        List<Bitmap> aniFundo = new ArrayList<>();
        aniFundo.add(gImgs.criarImg("fundos/fundo transparencia 50.png"));
        Componente fundoPremiacao = new Componente(getContext(),0,0);
        fundoPremiacao.setVisibilidade(true);
        fundoPremiacao.setAnimacao(aniFundo);
        getComponentesMensagem().add(fundoPremiacao);

        Componente bauAberto = new Componente(getContext(),posicoes.getP8().x-100,posicoes.getP7().y-100);
        List<Bitmap> aniBauAberto = new ArrayList<>();
        aniBauAberto.add(gImgs.criarImg("botao bau aberto.png"));
        bauAberto.setVisibilidade(true);
        bauAberto.setAnimacao(aniBauAberto);
        getComponentesMensagem().add(bauAberto);

        //valores

        List<Bitmap> aniCartaoValor = new ArrayList<>();
        aniCartaoValor.add(gImgs.criarImg("cartoes/cartao azul.png"));

        Cartao c1 = new Cartao(getContext(), inicioX, inicioY, 180, 180,"valor fracionado","2.1",  Acao.INFOVALOR);
        c1.setAnimacao(aniCartaoValor);
        Cartao c2 =  new Cartao(getContext(), inicioX, inicioY + tamanho + distancia, 180, 180,"valor inteiro","10",  Acao.INFOVALOR);
        c2.setAnimacao(aniCartaoValor);
        Cartao c3 = new Cartao(getContext(), inicioX,  inicioY + tamanho*2 + distancia*2, 180, 180,"valor fracionado","90.0", Acao.INFOVALOR);
        c3.setAnimacao(aniCartaoValor);
        Cartao c4 = new Cartao(getContext(), inicioX,  inicioY + tamanho*3 + distancia*3, 180, 180,"valor inteiro","5",  Acao.INFOVALOR);
        c4.setAnimacao(aniCartaoValor);


        //tipo

        List<Bitmap> aniCartaoTipo = new ArrayList<>();
        aniCartaoTipo.add(gImgs.criarImg("cartoes/cartao vermelho.png"));

        Cartao c5 = new Cartao(getContext(), inicioX + tamanho + distancia,  inicioY, 180, 180,"fracionados","byte",   Acao.INFOBYTE);
        c5.setAnimacao(aniCartaoTipo);
        Cartao c6 =  new Cartao(getContext(), inicioX + tamanho + distancia,  inicioY + tamanho + distancia, 180, 180,"inteiros","float",  Acao.INFOFLOAT);
        c6.setAnimacao(aniCartaoTipo);
        Cartao c7 = new Cartao(getContext(), inicioX + tamanho + distancia, inicioY + tamanho*2 + distancia*2, 180, 180,"fracionados","double",  Acao.INFODOUBLE);
        c7.setAnimacao(aniCartaoTipo);
        Cartao c8 = new Cartao(getContext(), inicioX + tamanho + distancia, inicioY + tamanho*3 + distancia*3, 180, 180,"inteiros","short",  Acao.INFOSHORT);
        c8.setAnimacao(aniCartaoTipo);
        //------------->

        //nome

        List<Bitmap> aniCartaoNome = new ArrayList<>();
        aniCartaoNome.add(gImgs.criarImg("cartoes/cartao roxo.png"));

        Cartao c9 = new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY, 180, 180,"nome","vel. Ataque",  Acao.INFONOME);
        c9.setAnimacao(aniCartaoNome);
        Cartao c10 =  new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY + tamanho + distancia, 180, 180,"nome","forca",  Acao.INFONOME);
        c10.setAnimacao(aniCartaoNome);
        Cartao c11 = new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY + tamanho*2 + distancia*2, 180, 180,"nome","vida",  Acao.INFONOME);
        c11.setAnimacao(aniCartaoNome);
        Cartao c12 = new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY + tamanho*3 + distancia*3, 180, 180,"nome","defesa",  Acao.OKPREMIACAO);
        c12.setAnimacao(aniCartaoNome);

        //operador

        List<Bitmap> aniCartaoOperador = new ArrayList<>();
        aniCartaoOperador.add(gImgs.criarImg("cartoes/cartao amarelo.png"));

        Cartao c13 = new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY, 180, 180,"operador atribuicao","=",  Acao.INFOOPERADORIGUAL);
        c13.setAnimacao(aniCartaoOperador);
        Cartao c14 =  new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY + tamanho + distancia, 180, 180,"operador atribuicao","=",  Acao.INFOOPERADORIGUAL);
        c14.setAnimacao(aniCartaoOperador);
        Cartao c15 = new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY + tamanho*2 + distancia*2, 180, 180,"operador atribuicao","=",  Acao.INFOOPERADORIGUAL);
        c15.setAnimacao(aniCartaoOperador);
        Cartao c16 = new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY + tamanho*3 + distancia*3, 180, 180,"operador atribuicao","=",  Acao.INFOOPERADORIGUAL);
        c16.setAnimacao(aniCartaoOperador);
        //------------->
/*
        //cartão jogador
            Cartao cj1 = new Cartao(getContext(), inicioX, inicioY, 180, 180,"valor inteiro","6",  Acao.CARTAOJOGADOR);
            cj1.setAnimacao(aniCartaoValor);
            Cartao cj2 =  new Cartao(getContext(), inicioX, inicioY + tamanho + distancia, 180, 180,"valor fracionado","4.5",  Acao.CARTAOJOGADOR);
            cj2.setAnimacao(aniCartaoValor);
            Cartao cj3 = new Cartao(getContext(), inicioX,  inicioY + tamanho*2 + distancia*2, 180, 180,"valor fracionado","7.3", Acao.CARTAOJOGADOR);
            cj3.setAnimacao(aniCartaoValor);
            Cartao cj4 = new Cartao(getContext(), inicioX,  inicioY + tamanho*3 + distancia*3, 180, 180,"valor inteiro","9",  Acao.CARTAOJOGADOR);
            cj4.setAnimacao(aniCartaoValor);

            Cartao cj5 = new Cartao(getContext(), inicioX + tamanho + distancia,  inicioY, 180, 180,"fracionados","float",   Acao.CARTAOJOGADOR);
            cj5.setAnimacao(aniCartaoTipo);
            Cartao cj6 =  new Cartao(getContext(), inicioX + tamanho + distancia,  inicioY + tamanho + distancia, 180, 180,"inteiros","byte",  Acao.CARTAOJOGADOR);
            cj6.setAnimacao(aniCartaoTipo);
            Cartao cj7 = new Cartao(getContext(), inicioX + tamanho + distancia, inicioY + tamanho*2 + distancia*2, 180, 180,"fracionados","double",  Acao.CARTAOJOGADOR);
            cj7.setAnimacao(aniCartaoTipo);
            Cartao cj8 = new Cartao(getContext(), inicioX + tamanho + distancia, inicioY + tamanho*3 + distancia*3, 180, 180,"inteiros","short",  Acao.CARTAOJOGADOR);
            cj8.setAnimacao(aniCartaoTipo);

            Cartao cj9 = new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY, 180, 180,"nome","vel. Ataque",  Acao.CARTAOJOGADOR);
            cj9.setAnimacao(aniCartaoNome);
            Cartao cj10 =  new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY + tamanho + distancia, 180, 180,"nome","poder",  Acao.CARTAOJOGADOR);
            cj10.setAnimacao(aniCartaoNome);
            Cartao cj11 = new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY + tamanho*2 + distancia*2, 180, 180,"nome","vida",  Acao.CARTAOJOGADOR);
            cj11.setAnimacao(aniCartaoNome);
            Cartao cj12 = new Cartao(getContext(), inicioX + tamanho*2 + distancia*2, inicioY + tamanho*3 + distancia*3, 180, 180,"nome","defesa",  Acao.CARTAOJOGADOR);
            cj12.setAnimacao(aniCartaoNome);

            Cartao cj13 = new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY, 180, 180,"operador atribuicao","=",  Acao.CARTAOJOGADOR);
            cj13.setAnimacao(aniCartaoOperador);
            Cartao cj14 =  new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY + tamanho + distancia, 180, 180,"operador atribuicao","=",  Acao.CARTAOJOGADOR);
            cj14.setAnimacao(aniCartaoOperador);
            Cartao cj15 = new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY + tamanho*2 + distancia*2, 180, 180,"operador atribuicao","=",  Acao.CARTAOJOGADOR);
            cj15.setAnimacao(aniCartaoOperador);
            Cartao cj16 = new Cartao(getContext(), inicioX + tamanho*3 + distancia*3, inicioY + tamanho*3 + distancia*3, 180, 180,"operador atribuicao","=",  Acao.CARTAOJOGADOR);
            cj16.setAnimacao(aniCartaoOperador);

            getJogador().addCartaoTipoFracionados(cj5);
            getJogador().addCartaoTipoInteiros(cj6);
            getJogador().addCartaoTipoFracionados(cj7);
            getJogador().addCartaoTipoInteiros(c8);

            getJogador().addCartaoNome(cj9);
            getJogador().addCartaoNome(cj10);
            getJogador().addCartaoNome(cj11);
            getJogador().addCartaoNome(cj12);

            getJogador().addCartaoOperadorAtribuicao(cj13);
            getJogador().addCartaoOperadorAtribuicao(cj14);
            getJogador().addCartaoOperadorAtribuicao(cj15);
            getJogador().addCartaoOperadorAtribuicao(cj16);

            getJogador().addCartaoValorInteiro(cj1);
            getJogador().addCartaoValorFracionado(cj2);
            getJogador().addCartaoValorFracionado(cj3);
            getJogador().addCartaoValorInteiro(cj4);*/

        c1.setVisibilidade(true);c2.setVisibilidade(true);c3.setVisibilidade(true);c4.setVisibilidade(true);
        c5.setVisibilidade(true);c6.setVisibilidade(true);c7.setVisibilidade(true);c8.setVisibilidade(true);
        c9.setVisibilidade(true);c10.setVisibilidade(true);c11.setVisibilidade(true);c12.setVisibilidade(true);
        c13.setVisibilidade(true);c14.setVisibilidade(true);c15.setVisibilidade(true);c16.setVisibilidade(true);
        getBotoesMensagem().add(c1);getBotoesMensagem().add(c2);getBotoesMensagem().add(c3);
        getBotoesMensagem().add(c4);getBotoesMensagem().add(c5);getBotoesMensagem().add(c6);
        getBotoesMensagem().add(c7);getBotoesMensagem().add(c8);getBotoesMensagem().add(c9);
        getBotoesMensagem().add(c10);getBotoesMensagem().add(c11);getBotoesMensagem().add(c12);
        getBotoesMensagem().add(c13);getBotoesMensagem().add(c14);getBotoesMensagem().add(c15);getBotoesMensagem().add(c16);


        List<Bitmap> aniBotaoOkPremiacao = new ArrayList<>();
        aniBotaoOkPremiacao.add(gImgs.criarImg("botao padrao.png"));
        Botao botaoOkPremiacao = new Botao(getContext(),0,0,180,180,Acao.OKPREMIACAO);
        botaoOkPremiacao.setAnimacao(aniBotaoOkPremiacao);
        botaoOkPremiacao.setTexto("Ok");
        botaoOkPremiacao.setTamanhoTexto(70);
        botaoOkPremiacao.setVisibilidade(true);
        botaoOkPremiacao.setPosX(posicoes.getP13().x);
        botaoOkPremiacao.setPosY(posicoes.getP13().y);
        getBotoesMensagem().add(botaoOkPremiacao);

        //__________________________________->
    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }


}
