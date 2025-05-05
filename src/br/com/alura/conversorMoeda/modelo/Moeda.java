package br.com.alura.conversorMoeda.modelo;

public class Moeda {
    private String codigo;
    private String nome;
    private double valor;

    public Moeda(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
