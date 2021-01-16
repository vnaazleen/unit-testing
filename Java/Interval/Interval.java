package Interval;

import java.lang.Math;

public class Interval {
	protected int start;
	protected int limit;

	public Interval (int e) {
		this.start = 0;
		this.limit = e;
	}
	
	public Interval (int a, int b) {
		this.start = Math.min(a, b);
		this.limit = Math.max(a, b);
	}

	public Interval() {
		this.start = this.limit = 0;
	}

	private void reset() {
		this.start = this.limit = 0;
    }
    
    protected boolean isVaild (int start, int limit) {
        return start <= limit;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int newStart) {
        if (isVaild(newStart, this.limit)) {
            this.start = newStart;
        } else {
            throw new IllegalArgumentException("Illegal Interval");
        }
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int newlimit) {
        if (isVaild(this.start, newlimit)) {
            this.limit = newlimit;
        } else {
            throw new IllegalArgumentException("Illegal Interval");
        }
    }

	public void rStretch() {
        this.limit++;
    }

    public void rStretch(int n) {
        this.limit += n;
    }

    public void lStretch() {
        this.start--;
    }

    public void lStretch(int n) {
        this.limit -= n;
    }

    public void stretch() {
        this.start--;
        this.limit++;
    }

    public void stretch(int n) {
        this.start -= n;
        this.limit += n;
    }

    public void squeeze() {
        this.start++;
        this.limit--;
        if (this.start > this.limit)
            this.reset();
    }

    public void squeeze(int n) {
        this.start += n;
        this.limit -= n;
        if (this.start > this.limit)
            this.reset();
    }

    public void shift(int n) {
        this.start += n;
        this.limit += n;
    }
    
    public int length() {
        return this.limit - this.start;
    }
	
	public Boolean contains (Interval Interval2) {
		return this.start <= Interval2.start && this.limit >= Interval2.limit;
	}

	public Boolean contains (int element) {
		return this.start <= element && this.limit > element;
	}

	public Boolean isDisjoint (Interval r) {
		return this.start >= r.limit || this.limit <= r.start;
	}

	public Boolean overlaps (Interval r) {
		return !isDisjoint(r);
	}

	public Boolean equals (Interval r) {
		return this.start == r.start && this.limit == r.limit;
	}

	public Boolean touching (Interval Interval) {
		return Interval.start == limit - 1 || Interval.limit - 1 == start;
	}

	public boolean lessThan (Interval r) {
        return this.start < r.start;
    }
    
    public boolean moreThan (Interval r) {
        return this.start > r.start;
    }
	
	public Interval merge(Interval r) {
        if (this.isDisjoint(r)) {
            return new Interval();
        }
        int a = Math.min(this.start, r.start);
        int b = Math.max(this.limit, r.limit);
        return new Interval(a, b);
    } 

    @Override
    public String toString() {
        return "[" + String.valueOf(start) + " , " + String.valueOf(limit) + ")";
    }
}