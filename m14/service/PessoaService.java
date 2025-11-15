package service;

import model.Pessoa;
import java.util.ArrayList;
import java.util.Iterator;

public class PessoaService {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrarPessoa(String nome, String email) {
        pessoas.add(new Pessoa(contadorId++, nome, email));
    }

    public ArrayList<Pessoa> listarPessoas() {
        // Retornar uma cópia para evitar que o código externo modifique a lista interna
        return new ArrayList<>(pessoas);
    }

    public boolean atualizarPessoa(int id, String novoNome, String novoEmail) {
        for(Pessoa p : pessoas) {
            if(p.getId() == id) {
                p.setNome(novoNome);
                p.setEmail(novoEmail);
                return true;
            }
        }
        return false;
    }

    public boolean deletarPessoa(int id) {
        // Usar iterator para remover com segurança durante a iteração
        Iterator<Pessoa> it = pessoas.iterator();
        while (it.hasNext()) {
            Pessoa p = it.next();
            if (p.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
