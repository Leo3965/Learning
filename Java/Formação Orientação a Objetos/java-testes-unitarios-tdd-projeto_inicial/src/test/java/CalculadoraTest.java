import br.com.alura.tdd.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void deveriaSomarDoisNumerosPositivos() {
        Calculadora calculadora = new Calculadora();
        int soma = calculadora.soma(3, 7);
        assertEquals(soma, 10);
    }
}
