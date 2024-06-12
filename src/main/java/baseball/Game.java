package baseball;

import java.io.*;
import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private boolean GAMEBUTTON = true;
    private int STARTINCLISIVE = 1;
    private int ENDINCLUSIVE = 9;
    private String QUESTION = "숫자를 입력해주세요 : ";
    private String ANSWER = "";
    private String INPUT = "";
    private String INPUT2 = "";
    private int BALL;
    private int STRIKE;
    private String RANDOMNUM1;
    private String RANDOMNUM2;
    private String RANDOMNUM3;

    public void init(Game baseballgame){
        loopGame();

    }

    Game (){
        getStringAnswer();
    }

    private void initCount(){
        BALL = 0;
        STRIKE = 0;
    }

    private void stopGame(){
        INPUT2 = "";
        GAMEBUTTON = false;
    }

    private void isVerifiedInput2(String arg){
        if(arg.equals("1")){
            getStringAnswer();
            initCount();
            loopGame();
        } else if (arg.equals("2")) {
            initCount();
            stopGame();
        } else {
            stopGame();
            throw new IllegalArgumentException("사용자가 잘못된 값을 입력하였습니다:"+arg);
        }
    }

    private void loopGame(){
        while(GAMEBUTTON){
            System.out.print(QUESTION);
            getInput();
            isCheckAll();
            showBallStrikeCount();
        }
    }

    private void winGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        INPUT2 = readLine();
        isVerifiedInput2(INPUT2);
    }

    private void doIWin (){
        System.out.print("\n");
        if(STRIKE==3){
            winGame();
        }else {
            initCount();
        }
    }

    private void showBallStrikeCount(){
        if(BALL == 0){
            showStrikeCount();
        }else{
            System.out.print(BALL+"볼 ");
            showStrikeCount();
        }
        doIWin();
    }

    private void showStrikeCount(){
        if(STRIKE == 0){
            System.out.print("낫싱");
        }else {
            System.out.print(STRIKE+"스트라이크");
        }
    }

    private void isCheckAll(){
        isCheckOne(0);
        isCheckOne(1);
        isCheckOne(2);
    }

    private void isCheckOne(int arg){
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
        if(set.size() != 3) {
            getStringAnswer();
        }
    }


    private int getRandomNum(){
        return pickNumberInRange(STARTINCLISIVE, ENDINCLUSIVE);
    }

    private void getStringAnswer(){
        int int_RandomNum1 = getRandomNum();
        int int_RandomNum2 = getRandomNum();
        int int_RandomNum3 = getRandomNum();
        RANDOMNUM1 = Integer.toString(int_RandomNum1);
        RANDOMNUM2 = Integer.toString(int_RandomNum2);
        RANDOMNUM3 = Integer.toString(int_RandomNum3);
        isVerifiedAnswer(RANDOMNUM1, RANDOMNUM2, RANDOMNUM3);
        String String_RandomNum = RANDOMNUM1 + RANDOMNUM2 + RANDOMNUM3;
        ANSWER = String_RandomNum;
//        System.out.println(ANSWER);
    }

}
