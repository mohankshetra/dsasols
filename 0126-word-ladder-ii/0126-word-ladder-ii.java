import java.util.*;

class Solution {

    Map<String, List<String>> parents = new HashMap<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return result;

        bfs(beginWord, endWord, dict);

        if (!parents.containsKey(endWord))
            return result;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, path);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> dict) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original)
                            continue;

                        chars[j] = c;
                        String next = new String(chars);

                        if (!dict.contains(next))
                            continue;

                        if (!visited.contains(next)) {

                            if (!levelVisited.contains(next)) {
                                queue.offer(next);
                                levelVisited.add(next);
                            }

                            parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }

                    chars[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }
    }

    private void dfs(String word, String beginWord, List<String> path) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parents.containsKey(word))
            return;

        for (String parent : parents.get(word)) {

            path.add(parent);
            dfs(parent, beginWord, path);
            path.remove(path.size() - 1);
        }
    }
}