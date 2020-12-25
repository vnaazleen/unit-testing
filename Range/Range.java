package Range;

import java.lang.Math;

public class Range {
	private int start;
	private int end;

	public Range (int e) {
		this.start = 0;
		this.end = e;
	}
	
	public Range (int a, int b) {
		this.start = Math.min(a, b);
		this.end = Math.max(a, b);
	}

	public Range() {
		this.start = this.end = 0;
	}

	private void reset() {
		this.start = this.end = 0;
	}

	public void rStretch() {
        this.end++;
    }

    public void rStretch(int n) {
        this.end += n;
    }

    public void lStretch() {
        this.start--;
    }

    public void lStretch(int n) {
        this.end -= n;
    }

    public void stretch() {
        this.start--;
        this.end++;
    }

    public void stretch(int n) {
        this.start -= n;
        this.end += n;
    }

    public void squeeze() {
        this.start++;
        this.end--;
        if (this.start > this.end)
            this.reset();
    }

    public void squeeze(int n) {
        this.start += n;
        this.end -= n;
        if (this.start > this.end)
            this.reset();
    }

    public void shift(int n) {
        this.start += n;
        this.end += n;
    }
    
    public int length() {
        return this.end - this.start + 1;
    }

	public String toString() {
        return "[" + this.start + ", " + this.end + ")";
    }
	
	public Range combine (Range range2) {
		int newStart = this.start <= range2.start ? this.start : range2.start;
		int newEnd = this.end >= range2.end ? this.end : range2.end;

		return new Range(newStart, newEnd);
	}
	
	public Boolean contains (Range range2) {
		return this.start <= range2.start && this.end >= range2.end;
	}

	public Boolean contains (int element) {
		return this.start <= element && this.end > element;
	}

	public Boolean isDisjoint (Range r) {
		return this.start >= r.end || this.end <= r.start;
	}

	public Boolean overlaps (Range r) {
		return !isDisjoint(r);
	}

	public Boolean equals (Range r) {
		return this.start == r.start && this.end == r.end;
	}

	public Boolean touching (Range range) {
		return range.start == end - 1 || range.end - 1 == start;
	}

	public boolean lessThan(Range r) {
        return this.start < r.start;
	}

	public enum Relation {
        SUBSET, SUPERSET, OVERLAPL, OVERLAPR, TOUCHINGL, TOUCHINGR, LESSDISJOINT, MOREDISJOINT, SAME;
    }
	
	public Relation classify(Range r) {
        if (this.end == r.start) 
            return Relation.TOUCHINGR;
        if (this.start == r.end)
            return Relation.TOUCHINGL;
        if (this.equals(r))
            return Relation.SAME;
        if (this.contains(r)) 
            return Relation.SUPERSET;
        if (r.contains(this))
            return Relation.SUBSET;
        if (this.isDisjoint(r))
            if (this.start > r.end)
                return Relation.MOREDISJOINT;
            else
                return Relation.LESSDISJOINT;
        if (this.lessThan(r))
            return Relation.OVERLAPL;
        return Relation.OVERLAPR;
	}
	
	public Range merge(Range r) {
        if (this.isDisjoint(r)) {
            return new Range();
        }
        int a = Math.min(this.start, r.start);
        int b = Math.max(this.end, r.end);
        return new Range(a, b);
    } 
}