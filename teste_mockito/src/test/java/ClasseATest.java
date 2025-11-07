import models.ClasseA;
import models.ClasseB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClasseATest {
    @InjectMocks
    ClasseA classeA;

    @Mock
    ClasseB classeB;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void testaSomarValores(){
        Mockito.when(classeB.getX()).thenReturn(20);

        Assertions.assertEquals(25, classeA.somarValores());
    }
}
