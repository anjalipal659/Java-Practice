package LeetCodeJava;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }

        int result = 0;

        for (int i = 0; i < k; i++) {
            result = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };

        int k = 8;

        System.out.println("Kth smallest element: "
                + kthSmallest(matrix, k));
    }
}