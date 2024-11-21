package kr.or.shammah.d9;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class StringClassEx {
    @Test
    void stringTest(){
        String str = "Hello world";
        //----
        System.out.println("srt.length(), str의 문자열을 반환 : " + str.length());
        //----
        System.out.println("str.isEmpty(), str이 비엉있는 문자열인지를 검사 (t/f) : " + str.isEmpty()); //""
        //----
        System.out.println("str.equals('Hello'), str과 일치된 전체 문자열을 검사 (t/f) : " + str.equals("Hello"));
        //----
        System.out.println("str.charAt(n), str의 특정 인덱스 문자열을 반환 : " + str.charAt(0));
        //----
        System.out.println("str.toLowerCase(), str의 모든 문자를 소문자로 변환하여 반환 : " + str.toLowerCase());
        //----
        System.out.println("str.toLowerCase(), str의 모든 문자를 대문자로 변환하여 반환 : " + str.toUpperCase());
        //----
        System.out.println("str.contains('lo'), str의 문자열 중에서 특정문자열을 검사 (t/f) : " + str.contains("lo"));
        //----
        System.out.println("str.indexOf('o'), str의 특정문자열의 인덱스 번호를 반환 : "+ str.indexOf("o"));
        //----
        System.out.println("str.startsWith('H'), 특정 문자열로 시작하는지 검사 (t/f): "+str.startsWith("H"));
        //----
        System.out.println("str.endsWith('d'), 특정 문자열로 마치는지 검사 (t/f):  "+str.endsWith("d"));
        //----
        System.out.println("str.repeat(4), str의 문자열을 해당 횟수 만큼 반복 반환 : " + str.repeat(4));
        //----
        System.out.println("str.concat(), str에 문자열을 추가하여 반환 " + str.concat(", My World"));
    }

    @Test
    void stringGumsa(){
        String uri = "http://www.google.com/search?q=java";
        String[] uriArr = uri.split("//");
        String[] uriArr2 = uriArr[1].split("/");
        System.out.println(uriArr2[0]);
    }
    @Test
    void arrayCopy(){
        ArrayList<String> strs = new ArrayList<>();
        strs.add("김씨");
        strs.get(0);
        strs.set(0, "박씨");
        strs.remove(0);
    }

    @Test
    void averPoint(){
        //--- Cmd+Alt+V : Refactor / Introduce Valuable
        String point = "80, 60, 70, 100, 90";
        String[] pt = point.split(", ");
        List<Integer> ptList = Arrays.stream(pt).map(s -> Integer.parseInt(s)).toList();

        int sum= 0;
        for (int i = 0; i < ptList.size(); i++) {
            sum += ptList.get(i);
        }
        sum = sum/ptList.size();
        System.out.println(sum);

        List<Integer> highPt = new ArrayList<>();
        List<Integer> lowPt = new ArrayList<>();

        for (int i = 0; i < ptList.size(); i++) {

            if(ptList.get(i) > sum){
                highPt.set(i,  ptList.get(i));
                System.out.println(highPt);
            }else{
                lowPt.set(i,  ptList.get(i));
                System.out.println(lowPt);
            }

        }
    }
}
