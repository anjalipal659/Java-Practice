import java.util.Arrays;

public class HIndex {

    public static int calculateHIndex(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {

            int papers = n - i;

            if (citations[i] >= papers) {
                return papers;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(
            "H-Index: " + calculateHIndex(citations)
        );
    }
}