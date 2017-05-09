public class BowlingGame {

 int score = 0;

    public int cal(String bowlingCode, int i) {
        score = 0;
        char c0 = bowlingCode.charAt(i + 1);
        char c1 = bowlingCode.charAt(i + 2);
        char c2 = bowlingCode.charAt(i + 3);
        char c3 = bowlingCode.charAt(i + 4);
        if (bowlingCode.charAt(i) == 'X') {
            score = score + 10;
            if (c1 == 'X') {
                score = score + 10;
                if (c3 == 'X') {
                    score = score + 10;
                } else if (c3 != '-') {
                    if (c3 == '|') {
                        if (bowlingCode.charAt(i + 5) == 'X')
                            score += 10;
                        else if (bowlingCode.charAt(i + 5) != '-')
                            score += Integer.parseInt("" + bowlingCode.charAt(i + 5));
                    } else {
                        score = score + Integer.parseInt("" + c3);
                    }
                }
            } else if (c1 == '-') {
                if (c2 == '/')
                    score = score + 10;
                else if (c2 != '-') {
                    score = score + Integer.parseInt("" + c2);
                }
            } else {
                if (c2 == '/') {
                    score = score + 10 ;
                } else if (c2 != '-') {
                     score = score + Integer.parseInt("" + c1);
                    score = score + Integer.parseInt("" + c2);
                }
            }
        } else if (bowlingCode.charAt(i) == '-') {
            if (c0 == '/') {            
                score = score + 10;
                if (c2 == 'X')
                    score = score + 10;
                else if (c2 != '-')
                    score = score + Integer.parseInt("" + c2);
            }
        } else if (bowlingCode.charAt(i) != '|' && bowlingCode.charAt(i) != '/') {
            score = score + Integer.parseInt("" + bowlingCode.charAt(i));
            if (c0 == '/') {
                score = score + 10 - Integer.parseInt("" + bowlingCode.charAt(i));
                if (c2 == 'X')
                    score = score + 10;
                else if (c2 != '-') {
                    score = score + Integer.parseInt("" + c2);
                }
            } else if (c0 != '-' && c0 != '|') {
                score = score + Integer.parseInt("" + c0);
            }
        }
        System.out.println(score);
        return score;
    }

    public int getBowlingScore(String bowlingCode) {
        if (bowlingCode.charAt(bowlingCode.length() - 1) == '|') {
            for (int i = 0; i < bowlingCode.length() - 5; ++i) {
                score += cal(bowlingCode, i);
            }
            char c4 = bowlingCode.charAt(bowlingCode.length() - 4);
            char c5 = bowlingCode.charAt(bowlingCode.length() - 3);
            if (c4 != '-') {
                score += Integer.parseInt("" + c4);
            }
            if (c5 != '-') {
                score += Integer.parseInt("" + c5);
            }

        } else if (bowlingCode.charAt(bowlingCode.length() - 2) == '|') {
            for (int i = 0; i < bowlingCode.length() - 6; ++i) {
                score += cal(bowlingCode, i);
            }
            score += 10;
            char c4 = bowlingCode.charAt(bowlingCode.length() - 1);
            if (c4 == 'X') {
         
                score += 10;
            } else if(c4 != '-')
                score += Integer.parseInt("" + c4);
        } else   {
            for (int i = 0; i < bowlingCode.length() - 6; ++i) {
                score += cal(bowlingCode, i);
            }
            score += 10;
            char c4 = bowlingCode.charAt(bowlingCode.length() - 2);
            char c5 = bowlingCode.charAt(bowlingCode.length() - 1);
           if (c4 == 'X') {
                score += 10;
            } else if(c4 != '-') {
               score += Integer.parseInt("" + c4);
           }
           if (c5 == 'X') {
                score += 10;
            } else if(c5 != '-') {
               score += Integer.parseInt("" + c5);
           }
        }
        return score;
    }
}
