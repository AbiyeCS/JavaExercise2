import JE2.enums.Day;
import JE2.records.Point;

public class EnumRecordTest {
    public static void main(String[] args) {
        Day today = Day.SATURDAY;
        System.out.println("Is weekend? " + today.isWeekend());

        Point p = new Point(3, 4);
        System.out.println("Distance: " + p.distanceFromOrigin());
    }
}
