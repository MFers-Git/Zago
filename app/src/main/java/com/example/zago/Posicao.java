package com.example.zago;

import android.graphics.Point;

public class Posicao {

    private Point p1, p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
    private int larguraTela, alturaTela;

    public Posicao(int larguraTela, int alturaTela){

        this.larguraTela = larguraTela;
        this.alturaTela = alturaTela;

        p1 = new Point(240 ,270 );
        p2 = new Point(480 ,270);
        p3 = new Point(960 ,270);
        p4 = new Point(1440 ,270);
        p5 = new Point(1680 ,270);
        p6 = new Point(240 ,540);
        p7 = new Point(480 ,540);
        p8 = new Point(960 ,540);
        p9 = new Point(1440 ,540);
        p10 = new Point(1680 ,540);
        p11 = new Point(240 ,810 );
        p12 = new Point(480 ,810 );
        p13 = new Point(960 ,810 );
        p14 = new Point(1440 ,810 );
        p15 = new Point(1680 ,810 );


    }

    public Posicao(){

        p1 = new Point(240 ,270 );
        p2 = new Point(480 ,270);
        p3 = new Point(960 ,270);
        p4 = new Point(1440 ,270);
        p5 = new Point(1680 ,270);
        p6 = new Point(240 ,540);
        p7 = new Point(480 ,540);
        p8 = new Point(960 ,540);
        p9 = new Point(1440 ,540);
        p10 = new Point(1680 ,540);
        p11 = new Point(240 ,810 );
        p12 = new Point(480 ,810 );
        p13 = new Point(960 ,810 );
        p14 = new Point(1440 ,810 );
        p15 = new Point(1680 ,810 );


    }


    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    public Point getP5() {
        return p5;
    }

    public Point getP6() {
        return p6;
    }

    public Point getP7() {
        return p7;
    }

    public Point getP8() {
        return p8;
    }

    public Point getP9() {
        return p9;
    }

    public Point getP10() {
        return p10;
    }

    public Point getP11() {
        return p11;
    }

    public Point getP12() {
        return p12;
    }

    public Point getP13() {
        return p13;
    }

    public Point getP14() {
        return p14;
    }

    public Point getP15() {
        return p15;
    }
}
