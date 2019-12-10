class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();

        int length = beginWord.length();
        int steps = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            ++steps;

            int qSize = queue.size();
            for (int i = 0; i < qSize; ++i) {
                String curWord = queue.poll();
                if (curWord.equals(endWord)) {
                    return steps;
                }

                for (int j = 0; j < length; ++j) {
                    StringBuilder newWord = new StringBuilder(curWord);
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        newWord.setCharAt(j, ch);

                        if (!wordSet.contains(newWord.toString()) || visited.contains(newWord.toString())) {
                            continue;
                        }

                        queue.offer(newWord.toString());
                        visited.add(newWord.toString());
                    }
                }
            }
        }

        return 0;
    }
}