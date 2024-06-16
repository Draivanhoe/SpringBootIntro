package com.esercizio01.entities;

public class User {

    private String nome;
    private String regione;
    private String saluto;

    public User() {
    }

    public User(String nome, String regione) {
        this.nome = nome;
        this.regione = regione;
        this.saluto = "Ciao " + this.nome + ", com'è il tempo in " + this.regione + "?";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getSaluto() {
        return saluto;
    }

    public void setSaluto(String saluto) {
        this.saluto = saluto;
    }
}