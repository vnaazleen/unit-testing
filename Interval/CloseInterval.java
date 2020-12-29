package Interval;

public class CloseInterval extends Interval {
    
    CloseInterval () {
        super();
    }

    CloseInterval (int limit) {
        super(limit);
    }

    CloseInterval (int start, int limit) {
        super(start + 1, limit - 1);
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
    public void setLimit(int newlimit) {
        if (isVaild(this.start, newlimit - 1)) {
            this.limit = newlimit - 1;
        } else {
            throw new IllegalArgumentException("Illegal Interval");
        }
    }

    @Override
    public String toString() {
        return "[" + this.start + " , " + this.limit + "]";
    }
}

