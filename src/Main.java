import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        // HTML tags removal sample
        String textHTML = "<div>\n" +
                "<p>Символи <> круглих дужок <code>'('</code> та <code>')'</code>. <br />Ці символи\n" +
                "дозволяють отримати з рядка додаткову інформацію.\n" +
                "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію\n" +
                "за заданим виразом і знаходить її - він просто повертає\n" +
                "знайдений рядок.</p>\n" +
                "<p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, щоб життя медом не здавалося.</p>\n" +
                "</div>";
        // Valid number sample
        String textNumberRight = "(+380)96-220-24-11";
        // Invalid number sample
        String textNumberWrong = "+7-420-43543";
        // Unnecessary space removal sample
        String textSpaceRemoval = "Я хочу    бути     програмістом";

        // Number validation
        Pattern numberPattern = Pattern.compile("\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}");
        regexMatcher(numberPattern, textNumberRight);
        regexMatcher(numberPattern, textNumberWrong);
        
        // Unnecessary space removal
        String whitespaceRegex = "\\s{2,}";
        String cleanSpace = textSpaceRemoval.replaceAll(whitespaceRegex, " ");
        System.out.println("\nText cleaned of unnecessary spaces: " + cleanSpace);

        // HTML tags removal
        String htmlTagsRegex = "(<[^>]+>|<+>)";
        String cleanHTML = textHTML.replaceAll(htmlTagsRegex, "");
        System.out.println("\nText cleaned of HTML tags: " + cleanHTML);
    }
    public static void regexMatcher(Pattern pattern, String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            System.out.println("Number is valid, pattern matched: " + text);
        } else {
            System.out.println("Number is invalid, pattern not matched: " + text);
        }
    }
}
