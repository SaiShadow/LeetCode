class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] datesOfMonths = {
                31,
                28,
                31,
                30,
                31,
                30,
                31,
                31,
                30,
                31,
                30,
                31,
        };

        int[] days = new int[13];
        
        for(int i = 0; i < 12; i++) {
            days[i+1] = days[i] + datesOfMonths[i];
        }

        int dayOfAliceArrival = calcDay(arriveAlice, days);
        int dayOfBobArrival = calcDay(arriveBob, days);
        int dayOfAliceLeave = calcDay(leaveAlice, days);
        int dayOfBobLeave = calcDay(leaveBob, days);

        int diff = Math.min(dayOfAliceLeave, dayOfBobLeave) - Math.max(dayOfAliceArrival, dayOfBobArrival) + 1;

        return Math.max(diff, 0);

    }

    private int calcDay(String date, int[] calendar) {
        int month = Integer.valueOf(date.substring(0, 2));
        int day = Integer.valueOf(date.substring(3));
        return calendar[month - 1] + day;
    }
}