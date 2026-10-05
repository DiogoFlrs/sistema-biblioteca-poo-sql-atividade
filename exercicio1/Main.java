public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10);

        Livro livro1 = new Livro("L01", "Java para Iniciantes");
        Livro livro2 = new Livro("L02", "Estrutura de Dados");
        Livro livro3 = new Livro("L03", "Banco de Dados Relacional");
        Revista revista1 = new Revista("R01", "Tech Monthly");

        Aluno aluno = new Aluno("Carlos Silva"); // Limite no máximo é para ser de 3 itens.

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(livro3);
        biblioteca.adicionarItem(revista1);

        biblioteca.listarAcervo();

     
        biblioteca.emprestar(aluno, livro1);
        biblioteca.emprestar(aluno, livro2);
        biblioteca.emprestar(aluno, revista1);

      //(Tentativa de criação de empréstimo bem sucedido)
        biblioteca.emprestar(aluno, livro3);

        biblioteca.listarAcervo();
    }
}
