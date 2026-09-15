public class Main {
    public static void main(String[] args) {

        CarrinhoCinema carrinho = new CarrinhoCinema();
        HistoricoCarrinho historico = new HistoricoCarrinho();

        // 1. Usuário adiciona um ingresso e o sistema salva o estado
        carrinho.adicionarItem("Ingresso Batman", 50.0);
        historico.guardarEstado(carrinho.salvar()); // Ponto de restauração 1
        carrinho.exibirStatus();

        // 2. Usuário adiciona um combo grande por engano
        carrinho.adicionarItem("Combo Mega Gigante", 75.0);
        carrinho.exibirStatus();

        // 3. Usuário clica em "Desfazer"
        Memento estadoAnterior = historico.desfazer();
        if (estadoAnterior != null) {
            carrinho.restaurar(estadoAnterior);
        }

        // 4. Verifica se o carrinho voltou ao estado correto
        carrinho.exibirStatus();
    }
}