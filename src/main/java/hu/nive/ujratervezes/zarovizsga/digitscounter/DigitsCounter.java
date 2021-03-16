package hu.nive.ujratervezes.zarovizsga.digitscounter;

public class DigitsCounter {

    private final String DIGITS = "0123456789";
    StringBuilder digitCollector = new StringBuilder();

    public int getCountOfDigits(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            addDigitIfNeed(s.charAt(i));
        }

        return digitCollector.length();
    }

    private void addDigitIfNeed(char c) {
        if (DIGITS.indexOf(c) >= 0 && digitCollector.toString().indexOf(c) < 0) {
            digitCollector.append(c);
        }
    }
}
