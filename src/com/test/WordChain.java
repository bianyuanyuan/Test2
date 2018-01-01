package com.test;

class WordChain {
    public static Word word[];
    public static String s[] = new String[]{
            "aloha",
            "dog",
            "arachnid",
            "gopher",
            "tiger",
            "rat",
    };

    public WordChain() {
    }

    static int n = 6, m, fa[];
    static boolean flag[];
    static int path[];
    static boolean visit[];
    static int in[];
    static int out[];

    public static int root(int x) {
        if (fa[x] == x) {
            return x;
        }
        return fa[x] = root(fa[x]);
    }

    public static void uset(int x, int y) {
        int a = root(x);
        int b = root(y);
        if (a != b) {
            fa[b] = a;
        }
    }

    public static boolean judge() {
        int t = 0;
        for (int i = 0; i < 26; ++i) {
            if (flag[i] && fa[i] == i) {
                t++;
            }
        }
        return t == 1;
    }

    public static void find(int u) {
        for (int i = 0; i < n; ++i) {
            if (!visit[i] && word[i].u == u) {
                visit[i] = true;
                find(word[i].v);
                path[m++] = i;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 6; i++) {
            int u = s[i].charAt(0) - 'a';
            int v = s[i].charAt(s[i].length() - 1) - 'a';
            word[i].u = u;
            word[i].v = v;
            in[v]++;
            out[u]++;
            flag[u] = true;
            flag[v] = true;
            uset(u, v);
        }
        int start = word[0].u;
        int cnt1 = 0, cnt2 = 0;
        int i;
        for (i = 0; i < 26; i++) {
            if (in[i] == out[i]) {
                continue;
            } else if (in[i] == out[i] + 1) {
                cnt1++;
            } else if (in[i] == out[i] - 1) {
                cnt2++;
                start = i;
            } else {
                break;
            }
        }

        if (i == 26 && (cnt1 == cnt2 || cnt1 < 2) && judge()) {
            m = 0;
            find(start);
            for (i = m - 1; i > 0; --i) {
                System.out.print(word[path[i]].s + "." + word[path[0]].s);
            }
            System.out.println();
        } else {
            System.out.println("These words can not be joined.");
        }
    }
}
