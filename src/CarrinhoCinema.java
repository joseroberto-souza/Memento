import java.util.ArrayList;
import java.util.List;

public class CarrinhoCinema {
    private List<String> itens = new ArrayList<>();
    private double valorTotal = 0;

    public void adicionarItem(String item, double preco){
        this.itens.add(item);
        this.valorTotal += preco;
        System.out.println("Adicionado: "+item+" "+ "R$: "+preco );
    }
    public Memento salvar(){
        return new CarrinhoMementoConcrete(new ArrayList<>(this.itens),this.valorTotal);
    }

    public void restaurar(Memento memento){
        if(memento instanceof CarrinhoMementoConcrete estadoSalvo){
            this.itens = estadoSalvo.getItens();
            this.valorTotal = estadoSalvo.getValorTotal();
            System.out.println("Estado restaurado");
        }
    }

    public void exibirStatus() {
        System.out.println("Estado Atual do Carrinho: " + itens + " | Total: R$ " + valorTotal);
    }

    private static class  CarrinhoMementoConcrete implements Memento{
        private final List<String> itens;
        private final double valorTotal;


        private CarrinhoMementoConcrete(List<String> itens, double valorTotal) {
            this.itens = itens;
            this.valorTotal = valorTotal;
        }
        public List<String> getItens(){
            return itens;
        }
        public double getValorTotal(){
            return valorTotal;
        }
    }
}
