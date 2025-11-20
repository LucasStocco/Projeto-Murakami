package app;

import  pedido.Produto;
import pedido.Item;
import pedido.Pedido;

public class MainApp {
    
    public static void main(String[] args) {
        
      Pedido p1 = criarPedido();
      
    }

    public static Pedido CriarPedido() {
          // 1 pedido com 2 itens
          Cliente murakami = new Cliente();
          murakami.setId(1);
          murakami.setNome("Murakami");
  
          Produto coca = new Produto();
          coca.setNome("Coca-cola zero");
          coca.setValor(5.50f);
  
          Produto coxinha = new Produto();
          coxinha.setNome("Coxinha");
          coxinha.setValor(10f);
  
  
          Item item1 = new Item();
          item1.setProduto(coca);
          item1.setQde(10);
  
          Item item2 = new Item();
          item2.setProduto(coxinha);
          item2.setQde(100);
  
          Pedido pedido1 = new Pedido();
          pedido1.setId(1l);
          pedido1.setCliente(murakami);
          pedido1.addItem(item1);
          pedido1.addItem(item2);

          return pedido1;
    }
      
}

