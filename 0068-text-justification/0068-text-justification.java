class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            int lineLength = words[i].length();
            int j = i + 1;

            // Find words that fit in the current line
            while (j < words.length &&
                   lineLength + 1 + words[j].length() <= maxWidth) {

                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder line = new StringBuilder();

            int numWords = j - i;
            int totalChars = 0;

            for (int k = i; k < j; k++) {
                totalChars += words[k].length();
            }

            int totalSpaces = maxWidth - totalChars;

            // Last line OR only one word
            if (j == words.length || numWords == 1) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k != j - 1) {
                        line.append(" ");
                        totalSpaces--;
                    }
                }

                while (totalSpaces-- > 0) {
                    line.append(" ");
                }
            }
            else {

                int gaps = numWords - 1;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spaces = spacesPerGap;

                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        while (spaces-- > 0) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
        
    }
}