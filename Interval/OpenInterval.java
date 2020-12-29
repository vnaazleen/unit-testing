package Interval;

public class OpenInterval extends Interval {
    
    OpenInterval () {
        super();
    }

    OpenInterval (int limit) {
        super(limit);
    }

    OpenInterval (int start, int limit) {
        super(start + 1, limit);
    }

    @Override
    public void setStart(int newStart) {
        if (isVaild(newStart + 1, this.limit)) {
            this.start = newStart + 1;
        } else {
            throw new IllegalArgumentException("Illegal Interval");
        }
    }

    @Override
    public Interval combine (Interval Interval2) {
		int newStart = this.start <= Interval2.start ? this.start : Interval2.start;
		int newlimit = this.limit >= Interval2.limit ? this.limit : Interval2.limit;

		return new Interval(newStart - 1, newlimit);
	}

    @Override
    public String toString() {
        return "(" + this.start + " , " + this.limit + ")";
    }
}
