import java.util.Scanner;

public class Game {
    private static final Board board = new Board();
    private static int turn = 0;
    public static boolean isFinished() {
        for (int i = 0; i < 3; i++) {
            if(board.horizontalMatch(i, 'X') || board.verticalMatch(i, 'X') || board.diagonalMatch('X')){
                System.out.println("X won");
                return true;
            }
            else if(board.horizontalMatch(i, 'O') || board.verticalMatch(i, 'O') || board.diagonalMatch('O')){
                System.out.println("O won");
                return true;
            }
        }
        return board.modCount == 9;
    }
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        while (!isFinished()) {
            if(turn == 0) {
                System.out.println("X`s turn");
            }else {
                System.out.println("O`s turn");
            }
            System.out.print("i: ");
            int i = scanner.nextInt() - 1;
            System.out.print("j: ");
            int j = scanner.nextInt() - 1;
            if(turn == 0) {
                try {
                    board.setCell(i,j,'X');
                    turn = 1^turn;
                }
                catch (IncorrectCoordinate e) {
                    System.out.println("cannot set cell");
                }
            }else {
                try {
                    board.setCell(i,j,'O');
                    turn = 1^turn;
                }
                catch (IncorrectCoordinate e) {
                    System.out.println("cannot set cell");
                }
            }

            board.print();
        }
    }
}
