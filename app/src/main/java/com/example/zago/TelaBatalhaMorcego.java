package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TelaBatalhaMorcego extends Tela{

    private Ser oponente;

    private Campeao campeao;
    private boolean vezCampeao,vezOponente;
    private int aux;

    private boolean vitoriaCampeao, vitoriaOponente,verificaPremioJaRecebido;

    public TelaBatalhaMorcego(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    public void onDraw(Canvas canvas){

        verificaAtacante();

        super.onDraw(canvas);
    }

    public void verificaAtacante(){

            if(verificaPremioJaRecebido){

                if(vitoriaCampeao){
                    GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
                    oponente.setVisibilidade(false);
                    oponente.setBatalhando(false);
                    campeao.criarAnimacaoEsquerdaRepouso();
                    super.setExibirMensagem(true);
                    //premiacao();
                    vitoriaCampeao = false;

                    Botao bauFechado = new Botao(this.getContext(),getPosicoes().getP8().x-100,getPosicoes().getP7().y-100,180,180, Acao.PREMIOTUTORIAL);
                    List<Bitmap> aniBauFechado = new ArrayList<>();
                    aniBauFechado.add(gImgs.criarImg("botao bau fechado.png"));
                    bauFechado.setVisibilidade(true);
                    bauFechado.setAnimacao(aniBauFechado);
                    getBotoesMensagem().add(bauFechado);

                }else if(vitoriaOponente){
                    GeradorDeImagens gImgs = new GeradorDeImagens(this.getContext());
                    campeao.setVisibilidade(false);
                    campeao.setBatalhando(false);
                    oponente.criarAnimacaoDireitaRepouso();
                    super.setExibirMensagem(true);
                    //premiacao();
                    vitoriaOponente = false;

                    Botao bauFechado = new Botao(this.getContext(),getPosicoes().getP8().x-100,getPosicoes().getP7().y-100,180,180, Acao.PREMIOTUTORIAL);
                    List<Bitmap> aniBauFechado = new ArrayList<>();
                    aniBauFechado.add(gImgs.criarImg("botao bau fechado.png"));
                    bauFechado.setVisibilidade(true);
                    bauFechado.setAnimacao(aniBauFechado);
                    getBotoesMensagem().add(bauFechado);
                }
            }else{

                if(aux > 60){
                    aux=0;
                    if(vezCampeao){

                        campeao.setAtacando(true);
                        campeao.criarAnimacaoEsquerdaAtaque();
                        campeao.setVisibilidade(true);
                        oponente.criarAnimacaoDireitaRepouso();
                        oponente.setVisibilidade(true);
                        vezCampeao = false;
                        vezOponente = true;
                        oponente.setVidaAtual(oponente.getVidaAtual() - (campeao.getNumForca() - oponente.getNumDef()));
                        verificaVitoria();
                    }else{

                        oponente.setAtacando(true);
                        oponente.criarAnimacaoDireitaAtaque();
                        oponente.setVisibilidade(true);
                        campeao.criarAnimacaoEsquerdaRepouso();
                        campeao.setVisibilidade(true);
                        vezCampeao = true;
                        vezOponente = false;
                        campeao.setVidaAtual(campeao.getVidaAtual() - (oponente.getNumForca() - campeao.getNumDef()));
                        verificaVitoria();
                    }
                }else{
                    aux++;
                }
            }

    }

    public void verificaVitoria(){

        if(campeao.getVidaAtual()<=0){
            vitoriaOponente = true;
            verificaPremioJaRecebido = true;
        }else if(oponente.getVidaAtual()<=0) {
            vitoriaCampeao = true;
            verificaPremioJaRecebido = true;
        }
    }

    @Override
    public void criarTela() {

        GeradorDeImagens gi = new GeradorDeImagens(getContext());
        //Fundo início

        Componente fundo = new Componente(getContext(), 0, 0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundos/fase morcego.png"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);

        componentes.add(fundo);

        //oponente
        oponente = new Morcego(getContext(),0,0,10,1,60,1);
        oponente.setPosX(getPosicoes().getP8().x);
        oponente.setPosY(getPosicoes().getP8().y);
        oponente.criarAnimacaoDireitaRepouso();
        oponente.setVisibilidade(true);
        oponente.setBatalhando(true);
        componentes.add(oponente);

        campeao = getJogador().getCampeao();
        campeao.setPosX(getPosicoes().getP7().x);
        campeao.setPosY(getPosicoes().getP7().y);
        campeao.criarAnimacaoEsquerdaRepouso();
        campeao.setVisibilidade(true);
        campeao.setBatalhando(true);
        componentes.add(campeao);

        if(campeao.getNumVel() > oponente.getNumVel()){
            vezCampeao = true;
            vezOponente = false;
        }else{
            vezCampeao = false;
            vezOponente = true;
        }
    }

    @Override
    public void premiacao() {


        getComponentesMensagem().clear();
        getBotoesMensagem().clear();

        GeradorDeImagens gImgs = new GeradorDeImagens(getContext());

        List<Bitmap> aniFundo = new ArrayList<>();
        aniFundo.add(gImgs.criarImg("fundos/fundo transparencia 50.png"));
        Componente fundoPremiacao = new Componente(getContext(),0,0);
        fundoPremiacao.setVisibilidade(true);
        fundoPremiacao.setAnimacao(aniFundo);
        getComponentesMensagem().add(fundoPremiacao);

        Componente bauAberto = new Componente(getContext(),getPosicoes().getP8().x-100,getPosicoes().getP7().y-100);
        List<Bitmap> aniBauAberto = new ArrayList<>();
        aniBauAberto.add(gImgs.criarImg("botao bau aberto.png"));
        bauAberto.setVisibilidade(true);
        bauAberto.setAnimacao(aniBauAberto);
        getComponentesMensagem().add(bauAberto);

        Cartao cartao = oponente.getRecompensa();

        if (cartao.getTipo().equals("inteiros")){
            getJogador().addCartaoValorInteiro(cartao);
        }
        if (cartao.getTipo().equals("operador concatenacao")){
            getJogador().addCartaoOperadorConcatenacao(cartao);
        }

        cartao.setPosX(getPosicoes().getP8().x);
        cartao.setPosY(getPosicoes().getP8().y);

        cartao.setVisibilidade(true);
        getBotoesMensagem().add(cartao);

        List<Bitmap> aniBotaoOkPremiacao = new ArrayList<>();
        aniBotaoOkPremiacao.add(gImgs.criarImg("botao padrao.png"));
        Botao botaoOkPremiacao = new Botao(getContext(),0,0,180,180,Acao.TELAMUNDO);
        botaoOkPremiacao.setAnimacao(aniBotaoOkPremiacao);
        botaoOkPremiacao.setTexto("Ok");
        botaoOkPremiacao.setTamanhoTexto(70);
        botaoOkPremiacao.setVisibilidade(true);
        botaoOkPremiacao.setPosX(getPosicoes().getP13().x);
        botaoOkPremiacao.setPosY(getPosicoes().getP13().y);
        getBotoesMensagem().add(botaoOkPremiacao);


    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
