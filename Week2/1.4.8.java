import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class countEqualNumber {
    public static long countPairs(int[] numbers) {
        long count = 0;
        if (numbers == null || numbers.length < 2) {
            return count;
        }
        Arrays.sort(numbers);

        int currentCount = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i-1]) {
                currentCount++;
            } else {
                count += (long) currentCount * (currentCount - 1) / 2;
                currentCount = 1;
            }
        }
        count += (long) currentCount * (currentCount - 1) / 2;
        return count;
    }
    public static void main(String[] args) {
        String filename = "int.txt";
        try {
            Scanner sc = new Scanner(new File(filename));
            ArrayList<Integer> numbers = new ArrayList<>();
            while (sc.hasNextInt()) {
                numbers.add(sc.nextInt());
            }
            sc.close();
            int[] nums = numbers.stream().mapToInt(i -> i).toArray();
            long result = countPairs(nums);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

}