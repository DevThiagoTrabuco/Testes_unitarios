package applications;

import com.teste.applications.ProductApplication;
import com.teste.entities.Product;
import com.teste.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductApplicationTest {
    private Product product;

    @InjectMocks
    ProductApplication ProductApplication;

    @Mock
    ProductService ProductService;

    @BeforeEach
    public void setUp(){
        product = new Product(1, "Hamburguer", 10.4f, "C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\atividade_casa_02\\imagens\\origem\\amburgue.jpeg");
    }

//  Deve salvar a imagem corretamente.
    @Test
    public void deveSalvarImagem(){
        //Arrange
        ProductApplication.append(product);
        //Act
        //Assert
        Mockito.verify(ProductService).save(product);
    }
//  Deve remover a imagem corretamente.
    @Test
    public void deveRemoverImagem(){
        //Arrange
        ProductApplication.remove(product.getId());
        //Act
        //Assert
        Mockito.verify(ProductService).remove(product.getId());
    }
//  Deve atualizar a imagem corretamente.
    @Test
    public void deveAtualizarImagem(){
        //Arrange
        ProductApplication.append(product);
        product.setImage("C:\\Users\\thiag\\Documents\\Github\\Testes_unitarios\\atividade_casa_02\\imagens\\origem\\rotdogue.jpeg");

        //Act
        ProductApplication.update(product.getId(), product);

        //Assert
        Mockito.verify(ProductService).update(product);
    }

}
