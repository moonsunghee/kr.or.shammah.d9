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
        System.out.println(sum); //80

        List<Integer> highPt = new ArrayList<>();
        List<Integer> lowPt = new ArrayList<>();

        for (int i = 0; i < ptList.size(); i++) {
            if(ptList.get(i) > sum){
                highPt.add( ptList.get(i));
                System.out.println(highPt+"평균위");
            }else{
                lowPt.add(ptList.get(i));
                System.out.println(lowPt+"평균아래");
            }
        }
        System.out.println(highPt+"평균위, "+lowPt+"평균아래");
    }


    @Test
    void listWithFunction(){
        ArrayList<Integer> numbers = new ArrayList<>();
//        assertThat(getSum(List.of(1, 2, 3, 4))).isEqualTo(10);
//        assertThat(getSum(List.of(7))).isEqualTo(7);
//        assertThat(getSum(List.of())).isEqualTo(0);
//        assertThat(getAverage(List.of(1, 2, 3, 4))).isEqualTo(2.5);
//        assertThat(getAverage(List.of(7))).isEqualTo(7.0);
//        assertThat(getAverage(List.of())).isEqualTo(0.0);
//        assertThat(findMax(List.of(3, 10, 5, 4, 7))).isEqualTo(10);
//        assertThat(findMax(List.of(7))).isEqualTo(7);
//        assertThat(isPass(List.of(60, 60))).isTrue();
//        assertThat(isPass(List.of(40, 80))).isTrue();
//        assertThat(isPass(List.of( 100, 100, 39))).isFalse();
//        assertThat(isPass(List.of( 39, 100, 100))).isFalse();
//        assertThat(isPass(List.of(100, 0, 100))).isFalse();
        //---------
        assertThat(getIntegersBetween(1, 5)).isEqualTo(List.of(1, 2, 3, 4, 5));
        assertThat(getIntegersBetween(-3, 1)).isEqualTo(List.of(-3, -2, -1, 0, 1));
        assertThat(getIntegersBetween(3, 3)).isEqualTo(List.of(3));
        assertThat(getIntegersBetween(5, 1)).containsExactlyInAnyOrder(5, 4, 3, 2, 1);
    }
    int getSum(List<Integer> numList) {
        int sum = 0;
        for(int i=0; i<numList.size(); i++){
            sum = sum+numList.get(i);
        }
        return sum;
    }
    double getAverage(List<Integer> numList){
        double average=0;
        if(numList.isEmpty()) {
            average = 0.0;
        }else{
            average = (double) getSum(numList) / numList.size();
        }
        return average;
    }
    int findMax(List<Integer> numList){
        int maxNum = numList.get(0);
        for(int i=0; i<numList.size(); i++){
            maxNum = Math.max(maxNum, numList.get(i));
        }
        return maxNum;
    }

    boolean isPass(List<Integer> numList){
        int sum = 0;
        double average = 0;

        boolean subjectFail = true;
        boolean passOrFail = false;

        for (Integer i : numList) {
            if(i < 40){
                subjectFail = false;
            }
            sum = sum + i;
        }

        average = (double) sum/numList.size();
        if(average >= 60){
            passOrFail = true;
        }

        return subjectFail && passOrFail;
    }

    List<Integer> getIntegersBetween(int start, int end){
        List<Integer> result = new ArrayList<>();

        if(start <= end){
            for(int i = start; i <= end; i++){
                result.add(i);
            }
        }else{
            for(int i = start; i >= end; i--){
                result.add(i);
            }
        }
        return result;
    }
}
