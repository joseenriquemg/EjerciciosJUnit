package clases;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TablasTest {

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

	@ParameterizedTest
	@MethodSource("esMagica")
	void testEsMagica(int[][] matriz, boolean expected) {
		boolean resultado = Tablas.esMagica(matriz);
		assertEquals(expected, resultado);
	}

	static Stream<Arguments> esMagica() {
		return Stream.of(Arguments.of(new int[][] { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } }, true),
				Arguments.of(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, false),
				Arguments.of(new int[][] { { 1, 1 }, { 1, 2 } }, false));
	}

	@ParameterizedTest
	@MethodSource("gira90Provider")
	void testGira90(int[][] tablaInicio, int[][] expected) {
		int[][] resultado = Tablas.gira90(tablaInicio);
		assertArrayEquals(expected, resultado);
	}

	static Stream<Arguments> gira90Provider() {
		return Stream.of(Arguments.of(new int[][] { { 1 } }, new int[][] { { 1 } }),
				Arguments.of(new int[][] { { 2, 4 }, { 6, 8 } }, new int[][] { { 6, 2 }, { 8, 4 } }),
				Arguments.of(new int[][] { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } },
						new int[][] { { 14, 8, 2 }, { 16, 10, 4 }, { 18, 12, 6 } }));
	}
}
