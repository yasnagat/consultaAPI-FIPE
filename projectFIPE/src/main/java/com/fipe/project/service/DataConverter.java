package com.fipe.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class DataConverter implements IDataConverter {
    // ObjectMapper é uma classe da biblioteca Jackson, usada para transformar json em POJO (serialização e desserialização)
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    // metodo da interface sofre override para receber infos que nao tem na interface
    public <T> T dataObtainer(String json, Class<T> classe) {
        // implementa um tratamento de exceção em razão da interface
        try {
            // recebe o JSON, a variavel json e a classe que ele representa e retorna uma instância dessa classe
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // necessário criar uma lista pois os dados json estao organizados em formato de lista de objetos do tipo da classe que vamos passar
    @Override
    public <T> List<T> newList (String json, Class<T> classe) {
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        try {
            return mapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


}
}
