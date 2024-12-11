package com.example.zago;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Act extends Activity {

    private Tela telaRecorrente;
    private int altura, largura;
    private Posicao posicoes;
    private Jogador jogador;
    private GeradorDeImagens gImgs;
    private int contMultTouch;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        gImgs = new GeradorDeImagens(this);

        modoOrientacaoPaisagem();
        manterTelaLigada();
        telaCheia();

        setarResolucaoTela();

        jogador = new Jogador();

        telaRecorrente = new TelaInicial(this, posicoes,jogador);

        //-------------------------------------------------------------------------------------------------------------->

        List<Bitmap> aniTutorial = new ArrayList<>();
        aniTutorial.add(gImgs.criarImg("intro zago.png"));

        Componente fundoTutorial = new Componente(this,0,0);
        fundoTutorial.setAnimacao(aniTutorial);
        fundoTutorial.setVisibilidade(true);
        telaRecorrente.getComponentesMensagem().add(fundoTutorial);

        List<Bitmap> aniBotaoOkTutorial = new ArrayList<>();
        aniBotaoOkTutorial.add(gImgs.criarImg("botao padrao.png"));

        Botao botaoOkTutorial = new Botao(this,0,0,180,180,Acao.OKPREMIACAO);
        botaoOkTutorial.setTexto("Ok");
        botaoOkTutorial.setTamanhoTexto(70);
        botaoOkTutorial.setAnimacao(aniBotaoOkTutorial);
        botaoOkTutorial.setPosX(posicoes.getP13().x);
        botaoOkTutorial.setPosY(posicoes.getP13().y);
        botaoOkTutorial.setVisibilidade(true);
        telaRecorrente.getBotoesMensagem().add(botaoOkTutorial);

        telaRecorrente.setExibirMensagem(true);
        telaRecorrente.criarTela();

        setContentView(telaRecorrente);

        //--------------------------------------------------------------------------------------------------------------->


        telaRecorrente.criarTela();

        setContentView(telaRecorrente);

    }

    private void setarResolucaoTela() {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        largura = size.x;
        altura = size.y;
        posicoes = new Posicao(largura, altura);

    }

    public void modoOrientacaoPaisagem() {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void manterTelaLigada() {

        Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void telaCheia() {

        Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        win.requestFeature(Window.FEATURE_NO_TITLE);
        win.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        //evita duplo clique

        if (contMultTouch == 1l) {
            contMultTouch = 0;
            entrada(motionEvent.getX(), motionEvent.getY());
        } else {
            contMultTouch++;
        }

        return super.onTouchEvent(motionEvent);
    }

    public void entrada(double x, double y) {

        Botao v = telaRecorrente.getBotaoCoordenadas(x, y);

        if (v != null) {

            Acao a = v.getAcao();

            switch (a) {

                case CONFIRMARCRIACAOPERSONAGEM:

                    Campeao campeao = (Campeao) telaRecorrente.getComponenteSelecionado();

                    jogador.setCampeao(campeao);

                    telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);

                    List<Bitmap> aniTutorial = new ArrayList<>();
                    aniTutorial.add(gImgs.criarImg("textos/instrucao01.png"));

                    Componente fundoTutorial = new Componente(this,0,0);
                    fundoTutorial.setAnimacao(aniTutorial);
                    fundoTutorial.setVisibilidade(true);
                    telaRecorrente.getComponentesMensagem().add(fundoTutorial);

                    List<Bitmap> aniBotaoOkTutorial = new ArrayList<>();
                    aniBotaoOkTutorial.add(gImgs.criarImg("botao padrao.png"));

                    Botao botaoOkTutorial = new Botao(this,0,0,180,180,Acao.BAUPREMIACAOTUTORIAL);
                    botaoOkTutorial.setTexto("Ok");
                    botaoOkTutorial.setTamanhoTexto(70);
                    botaoOkTutorial.setAnimacao(aniBotaoOkTutorial);
                    botaoOkTutorial.setPosX(posicoes.getP13().x);
                    botaoOkTutorial.setPosY(posicoes.getP13().y);
                    botaoOkTutorial.setVisibilidade(true);
                    telaRecorrente.getBotoesMensagem().add(botaoOkTutorial);

                    telaRecorrente.setExibirMensagem(true);
                    telaRecorrente.criarTela();

                    setContentView(telaRecorrente);

                    break;

                case JHOSELECAO:

                    telaRecorrente.setComponenteSelecionadoPorNome("jho");
                    break;

                case MARIASELECAO:

                    telaRecorrente.setComponenteSelecionadoPorNome("maria");
                    break;

                case BAUPREMIACAOTUTORIAL:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundo = new ArrayList<>();
                    aniFundo.add(gImgs.criarImg("fundos/fundo transparencia 50.png"));
                    Componente fundoPremiacao = new Componente(this,0,0);
                    fundoPremiacao.setVisibilidade(true);
                    fundoPremiacao.setAnimacao(aniFundo);
                    telaRecorrente.getComponentesMensagem().add(fundoPremiacao);

                    Botao bauFechado = new Botao(this,posicoes.getP8().x-100,posicoes.getP7().y-100,180,180, Acao.PREMIOTUTORIAL);
                    List<Bitmap> aniBauFechado = new ArrayList<>();
                    aniBauFechado.add(gImgs.criarImg("botao bau fechado.png"));
                    bauFechado.setVisibilidade(true);
                    bauFechado.setAnimacao(aniBauFechado);
                    telaRecorrente.getBotoesMensagem().add(bauFechado);

                    break;

                case PREMIOTUTORIAL:

                    telaRecorrente.premiacao();

                    break;

                case CRIARVARIAVELFORCA:

                    telaRecorrente = new TelaCriacaoVariavelForca(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    jogador.getCampeao().setVariavelSelecionada((Variavel) v);

                    setContentView(telaRecorrente);

                    break;

                case  CRIARVARIAVELVIDA:

                    telaRecorrente = new TelaCriacaoVariavelVida(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    jogador.getCampeao().setVariavelSelecionada((Variavel) v);
                    setContentView(telaRecorrente);

                    break;

                case  CRIARVARIAVELDEF:

                    telaRecorrente = new TelaCriacaoVariavelDefesa(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    jogador.getCampeao().setVariavelSelecionada((Variavel) v);
                    setContentView(telaRecorrente);

                    break;
                case CRIARMETODODEFESA:

                    telaRecorrente = new TelaCriacaoVariavelDefesa(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    jogador.getCampeao().setVariavelSelecionada((Variavel) v);
                    setContentView(telaRecorrente);

                    break;

                case CRIARVARIAVELVEL:

                    telaRecorrente = new TelaCriacaoVariavelVelocidade(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    jogador.getCampeao().setVariavelSelecionada((Variavel) v);
                    setContentView(telaRecorrente);

                    break;

//confimações de variáveis e métodos-------------------------------------------------------------------------------------------

                case CONFIRMACAODETALHE:
                    boolean aux = true;
                   /* if(jogador.getCampeao().getVariavelForca().getPreenchida()==true){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_LONG).show();
                        aux = false;
                    }*/
                    if(jogador.getCampeao().getVariavelForca()==null){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_SHORT).show();
                        aux = false;
                    }
                    /*if(jogador.getCampeao().getVariavelVida().getPreenchida()==true){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_LONG).show();
                        aux = false;
                    }*/
                    if(jogador.getCampeao().getVariavelVida()==null){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_SHORT).show();
                        aux = false;
                    }
                   /* if(jogador.getCampeao().getVariavelDefesa().getPreenchida()==true){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_LONG).show();
                        aux = false;
                    }*/
                    if(jogador.getCampeao().getVariavelDefesa()==null){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_SHORT).show();
                        aux = false;
                    }
                    /*if(jogador.getCampeao().getVariavelVel().getPreenchida()==true){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_LONG).show();
                        aux = false;
                    }*/
                    if(jogador.getCampeao().getVariavelVel()==null){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_SHORT).show();
                        aux = false;
                    }

                    /*if(jogador.getCampeao().getMetodoAtacar().getPreenchida()==true){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_LONG).show();
                        aux = false;
                    }*/
                    if(jogador.getCampeao().getMetodoAtacar()==null){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_SHORT).show();
                        aux = false;
                    }
                    /*if(jogador.getCampeao().getMetodoDefender().getPreenchida()==true){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_LONG).show();
                        aux = false;
                    }*/
                    if(jogador.getCampeao().getMetodoDefender()==null){
                        Toast.makeText(this, "Por favor, crie todas as variáveis e métodos.", Toast.LENGTH_SHORT).show();
                        aux = false;
                    }

                    if(aux){

                        telaRecorrente = new TelaMundo(this,posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    }

                    break;

                case CONFIRMARCRIACAOMETODOATACAR:

                    aux = true;
                    for(Botao c: telaRecorrente.getComponentesSelecionados()){

                        if(c.getTexto()==null){
                            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                            aux = false;
                            break;
                        }
                    }

                    if(aux){


                        Metodo me = jogador.getCampeao().getmetodoSelecionado();

                        Cartao c1 = (Cartao) telaRecorrente.getComponentesSelecionados().get(0);
                        Cartao c2 = (Cartao) telaRecorrente.getComponentesSelecionados().get(1);
                        Cartao c3 = (Cartao) telaRecorrente.getComponentesSelecionados().get(2);
                        Cartao c4 = (Cartao) telaRecorrente.getComponentesSelecionados().get(3);
                        Cartao c5 = (Cartao) telaRecorrente.getComponentesSelecionados().get(4);
                        Cartao c6 = (Cartao) telaRecorrente.getComponentesSelecionados().get(5);
                        Cartao c7 = (Cartao) telaRecorrente.getComponentesSelecionados().get(6);
                        Cartao c8 = (Cartao) telaRecorrente.getComponentesSelecionados().get(7);
                        Cartao c9 = (Cartao) telaRecorrente.getComponentesSelecionados().get(8);
                        Cartao c10 = (Cartao) telaRecorrente.getComponentesSelecionados().get(9);
                        Cartao c11 = (Cartao) telaRecorrente.getComponentesSelecionados().get(10);
                        Cartao c12 = (Cartao) telaRecorrente.getComponentesSelecionados().get(11);
                        Cartao c13 = (Cartao) telaRecorrente.getComponentesSelecionados().get(12);

                        me.setcTModificadorAcesso(c1);
                        me.setcTTipoRetornoMetodo(c2);
                        me.setcTNomeMetodo(c3);
                        me.setValorAtaqueCampeao(c4);
                        me.setValorDefesaOponente(c5);
                        me.setcTTipo(c6);
                        me.setcTNome(c7);
                        me.setcTOperadorAtribuicao(c8);
                        me.setcTValorVJogador(c9);
                        me.setcTOperadorConcatenacao(c10);
                        me.setcTValorVOponente(c11);
                        me.setcTReturn(c12);
                        me.setcTVariavelReturn(c13);
                        //jogador.getCampeao().getMetodoAtacar().setPreenchida(true);
                        jogador.getCampeao().setMetodoAtacar(me);
                        telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    }

                    break;

                case CONFIRMARCRIACAOMETODODEFENDER:

                    aux = true;
                    for(Botao c: telaRecorrente.getComponentesSelecionados()){

                        if(c.getTexto()==null){
                            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                            aux = false;
                            break;
                        }
                    }

                    if(aux){


                        Metodo me = jogador.getCampeao().getmetodoSelecionado();

                        Cartao c1 = (Cartao) telaRecorrente.getComponentesSelecionados().get(0);
                        Cartao c2 = (Cartao) telaRecorrente.getComponentesSelecionados().get(1);
                        Cartao c3 = (Cartao) telaRecorrente.getComponentesSelecionados().get(2);
                        Cartao c4 = (Cartao) telaRecorrente.getComponentesSelecionados().get(3);
                        Cartao c5 = (Cartao) telaRecorrente.getComponentesSelecionados().get(4);
                        Cartao c6 = (Cartao) telaRecorrente.getComponentesSelecionados().get(5);
                        Cartao c7 = (Cartao) telaRecorrente.getComponentesSelecionados().get(6);
                        Cartao c8 = (Cartao) telaRecorrente.getComponentesSelecionados().get(7);
                        Cartao c9 = (Cartao) telaRecorrente.getComponentesSelecionados().get(8);
                        Cartao c10 = (Cartao) telaRecorrente.getComponentesSelecionados().get(9);
                        Cartao c11 = (Cartao) telaRecorrente.getComponentesSelecionados().get(10);
                        Cartao c12 = (Cartao) telaRecorrente.getComponentesSelecionados().get(11);
                        Cartao c13 = (Cartao) telaRecorrente.getComponentesSelecionados().get(12);

                        me.setcTModificadorAcesso(c1);
                        me.setcTTipoRetornoMetodo(c2);
                        me.setcTNomeMetodo(c3);
                        me.setValorAtaqueCampeao(c4);
                        me.setValorDefesaOponente(c5);
                        me.setcTTipo(c6);
                        me.setcTNome(c7);
                        me.setcTOperadorAtribuicao(c8);
                        me.setcTValorVJogador(c9);
                        me.setcTOperadorConcatenacao(c10);
                        me.setcTValorVOponente(c11);
                        me.setcTReturn(c12);
                        me.setcTVariavelReturn(c13);
                        //jogador.getCampeao().getMetodoDefender().setPreenchida(true);
                        jogador.getCampeao().setMetodoDefender(me);
                        telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    }



                    break;

                case CONFIRMARCRIACAOVARIAVELFORCA:

                    aux = true;
                    for(Botao c: telaRecorrente.getComponentesSelecionados()){

                        if(c.getTexto()==null){
                            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                            aux = false;
                            break;
                        }
                    }

                    if(aux){


                        Variavel va = jogador.getCampeao().getVariavelSelecionada();

                        Cartao c1 = (Cartao) telaRecorrente.getComponentesSelecionados().get(0);
                        Cartao c2 = (Cartao) telaRecorrente.getComponentesSelecionados().get(1);
                        Cartao c3 = (Cartao) telaRecorrente.getComponentesSelecionados().get(2);
                        Cartao c4 = (Cartao) telaRecorrente.getComponentesSelecionados().get(3);

                        va.setCartaoTipo(c1);
                        va.setCartaoNome(c2);
                        va.setCartaoOperador(c3);
                        va.setCartaoValor(c4);

                        jogador.getCampeao().setVariavelForca(va);
                        jogador.getCampeao().getVariavelForca().setPreenchida(true);
                        telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    }


                    break;

                case CONFIRMARCRIACAOVARIAVELVIDA:

                    aux = true;
                    for(Botao c: telaRecorrente.getComponentesSelecionados()){

                        if(c.getTexto()==null){
                            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                            aux = false;
                            break;
                        }
                    }

                    if(aux){


                        Variavel va = jogador.getCampeao().getVariavelSelecionada();

                        Cartao c1 = (Cartao) telaRecorrente.getComponentesSelecionados().get(0);
                        Cartao c2 = (Cartao) telaRecorrente.getComponentesSelecionados().get(1);
                        Cartao c3 = (Cartao) telaRecorrente.getComponentesSelecionados().get(2);
                        Cartao c4 = (Cartao) telaRecorrente.getComponentesSelecionados().get(3);

                        va.setCartaoTipo(c1);
                        va.setCartaoNome(c2);
                        va.setCartaoOperador(c3);
                        va.setCartaoValor(c4);

                        jogador.getCampeao().setVariavelVida(va);

                        telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    }


                    break;

                case CONFIRMARCRIACAOVARIAVELDEFESA:
                    aux = true;
                    for(Botao c: telaRecorrente.getComponentesSelecionados()){

                        if(c.getTexto()==null){
                            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                            aux = false;
                            break;
                        }
                    }

                    if(aux){


                        Variavel va = jogador.getCampeao().getVariavelSelecionada();

                        Cartao c1 = (Cartao) telaRecorrente.getComponentesSelecionados().get(0);
                        Cartao c2 = (Cartao) telaRecorrente.getComponentesSelecionados().get(1);
                        Cartao c3 = (Cartao) telaRecorrente.getComponentesSelecionados().get(2);
                        Cartao c4 = (Cartao) telaRecorrente.getComponentesSelecionados().get(3);

                        va.setCartaoTipo(c1);
                        va.setCartaoNome(c2);
                        va.setCartaoOperador(c3);
                        va.setCartaoValor(c4);

                        jogador.getCampeao().setVariavelDef(va);
                        jogador.getCampeao().getVariavelDefesa().setPreenchida(true);
                        telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    }

                    break;
                case CONFIRMARCRIACAOVARIAVELVELOCIDADE:

                    aux = true;
                    for(Botao c: telaRecorrente.getComponentesSelecionados()){

                        if(c.getTexto()==null){
                            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                            aux = false;
                            break;
                        }
                    }

                    if(aux){


                        Variavel va = jogador.getCampeao().getVariavelSelecionada();

                        Cartao c1 = (Cartao) telaRecorrente.getComponentesSelecionados().get(0);
                        Cartao c2 = (Cartao) telaRecorrente.getComponentesSelecionados().get(1);
                        Cartao c3 = (Cartao) telaRecorrente.getComponentesSelecionados().get(2);
                        Cartao c4 = (Cartao) telaRecorrente.getComponentesSelecionados().get(3);

                        va.setCartaoTipo(c1);
                        va.setCartaoNome(c2);
                        va.setCartaoOperador(c3);
                        va.setCartaoValor(c4);

                        jogador.getCampeao().setVariavelVel(va);
                        jogador.getCampeao().getVariavelVel().setPreenchida(true);
                        telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    }

                    break;

                case OKPREMIACAO:

                    telaRecorrente.setExibirMensagem(false);

                    break;

                case CARTAOTELA:

                 Cartao cj = (Cartao) telaRecorrente.getComponenteSelecionado();
                 Cartao ct = (Cartao) v;

                 if(ct.getTipo().equals(cj.getTipo())){

                        ct.setTexto(cj.getTexto());
                 }else{
                     Toast.makeText(this, "Esse cartão não representa a escolha correta", Toast.LENGTH_SHORT).show();
                 }

                    break;
                case CARTAOJOGADOR:
                    cj = (Cartao) v;

                    if(cj.getTipo() != null){
                        telaRecorrente.setComponenteSelecionado(v);

                    }else{
                        Toast.makeText(this, "Por favor, escolha um cartão com descrição", Toast.LENGTH_SHORT).show();
                    }

                    break;

                //telas

                case TELADETALHE:

                    telaRecorrente =  new TelaDetalhe(this, posicoes,jogador);
                    telaRecorrente.criarTela();

                    setContentView(telaRecorrente);

                    break;

                case TELACRIACAO:

                    telaRecorrente = new TelaCriacao(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case TELACRIACAOMETODO:

                        telaRecorrente = new TelaCriacaoMetodo(this,posicoes,jogador);
                        telaRecorrente.criarTela();
                        setContentView(telaRecorrente);

                    break;

                case TELACRIACAOVARIAVEL:

                    telaRecorrente = new TelaCriacaoVariavel(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;
                case TELACRIACAOCONCATENACAO:

                    telaRecorrente = new TelaCriacaoConcatenacao(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case TELACRIACAOLOOP:

                    telaRecorrente = new TelaCriacaoLoop(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case TELACRIACAOMETODOATACAR:

                    telaRecorrente = new TelaCriacaoMetodoAtacar(this, posicoes, jogador);
                    telaRecorrente.criarTela();
                    jogador.getCampeao().setMetodoSelecionado((Metodo) v);
                    setContentView(telaRecorrente);

                    break;

                case TELACRIACAOMETODODEFENDER:

                    telaRecorrente = new TelaCriacaoMetodoDefender(this, posicoes, jogador);
                    telaRecorrente.criarTela();
                    jogador.getCampeao().setMetodoSelecionado((Metodo) v);
                    setContentView(telaRecorrente);

                    break;

                case TELASILVA:

                    telaRecorrente = new TelaSilva(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;
                case TELAVULCANO:

                    telaRecorrente = new TelaVulcano(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case TELAGLACIES:

                    telaRecorrente = new TelaGlacies(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;
                case TELACRIARPERSONAGEM:

                    telaRecorrente = new TelaCPersonagem(this, posicoes,jogador );

                    telaRecorrente.criarTela();

                    setContentView(telaRecorrente);

                    break;

                case TELAMUNDO:

                    telaRecorrente = new TelaMundo(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case BOLSA:

                    telaRecorrente = new TelaBolsa(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);


                    break;

                case TELABATALHAMORCEGO:

                    telaRecorrente = new TelaBatalhaMorcego(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case TELABATALHAARANHA:

                    telaRecorrente = new TelaBatalhaAranha(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case TELABATALHAJHO:

                    telaRecorrente = new TelaBatalhaJho(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;

                case TELABATALHAMARIA:

                    telaRecorrente = new TelaBatalhaMaria(this,posicoes,jogador);
                    telaRecorrente.criarTela();
                    setContentView(telaRecorrente);

                    break;


                //infos

                case INFOVALOR:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundoValor = new ArrayList<>();
                    aniFundoValor.add(gImgs.criarImg("info valor.png"));
                    Componente fundoInfoValor = new Componente(this,0,0);
                    fundoInfoValor.setVisibilidade(true);
                    fundoInfoValor.setAnimacao(aniFundoValor);
                    telaRecorrente.getComponentesMensagem().add(fundoInfoValor);


                    List<Bitmap> aniOkInfoValor = new ArrayList<>();
                    aniOkInfoValor.add(gImgs.criarImg("botao padrao.png"));
                    Botao okInfoValor = new Botao(this,posicoes.getP13().x,posicoes.getP13().y,180,180, Acao.PREMIOTUTORIAL);
                    okInfoValor.setTexto("Ok");
                    okInfoValor.setVisibilidade(true);
                    okInfoValor.setAnimacao(aniOkInfoValor);
                    telaRecorrente.getBotoesMensagem().add(okInfoValor);

                    break;

                case INFOFLOAT:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundofloat = new ArrayList<>();
                    aniFundofloat.add(gImgs.criarImg("info float.png"));
                    Componente fundoInfoFloat = new Componente(this,0,0);
                    fundoInfoFloat.setVisibilidade(true);
                    fundoInfoFloat.setAnimacao(aniFundofloat);
                    telaRecorrente.getComponentesMensagem().add(fundoInfoFloat);


                    List<Bitmap> aniOkInfoFloat = new ArrayList<>();
                    aniOkInfoFloat.add(gImgs.criarImg("botao padrao.png"));
                    Botao okInfoFloat = new Botao(this,posicoes.getP13().x,posicoes.getP13().y,180,180, Acao.PREMIOTUTORIAL);
                    okInfoFloat.setTexto("Ok");
                    okInfoFloat.setVisibilidade(true);
                    okInfoFloat.setAnimacao(aniOkInfoFloat);
                    telaRecorrente.getBotoesMensagem().add(okInfoFloat);

                    break;

                case INFOBYTE:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundoByte = new ArrayList<>();
                    aniFundoByte.add(gImgs.criarImg("info byte.png"));
                    Componente fundoInfoByte = new Componente(this,0,0);
                    fundoInfoByte.setVisibilidade(true);
                    fundoInfoByte.setAnimacao(aniFundoByte);
                    telaRecorrente.getComponentesMensagem().add(fundoInfoByte);


                    List<Bitmap> aniOkInfoByte = new ArrayList<>();
                    aniOkInfoByte.add(gImgs.criarImg("botao padrao.png"));
                    Botao okInfoByte = new Botao(this,posicoes.getP13().x,posicoes.getP13().y,180,180, Acao.PREMIOTUTORIAL);
                    okInfoByte.setTexto("Ok");
                    okInfoByte.setVisibilidade(true);
                    okInfoByte.setAnimacao(aniOkInfoByte);
                    telaRecorrente.getBotoesMensagem().add(okInfoByte);

                    break;

                case INFODOUBLE:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundoDouble = new ArrayList<>();
                    aniFundoDouble.add(gImgs.criarImg("info double.png"));
                    Componente fundoInfoDouble = new Componente(this,0,0);
                    fundoInfoDouble.setVisibilidade(true);
                    fundoInfoDouble.setAnimacao(aniFundoDouble);
                    telaRecorrente.getComponentesMensagem().add(fundoInfoDouble);


                    List<Bitmap> aniOkInfoDouble = new ArrayList<>();
                    aniOkInfoDouble.add(gImgs.criarImg("botao padrao.png"));
                    Botao okInfoDouble = new Botao(this,posicoes.getP13().x,posicoes.getP13().y,180,180, Acao.PREMIOTUTORIAL);
                    okInfoDouble.setTexto("Ok");
                    okInfoDouble.setVisibilidade(true);
                    okInfoDouble.setAnimacao(aniOkInfoDouble);
                    telaRecorrente.getBotoesMensagem().add(okInfoDouble);

                    break;

                case INFOSHORT:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundoShort = new ArrayList<>();
                    aniFundoShort.add(gImgs.criarImg("info short.png"));
                    Componente fundoInfoShort = new Componente(this,0,0);
                    fundoInfoShort.setVisibilidade(true);
                    fundoInfoShort.setAnimacao(aniFundoShort);
                    telaRecorrente.getComponentesMensagem().add(fundoInfoShort);


                    List<Bitmap> aniOkInfoShort = new ArrayList<>();
                    aniOkInfoShort.add(gImgs.criarImg("botao padrao.png"));
                    Botao okInfoShort = new Botao(this,posicoes.getP13().x,posicoes.getP13().y,180,180, Acao.PREMIOTUTORIAL);
                    okInfoShort.setTexto("Ok");
                    okInfoShort.setVisibilidade(true);
                    okInfoShort.setAnimacao(aniOkInfoShort);
                    telaRecorrente.getBotoesMensagem().add(okInfoShort);

                    break;

                case INFONOME:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundoNome = new ArrayList<>();
                    aniFundoNome.add(gImgs.criarImg("info nome.png"));
                    Componente fundoInfoNome = new Componente(this,0,0);
                    fundoInfoNome.setVisibilidade(true);
                    fundoInfoNome.setAnimacao(aniFundoNome);
                    telaRecorrente.getComponentesMensagem().add(fundoInfoNome);


                    List<Bitmap> aniOkInfoNome = new ArrayList<>();
                    aniOkInfoNome.add(gImgs.criarImg("botao padrao.png"));
                    Botao okInfoNome = new Botao(this,posicoes.getP13().x,posicoes.getP13().y,180,180, Acao.PREMIOTUTORIAL);
                    okInfoNome.setTexto("Ok");
                    okInfoNome.setVisibilidade(true);
                    okInfoNome.setAnimacao(aniOkInfoNome);
                    telaRecorrente.getBotoesMensagem().add(okInfoNome);

                    break;

                case INFOOPERADORIGUAL:

                    telaRecorrente.getComponentesMensagem().clear();
                    telaRecorrente.getBotoesMensagem().clear();

                    List<Bitmap> aniFundoOperadorIgual = new ArrayList<>();
                    aniFundoOperadorIgual.add(gImgs.criarImg("info operador igual.png"));
                    Componente fundoInfoOperadorIgual = new Componente(this,0,0);
                    fundoInfoOperadorIgual.setVisibilidade(true);
                    fundoInfoOperadorIgual.setAnimacao(aniFundoOperadorIgual);
                    telaRecorrente.getComponentesMensagem().add(fundoInfoOperadorIgual);


                    List<Bitmap> aniOkInfoOperadorIgual = new ArrayList<>();
                    aniOkInfoOperadorIgual.add(gImgs.criarImg("botao padrao.png"));
                    Botao okInfoOperadorIgual = new Botao(this,posicoes.getP13().x,posicoes.getP13().y,180,180, Acao.PREMIOTUTORIAL);
                    okInfoOperadorIgual.setTexto("Ok");
                    okInfoOperadorIgual.setVisibilidade(true);
                    okInfoOperadorIgual.setAnimacao(aniOkInfoOperadorIgual);
                    telaRecorrente.getBotoesMensagem().add(okInfoOperadorIgual);

                    break;
            }
        } else {

        }
    }
}
