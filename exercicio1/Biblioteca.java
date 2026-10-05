public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private int totalItens;

    public Biblioteca(int capacidade) {
        this.acervo = new ItemBiblioteca[capacidade];
        this.totalItens = 0;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if (totalItens < acervo.length) {
            acervo[totalItens] = item;
            totalItens++;
        } else {
            System.out.println("Acervo cheio! Não é possível adicionar " + item.getTitulo());
        }
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        if (usuario.getQuantidadeEmprestada() >= usuario.getLimiteItens()) {
            System.out.println("Empréstimo Recusado: " + usuario.getNome() + " atingiu o limite de itens.");
            return false;
        }

        if (!item.isDisponivel()) {
            System.out.println("Empréstimo Recusado: O item '" + item.getTitulo() + "' não está disponível.");
            return false;
        }

        item.setDisponivel(false);
        usuario.incrementarEmprestimo();
        System.out.println("Empréstimo Sucesso: '" + item.getTitulo() + "' emprestado para " + usuario.getNome() + ".");
        return true;
    }

    public boolean devolver(Usuario usuario, ItemBiblioteca item) {
        if (item.isDisponivel()) {
            System.out.println("Devolução Falhou: O item '" + item.getTitulo() + "' já está no acervo.");
            return false;
        }

        item.setDisponivel(true);
        usuario.decrementarEmprestimo();
        System.out.println("Devolução Sucesso: '" + item.getTitulo() + "' devolvido por " + usuario.getNome() + ".");
        return true;
    }

    public void listarAcervo() {
        System.out.println("\n--- ACERVO DA BIBLIOTECA ---");
        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca item = acervo[i];
            String status = item.isDisponivel() ? "Disponível" : "Emprestado";
            System.out.println("Código: " + item.getCodigo() +
                               " | Título: " + item.getTitulo() +
                               " | Prazo: " + item.getPrazoEmprestimo() + " dias" +
                               " | Multa/Dia: R$ " + item.getValorMultaPorDia() +
                               " | Status: " + status);
        }
        System.out.println("-----------------------------\n");
    }
}
