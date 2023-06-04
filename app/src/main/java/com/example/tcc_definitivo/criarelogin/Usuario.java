package com.example.tcc_definitivo.criarelogin;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String localidade;

    public Usuario(String String1,String String2) {
        this.email=String1;
        this.senha=String2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
