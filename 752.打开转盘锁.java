class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }

        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        int steps = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; ++i) {
                String curPW = queue.poll();
                if (curPW.equals(target)) {
                    return steps;
                }

                for (int j = 0; j < 4; ++j) {
                    char[] newPW1 = new String(curPW).toCharArray();
                    char[] newPW2 = new String(curPW).toCharArray();

                    newPW1[j] = newPW1[j] == '0' ? '9' : --newPW1[j];
                    newPW2[j] = newPW2[j] == '9' ? '0' : ++newPW2[j];

                    String pw1 = String.valueOf(newPW1);
                    String pw2 = String.valueOf(newPW2);

                    if (!deadSet.contains(pw1) || !visited.contains(pw1)) {
                        queue.offer(pw1);
                        visited.add(pw1);
                    }
                    if (!deadSet.contains(pw2) || !visited.contains(pw2)) {
                        queue.offer(pw2);
                        visited.add(pw2);
                    }
                }
            }

            ++steps;
        }

        return -1;
    }
}