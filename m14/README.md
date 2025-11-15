Como configurar e compilar o projeto Java

Passos rápidos para Windows (PowerShell)

1. Instale o JDK (OpenJDK ou Oracle JDK). Ao final da instalação, verifique o diretório de instalação, por exemplo:

    C:\Program Files\Java\jdk-25\bin

2. Teste temporariamente na sessão atual do PowerShell (substitua o caminho pelo seu):

    $env:PATH = 'C:\Program Files\Java\jdk-XX\bin;' + $env:PATH
    javac -version
    java -version

3. Para tornar permanente (GUI recomendada):
   - Abra Configurações → Sistema → Sobre → Configurações avançadas do sistema → Variáveis de Ambiente.
   - Em "Variáveis do sistema" edite `Path` e adicione `C:\Program Files\Java\jdk-XX\bin`.
   - Abra novo PowerShell e verifique:

    javac -version
    java -version

    Alternativa (linha de comando) — use com cuidado:
    - No PowerShell execute (substitua se seu JDK estiver em outro caminho):

         setx PATH "%PATH%;C:\Program Files\Java\jdk-25\bin"

    - Abra uma nova janela do PowerShell e rode `javac -version` para confirmar.

4. Compilar e executar o projeto (na pasta do projeto):

    # Com packages (recomendado)
    javac -d . CadastroCRUD.java model\Pessoa.java service\PessoaService.java
    java CadastroCRUD

    # Sem packages (não-recomendado para produção)
    javac *.java
    java CadastroCRUD

5. Observações
 - Se `javac` não for encontrado, verifique o PATH e a versão do JDK instalada.
 - Mantenha a estrutura de diretórios correspondente às declarações `package`.
