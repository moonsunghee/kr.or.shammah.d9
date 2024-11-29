package kr.or.shammah.d9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {
    @Test
//    void maxTest() {
//        //System.out.println("hello Test");
//        assertThat(Math.max(10, 5)).isEqualTo(10);
//        assertThat(pow(5)).isEqualTo(25);
//    }
//    int pow(int n){
//        return 0;
//    }
    void squaerTest(){
        assertThat(square(5)).isEqualTo(25);
    }
    int square(int n){
        int result = n * n;
        return result;
    }
    @Test
    void calculateAge() {
        assertThat(calculateBirthYear(1)).isEqualTo(2024);
        assertThat(calculateBirthYear(2)).isEqualTo(2023);
        assertThat(calculateBirthYear(4)).isEqualTo(2021);
    }
    int calculateBirthYear(int age){
        int year = 2025 - age;
        return year;
    }
    @Test
    void getAverageTest(){
        assertThat(getAverage(100, 100, 70)).isEqualTo(90);
        assertThat(getAverage(0, 100, 50)).isEqualTo(50);
    }
    int getAverage(int a, int b, int c){
        int result = (a + b + c)/3;
        return result;
    }
     void isPositiveTest(){
         assertThat(isPositive(3)).isEqualTo(true);
         assertThat(isPositive(9)).isTrue();
         assertThat(isPositive(0)).isFalse();
         assertThat(isPositive(-5)).isFalse();
     }
     boolean isPositive(int a){
        boolean result = a > 0;
        return result;
     }

}
