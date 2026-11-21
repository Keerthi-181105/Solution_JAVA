class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] head = new int[n], nxt = new int[n];
        Arrays.fill(head, -1);
        for (int i = 1; i < n; i++) {
            nxt[i] = head[parent[i]];
            head[parent[i]] = i;
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] newParent = new int[n], prv = new int[n], order = new int[n], stack = new int[n];
        int[] cur = head.clone();
        int cnt = 0, sp = 0;

        int c0 = s.charAt(0) - 'a';
        prv[0] = last[c0];
        last[c0] = 0;
        order[cnt++] = 0;
        stack[sp++] = 0;

        while (sp > 0) {
            int x = stack[sp - 1];
            if (cur[x] != -1) {
                int y = cur[x];
                cur[x] = nxt[y];
                int c = s.charAt(y) - 'a';
                newParent[y] = (last[c] != -1) ? last[c] : parent[y];
                prv[y] = last[c];
                last[c] = y;
                order[cnt++] = y;
                stack[sp++] = y;
            } else {
                last[s.charAt(x) - 'a'] = prv[x];
                sp--;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i >= 1; i--) {
            int x = order[i];
            ans[newParent[x]] += ans[x];
        }
        return ans;
    }
}