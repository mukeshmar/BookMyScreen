package live.mukeshtechlab.bookmyscreen.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomStringGenerationService {
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWQYZ";
    private static final String NUMBERS = "0123456789";
    private static final int LENGTH = 7;
    private static final Random random = new Random();

    public static String generateRandomString() {
        StringBuilder stringBuilder = new StringBuilder(LENGTH);

        // 4 Alphabets
                for (int i = 1; i <= 4; i++) {
            stringBuilder.append(ALPHABETS.charAt(random.nextInt(26)));  // there are 26 Alphabets
        }

        // 2 numbers
        for(int i = 1; i<= 2; i++){
            stringBuilder.append(NUMBERS.charAt(random.nextInt(10)));
        }

        // 1 alphabets
        stringBuilder.append(ALPHABETS.charAt(random.nextInt(26)));  // there are 26 Alphabets

        return stringBuilder.toString();
    }
}
