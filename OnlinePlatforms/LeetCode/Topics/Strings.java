package OnlinePlatforms.LeetCode.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Strings {

    int[] parent = new int[26];

    public static void main(String[] args) {
        Strings strings = new Strings();
        System.out.println(strings.findKthNumber(1000, 3));
    }

    public int findKthNumber(int n, int k) {
        int current = 1;
        k--; // We already count '1' as the first

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                current++;
                k -= steps;
            } else {
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private long countSteps(int n, long prefix, long nextPrefix) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        // Start from 1 to n, generating numbers in lexicographical order
        int current = 1;

        for (int i = 1; i <= n; ++i) {
            result.add(current);

            // If the current * 10 is within the range [1, n], multiply by 10
            if (current * 10 <= n) {
                current *= 10;
            } else if (current % 10 != 9 && current + 1 <= n) {
                // Otherwise, if incrementing by 1 is within the range, increment
                current++;
            } else {
                // Otherwise, go back to the nearest valid number to increment
                while ((current / 10) % 10 == 9) {
                    current /= 10;
                }
                current = current / 10 + 1;
            }
        }

        return result;
    }


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
