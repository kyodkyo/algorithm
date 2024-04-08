import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, map[][], ans;
	static boolean visited[][][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Node {
		int r, c, t, use;

		public Node(int r, int c, int t, int use) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.use = use;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new int[N][N];
		visited = new boolean[2][N][N];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		// 교차로 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if (map[i][j] == 0) {
					if ((i - 1 >= 0 && map[i - 1][j] == 0) || (i + 1 < N && map[i + 1][j] == 0))
						cnt++;
					if ((j - 1 >= 0 && map[i][j - 1] == 0) || (j + 1 < N && map[i][j + 1] == 0))
						cnt++;
				}
				if (cnt == 2)
					map[i][j] = -1;
			}
		}
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 1));
		visited[1][0][0] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.r==N-1 && cur.c==N-1) {
				ans = Math.min(ans, cur.t);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				int nt = cur.t + 1;
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == -1)
					continue;
				if (map[nr][nc] == 0) {
					// 대기
					if (nt % M != 0) {
						q.add(new Node(cur.r, cur.c, cur.t + 1, cur.use));
					} else if (cur.use>0 && map[cur.r][cur.c] == 1 && !visited[0][nr][nc]) {// 연속이지 않고 방문하지 않은곳
						visited[0][nr][nc] = true;
						q.add(new Node(nr, nc, nt, 0));
					}
				} else if (map[nr][nc] == 1 && !visited[cur.use][nr][nc]) {
					visited[cur.use][nr][nc] = true;
					q.add(new Node(nr, nc, nt, cur.use));
				} else if (map[nr][nc] >= 2) {
					// 대기
					if (nt % map[nr][nc] != 0) {
						q.add(new Node(cur.r, cur.c, nt, cur.use));
					}
					// 이동
					else if (map[cur.r][cur.c] == 1 && !visited[cur.use][nr][nc]) {
						visited[cur.use][nr][nc] = true;
						q.add(new Node(nr, nc, nt, cur.use));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		System.out.println(ans);
	}
}
