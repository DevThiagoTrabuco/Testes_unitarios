package com.teste.models;

public class Jogo {
    private final Jogador jogador;

    public Jogo(Jogador jogador){
        this.jogador = jogador;
    }

    public String soltarMagia(){
        return "Jogador X lançou a magia: " + jogador.getMagia();
    }

    public void iniciarJogo(){
        System.out.println("O jogo começou.");
        jogador.realizarAlgo();
    }
}
