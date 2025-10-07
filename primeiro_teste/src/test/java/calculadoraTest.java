import com.teste.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class calculadoraTest {
    private Calculadora calculadora;
    double vA, vB;
    double result;

    @BeforeEach
    public void setup(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisValores(){
        Assertions.assertEquals(30, calculadora.somar(10, 20));
    }

    @Test
    public void deveSubtrairDoisValores(){
        vA = 20;
        vB = 10;
        result = calculadora.subtrair(vA, vB);

        Assertions.assertEquals(10, result);
    }

    @Test
    public void deveMultiplicarDoisValores() {
        vA = 10;
        vB = 2;
        result = calculadora.multiplicar(vA, vB);

        Assertions.assertEquals(20, result);
    }

    @Test
    public void deveDividirDoisValores() {
        vA = 10;
        vB = 2;
        result = calculadora.dividir(vA, vB);

        Assertions.assertEquals(5, result);
    }
}
