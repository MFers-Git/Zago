package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class TelaMundo extends Tela{
    public TelaMundo(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {

        Context context = getContext();
        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());

        //fundo

        Componente fundo = new Componente(context, 0, 0);
        List<Bitmap> af = new ArrayList<>();
        af.add(gi.criarImg("fundos/telaMundo.jpg"));
        fundo.setAnimacao(af);
        fundo.setVisibilidade(true);

        componentes.add(fundo);

        //caixa de textos início

        CaixaTexto ct = new CaixaTexto(getContext(),getPosicoes().getP3().x-100,getPosicoes().getP3().y-100,"Mundo",80);
        ct.setVisibilidade(true);
        componentes.add(ct);

        //botões início

        Botao bv = new Botao(getContext(),getPosicoes().getP7().x, getPosicoes().getP7().y,180,180,Acao.TELAVULCANO);
        bv.setTexto("Vulcano");
        List<Bitmap> ae = new ArrayList<>();
        ae.add(gi.criarImg("botoes/bvulcao.png"));
        bv.setAnimacao(ae);
        bv.setVisibilidade(true);

        botoes.add(bv);

        Botao bc = new Botao(getContext(),getPosicoes().getP8().x, getPosicoes().getP8().y,180,180,Acao.TELASILVA);
        bc.setTexto("Silva");
        List<Bitmap> as = new ArrayList<>();
        as.add(gi.criarImg("botoes/bcidade.png"));
        bc.setAnimacao(as);
        bc.setVisibilidade(true);

        botoes.add(bc);

        Botao bg = new Botao(getContext(),getPosicoes().getP9().x, getPosicoes().getP9().y,180,180,Acao.TELAGLACIES);
        bg.setTexto("Glacies");
        List<Bitmap> ag = new ArrayList<>();
        ag.add(gi.criarImg("botoes/bgelo.png"));
        bg.setAnimacao(ag);
        bg.setVisibilidade(true);

        botoes.add(bg);

        Botao bbolsa = new Botao(getContext(),getPosicoes().getP5().x, getPosicoes().getP5().y,180,180,Acao.BOLSA);
        bbolsa.setTexto("Bolsa");
        List<Bitmap> ab = new ArrayList<>();
        ab.add(gi.criarImg("botoes/bbolsa.png"));
        bbolsa.setAnimacao(ab);
        bbolsa.setVisibilidade(true);

        botoes.add(bbolsa);

        Botao bcriacao = new Botao(getContext(),getPosicoes().getP10().x, getPosicoes().getP10().y,180,180,Acao.TELACRIACAO);
        bcriacao.setTexto("Criação");
        List<Bitmap> ac = new ArrayList<>();
        ac.add(gi.criarImg("botoes/bcriacao.png"));
        bcriacao.setAnimacao(ac);
        bcriacao.setVisibilidade(true);

        botoes.add(bcriacao);

        //---------------------->

    }

    @Override
    public void premiacao() {

    }

    @Override
    public List<Botao> getComponentesSelecionados() {
        return null;
    }
}
