package JE2.records;

public record Point(int x, int y) {
    public double distanceFromOrigin(){
        return Math.sqrt(x * x + y * y);
    }
}
