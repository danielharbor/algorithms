package com.topics.random;

import java.util.*;


/*
Problem Statement: Given the schedule of two people in the form of {{"10:00", "12:00"}}, a valid meeting window and meeting duration,
return a set of avaible times for both people to meet
Input -
schdlA: schedule for person A (unavailable times)
schdlB: schedule for person B (unavailable times)
validHours: valid period for meeting
duration: meeting duration in minutes

Note: All time periods are in 24 hr format
*/

public class MeetingTimes {
    public static void main(String[] args) {
        String[][] schedule1 = {{"9:10", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[][] schedule2 = {{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] validHours = {"10:00", "18:30"};
        int duration = 30;
        System.out.println(getValidMeetingTimes(schedule1, schedule2, validHours, duration));
    }

    static List<List<String>> getValidMeetingTimes(String[][] schdlA, String[][] schdlB, String[] validHours, int duration) {
        List<List<String>> res = new ArrayList<>();
        List<String[]> timesA = getValidTimes(schdlA, validHours, duration);
        List<String[]> timesB = getValidTimes(schdlB, validHours, duration);
        for (String[] timeA : timesA) {
            for (String[] timeB : timesB) {
                String[] overlap = getPeriodsOverlap(timeA, timeB, duration);
                if (overlap != null) {
                    res.add(List.of(overlap[0], overlap[1]));
                }
            }
        }

        return res;
    }

    static int[] convertTimeToInt(String start, String end) {
        int startInt = Integer.parseInt(start.substring(0, 2) + start.substring(3));
        int endInt = Integer.parseInt(end.substring(0, 2) + end.substring(3));
        return new int[]{startInt, endInt};
    }

    static String[] getPeriodsOverlap(String[] a, String[] b, int duration) {
        String[] overlap = null;
        int[] periodA = convertTimeToInt(a[0], a[1]);
        int[] periodB = convertTimeToInt(b[0], b[1]);

        // check if periods overlap
        boolean periodsOverlap = periodA[0] < periodB[1] && periodB[0] < periodA[1];
        boolean overlapIsLongEnough = (periodA[1] - periodA[0]) >= duration;

        if (periodsOverlap && overlapIsLongEnough) {
            String overlapStart = periodA[0] < periodB[0] ? b[0] : a[0]; // take max time as start
            String overlapEnd = periodA[1] < periodB[1] ? a[1] : b[1]; // take min time as end
            overlap = new String[]{overlapStart, overlapEnd};
        }

        return overlap;
    }

    static List<String[]> getValidTimes(String[][] times, String[] validHours, int meetingDuration) {
        List<String[]> res = new ArrayList<>();
        for (int i = 0; i < times.length-1; ++i) {
            String[] cur = times[i];
            String[] next = times[i+1];
            if (cur[1].compareTo(next[0]) < 0) { // there's a gap between the periods
                String[] newPeriod = {cur[1], next[0]};
                String[] overlap = getPeriodsOverlap(newPeriod, validHours, meetingDuration);
                if (overlap != null) {
                    res.add(overlap);
                }
            }
        }

        return res;
    }
}
