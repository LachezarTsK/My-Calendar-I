
import java.util.TreeSet;

public class MyCalendar {

    private record Interval(int start, int end) {}
    private final TreeSet<Interval> booking;

    public MyCalendar() {
        booking = new TreeSet<>((first, second) -> first.start - second.start);
    }

    public boolean book(int start, int end) {
        Interval interval = new Interval(start, end);

        if ((booking.ceiling(interval) == null || booking.ceiling(interval).start >= interval.end)
           && (booking.floor(interval) == null || booking.floor(interval).end <= interval.start)) {

            return booking.add(interval);
        }
        return false;
    }
}
