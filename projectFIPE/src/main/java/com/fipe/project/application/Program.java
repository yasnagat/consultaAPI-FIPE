package com.fipe.project.application;


import com.fipe.project.model.VehicleBrand;
import com.fipe.project.model.VehicleData;
import com.fipe.project.model.VehicleModel;
import com.fipe.project.service.APIConsumer;
import com.fipe.project.service.DataConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    private final APIConsumer consumer = new APIConsumer();
    private final DataConverter dataConverter = new DataConverter();

    public void menuExibit() {
        Scanner scanner = new Scanner(System.in);
        // 1 - usuario informa o tipo de veiculo
        System.out.print("Qual tipo de veículo você deseja buscar? ");
        String choice = scanner.nextLine();

        String ADDRESS = "https://parallelum.com.br/fipe/api/v1/";
        var search = consumer.dataObtainer(ADDRESS + choice.toLowerCase() + "/marcas");
        // a primeira requisicao retorna uma lista
        // lida com a colecao de dados com um stream
        var brand = dataConverter.newList(search, VehicleBrand.class);
        brand.stream()
                .sorted(Comparator.comparing(VehicleBrand::code))
                .forEach(System.out::println);
        // 2
        // usuario informa a marca que quer ver os modelos
        System.out.print("Informe o código da marca para listar os modelos produzidos: ");
        var codes = scanner.nextLine();

        search = consumer.dataObtainer(ADDRESS + choice.toLowerCase() + "/marcas/" + codes + "/modelos");
        var model = dataConverter.dataObtainer(search, VehicleModel.class);
        System.out.println("Modelos dessa marca: ");
        model.modelos().stream()
                .sorted(Comparator.comparing(VehicleBrand::code))
                .forEach(System.out::println);

        // 3 - pesquisa por trecho do modelo que ele quer visualizar, por exemplo PALIO.
        //- Listaremos apenas os modelos que tiverem a palavra PALIO no nome.

        System.out.print("Informe o nome do modelo para exibir: ");
        var modelName = scanner.nextLine();

        // lista da classe de marcas de veiculo chamada filteredModels que é preenchida pela sequencia de
        List<VehicleBrand> filteredModels = model.modelos().stream()
                .filter(m -> m.name().toLowerCase().contains(modelName.toLowerCase()))
                        .collect(Collectors.toList());
        System.out.println("Modelos filtrados: ");
        filteredModels.forEach(System.out::println);

        System.out.println("Agora informe o código do modelo a ser listado: ");
        var codeModel = scanner.nextLine();

        search = consumer.dataObtainer( ADDRESS + choice.toLowerCase() + "/marcas/" + codes + "/modelos" + "/" + codeModel + "/anos");

        List<VehicleBrand> years = dataConverter.newList(search, VehicleBrand.class);
        List<VehicleData> vehicles = new ArrayList<>();

        for (int i = 0; i < years.size(); i++) {
            var yearsAddress =  ADDRESS + choice.toLowerCase() + "/marcas/" + codes + "/modelos/" + codeModel + "/anos/" + years.get(i).code();
            var json = consumer.dataObtainer(yearsAddress);
            System.out.println("JSON retornado: " + json);

            VehicleData vehicle = dataConverter.dataObtainer(json, VehicleData.class);
            vehicles.add(vehicle);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
        vehicles.forEach(System.out::println);

    }

}








