public class Main {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica("Lucas Costa", "123.456.789-00");
        PessoaJuridica pj = new PessoaJuridica("NomadMind LTDA", "12.345.678/0001-99");

        pf.exibirInformacoes();
        System.out.println();
        pj.exibirInformacoes();
    }
}
