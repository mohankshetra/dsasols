class Solution {

    private final String[] below20 = {
            "", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
    };

    private final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"
    };

    private final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        StringBuilder result = new StringBuilder();

        int index = 0;

        while (num > 0) {

            if (num % 1000 != 0) {

                String part = helper(num % 1000);

                if (!thousands[index].isEmpty())
                    part += thousands[index] + " ";

                result.insert(0, part);
            }

            num /= 1000;
            index++;
        }

        return result.toString().trim();
    }

    private String helper(int num) {

        if (num == 0)
            return "";

        if (num < 20)
            return below20[num] + " ";

        if (num < 100)
            return tens[num / 10] + " " + helper(num % 10);

        return below20[num / 100] + " Hundred " + helper(num % 100);
    }
}