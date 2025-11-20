import java.util.ArrayList;

public class Pedido{

   
    private Long id;
    private Cliente cliente;
    private ArrayList<Item> itens;

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Float getValorTotal() {
        Float total = 0f;
        for(Item item : getItens()){
            total = total + item.getValorTotal();
        }
        return total;
    }

    public void addItem(Item item) {
      getItens().add(item) ;
    }
    

}