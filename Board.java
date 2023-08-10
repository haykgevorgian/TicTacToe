public class Board {
    Cell[][] cells = new Cell[3][3];
    int modCount = 0;
    Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    public void setCell(int i, int j, char ch) throws IncorrectCoordinate{
        if(i < 0 || j < 0 || i > 2 || j > 2) {
            throw new IncorrectCoordinate();
        }
        if(getCell(i,j).isEmpty()){
            getCell(i,j).set(ch);
            modCount++;
        }else {
            throw new IncorrectCoordinate();
        }
    }
    public Cell getCell(int i, int j) {
        return cells[i][j];
    }
    public char get(int i, int j) {
        return getCell(i,j).get();
    }
    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(get(i,j) + " ");
            }
            System.out.println();
        }
    }
    public boolean horizontalMatch(int i, char ch) {
        return get(i, 0) == ch && get(i, 1) == ch && get(i,2) == ch;
    }
    public boolean verticalMatch(int j, char ch) {
        return get(0, j) == ch && get(1, j) == ch && get(2, j) == ch;
    }
    public boolean diagonalMatch(char ch) {
            return ((get(0,0) == ch && get(1,1) == ch && get(2,2) == ch) ||
                    (get(0,2) == ch && get(1,1) == ch && get(2,0) == ch));
    }
}
