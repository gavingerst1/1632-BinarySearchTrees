import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int[] sizes = {100, 1000, 10000};
        int K = 100000;
        int trials = 10;

        for (int n : sizes) {
            double totalHeight = 0;
            double totalFindAverage = 0;

            for (int t = 0; t < trials; t++) {
                BinarySearchTree tree = new BinarySearchTree();
                int[] numbers = new int[n];

                // Generate and insert random numbers
                for (int i = 0; i < n; i++) {
                    int num = random.nextInt(K) + 1;

                    numbers[i] = num;
                    tree.insert(num);
                }

                totalHeight += tree.height();

                // Find each number and count nodes visited
                int totalNodes = 0;

                for (int num : numbers) {
                    totalNodes += tree.find(num);
                }

                double averageFind = (double) totalNodes / n;
                totalFindAverage += averageFind;
            }

            System.out.println("N = " + n);
            System.out.println("Average Height: " +
                    totalHeight / trials);
            System.out.println("Average Nodes Per Find: " +
                    totalFindAverage / trials);
            System.out.println();
        }
    }
}
