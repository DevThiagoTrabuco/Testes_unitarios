package facade;

import applications.ProductApplication;
import entities.Product;
import repositories.ProductRepository;
import services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFacadeTest {
    ProductService productService;
    ProductRepository productRepository;
    ProductApplication productApplication;
    ProductFacade productFacade;
    Product product1;
    Product product2;

    @BeforeEach
    public void setup() {
        productService = new ProductService();
        productRepository = new ProductRepository();
        productApplication = new ProductApplication(productRepository, productService);
        productFacade = new ProductFacade(productApplication);

        product1 = new Product(1, "Hot Dog", 10.4f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\cachorroquente.jpeg");
        product2 = new Product(2, "Hamburguer", 15.0f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\amburgue.jpeg");
    }

//1. Retornar a lista completa de produtos ao chamar o metodo getAll.
    @Test
    public void retornarTodosOsProdutos() {
        //Arrange
        productFacade.append(product1);
        productFacade.append(product2);
        //Act
        List<Product> produtos = productFacade.getAll();
        //Assert
        assertEquals(2, produtos.size());
        assertTrue(produtos.contains(product1));
        assertTrue(produtos.contains(product2));
    }

//2. Retornar o produto correto ao fornecer um ID válido no metodo getById.
    @Test
    public void retornarProdutoValido() {
        //Arrange
        productFacade.append(product1);
        //Act
        Product productId1 = productFacade.getById(product1.getId());
        //Assert
        assertEquals(productId1.getId(), product1.getId());
        assertEquals(productId1.getDescription(), product1.getDescription());
        assertEquals(productId1.getPrice(), product1.getPrice());

        File arquivo = new File(productService.getImagePathById(1));
        assertTrue(arquivo.exists());

    }

//3. Retornar true para um ID existente e false para um ID inexistente no metodo exists.
    @Test
    public void retornarSeProdutoExisteOuNao() {
        //Arrange
        productFacade.append(product1);
        //Assert
        assertTrue(productFacade.exists(product1.getId()));
        assertFalse(productFacade.exists(99));
    }

//4. Adicionar um novo produto corretamente ao chamar o metodo append.
    @Test
    public void adicionarProduto() {
        //Arrange
        productFacade.append(product1);
        //Assert
        assertTrue(productFacade.exists(product1.getId()));
    }

//5. Remover um produto existente ao fornecer um ID válido no metodo remove.
    @Test
    public void removerProduto(){
        //Arrange
        productFacade.append(product1);
        //Act
        productFacade.remove(product1.getId());
        //Assert
        assertThrows(NoSuchElementException.class,() -> productFacade.getById(product1.getId()));
    }

}
