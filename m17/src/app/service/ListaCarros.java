package app.service;

import java.util.ArrayList;
import java.util.List;
import app.model.Carro;

public class ListaCarros<T extends Carro> {
    private List<T> lista = new ArrayList<>();

    public void adicionarCarro(T carro) {
        lista.add(carro);
    }

    public void exibirTodos() {
        for (T carro : lista) {
            carro.exibirInfo();
        }
    }
}
