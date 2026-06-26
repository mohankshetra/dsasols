class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix
            while (!strs[i].startsWith(prefix)) {
                // Trim the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, no common prefix
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    
    }
}