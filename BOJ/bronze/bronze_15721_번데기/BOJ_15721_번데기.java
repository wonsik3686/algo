import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15721_번데기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());	// 인원 저장 변수
		int T = Integer.parseInt(br.readLine());	// 구할 번째 변수
		char target = br.readLine().charAt(0);	// 구할 구호 변수
		int cnt = 0;	// 구호 카운팅 변수
		String str1 = "0101";	// 문장 part1
		String str2 = "0";	// 문장 part2
		String str3 = "1";	// 문장 part3
		int idx = 0; 	// 사람 번호
		int res = 0;	// 결과 저장 변수
		
		while(true) {	// 문장 회차 순회
			
			str2 += "0";	// 구호 추가
			str3 += "1";	// 구호 추가
			String strFull = str1 + str2 + str3;	// n회차 문장으로 결합
			int size = strFull.length();	// 문장 길이 변수
			for(int i = 0; i < size; i++) {
				if(idx == A)	// 인원 한바퀴 돌았으면
					idx = 0;	// 처음부터
				if(strFull.charAt(i) == target) {	// 목표 구호면
					cnt++;			// 구호 카운팅
					if(cnt == T) {	// 목표 카운팅이면
						res = idx;	// 현재 사람 번호 저장
						break;		// 반복문 탈출
					}
				}					
				idx++;				// 다음 사람으로 idx 증가
			}
			if(cnt == T)			// 결과 맞으면 while문 탈출
				break;			
		}
		System.out.println(res);	// 결과값 출력
	} // end main
}
