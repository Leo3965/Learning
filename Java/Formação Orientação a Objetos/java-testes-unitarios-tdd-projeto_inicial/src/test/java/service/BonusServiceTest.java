package service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    BonusService service = new BonusService();

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Léo", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Léo", LocalDate.now(), new BigDecimal("2200")));
        assertEquals(new BigDecimal("220.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
        int salario = 10000;
        BigDecimal bonus = service.calcularBonus(new Funcionario("Léo", LocalDate.now(), new BigDecimal(salario)));

        assertEquals(
                new BigDecimal(salario*0.1).setScale(2),
                bonus
        );
    }
}
