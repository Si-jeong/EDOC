package d210217;

import java.io.*;
import java.util.*;


public class BufferIO_EX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //한 줄에 두 개의 정수 a, b 입력
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine()); //한 줄에 한 개의 정수 c 입력

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        sb.append(c+"\n");
        sb.append("fin.\n");

        bw.write(sb.toString());

        bw.close();
        br.close();
    }


}
