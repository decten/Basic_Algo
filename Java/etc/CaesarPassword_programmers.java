package etc;

import java.util.*;

public class CaesarPassword_programmers {
    static void solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length();i++){
            char alpha = s.charAt(i);
            if(alpha==' '){
                sb.append(' ');
                continue;
            }
            if(alpha+n > 'Z'){
                char newAlpha = (char) (alpha+n-'Z');
                sb.append(newAlpha);
                continue;
            }
            if(alpha+n > 'z'){
                char newAlpha = (char) (alpha+n-'z');
                sb.append(newAlpha);
                continue;
            }
            char newAlpha = (char) (alpha+n);
            sb.append(newAlpha);
        }
        sb.toString();
    }
    public static void main(String args[]){
        solution("AB",1);
    }
}
