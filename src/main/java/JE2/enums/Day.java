package JE2.enums;

public enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public boolean isWeekend(){
        // What does the (this) do?
        // In switch (this), the this refers to the current enum constant instance (e.g., Day.SATURDAY)
        return switch (this) {
            case SATURDAY, SUNDAY -> true;
            default -> false;
        };
    }
}
