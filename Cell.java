
public class Cell {
    private char cell = '-';
    public Cell() {}
    public void set(char cell) {
        switch (cell) {
            case 'X','O' -> this.cell = cell;
            default -> System.out.println("not compatible character");
        }

    }
    public boolean isEmpty() {
        return cell == '-';
    }
    public char get() {
        return cell;
    }
}
