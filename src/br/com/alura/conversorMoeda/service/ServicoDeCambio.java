package br.com.alura.conversorMoeda.service;

import br.com.alura.conversorMoeda.modelo.ValoresDasMoedas;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoDeCambio {
    private static final String API_KEY = "e383753eff81af67160ee35b"; // Substitua pela sua chave

    public double obterTaxaConversao(String moedaOrigem, String moedaDestino) throws IOException {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaOrigem + "/" + moedaDestino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            ValoresDasMoedas valores = gson.fromJson(response.body(), ValoresDasMoedas.class);

            if ("success".equals(valores.getResult())) {
                return valores.getConversionRate();
            } else {
                throw new IOException("Erro na API: " + valores.getErrorType());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Operação interrompida", e);
        }
    }
}
