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
    public String toString() {
        return "(" + this.start + " , " + this.limit + ")";
    }
}
