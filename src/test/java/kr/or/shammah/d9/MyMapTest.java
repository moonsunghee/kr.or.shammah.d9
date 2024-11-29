package kr.or.shammah.d9;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class MyMapTest {
  @Test
  void mapPut() {
    Map<String, String> englishKorean = new HashMap<>();
    englishKorean.put("book", "책");
    englishKorean.put("apple", "사가ㅗ");
    englishKorean.put("car", "자동차");
    //map에는 값을 수정하는 메서드가 없음, 그래서 .put()으로 덮어씀
    englishKorean.put("apple", "사과");
    
    assertThat(englishKorean).containsEntry("apple", "사과");
  }
  
  @Test
  void studentAgeMap() {
    //new HashMap<String, Integer>() : Opt+Cmd+V
    HashMap<String, Integer> studentsAge = new HashMap<>();
    studentsAge.put("문성희", 48);
    studentsAge.put("다니엘", 36);
    studentsAge.put("요한", 24);
    
    assertThat(studentsAge.get("다니엘")).isEqualTo(36);
  }
  
  @Test
  void fruitPriceMap() {
    HashMap<String, Integer> fruitPrice = new HashMap<>();
    fruitPrice.put("사과", 3000);
    fruitPrice.put("바나나", 2800);
    fruitPrice.put("감귤", 4600);
    fruitPrice.put("단감", 4000);
    fruitPrice.put("포도", 6000);
    fruitPrice.put("키위", 3900);
    
    fruitPrice.put("포도", 6200);
    
    //fruitPrice.keySet().for + Enter
    for (String key : fruitPrice.keySet()) {
      System.out.println("key = " + key);
    }
    
    //fruitPrice.values().for + Enter
    for (Integer value : fruitPrice.values()) {
      System.out.println("value = " + value);
    }
    
    //fruitPrice.entrySet().for + Enter
    for (Map.Entry<String, Integer> entry : fruitPrice.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      //System.out.println("key : " + key + ", value : " + value);
      
      if (value >= 4000) {
        System.out.println("4000원 이상의 과일 -> " + "key : " + key + ", value : " + value);
      }
    }
    
  }
  
  @Test
  void productStockMap() {
    Map<String, Integer> productStock = new HashMap<>();
    productStock.put("갤럭시 S24", 8);
    productStock.put("삼다수 2L", 20);
    productStock.put("칙촉 오리지널 6+2입 120g", 10);
    productStock.put("M4 맥북 프로", 5);
    
    // 아래에 코드를 작성해 주세요
    // productStock.put("갤럭시 S24", 7);
    // productStock.put("M4 맥북 프로", 4);
    int product1 = productStock.get("갤럭시 S24");
    int product2 = productStock.get("M4 맥북 프로");
    productStock.put("갤럭시 S24", product1 - 1);
    productStock.put("M4 맥북 프로", product2 - 1);
    
    // 아래 테스트를 통과해야 합니다
    assertThat(productStock.get("갤럭시 S24")).isEqualTo(7);
    assertThat(productStock.get("M4 맥북 프로")).isEqualTo(4);
  }
  
  @Test
  void nameListMap() {
    List<String> nameList = List.of(
        "권상윤",
        "김민성",
        "추민영",
        "김성락",
        "황승혁",
        "문성희",
        "문인혁",
        "박현지",
        "윤찬영",
        "윤태우",
        "권상윤",
        "이채현",
        "황효진",
        "권상윤",
        "황승혁",
        "박현지",
        "이호연",
        "전지예",
        "정해준",
        "문인혁",
        "김성락",
        "추민영",
        "허재",
        "황승혁",
        "황효진"
    );
    // 아래에 코드 추가
    Map<String, Integer> nameMap = new HashMap<>();

//    for(String name : nameList){
//      if(nameMap.get(name) == null){
//        nameMap.put(name, 1);
//      }else{
//        int count = nameMap.get(name);
//        count++;
//        nameMap.put(name, count);
//      }
//    }
    
    //nameList.for+Enter
    for (String name : nameList) {
      nameMap.put(name, nameMap.getOrDefault(name,0) + 1);
    }
    
    // 아래 테스트를 통과해야 합니다
    assertThat(nameMap).containsEntry("추민영", 2)
        .containsEntry("문성희", 1)
        .containsEntry("전지예", 1)
        .containsEntry("정해준", 1)
        .containsEntry("김성락", 2)
        .containsEntry("이호연", 1)
        .containsEntry("권상윤", 3)
        .containsEntry("황승혁", 3)
        .containsEntry("박현지", 2)
        .containsEntry("김민성", 1)
        .containsEntry("이채현", 1)
        .containsEntry("문인혁", 2)
        .containsEntry("황효진", 2)
        .containsEntry("윤찬영", 1)
        .containsEntry("윤태우", 1)
        .containsEntry("허재", 1);
  }
  
  @Test
  void findIntersection(){
    List<Integer> list1 = List.of(1,2,3,4);
    List<Integer> list2 = List.of(2,4,5,6);
    
    List<Integer> listIntsersection = new ArrayList<>();
    for (int i = 0; i < list2.size(); i++) {
      if(list1.contains(list2.get(i))){
        listIntsersection.add(list2.get(i));
      }
    }
    System.out.println(listIntsersection);
    
  }
  
  @Test
  void mapToArray(){
    ArrayList<String> 한국도시들 = new ArrayList<>(List.of("제주", "강릉", "울산"));
    ArrayList<String> 미국도시들 = new ArrayList<>(List.of("디트로이트", "스프링필드", "볼티모어"));
    ArrayList<String> 독일도시들 = new ArrayList<>(List.of("프랑크푸르트", "함부르크", "브레멘"));
    
    ArrayList<ArrayList<String>> 세계도시들 = new ArrayList<>();
    세계도시들.add(한국도시들);
    세계도시들.add(미국도시들);
    세계도시들.add(독일도시들);
    
    /*HashMap<String, List<String>> maps = new HashMap<>();
    for (ArrayList<String> cuntries : 세계도시들) {
      if(cuntries == 한국도시들){
        maps.put("한국", 한국도시들);
      }else if(cuntries==미국도시들){
        maps.put("미국", 미국도시들);
      }else{
        maps.put("독일", 독일도시들);
      }
    }*/
    //System.out.println(세계도시들);
    HashMap<String, ArrayList<String>> 세계도시들v2 = new HashMap<>();
    세계도시들v2.put("한국", 한국도시들);
    세계도시들v2.put("미국", 미국도시들);
    세계도시들v2.put("독일", 독일도시들);
    //System.out.println(세계도시들v2);
    
    HashMap<String, String> emoji2 = new HashMap<>();
    emoji2.put("한국", "🇰🇷");
    emoji2.put("미국", "🇺🇸");
    emoji2.put("독일", "🇩🇪");
    
    for (Map.Entry<String, ArrayList<String>> entry : 세계도시들v2.entrySet()) {
      String 나라 = entry.getKey();
      String emoji = emoji2.get(나라);
      
      ArrayList<String> 그나라도시들 = entry.getValue();
      //System.out.println("나라 : "+나라+", 도시들 : "+그나라도시들);
//      if(나라.equals("한국")){
//        emoji = "🇰🇷";
//      }
//      if(나라.equals("미국")){
//        emoji = "🇺🇸";
//      }
//      if(나라.equals("독일")){
//        emoji = "🇩🇪";
//      }
      for(String 나라이름:세계도시들v2.keySet()){
        String 이모지 = emoji2.get(나라이름);
        ArrayList<String> 도시들 = 세계도시들v2.get(나라이름);
        System.out.println(이모지 + 나라이름 + 도시들);
      }
//      for (String 도시 : 그나라도시들) {
//        System.out.println(emoji + 도시);
//      }
    }
  }
  
  @Test
  void myContainsTest() {
    ArrayList<String> names = new ArrayList<>();
    names.add("박효신");
    names.add("이지은");
    names.add("하현우");
    
    boolean 하현우존재여부 = myContains(names, "하현우");
    boolean 잔나비존재여부 = myContains(names, "잔나비");
    
    assertThat(하현우존재여부).isTrue();
    assertThat(잔나비존재여부).isFalse();
    System.out.println(myContains(names, "이지은"));
  }
  boolean myContains(ArrayList<String> stringList, String inputString){
    for(String str : stringList){
      System.out.println("str = " + str);
      if(str.equals(inputString)){
        return true;
      }
    }
    return false;
  }
  @Test
  void getCommonElementsTest() {
    List<Integer> firstList = List.of(1, 2, 3);
    List<Integer> secondList = List.of(2, 3, 4);
    
    List<Integer> commonElements = getCommonElements(firstList, secondList);
    
    assertThat(commonElements)
        .containsExactlyInAnyOrder(2, 3);
  }
  List<Integer> getCommonElements(List<Integer> listA, List<Integer> listB){
    
    List<Integer> setA = new ArrayList<>(listA);
    // 공통 요소를 저장할 리스트
    List<Integer> commonElements = new ArrayList<>();
    
    // listB의 각 요소가 setA에 포함되어 있는지 확인
    for (Integer element : listB) {
      //if(myContains(setA, element)){
      //  commonElements.add(element);
      //}
      if (setA.contains(element)) {
       commonElements.add(element);
      }
    }
    
    return commonElements;
  }
}
