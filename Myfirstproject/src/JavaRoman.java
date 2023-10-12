import java.util.*;

public class JavaRoman{
    public static void main(String[] args) {
        // Task 1: Shuffle an array
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> list = Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new));
        Collections.shuffle(list);
        System.out.println("Shuffled Array: " + list);

        // Task 2: Convert Roman Number to Integer
        String romanNumber = "IX";
        int integerValue = convertRomanToInteger(romanNumber);
        System.out.println("Roman to Integer: " + integerValue);

        // Task 3: Check for Pangram
        String sentence = "The quick brown fox jumps over the lazy dog";
        boolean isPangram = checkPangram(sentence);
        System.out.println("Is Pangram? " + isPangram);
    }

    // Function to convert Roman Number to Integer
    private static int convertRomanToInteger(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curValue = romanValues.get(s.charAt(i));
            if (curValue < prevValue) {
                result -= curValue;
            } else {
                result += curValue;
            }
            prevValue = curValue;
        }

        return result;
    }

    // Function to check for Pangram
    private static boolean checkPangram(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                set.add(c);
            }
        }
        return set.size() == 26;
    }
}