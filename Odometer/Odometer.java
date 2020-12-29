package Odometer;

import java.util.ArrayList;

public class Odometer {
    private int size = 0;
    private int length = 0;
    private int position = 0;
    private ArrayList<Integer> readings = new ArrayList<Integer>();

    private boolean isAscending(int n) {
        if (n < 10) 
            return true;
        if ((n % 10) <= (n / 10) % 10) 
            return false;
        return isAscending(n / 10);
    }

    public Odometer(int size) {
        if (size < 2 || size > 8) return;

	    this.size = size;

	    int start = 1;
        for (int i = 1; i < size; ++i) 
            start *= 10;

	    for (int i = start; i < start * 10; ++i) {
	        if (isAscending(i)) {
		        this.readings.add(i);
		        this.length++;
	        }
	    }
    }

	int next(int step) {
        for (int i = 0; i < step; ++i) 
            this.position++;

        while (this.position >= this.length) 
            this.position -= this.length;
            
	    return this.readings.get(this.position);
	}

	int prev(int step) {
	    for (int i = 0; i < step; ++i) 
                 this.position--;

	    while (this.position < 0) 
		    this.position += this.length;

	    return this.readings.get(this.position);
	}

	int diff(Odometer b) {
	    if (this.size != b.size) return -1;

	    if (this.position >= b.position) 
		    return this.position - b.position;
	    else 
		    return this.position - b.position + this.length;
    }
}