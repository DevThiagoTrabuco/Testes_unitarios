import com.teste.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class calculadoraTest {
    private Calculadora calculadora;
    double vA = 10, vB = 5;
    double result;

    @BeforeEach
    public void setup(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisValores(){
        result = calculadora.somar(vA, vB);
        Assertions.assertEquals(15, result);
    }

    @Test
    public void deveSubtrairDoisValores(){
        result = calculadora.subtrair(vA, vB);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void deveMultiplicarDoisValores() {
        result = calculadora.multiplicar(vA, vB);
        Assertions.assertEquals(50, result);
    }

    @Test
    public void deveDividirDoisValores() {
        result = calculadora.dividir(vA, vB);
        Assertions.assertEquals(2, result);
    }
}
