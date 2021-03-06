package array;

import java.util.*;

import static java.lang.System.out;

public class LogicalProgramInArray {

    static char[] characters = {'a', 'b', 'c', 'd'};

    public void moveZeros() {
        int[] intArray = {0, 1, 0, 3, 12};

        for (int i = 0; i < intArray.length - 1; i++) {
            out.println("");
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == 0 && intArray[j] != 0) {
                    intArray[i] = intArray[j];
                    intArray[j] = 0;
                    break;
                }
            }
        }
        out.println("-----> " + Arrays.toString(intArray));
    }

    public void mergeSortedArray() {
        int[] firstArray = {0, 3, 4, 32};
        int[] secondArray = {4, 6, 30, 55, 65};
        int[] mergedArray = new int[firstArray.length + secondArray.length];
        int firstCurrPos = 0, secondCurrentPos = 0, mergedCurrentPos = 0;

        while (firstCurrPos < firstArray.length && secondCurrentPos < secondArray.length) {
            int firstValue = firstArray[firstCurrPos];
            int secondValue = secondArray[secondCurrentPos];
            if (firstValue < secondValue) {
                mergedArray[mergedCurrentPos++] = firstValue;
                firstCurrPos++;
            } else {
                mergedArray[mergedCurrentPos++] = secondValue;
                secondCurrentPos++;
            }
        }

        if (firstCurrPos >= firstArray.length) {
            fillRemainingItemOfSecondArray(secondArray, mergedArray, secondCurrentPos, mergedCurrentPos);
        } else {
            fillRemainingItemOfSecondArray(firstArray, mergedArray, firstCurrPos, mergedCurrentPos);
        }

        out.println("----> " + Arrays.toString(mergedArray));
    }

    void fillRemainingItemOfFirstArray(int[] secondArray, int[] mergedArray, int secondCurrentPos, int mergedCurrentPos) {
        while (secondCurrentPos < secondArray.length) {
            mergedArray[mergedCurrentPos++] = secondArray[secondCurrentPos++];
        }
    }

    void fillRemainingItemOfSecondArray(int[] firstArray, int[] mergedArray, int firstCurrPos, int mergedCurrentPos) {
        while (firstCurrPos < firstArray.length) {
            mergedArray[mergedCurrentPos++] = firstArray[firstCurrPos++];
        }
    }

    public void reverseString() {
        String word = "Hello world";
        StringBuilder stringBuilder = new StringBuilder(word);
        out.println("After reverse: " + word);
        for (int startPos = 0, endPos = stringBuilder.length() - 1; startPos < stringBuilder.length() / 2; startPos++, endPos--) {
            char temp = stringBuilder.charAt(startPos);
            stringBuilder.setCharAt(startPos, stringBuilder.charAt(endPos));
            stringBuilder.setCharAt(endPos, temp);
        }

        out.println("After reverse: " + stringBuilder);
    }

    public void findMaxRepeatedElementInArray() {
        char[] characters = {'a', 'c', 'b', 'c', 'd', 'b', 'a', 'b', 'b', 'b'};
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        for (char character : characters) {
            String key = String.valueOf(character);
            if (hashtable.containsKey(key)) {
                int value = hashtable.get(key) + 1;
                hashtable.put(key, value);
            } else {
                hashtable.put(key, 1);
            }
        }

        Set<String> mySet = hashtable.keySet();
        String maxRepeatedKey = "";
        int maxValue = 0;
        for (String key : mySet) {
            if (maxValue < hashtable.get(key)) {
                maxValue = hashtable.get(key);
                maxRepeatedKey = key;
            }
        }
        out.println("Key: " + maxRepeatedKey + " Value is: " + hashtable.get(maxRepeatedKey));
    }

    public void reverseTheArray() {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        out.println("Before: " + Arrays.toString(num));
        int halfOfTheArraySize = num.length / 2;
        int temp = 0;
        for (int front = 0, back = num.length - 1; front < halfOfTheArraySize; front++, back--) {
            temp = num[front];
            num[front] = num[back];
            num[back] = temp;
        }
        out.println("After: " + Arrays.toString(num));
    }

    public void findSumOfConsecutiveDigitIsEqualToGivenNUmber() {
        int[] num = {1,2,3,7,5};
        int givenNUmber = 15;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num.length - 1; i++) {
            int sum = 0;
            int startPos = 0;
            for (int j = i; j < num.length - 1; j++) {
                if (i == j) {
                    startPos = i;
                    sum = num[j] + num[j + 1];
                } else {
                    sum = sum + num[j + 1];
                }
                if (sum == givenNUmber) {
                    int endPos = j + 1;
                    out.println(" Start Pos: " + startPos + " End Pos: " + endPos);
                    arrayList.add(startPos);
                    arrayList.add(endPos);
                }
            }
        }
        out.println("-----> "+Arrays.toString(arrayList.toArray()));
    }

    public static void printPairOfArrays(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters.length; j++) {
                if (i != j) {
                    out.println(characters[i] + "," + characters[j]);
                }
            }
            out.println();
        }
    }

    private static void printPairOfSums(int[] num) {
        for (int k : num) {
            for (int i : num) {
                int sum = k + i;
                out.print(sum + ", ");
            }
            out.println();
        }
    }

    void checkItemIsInBothArrayBigO() {
        String[] itemArrayOne = {"Apple", "Orange", "Banana", "Krishna", "Apple"};
        String[] itemArrayTwo = {"Arun", "Karthik", "Orange"};

        Set<String> set = new HashSet<>(Arrays.asList(itemArrayOne));

        out.println("-----> " + Arrays.toString(set.toArray()));

        for (String item : itemArrayTwo) {
            if (set.contains(item)) {
                out.println(item + ": item found");
            }
        }

    }

    void checkItemIsInBothArray() {
        String[] itemArrayOne = {"Apple", "Orange", "Banana", "Krishna"};
        String[] itemArrayTwo = {"Arun", "Karthik", "Orange"};
        boolean itemAvailableInBothArray = false;
        String item = null;

        for (String searchItem : itemArrayOne) {
            for (String s : itemArrayTwo) {
                if (searchItem.equalsIgnoreCase(s)) {
                    itemAvailableInBothArray = true;
                    item = searchItem;
                    break;
                }
            }
        }

        if (itemAvailableInBothArray) {
            out.println(item + " item found in both the array");
        }
    }

    void findSumOfTwoDigitSubArrayEqualsToGivenNumberBigO() {
        // Input success case
        int[] num = {1, 2, 4, 5, 8};
        // Input failure case
//        int[] num = {1, 2, 4, 5, 13};
        int givenNumber = 12;
        boolean isSumEquals = false;
        Set<Integer> keySet = new HashSet<>();

        for (int j : num) {
            if (keySet.contains(j)) {
                isSumEquals = true;
                break;
            } else {
                keySet.add(givenNumber - j);
            }
        }

        if (isSumEquals) {
            out.println("Yes it found");
        } else {
            out.println("Not found");
        }
    }

    void findSumOfTwoDigitSubArrayEqualsToGivenNumberBruitForce() {
        int[] num = {1, 2, 4, 5, 8};
        int givenNumber = 12;
        boolean numberFound = false;
        int firstPos = 0, secondPos = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (sum == givenNumber) {
                    firstPos = i;
                    secondPos = j;
                    numberFound = true;
                    break;
                }
            }
        }

        if (numberFound) {
            out.println("Array position " + firstPos + " and " + secondPos + " is equals to " + givenNumber);
        } else {
            out.println("Not found");
        }
    }
}
