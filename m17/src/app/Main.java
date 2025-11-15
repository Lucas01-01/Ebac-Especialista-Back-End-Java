package app;

import app.model.*;
import app.service.*;

public class Main {
    public static void main(String[] args) {
        ListaCarros<Carro> garagem = new ListaCarros<>();

        garagem.adicionarCarro(new Honda("Civic"));
        garagem.adicionarCarro(new Toyota("Corolla"));
        garagem.adicionarCarro(new Ford("Mustang"));

        garagem.exibirTodos();
    }
}
