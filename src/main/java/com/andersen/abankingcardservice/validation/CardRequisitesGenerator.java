package com.andersen.abankingcardservice.validation;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * Class CardNumberGenerator generate random valid card number, validity and CVV-code.
 * If there are requirements to issue card numbers in series,
 * the number generation algorithm needs to be changed
 */

@Component
public class CardRequisitesGenerator {
    Random random = new Random(System.currentTimeMillis());

    /**
     * Set card validity period in years
     */
    private static final int VALIDITY_PERIOD = 3;

    /**
     * Bank identification number. First 6 numbers of card.
     * Used to identify the bank that is issuing the card
     */
    private static final String BIN_CODE = "492020";

    /**
     * Total length (including the BIN and check number) of card number
     */
    private static final int LENGTH = 16;


    /**
     * Generate valid card number. Card number include is: BIN, 11 random numbers
     * of card, one check number calculated by the Luhn algorithm
     * (the last number in the card number)
     *
     * @return 16 digit card number
     */
    public String generateCardNumber() {
        int randomNumberLength = LENGTH - (BIN_CODE.length() + 1);
        StringBuilder builder = new StringBuilder(BIN_CODE);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = this.random.nextInt(10);
            builder.append(digit);
        }

        int checkDigit = this.getCheckDigit(builder.toString());
        builder.append(checkDigit);

        return builder.toString();
    }

    /**
     * Generates the check digit required to make the given card number
     * valid (i.e. pass the Luhn check). Use Luhn algorithm.
     *
     * @param number The card number for which to generate the check digit.
     * @return The check digit required to make the given card number
     * valid.
     */
    private int getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of
        // 10.
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }

    /**
     * Generate CVV from three random digits
     *
     * @return String CVV
     */
    public String generateCVV() {
        StringBuilder cvv = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(10);
            cvv.append(digit);
        }
        return cvv.toString();
    }

    /**
     * Set date of card expiration. The card expires three years from the date of issue
     * on the last day of the month at 23.59.59
     *
     * @return LocalDateTime expiration.
     */
    public LocalDateTime setValidityPeriod() {
        LocalDateTime dateTimeAfterThreeYears = LocalDateTime
                .now()
                .plus(VALIDITY_PERIOD, ChronoUnit.YEARS)
                .plus(1, ChronoUnit.MONTHS);
        return LocalDateTime.of(dateTimeAfterThreeYears.getYear(),
                        dateTimeAfterThreeYears.getMonth(), 1, 0, 0, 0)
                .minus(1, ChronoUnit.SECONDS);
    }

}
