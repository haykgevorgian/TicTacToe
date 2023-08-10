public class IncorrectCoordinate extends RuntimeException {
    @Override
    public String getMessage() {
        printStackTrace();
        return "cannot set cell";
    }
}
