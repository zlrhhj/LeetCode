public class ChessboardColor {
    public boolean squareIsWhite(String coordinate) {
        return (coordinate.charAt(0) - 'a' + coordinate.charAt(1) - '0') % 2 == 0;
    }
}
