import com.teste.models.Jogador;
import com.teste.models.Jogo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JogoTest {
    @Mock
    Jogador jogador;

    @InjectMocks
    Jogo jogo;

    @Test
    public void testarMagiaLancada(){
        Mockito.when(jogador.getMagia()).thenReturn("Fogo");

        assertEquals("Jogador X lançou a magia: Fogo", jogo.soltarMagia());
    }

    @Test
    public void testarIniciodoJogo(){
        this.jogo.iniciarJogo();
        Mockito.verify(jogador, Mockito.times(1)).realizarAlgo();
    }
}
