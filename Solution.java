
import java.util.TreeSet;

public class MyCalendar {

    private record Interval(int start, int end) {}
    private final TreeSet<Interval> bookedMeetings;

    public MyCalendar() {
        bookedMeetings = new TreeSet<>((first, second) -> first.start - second.start);
    }

    public boolean book(int start, int end) {
        Interval interval = new Interval(start, end);

        return (bookedMeetings.ceiling(interval) == null || bookedMeetings.ceiling(interval).start >= interval.end)
                && (bookedMeetings.floor(interval) == null || bookedMeetings.floor(interval).end <= interval.start)
                && bookedMeetings.add(interval);
    }
}
