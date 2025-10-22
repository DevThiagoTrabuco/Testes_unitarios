package applications;

import entities.Product;
import repositories.ProductRepository;
import services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductApplicationTest {
    ProductService productService;
    ProductRepository productRepository;
    ProductApplication productApplication;
    Product product1;
    Product product2;

    @BeforeEach
    public void setup() {
        productService = new ProductService();
        productRepository = new ProductRepository();
        productApplication = new ProductApplication(productRepository, productService);

        product1 = new Product(1, "Hot Dog", 10.4f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\cachorroquente.jpeg");
        product2 = new Product(2, "Hamburguer", 15.0f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\amburguer.jpeg");
    }

//1. Listar todos os produtos do repositório
    @Test
    public void listarTodosOsProdutos(){
        //Arrange
        productApplication.append(product1);
        productApplication.append(product2);
        //Act
        List<Product> productList = productApplication.getAll();
        //Assert
        assertEquals(2, productList.size());
    }

//2. Obter um produto por ID válido
    @Test
    public void obterProdutoValido(){
        //Arrange
        productApplication.append(product1);
        //Assert
        assertEquals(product1, productApplication.getById(product1.getId()));
    }

//3. Retornar nulo ou erro ao tentar obter produto por ID inválido
    @Test
    public void buscarProdutoNulo(){
        //Assert
        assertThrows(NoSuchElementException.class, () -> productApplication.getById(99));
    }

//4. Verificar se um produto existe por ID válido
    @Test
    public void buscarProdutoPorId(){
        //Arrange
        productApplication.append(product1);
        //Assert
        assertTrue(productApplication.exists(product1.getId()));
    }

//5. Retornar falso ao verificar a existência de um produto com ID inválido
    @Test
    public void confirmarExistenciaDeIdInvalido(){
        //Assert
        assertFalse(productApplication.exists(99));
    }

//6. Adicionar um novo produto e salvar sua imagem corretamente
    @Test
    public void adicionarProdutoComSucesso(){
        //Arrange
        productApplication.append(product1);
        //Assert
        assertEquals(product1.getId(), productApplication.getById(product1.getId()).getId());
    }

//7. Remover um produto existente e deletar sua imagem
    @Test
    public void removerProdutoExistente(){
        //Arrange
        productApplication.append(product1);
        //Act
        productApplication.remove(product1.getId());
        //Assert
        assertThrows(NoSuchElementException.class,() ->{productApplication.getById(product1.getId());});
    }

//8. Não alterar o sistema ao tentar remover um produto com ID inexistente
    @Test
    public void removerProdutoInexistente(){
        //Arrange
        productApplication.append(product1);
        //Act
        productApplication.remove(1);
        //Assert
        assertThrows(NoSuchElementException.class, () -> productApplication.remove(1));

    }

//9. Atualizar um produto existente e substituir sua imagem
    @Test
    public void atualizarProdutoExistente(){
        productApplication.append(product1);

        Product newProduct = new Product(1, "Hamburguer", 10.4f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\amburgue.jpeg");
        productApplication.update(newProduct.getId(), newProduct);

        File arquivo = new File(productService.getImagePathById(1));
        assertTrue(arquivo.exists());

    }
}
