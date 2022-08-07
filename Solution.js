
var MyCalendar = function () {
    this.bookedMeetings = [];
};

/** 
 * @param {number} start 
 * @param {number} end
 * @return {boolean}
 */
MyCalendar.prototype.book = function (start, end) {

    if (this.bookedMeetings.length === 0 || this.bookedMeetings[this.bookedMeetings.length - 1].end <= start) {
        this.bookedMeetings.push(new Interval(start, end));
        return true;
    }

    if (this.bookedMeetings[0].start >= end) {
        this.bookedMeetings.unshift(new Interval(start, end));
        return true;
    }

    for (let i = 1; i < this.bookedMeetings.length; ++i) {
        if (this.bookedMeetings[i - 1].end <= start && this.bookedMeetings[i].start >= end) {
            this.bookedMeetings.splice(i, 0, new Interval(start, end));
            return true;
        }
    }
    return false;
};

/** 
 * @param {number} start 
 * @param {number} end
 */
function Interval(start, end) {
    this.start = start;
    this.end = end;
}
