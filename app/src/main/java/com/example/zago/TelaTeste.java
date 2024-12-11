package com.example.zago;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TelaTeste extends Tela{
    public TelaTeste(Context context, Posicao posicoes, Jogador jogador) {
        super(context, posicoes, jogador);
    }

    @Override
    public void criarTela() {
        //fundo

        GeradorDeImagens gi = new GeradorDeImagens(this.getContext());

        Componente fundo = new Componente(getContext(), 0,0);
        List<Bitmap> af = new ArrayList<>();

        for (int x = 0; x < 99; x++) {
            if (x < 10) {
                af.add(gi.criarImg("fundo padrao/fundo padrao "+"0000" + x + ".png"));

            } else {
                af.add(gi.criarImg("fundo padrao/fundo padrao "+"000" + x + ".png"));

            }

        }
        Log.d("Tela criação P", "tamanho ani fundo: "+af.size());
        fundo.setAnimacao(af);

        fundo.setVisibilidade(true);

        componentes.add(fundo);

    }
}
