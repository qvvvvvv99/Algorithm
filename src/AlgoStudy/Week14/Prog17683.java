package AlgoStudy.Week14;

public class Prog17683 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"ABC" ["12:00,12:06,HELLO,ABC#ABC#ABC"] "(None)"
//		"ABC" ["12:00,12:10,HELLO,ABC#ABC#ABC"] "HELLO"
//		"ABC" ["12:04,13:00,HELLO,ABC#ABC#ABC"] "HELLO"
//		"C#C" ["12:00,12:06,HELLO,C#C#CC#"] "HELLO"
		String m = "ABC";
		String[] musicinfos = { "12:00,12:10,HELLO,ABC#ABC#ABC" };

		System.out.println(solution(m, musicinfos));
	}

	public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		String[] musicinfo;
		int len = 0, l = 0, musicLen = 0, max = 0;
		int sh, sm, eh, em;
		m = replace(m);
		for (int i = 0; i < musicinfos.length; i++) {
			musicinfo = musicinfos[i].split(",|:");
			sh = Integer.parseInt(musicinfo[0]);
			sm = Integer.parseInt(musicinfo[1]);
			eh = Integer.parseInt(musicinfo[2]);
			em = Integer.parseInt(musicinfo[3]);
			len = 60 * (eh - sh) + (em - sm);
			l = len;

			String music = musicinfo[5];
			music = replace(music);
			musicLen = music.length();
			String newMusic = music;
			if (l > musicLen) {
				while (true) {
					l -= musicLen;
					if (l <= musicLen) {
						newMusic += music.substring(0, l);
						break;
					}
					newMusic += music;
				}
			} else if (l < musicLen)
				newMusic = music.substring(0, l);
			// System.out.println(music);

			if (newMusic.contains(m)) {
				if (len > max) {
					max = len;
					answer = musicinfo[4];
				}
			}
		}

		return answer;
	}

	static String replace(String str) {
		str = str.replaceAll("C#", "a");
		str = str.replaceAll("D#", "b");
		str = str.replaceAll("F#", "c");
		str = str.replaceAll("G#", "d");
		str = str.replaceAll("A#", "e");
		return str;
	}
}
