package AlgoStudy.Week12;

public class Prog81302 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] cx = { -1, 1, 1, -1 };
	static int[] cy = { 1, 1, -1, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] res = new int[5];
		res = solution(places);

		for (int i = 0; i < 5; i++)
			System.out.print(res[i] + " ");
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int room = 0; room < 5; room++)
			answer[room] = check(places[room]);

		return answer;
	}

	static int check(String[] places) {
		int nx, ny, nnx, nny;

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (places[r].charAt(c) == 'P') {
					// �����¿�
					for (int i = 0; i < 4; i++) {
						nx = r + dx[i];
						ny = c + dy[i];
						if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
							continue;
						if (places[nx].charAt(ny) == 'P')
							return 0;

						// 2ĭ �����¿�
						nnx = r + 2 * dx[i];
						nny = c + 2 * dy[i];
						if (nnx < 0 || nnx >= 5 || nny < 0 || nny >= 5)
							continue;
						if (places[nnx].charAt(nny) == 'P') {
							if (places[nx].charAt(ny) != 'X')
								return 0;
						}
					}
					// �밢��
					for (int i = 0; i < 4; i++) {
						nx = r + cx[i];
						ny = c + cy[i];
						if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
							continue;
						if (places[nx].charAt(ny) == 'P') {
							int j;
							for (int cnt = 0; cnt < 2; cnt++) {
								j = i + cnt;
								j %= 4;
								nnx = r + dx[j];
								nny = c + dy[j];
								if (places[nnx].charAt(nny) != 'X')
									return 0;
							}
						}
					}
				}
			}
		}
		return 1;
	}
}
