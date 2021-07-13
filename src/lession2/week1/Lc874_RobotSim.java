package lession2.week1;

import java.util.HashSet;

public class Lc874_RobotSim {
    /**
     * 874. 模拟行走机器人
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        //上右下左
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int dire = 0;
        int ans = 0;
        HashSet<String> set = new HashSet();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }
        for (int i = 0; i < commands.length; i++) {
            int cmd = commands[i];
            if (cmd == -1) {
                dire = (dire + 1) % 4;
            } else if (cmd == -2) {
                dire = (dire + 3) % 4;
            } else if (cmd > 0) {
                for (int k = 0; k < cmd; k++) {
                    int curx = x + dx[dire];
                    int cury = y + dy[dire];
                    if (!set.contains(curx + "," + cury)) {
                        x = curx;
                        y = cury;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}
