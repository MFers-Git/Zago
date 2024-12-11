package com.example.zago;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class GeradorDeImagens {

    private Bitmap img = null;
    private Point dimensao;
    private Context context;

    public GeradorDeImagens(Context context){

       this.context = context;

    }

    public Bitmap criarImg(String nomeImg){

        try {

            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(nomeImg);
            img = BitmapFactory.decodeStream(inputStream);
            inputStream.close();

        }catch (IOException e){

        }
        return img;
    }

    public Bitmap getImg(){

        return img;
    }
    public Point getDimensao(){

        return dimensao;
    }

}
