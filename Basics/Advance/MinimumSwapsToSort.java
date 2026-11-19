public class MinimumSwapsToSort {

    public static int minimumSwaps(int[] arr) {

        int[] sorted = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sorted[i] = arr[i];
        }

        for (int i = 0; i < sorted.length; i++) {
            for (int j = i + 1; j < sorted.length; j++) {

                if (sorted[i] > sorted[j]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }

        int swaps = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != sorted[i]) {

                int correctIndex = i;

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == sorted[i]) {
                        correctIndex = j;
                        break;
                    }
                }

                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 1};

        System.out.println("Minimum Swaps: " + minimumSwaps(arr));
    }
}