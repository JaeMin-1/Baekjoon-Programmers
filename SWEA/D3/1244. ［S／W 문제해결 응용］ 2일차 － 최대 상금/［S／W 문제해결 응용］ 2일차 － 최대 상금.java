import java.io.*;
import java.util.*;

public class Solution {
    static Integer[] bestArr;
    static int answer, best, num;
    public static void DFS(Integer[] arr, int cnt, int start) {
        if(cnt == 0) {
            int sum = 0, num = 1;
            for(int i = arr.length-1; i>=0; i--) {
                sum += arr[i] * num;
                num *= 10;
            }
            answer = Math.max(answer, sum);
            return;

        }
        else {
            for(int i=start; i<arr.length-1; i++) {
                for(int j=i+1; j<arr.length; j++) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    DFS(arr, cnt-1, i);
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            Integer[] arr = new Integer[str.length];
            for(int i=0; i<str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
			
            int cnt = Integer.parseInt(st.nextToken());
            //시간 초과를 막는 핵심 코드
            if(arr.length<cnt) cnt = arr.length;
            answer = 0;
            DFS(arr, cnt, 0);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
