package com.renato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvancedMergeIntervals {

	public static void main(String[] args) {

		List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(1, 3));
        intervals1.add(new Interval(2, 4));
        intervals1.add(new Interval(5, 7));
        intervals1.add(new Interval(6, 8));
		System.out.println(mergeIntervals(intervals1));

	}

	// Advanced Merge Intervals
	// This coding challenge will test your skills in sophisticated sorting, complex
	// interval merging, and handling tricky edge cases.
	public static List<Interval> mergeIntervals(List<Interval> intervals) {
	    if (intervals == null || intervals.size() <= 1) return intervals;
	    
	    // Sort intervals based on start time
	    Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
	    
	    List<Interval> merged = new ArrayList<>();
	    Interval current = intervals.get(0);
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= current.end) {
	            // Merge intervals with custom merging logic
	            current.end = Math.max(current.end, interval.end);
	        } else {
	            merged.add(current);
	            current = interval;
	        }
	    }
	    
	    merged.add(current);
	    return merged;
	}

}

class Interval {
    int start;
    int end;
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
    
}