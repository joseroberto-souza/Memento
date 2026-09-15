import java.util.Stack;

public class HistoricoCarrinho {
    private final Stack<Memento> historico = new Stack<>();

    public void guardarEstado(Memento memento){
        historico.push(memento);
    }

    public Memento desfazer(){
        if(historico.isEmpty()){
            System.out.println("Nenhum histórioco encontrado");
            return null;
        }
        return historico.pop();
    }

}
