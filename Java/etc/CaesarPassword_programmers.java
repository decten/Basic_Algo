package etc;

public class CaesarPassword_programmers {

    static void solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            //n이 26 넘어갈 수 있음 -> 나머지 연산
            if (alpha >= 'a' && alpha <= 'z') {
                //'a'에 남은 값만 더하는 법을 배움
                char newAlpha = (char) ((alpha - 'a' + n) % 26 + 'a');
                sb.append(newAlpha);
                continue;
            } else if (alpha >= 'A' && alpha <= 'Z') {
                char newAlpha = (char) ((alpha - 'A' + n) % 26 + 'A');
                sb.append(newAlpha);
                continue;
            }
            sb.append(alpha);
        }
    }

    public static void main(String args[]) {
        solution("a B z", 4);
    }
}
