public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Pessoa Física:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + cpf);
    }
}