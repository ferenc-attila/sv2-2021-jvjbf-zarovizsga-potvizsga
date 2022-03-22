package numbers;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int number) {
        validateNumber(number);
        char[] chars = Integer.toString(number).toCharArray();
        return (getSumOfPoweredDigits(chars) == number);
    }

    private int getSumOfPoweredDigits(char[] chars) {
        int sum = 0;
        for (char c : chars) {
            int i = Integer.parseInt(Character.toString(c));
            sum += Math.pow(i, chars.length);
        }
        return sum;
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }
    }
}
