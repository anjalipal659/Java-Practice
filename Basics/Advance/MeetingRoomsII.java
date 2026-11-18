import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] meeting : intervals) {

            if (!rooms.isEmpty()
                    && meeting[0] >= rooms.peek()) {
                rooms.poll();
            }

            rooms.offer(meeting[1]);
        }

        return rooms.size();
    }

    public static void main(String[] args) {

        int[][] meetings = {
            {0, 30},
            {5, 10},
            {15, 20}
        };

        System.out.println(
            "Minimum rooms required: " + minMeetingRooms(meetings)
        );
    }
}