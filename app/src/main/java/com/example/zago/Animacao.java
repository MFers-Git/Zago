package com.example.zago;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Xfermode;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Animacao {

    private List<Bitmap> animacao;
    private Bitmap imgRecorrente;
    private int cont;

    private Context context;

    private boolean pause;

    public Animacao(Context context) {

        this.context = context;
        animacao = new ArrayList<>();
        cont = 0;

    }

    public Animacao(Context context, String caminho) {

        this.context = context;
        animacao = new ArrayList<>();
        cont = 0;

        criarImgStatica(caminho);

    }

    public void criarImgStatica(String caminho){

        GeradorDeImagens gImgs = new GeradorDeImagens(context);

        animacao.add(gImgs.criarImg(caminho));

    }

    public void criarAnimacao(String pasta,String lado,String nome, String estado,int quantFrame) {

        GeradorDeImagens gImgs = new GeradorDeImagens(context);

        for (int x = 0; x < quantFrame; x++) {
            if (x < 10) {

                animacao.add(gImgs.criarImg(pasta+"/"+lado+"/"+nome+"/"+estado+"/"+nome +" "+lado+" "+estado+" "+"0000" + x + ".png"));

            }else{
                animacao.add(gImgs.criarImg(pasta+"/"+lado+"/"+nome+"/"+estado+"/"+nome +" "+lado+" "+estado+" "+"000" + x + ".png"));
            }

        }

    }

    public Bitmap getImg() {

        if(pause){

            return imgRecorrente;
        }else{

            if (animacao.size() > cont) {
                imgRecorrente = animacao.get(cont);
                cont++;
            }else{
                cont = 0;
            }

            return imgRecorrente;

        }

    }

    public List<Bitmap> getAnimacao(){

        return animacao;
}

    public void pause(){

            pause = true;
    }

    public void despausar(){

            pause = false;

        }

}
