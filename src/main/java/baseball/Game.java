package baseball;

import java.io.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private int STARTINCLISIVE = 1;
    private int ENDINCLUSIVE = 9;
    private String QUESTION = "숫자를 입력해주세요 : ";
    private String ANSWER = "";

    public void init(Game baseballgame){
        System.out.println(ANSWER);
    }


    Game (){
        ANSWER = getStringAnswer();
    }

    private int getRandomNum(){
        return pickNumberInRange(STARTINCLISIVE, ENDINCLUSIVE);
    }

    private String getStringAnswer(){
        int int_RandomNum1 = getRandomNum();
        int int_RandomNum2 = getRandomNum();
        int int_RandomNum3 = getRandomNum();
        String String_RandomNum1 = Integer.toString(int_RandomNum1); this.getRandomNum();
        String String_RandomNum2 = Integer.toString(int_RandomNum2); this.getRandomNum();
        String String_RandomNum3 = Integer.toString(int_RandomNum3); this.getRandomNum();
        String String_RandomNum = String_RandomNum1+String_RandomNum2+String_RandomNum3;
        return String_RandomNum;
    }

    private String getInputNum(){
        return readLine();
    }

}
