package com.fipe.project.service;
// interface para definir o metodo que a classe de serviço DataConverter deve implementar
// uma interface é uma lista de métodos que definem o comportamento de um objeto

import java.util.List;

public interface IDataConverter {
    // todos os metodos da interfaces sao implicitamente publicos
    // Class<T> classe porque a classe do parametro pode ser qualquer uma
    // no caso, esse metodo vai retornar uma implementaçao de qualquer classe que for do json
    <T> T dataObtainer(String json, Class<T> classe);

    <T> List<T> newList (String json, Class<T> classe);
}
