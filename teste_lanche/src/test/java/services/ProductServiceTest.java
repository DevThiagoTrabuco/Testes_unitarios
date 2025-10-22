package services;

import entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {
    private ProductService productService;
    private Product product;

    @BeforeEach
    public void setup() {
        productService = new ProductService();
        product = new Product(1, "Hot Dog", 10.4f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\cachorroquente.jpeg");
    }

// 1. Salvar um produto com imagem válida
    @Test
    public void salvarProdutoComImagemValida() {
        boolean result = productService.save(product);
        //Assert
        assertTrue(result);
    }
// 2. Salvar um produto com imagem inexistente
    @Test
    public void salvarProdutoComImagemInexistente(){
        //Arrange
        product.setImage("C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\soda.jpeg");
        //Act
        boolean result = productService.save(product);
        //Assert
        assertFalse(result);
    }

// 3. Atualizar um produto existente
    @Test
    public void atualizarProdutoExistente(){
        //Arrange
        productService.save(product);
        Product product2 = new Product(1, "Hamburguer", 2.5f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\teste_lanche\\imagens_originais\\amburgue.jpeg");
        //Act
        productService.update(product2);
        //Assert
        File arquivo = new File(productService.getImagePathById(1));
        assertTrue(arquivo.exists());
    }

// 4. Remover um produto existente
    @Test
    public void removerProdutoExistente(){
        //Arrange
        productService.save(product);
        //Act
        productService.remove(1);
        //Assert
        assertThrows(NoSuchElementException.class, () -> productService.getImagePathById(1));
    }

// 5. Obter caminho da imagem por ID
    @Test
    public void obterCaminhoDaImagemPorId(){
        //Arrange
        productService.save(product);
        //Act
        String imagePath = productService.getImagePathById(1);
        //Assert
        assertNotNull(imagePath);
    }
}
