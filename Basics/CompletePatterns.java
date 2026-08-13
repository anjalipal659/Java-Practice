public class CompletePatterns {
    public static void main(String[] args) {

        int n = 5;

        // 1. Square
        System.out.println("1. Square");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        // 2. Increasing Triangle
        System.out.println("\n2. Increasing Triangle");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        // 3. Decreasing Triangle
        System.out.println("\n3. Decreasing Triangle");

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        // 4. Number Triangle
        System.out.println("\n4. Number Triangle");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        // 5. Same Number Triangle
        System.out.println("\n5. Same Number Triangle");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


        // 6. Reverse Number Triangle
        System.out.println("\n6. Reverse Number Triangle");

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        // 7. Right-Aligned Triangle
        System.out.println("\n7. Right-Aligned Triangle");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }


        // 8. Inverted Right-Aligned Triangle
        System.out.println("\n8. Inverted Right-Aligned Triangle");

        for (int i = n; i >= 1; i--) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }


        // 9. Pyramid
        System.out.println("\n9. Pyramid");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }


        // 10. Inverted Pyramid
        System.out.println("\n10. Inverted Pyramid");

        for (int i = n; i >= 1; i--) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }


        // 11. Diamond
        System.out.println("\n11. Diamond");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }


        // 12. 0-1 Triangle
        System.out.println("\n12. 0-1 Triangle");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {

                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }


        // 13. Number Pyramid
        System.out.println("\n13. Number Pyramid");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }


        // 14. Floyd's Triangle
        System.out.println("\n14. Floyd's Triangle");

        int number = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }

            System.out.println();
        }


        // 15. Hollow Square
        System.out.println("\n15. Hollow Square");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }


        // 16. Hollow Triangle
        System.out.println("\n16. Hollow Triangle");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {

                if (j == 1 || j == i || i == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }


        // 17. X Pattern
        System.out.println("\n17. X Pattern");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (i == j || i + j == n + 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }


        // 18. Plus Pattern
        System.out.println("\n18. Plus Pattern");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (i == (n + 1) / 2 || j == (n + 1) / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
}