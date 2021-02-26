package d210224;

import java.util.*;

// 테스트 결과 잘못 나옴

public class B1997 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 장식 판의 종류
        int w = sc.nextInt(); // 장식판, 박스 너비
        int b = sc.nextInt(); // 박스의 높이

        int [] result_height = new int [w]; // 높이
        int result = 0;

        for(int i = 0; i < n; i++){

            // 최대 높이
            for(int j=0; j<w; j++){
                if (result_height[j]>result) result = result_height[j];
            }

            // 장식판 정보 입력
            int h = sc.nextInt(); // 장식판 높이
            int c_h [] = new int [w];
            int n_h [] = new int [w];
            Arrays.fill(c_h, h+1);

            for(int j=0; j<h; j++) { // 한 줄씩 입력
                String[] array_word;
                String word = sc.next();
                array_word = word.split("");

                for (int k = 0; k < w; k++) {
                    if (array_word[k].equals(".")) {
                        continue;
                    } else { // X인 경우
                        // 밑바닥 높이 저장
                        if (c_h[k] > h - j)
                            c_h[k] = h - j;
                        //
                        if (n_h[k] < h - j)
                            n_h[k] = h - j;
                    }
                }
            }

            // 기준 높이 찾기

            int bottom=w-1;
            // 인덱스 마다 찾기
            for(int k=0; k<w; k++){
                // 각 인덱스에 대해
                boolean ok = true;
                for(int l=0; l<w; l++){
                    if (result_height[l] > result_height[k] - c_h[k] + c_h[l]){
                        ok = false;
                        System.out.println("k, l : "+k + ", " +l);
                        break;
                    }
                }
                if(ok){
                    bottom = k;
                    break;
                }

            }
            System.out.println(bottom);
            for(int k=0; k<w; k++){
                result_height[k] = result_height[bottom] + n_h[k]-c_h[bottom] + 1;
                if(result_height[k] > b) {
                    System.out.println("중간 결과: " + result);
                    for (int j = 0; j < w; j++) {
                        result_height[j] = n_h[j];
                    }
                }
            }

        }
        for(int j=0; j<w; j++){
            if (result_height[j]>result) result = result_height[j];
        }
        System.out.println("마지막: "+result);
    }
}