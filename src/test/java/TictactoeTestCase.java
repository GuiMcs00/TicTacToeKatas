import org.craftsmanship.tictactoe.TicTacToe;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TictactoeTestCase {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }


    @Test
    @DisplayName("SetBoard Válido")
    void testSetBoard() {
        game.setBoard(0,0);
        Assertions.assertEquals('X', game.getBoard()[0][0]);
    }


    @Test
    @DisplayName("Alternancia de Jogadores")
    void testAlternanciaJogadores() {
        game.setBoard(0,0);
        game.setBoard(0,1);
        Assertions.assertEquals('X', game.getBoard()[0][0]);
        Assertions.assertEquals('O', game.getBoard()[0][1]);
    }


    @Test
    @DisplayName("SetBoard na mesma posição")
    void testSetBoardMesmaPosicao() {
        game.setBoard(0,0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.setBoard(0,0));
    }


    @ParameterizedTest
    @DisplayName("CheckWinner horizontal")
    @CsvSource({
            "0, 0, false",
            "1, 0, false",
            "0, 1, false",
            "1, 1, false",
            "0, 2, true"
    })
    void testCheckWinHorizontal(int linha, int coluna, boolean expected) {
        game.setBoard(linha, coluna);
        boolean result = game.checkWinner();
        Assertions.assertEquals(expected, result);
    }


    @ParameterizedTest
    @DisplayName("CheckWinner vertical")
    @CsvSource({
            "0, 0, false",
            "0, 1, false",
            "1, 0, false",
            "0, 2, false",
            "2, 0, true"
    })
    void testCheckWinVertical(int linha, int coluna, boolean expected) {
        game.setBoard(linha, coluna);
        boolean result = game.checkWinner();
        Assertions.assertEquals(expected, result);
    }


    @ParameterizedTest
    @DisplayName("CheckWinner diagonal")
    @CsvSource({
            "0, 0, false",
            "0, 1, false",
            "1, 1, false",
            "0, 2, false",
            "2, 2, true"
    })
    void testCheckWinDiagonal(int linha, int coluna, boolean expected) {
        game.setBoard(linha, coluna);
        boolean result = game.checkWinner();
        Assertions.assertEquals(expected, result);
    }


}
