package com.fipe.project.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// realiza as requisições e recebe as respostas da API
public class APIConsumer {

    public String dataObtainer(String address) {
        // comunicação com o servidor: inicia a requisicao e recebe as respostas
        HttpClient client = HttpClient.newHttpClient();

        // define o metodo http get da requisicao - também pode definir cabeçalho, corpo e outros parametros da requisicao
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        // recebe a resposta da requisicao
        // inicia a variavel com um valor explicito, sendo que ela vai ser preenchida dentro do try-catch
        HttpResponse<String> response = null;

        try {
            // .send recebe a resposta como objeto HttpResponse
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }
}