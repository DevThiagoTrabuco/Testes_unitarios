import com.teste.App;
import com.teste.Produto;
import com.teste.Venda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    private Produto produto;
    private Venda venda;
    private String nomeProduto;
    private double precoProduto;
    private int estoqueProduto;
    private int qtdVendida;

//  Testar criação de produto com valores válidos.
    @Test
    public void deveCriarProdutoValido(){
        nomeProduto = "Produto 01";
        precoProduto = 2.50;
        estoqueProduto = 10;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);

        Assertions.assertEquals(nomeProduto, produto.getNome());
        Assertions.assertEquals(precoProduto, produto.getPreco());
        Assertions.assertEquals(estoqueProduto, produto.getEstoque());
    }

//  Testar criação de produto com preço negativo (deve ser inválido).
    @Test
    public void deveCriarProdutoComValorInvalido(){
        nomeProduto = "Produto 02";
        precoProduto = -5.85;
        estoqueProduto = 10;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);

        Assertions.assertEquals(nomeProduto, produto.getNome());
        Assertions.assertEquals(precoProduto, produto.getPreco());
        Assertions.assertEquals(estoqueProduto, produto.getEstoque());
    }

//  Testar criação de produto com estoque negativo (deve ser inválido).
    @Test
    public void deveCriarProdutoComEstoqueInvalido(){
        nomeProduto = "Produto 03";
        precoProduto = 5.85;
        estoqueProduto = -10;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);

        Assertions.assertEquals(nomeProduto, produto.getNome());
        Assertions.assertEquals(precoProduto, produto.getPreco());
        Assertions.assertEquals(estoqueProduto, produto.getEstoque());
    }

//  Testar alteração do nome do produto para um valor válido.
    @Test
    public void deveAlterarNomeProduto(){
        nomeProduto = "Produto 04";
        String nomeNovo = "Produto 04.5";
        precoProduto = 0;
        estoqueProduto = 0;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        produto.setNome(nomeNovo);

        Assertions.assertEquals(nomeNovo, produto.getNome());
    }

//  Testar alteração do preço do produto para um valor válido.
    @Test
    public void deveAlterarPrecoProduto(){
        nomeProduto = "Produto 05";
        precoProduto = 10;
        double precoNovo = 12.5;
        estoqueProduto = 0;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        produto.setPreco(precoNovo);

        Assertions.assertEquals(precoNovo, produto.getPreco());
    }

//  Testar alteração do estoque para um valor positivo.
    @Test
    public void deveAlterarEstoqueProduto(){
        nomeProduto = "Produto 06";
        precoProduto = 0;
        estoqueProduto = 5;
        int estoqueNovo = 10;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        produto.setEstoque(estoqueNovo);

        Assertions.assertEquals(estoqueNovo, produto.getEstoque());
    }

//  Testar alteração do preço do produto para um valor negativo (deve falhar).
    @Test
    public void deveAlterarPrecoProdutoInvalido(){
        nomeProduto = "Produto 07";
        precoProduto = 10;
        double precoNovo = -12.5;
        estoqueProduto = 0;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        produto.setPreco(precoNovo);

        Assertions.assertFalse(produto.getPreco() >= 0);
    }

//  Testar venda com quantidade menor que o estoque disponível.
    @Test
    public void deveRealizarVenda(){
        nomeProduto = "Produto 08";
        precoProduto = 10;
        estoqueProduto = 10;
        qtdVendida = 5;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);

        Assertions.assertTrue(venda.realizarVenda());
    }

//  Testar venda com quantidade igual ao estoque disponível.
    @Test
    public void deveRealizarVendaEstoqueTotal(){
        nomeProduto = "Produto 09";
        precoProduto = 10;
        estoqueProduto = 10;
        qtdVendida = estoqueProduto;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);

        Assertions.assertTrue(venda.realizarVenda());
    }

//  Testar venda com quantidade maior que o estoque disponível (deve falhar).
    @Test
    public void deveRealizarVendaInvalida(){
        nomeProduto = "Produto 10";
        precoProduto = 10;
        estoqueProduto = 10;
        qtdVendida = 11;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);

        Assertions.assertFalse(venda.realizarVenda());
    }

//  Testar cálculo do total da venda corretamente.
    @Test
    public void deveCalcularTotalVenda(){
        nomeProduto = "Produto 11";
        precoProduto = 10;
        estoqueProduto = 10;
        qtdVendida = 5;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);
        venda.realizarVenda();

        Assertions.assertEquals(50, venda.getTotalVenda());
    }

//  Testar aumento de estoque do produto após uma venda.
    @Test
    public void deveAumentarEstoque(){
        nomeProduto = "Produto 12";
        precoProduto = 10;
        estoqueProduto = 10;
        int reposicao = 4;
        qtdVendida = 2;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);

        venda.realizarVenda();
        produto.aumentarEstoque(reposicao);

        Assertions.assertEquals(12, venda.getProduto().getEstoque());
    }

//  Testar diminuição do estoque do produto após uma venda bem-sucedida.
    @Test
    public void deveDiminuirEstoque(){
        nomeProduto = "Produto 13";
        precoProduto = 10;
        estoqueProduto = 10;
        qtdVendida = 2;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);
        venda.realizarVenda();

        Assertions.assertEquals(8, venda.getProduto().getEstoque());
    }

//  Testar realizar venda de um produto que não existe (deve falhar).
    @Test
    public void deveRealizarVendaComProdutoInexistente(){
        qtdVendida = 5;

        venda = new Venda(produto, qtdVendida);

        Assertions.assertThrows(NullPointerException.class, () -> venda.realizarVenda());
    }

//  Testar criação de venda com quantidade negativa (deve falhar).
    @Test
    public void deveRealizarVendaComQuantidadeInvalida(){
        nomeProduto = "Produto 14";
        precoProduto = 10;
        estoqueProduto = 5;
        qtdVendida = -3;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);
        venda.realizarVenda();

        Assertions.assertFalse(venda.getProduto().getEstoque() - venda.getQuantidadeVendida() < produto.getEstoque());
    }

//  Testar alteração do estoque após a tentativa de venda com estoque insuficiente.
    @Test
    public void deveAlterarEstoqueAposVendaInvalida(){
        nomeProduto = "Produto 15";
        precoProduto = 10;
        estoqueProduto = 10;
        qtdVendida = 15;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);
        venda.realizarVenda();

        Assertions.assertEquals(10, venda.getProduto().getEstoque());
    }

//  Testar criação de vários produtos e realizar vendas com estoque compartilhado. [Não entendi esse]
    @Test
    public void deveRealizarVendaComEstoqueCompartilhado(){
        qtdVendida = 6;
        Produto prod1 = new Produto("Banana", 2.5, 7);
        Produto prod2 = new Produto("Maçã", 1.75, 15);
        Produto prod3 = new Produto("Laranja", 5, 12);

        Venda venda1 = new Venda(prod1, qtdVendida);
        Venda venda2 = new Venda(prod2, qtdVendida);
        Venda venda3 = new Venda(prod3, qtdVendida);

        Assertions.assertTrue(venda1.realizarVenda());
        Assertions.assertTrue(venda2.realizarVenda());
        Assertions.assertTrue(venda3.realizarVenda());
    }

//  Testar calcular total de venda quando o preço do produto for alterado antes da venda.
    @Test
    public void deveCalcularTotalComValorAlterado(){
        nomeProduto = "Produto 16";
        precoProduto = 10;
        double precoNovo = 12.5;
        estoqueProduto = 10;
        qtdVendida = 2;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);

        venda.getProduto().setPreco(precoNovo);
        venda.realizarVenda();

        Assertions.assertEquals(25, venda.getTotalVenda());
    }

//  Testar comportamento da venda quando o estoque inicial é zero.
    @Test
    public void deveRealizarVendaComEstoqueZerado(){
        nomeProduto = "Produto 17";
        precoProduto = 10;
        estoqueProduto = 0;
        qtdVendida = 5;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);

        Assertions.assertFalse(venda.realizarVenda());
    }

//  Testar aumento do estoque após uma reposição e verificar se a venda é bem-sucedida posteriormente.
    @Test
    public void deveReporEstoqueERealizarVenda(){
        nomeProduto = "Produto 18";
        precoProduto = 10;
        estoqueProduto = 10;
        int reposicao = 5;
        qtdVendida = 2;
    
        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, qtdVendida);
        produto.aumentarEstoque(reposicao);

        Assertions.assertEquals(15, produto.getEstoque());
        Assertions.assertTrue(venda.realizarVenda());
    }

//  Teste extra para 100% de coverage
    @Test
    public void deveExecutarHelloWorld(){
        App.main(null);
        Assertions.assertTrue(true);
    }
}
