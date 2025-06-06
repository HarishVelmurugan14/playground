package OnlinePlatforms.LeetCode.Topics;

import java.util.Arrays;
import java.util.Stack;

public class Strings {
    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize parent array
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union characters from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append((char) (find(c - 'a') + 'a'));
        }

        return result.toString();
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by lexicographical order (smaller becomes the parent)
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }

    public String robotWithString(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        char minChar = 'a';
        for (char x : s.toCharArray()) {
            freq[x - 'a']--;
            while (minChar <= 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }

            stack.push(x);
            while (!stack.isEmpty() && stack.peek() <= minChar) {
                result.append(stack.pop());
            }
        }

        return result.toString();
    }
}
