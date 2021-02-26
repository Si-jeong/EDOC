package d210224;

import java.util.Scanner;

// 테스트 결과 잘못 나옴
public class B16237 {
    static int result=0;
    static int a, b, c, d, e;

    static int solve(){
        if(a==0 && b==0){
            result = result + c + d;
            return result;
        }
        if(a==0 && c==0){
            result += d;
            result += b/2 + b%2;
            return result;
        }
        if(b==0 && d==0){
            if(a / 2 >= c){
                result += c;
                a = a - 2 * c;
                result += a/5 + a%5;
            }
            else{
                result += c;
            }
            return result;

        }
        if(c==0 && d==0){
            if(a / 3 >= b){
                result += b;
                a = a - 3 * b;
                result += a/5 + a%5;
            }
            else{
                result += a/3;
                b -= a/3;
                result += b/2 + b%2;
            }
            return result;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        result += e;

        if (a < d){
            result += a;
            a = 0;
            d = d - a;
        }
        else{
            result += d;
            d = 0;
            a = a - d;
        }
        if (b < c){
            result += b;
            b = 0;
            c = c - b;
        }
        else{
            result += c;
            c = 0;
            b = b - c;
        }

        System.out.print(solve());
    }
}
