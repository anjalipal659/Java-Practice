public class LargestPerimeterTriangle {

    public static int largestPerimeter(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length - 2; i++) {

            int a = arr[i];
            int b = arr[i + 1];
            int c = arr[i + 2];

            if (b + c > a) {
                return a + b + c;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 2};

        System.out.println("Largest Perimeter: " + largestPerimeter(arr));
    }
}