package com.koreait.first;

public class Utils {
    //문제가 발생되면 0리턴
    //문제가 발생안되면 파싱한다.
    public static int parseStringToInt(String val) {
        //예외처리
        int intVal = 0;
        try {
            intVal = Integer.parseInt(val);
        } catch(Exception e) {
            // 예외가 발생되었을 때 실행되고 싶은 것들을 여기에다가
            // 작성을 하시면 됩니다.
            e.printStackTrace(); //에러 내용 로그에 찍는다.
        } finally {
            // 에러가 터지든 안터지든 !!!무조건!!!
            // 실행됐으면 하는 것들을 작성.
        }

        return intVal;
    }
}
