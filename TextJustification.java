import java.util.*;

public class TextJustification {
    public static void fullJustify(String[] words, int L) {
        String[] list = new String[L];
        int i = 0;
        while (i < words.length) {
            int j = i;
            int len = 0;
            // grab as many words as I can
            while (j < words.length && len + (j - i) + words[j].length() <= L) len += words[j++].length();
            // # of space need to be inserted between each word is j==i?0:(L-len)/(j-i)
            int space = j <= i + 1 ? 0 : (L - len) / (j - i - 1);
            // # of space remained, L - len - space*(j-i);
            int remain = L - len - space * (j - i - 1);
            // construct a line
            StringBuilder s = new StringBuilder();
            // one word case & last line case
            if (j == words.length || j <= i + 1) {
                for (int t = i; t < j; t++) {
                    s.append(words[t]);
                    if (t != j - 1) s.append(" ");
                }
                remain += space * (j - i - 1) - (j - i - 1);
                for (int t = 0; t < remain; t++)
                    s.append(" ");
            } else {
                // general case
                for (int t = i; t < j; t++, remain--) {
                    s.append(words[t]);
                    if (t != j - 1) for (int u = 0; u < space; u++)
                        s.append(" ");
                    if (remain > 0) s.append(" ");
                }
            }
            // add line
            System.out.println(s.toString());
            i = j;
        }

    }

    public static void main(String[] args) {
        String[] words = new String[]{"Lorem",
                "ipsum",
                "dolor",
                "sit",
                "amet,",
                "consectetur",
                "adipiscing",
                "elit,",
                "sed",
                "do",
                "eiusmod",
                "tempor",
                "incididunt",
                "ut",
                "labore",
                "et dolore",
                "magna",
                "aliqua."};
        fullJustify(words, 20);
    }
}
