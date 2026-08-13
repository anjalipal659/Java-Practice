import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Create and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};

        // 2. Print array elements
        System.out.println("Array elements:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // 3. Print using enhanced for loop
        System.out.println("\nUsing enhanced for loop:");

        for (int number : numbers) {
            System.out.println(number);
        }

        // 4. Find sum
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println("\nSum = " + sum);

        // 5. Find maximum
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("Maximum = " + max);

        // 6. Find minimum
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("Minimum = " + min);

        // 7. Take array input from user
        System.out.print("\nEnter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print user input array
        System.out.println("Your array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}