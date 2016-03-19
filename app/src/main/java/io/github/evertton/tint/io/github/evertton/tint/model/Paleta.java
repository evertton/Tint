package io.github.evertton.tint.io.github.evertton.tint.model;

import java.util.ArrayList;

public class Paleta {

    public static ArrayList<Paleta> lista = new ArrayList<Paleta>();

    private String nome;
    private ArrayList<String> cores;

    public Paleta(String nome) {
        this.nome = nome;
        cores = new ArrayList<String>();
    }

    public void addCor(String cor) {
        cores.add(cor);
    }

    public ArrayList<String> getCores() {
        return cores;
    }

    public String getNome() {
        return nome;
    }

}
