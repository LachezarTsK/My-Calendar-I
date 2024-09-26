
#include <set>
using namespace std;

class MyCalendar {

    struct Interval {
        int start{};
        int end{};
        Interval(int start, int end) : start{start}, end{end}{}
    };

    struct CompareIntervals {
        bool operator()(const Interval& x, const Interval& y) const {return x.end <= y.start;};
    };
    set<Interval, CompareIntervals> bookedMeetings;

public:
    MyCalendar() = default;

    bool book(int start, int end) {
        return bookedMeetings.emplace(start, end).second;
    }
};
