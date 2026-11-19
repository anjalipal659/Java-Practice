public class MaximumUnitsOnTruck {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        for (int i = 0; i < boxTypes.length; i++) {
            for (int j = i + 1; j < boxTypes.length; j++) {

                if (boxTypes[i][1] < boxTypes[j][1]) {
                    int[] temp = boxTypes[i];
                    boxTypes[i] = boxTypes[j];
                    boxTypes[j] = temp;
                }
            }
        }

        int totalUnits = 0;

        for (int i = 0; i < boxTypes.length; i++) {

            int boxes = Math.min(boxTypes[i][0], truckSize);

            totalUnits += boxes * boxTypes[i][1];
            truckSize -= boxes;

            if (truckSize == 0) {
                break;
            }
        }

        return totalUnits;
    }

    public static void main(String[] args) {

        int[][] boxTypes = {
            {1, 3},
            {2, 2},
            {3, 1}
        };

        int truckSize = 4;

        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}