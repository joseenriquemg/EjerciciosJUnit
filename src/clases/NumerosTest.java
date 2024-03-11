package clases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumerosTest {

	@ParameterizedTest
	@MethodSource("esPrimo")
	void testEsPrimo(boolean expected, int numero) {
		// Me creo el objeto porque no es estático
		Numeros n = new Numeros(numero);
		boolean resultado = n.esPrimo();
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> esPrimo() {
		return Stream.of(Arguments.of(true, 3), Arguments.of(false, 14), Arguments.of(true, -1)

		);
	}

	@ParameterizedTest
	@MethodSource("esCapicua")
	void testEsCapicua(boolean expected, int numero) {
		// Me creo el objeto porque no es estático
		Numeros n = new Numeros(numero);
		boolean resultado = n.esCapicua();
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> esCapicua() {
		return Stream.of(Arguments.of(true, 11), Arguments.of(false, 23), Arguments.of(false, -1)

		);

	}
}
