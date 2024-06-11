package baseball;

import java.io.*;
import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private int STARTINCLISIVE = 1;
    private int ENDINCLUSIVE = 9;
    private String QUESTION = "숫자를 입력해주세요 : ";
    private String ANSWER = "";
    private String INPUT = "";
    private int BALL;
    private int STRIKE;
    private String RANDOMNUM1;
    private String RANDOMNUM2;
    private String RANDOMNUM3;

    public void init(Game baseballgame){
        System.out.println(ANSWER);
        System.out.println(BALL+"|"+STRIKE);
        loopGame();

    }

    Game (){
        ANSWER = getStringAnswer();
    }

    private void loopGame(){
        while(STRIKE!=3){
            System.out.print(QUESTION);
            getInput();
            isCheckAll();
            showBallStrikeCount();
            BALL = 0;
            if(STRIKE != 3){
                STRIKE = 0;
            }
        }
    }

    private void showStrikeCount(){
        if(STRIKE != 0){
            System.out.println(STRIKE+"스트라이크");
        }
    }

    private void showBallStrikeCount(){
        if(BALL == 0){
            showStrikeCount();
        }else{
            System.out.print(BALL+"볼 ");
            showStrikeCount();
        }
    }

    private void isCheckAll(){
        isCheck(0);
        isCheck(1);
        isCheck(2);
    }

    private void isCheck(int arg){
        for(int i=0;i<3;i++){
          if(i==arg){
            if(ANSWER.charAt(arg)==INPUT.charAt(i)){
                getStrike();
                continue;
            }
          }else{
            if(ANSWER.charAt(arg)==INPUT.charAt(i)){
                getBall();
                continue;
            }
          }
        }
    }

    private void getBall(){
        BALL += 1;
    }

    private void getStrike(){
        STRIKE += 1;
    }

    private void getInput(){
         INPUT = readLine();
         isVerifiedInput(INPUT);
    }

    private void isVerifiedInput(String arg){
        if (arg.length() != 3) {
            throw new IllegalArgumentException("사용자가 잘못된 값을 입력하였습니다:"+arg);
        }
    }

    private void isVerifiedAnswer(String arg1, String arg2, String arg3){
        Set<String> set = new HashSet<>();
        set.add(arg1);
        set.add(arg2);
        set.add(arg3);
        System.out.println(set);
        if(set.size() != 3) {
            getStringAnswer();
        }
    }


    private int getRandomNum(){
        return pickNumberInRange(STARTINCLISIVE, ENDINCLUSIVE);
    }

    private String getStringAnswer(){
        int int_RandomNum1 = getRandomNum();
        int int_RandomNum2 = getRandomNum();
        int int_RandomNum3 = getRandomNum();
        RANDOMNUM1 = Integer.toString(int_RandomNum1);
        RANDOMNUM2 = Integer.toString(int_RandomNum2);
        RANDOMNUM3 = Integer.toString(int_RandomNum3);
        isVerifiedAnswer(RANDOMNUM1, RANDOMNUM2, RANDOMNUM3);
        String String_RandomNum = RANDOMNUM1 + RANDOMNUM2 + RANDOMNUM3;
        return String_RandomNum;
    }

}
