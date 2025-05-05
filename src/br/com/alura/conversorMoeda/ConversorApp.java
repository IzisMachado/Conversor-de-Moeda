package br.com.alura.conversorMoeda;

import br.com.alura.conversorMoeda.service.ServicoDeCambio;

import java.io.IOException;

public class ConversorApp {
    private final ServicoDeCambio servicoDeCambio = new ServicoDeCambio();

    public double converter(String moedaOrigem, String moedaDestino, double valor) throws IOException {
        double taxa = servicoDeCambio.obterTaxaConversao(moedaOrigem, moedaDestino);
        return valor * taxa;
    }
}
