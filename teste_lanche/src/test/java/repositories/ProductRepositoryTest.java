package repositories;

import entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository productRepository;
    private Product product1;

    @BeforeEach
    public void setup() {
        productRepository = new ProductRepository();
        product1 = new Product(1, "Hot Dog", 10.4f, "");
    }

//1. Verificar se um produto é adicionado corretamente ao repositório (List)
    @Test
    public void verificarSeOProdutoEstaNoArray() {
        // Arrange
        productRepository.append(product1);
        // Act
        Product productId1 = productRepository.getById(1);
        // Assert
        assertNotNull(productId1);
    }

//2. Verificar se é possível recuperar um produto usando seu ID
    @Test
    public void recuperarProdutoPorId(){
        // Arrange
        productRepository.append(product1);
        //Act
        Product productId1 = productRepository.getById(1);
        //Assert
        assertEquals(productId1, product1);
    }

//3. Confirmar se um produto existe no repositório (List)
    @Test
    public void confirmarExistenciaDeProduto(){
        //Arrange
        productRepository.append(product1);
        //Assert
        assertTrue(productRepository.exists(1));
    }

//4. Testar se um produto é removido corretamente do repositório (List)
    @Test
    public void confirmarRemocaoDeProduto(){
        //Arrange
        productRepository.append(product1);
        //Act
        productRepository.remove(1);
        //Assert
        assertFalse(productRepository.exists(1));
    }

//5. Verificar se um produto é atualizado corretamente
    @Test
    public void confirmarAtualizacaoDeProduto(){
        //Arrange
        productRepository.append(product1);
        Product product2 = new Product(1, "Hamburguer", 2.5f, "");
        //Act
        productRepository.update(1, product2);
        //Assert
        assertEquals(product2.getDescription(), productRepository.getById(1).getDescription());
    }

//6. Testar se todos os produtos armazenados são recuperados corretamente
    @Test
    public void confirmarRecuperacaoDosProdutos(){
        //Arrange
        Product product2 = new Product(2, "Hamburguer", 2.5f, "");
        productRepository.append(product1);
        productRepository.append(product2);
        //Act
        List<Product> products = productRepository.getAll();
        //Assert
        assertEquals(2, products.size());
    }

//7. Verificar o comportamento ao tentar remover um produto que não existe
    @Test
    public void verificarRemocaoDeProdutoInexistente(){
        //Arrange
        productRepository.append(product1);
        //Act
        productRepository.remove(99);
        //Assert
        assertEquals(1, productRepository.getAll().size());
    }

//8. Testar o que acontece ao tentar atualizar um produto que não está no repositório (List)
    @Test
    public void verificarAtualizacaoDeProdutoInexistente(){
        //Arrange
        Product product2 = new Product(2, "Hamburguer", 2.5f, "");
        //Assert
        assertThrows(NoSuchElementException.class, () -> productRepository.update(99, product2));
    }
//9. Verificar se o repositório aceita a adição de produtos com IDs duplicados (espera-se que não)
    @Test
    public void VerificarAdicaoDeProdutoComIdDuplicado(){
        //Arrange
        productRepository.append(product1);
        Product product2 = new Product(1, "Hamburguer", 2.5f, "");
        //Act
        productRepository.append(product2);
        //Assert
        assertNotEquals(1, productRepository.getAll().size());
    }

//10. Confirmar que o repositório retorna uma lista vazia ao ser inicializado (List)
    @Test
    public void confirmarListaVaziaAoInicializar(){
        //Assert
        assertTrue(productRepository.getAll().isEmpty());
    }
}
