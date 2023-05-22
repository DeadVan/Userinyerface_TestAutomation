package Utils;

import java.util.Random;

public final class StringUtils {
    private StringUtils(){

    }
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static final int NUM_LETTERS_IN_ALPHABET = 26;

    private static final int NUM_DIGITS = 10;




    public static String getString() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            char c = ALPHA_NUMERIC_STRING.charAt(index);
            builder.append(c);
            builder.append("G");
        }return builder.toString();
    }

    public static String generatePassword() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
            for (int i = 0; i < 10 - 2 - 1; i++) {
                int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
                char c = ALPHA_NUMERIC_STRING.charAt(index);
                builder.append(c);
            }
            for (int i = 0; i < 2; i++) {
                char c = (char) (random.nextInt(NUM_LETTERS_IN_ALPHABET) + 'A');
                builder.append(c);
            }
            for (int i = 0; i < 1; i++) {
                int num = random.nextInt(NUM_DIGITS);
                builder.append(num);
        }
            builder.append("G");
        return builder.toString();
    }


}
