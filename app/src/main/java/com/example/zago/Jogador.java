package com.example.zago;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private Campeao campeao;
    private List<Cartao> cartoesTiposInteiros;
    private List<Cartao> cartoesTiposFracionados;
    private List<Cartao> cartoesNomesVariaveis;
    private List<Cartao> cartoesNomesMetodos;
    private List<Cartao> cartoesValoresInteiros;
    private List<Cartao> cartoesValoresFracionados;
    private List<Cartao> cartoesOperadoresAtribuicao;
    private List<Cartao> cartoesOperadoresConcatenacao;


    private int contSelecao;

    public Jogador(){


        cartoesNomesVariaveis = new ArrayList<>();
        cartoesTiposInteiros = new ArrayList<>();
        cartoesTiposFracionados = new ArrayList<>();
        cartoesNomesVariaveis = new ArrayList<>();
        cartoesNomesMetodos = new ArrayList<>();
        cartoesValoresInteiros = new ArrayList<>();
        cartoesValoresFracionados = new ArrayList<>();
        cartoesOperadoresAtribuicao = new ArrayList<>();
        cartoesOperadoresConcatenacao = new ArrayList<>();

    }

    public void addCartaoTipoInteiros(Cartao cartao) {

        cartoesTiposInteiros.add(cartao);
    }

    public void addCartaoTipoFracionados(Cartao cartao) {

        cartoesTiposFracionados.add(cartao);
    }

    public void addCartaoNomeVariavel(Cartao cartao) {

        cartoesNomesVariaveis.add(cartao);
    }

    public void addCartaoOperadorAtribuicao(Cartao cartao) {

        cartoesOperadoresAtribuicao.add(cartao);
    }
    public void addCartaoOperadorConcatenacao(Cartao cartao) {

        cartoesOperadoresConcatenacao.add(cartao);
    }

    public void addCartaoValorInteiro(Cartao cartao) {

        cartoesValoresInteiros.add(cartao);
    }
    public void addCartaoValorFracionado(Cartao cartao) {

        cartoesValoresFracionados.add(cartao);
    }

    public void addCartaoNomeMetodo(Cartao cartao) {

        cartoesNomesMetodos.add(cartao);
    }

    //sets
    public void setCampeao(Campeao campeao) {
        this.campeao = campeao;
    }

    //gets

    public Campeao getCampeao(){

        return campeao;
    }

    public Cartao getCartaoTipoInteiros() {

        if(cartoesTiposInteiros.size()==0){
            return null;
        }{
            return cartoesTiposInteiros.get(contSelecao);
        }

    }

    public Cartao getCartaoNomeVariavel() {

        if(cartoesNomesVariaveis.size()==0){
            return null;
        }else{
            return cartoesNomesVariaveis.get(contSelecao);
        }

    }

    public Cartao getCartaoOperadorConcatenacao() {

        if(cartoesOperadoresConcatenacao.size()==0){
            return null;
        }else{
            return cartoesOperadoresConcatenacao.get(contSelecao);
        }

    }
    public Cartao getCartaoOperadorAtribuicao() {

        if(cartoesOperadoresAtribuicao.size()==0){
            return null;
        }else{
            return cartoesOperadoresAtribuicao.get(contSelecao);
        }

    }

    public Cartao getCartaoValorInteiro() {

        if(cartoesValoresInteiros.size()==0){
            return null;
        }else{
            return cartoesValoresInteiros.get(contSelecao);
        }
    }

    public int numSelecaoProximo() {

        int aux = 0;
        if(contSelecao == 0){
            contSelecao++;
        }else if(contSelecao > cartoesNomesVariaveis.size()){
            contSelecao = 0;
        }else{
            contSelecao++;
            aux = contSelecao;
        }
        return aux;
    }

    public Cartao getCartaoModificadorAcesso() {
        return null;
    }

    public Cartao getCartaoReturn() {

        return null;
    }

    public Cartao getCartaoNomeMetodo() {
        if(cartoesNomesMetodos.size()==0){
            return null;
        }{
            return cartoesNomesMetodos.get(contSelecao);
        }
    }

    public Cartao getCartaoTipoFracionados() {

        if(cartoesTiposFracionados.size()==0){
            return null;
        }{
            return cartoesTiposFracionados.get(contSelecao);
        }

    }

    public Cartao getCartaoValorFracionado() {

        if(cartoesValoresFracionados.size()==0){
            return null;
        }{
            return cartoesValoresFracionados.get(contSelecao);
        }
    }


}
