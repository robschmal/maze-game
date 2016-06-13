package mazegame.java;

/**
 *
 * @author Rob
 */
public class LevelLayout {

    static public String getLevelLayoutString(int levelNumber) {

        String levelLayoutString = "";

        switch (levelNumber) {
            case 01: levelLayoutString
                        = "RRmmmmmmmmmmmmmmrrrmrrrrrrrrrrrrrrr"
                        + "mRmmmmmmmrrrrrrrrmHmrmmmmmmmrmmmmmm"
                        + "mRRRRRRRmrmmmmrmmmrmrmmmrrrrrmmrrrm"
                        + "mrmmmmmRmrBBrmrrrrrmrmmmrmmmmmmrmmm"
                        + "mrrrrrmRmmmmrmmmmmmmrmmmrrrrrrrrmmm"
                        + "mmmmmrmRrrrrrmRRRRRrrmmmmmmmmrmmmmm"
                        + "mrrrmrmRmmmmmmRmmmRmmmmmmrrrrrmmmmm"
                        + "mrmrVrmRRRRRRRRmmmRRRRRmmrmmmmmmmmm"
                        + "mrmmmmmmmmmmmmmmmmmmmmRrrrrrrrrrrmm"
                        + "mrmrrrrrmmrrrrrrrVmmmmRmmmmmmmmmrmm"
                        + "mrmmmmmrmmrmmmmrmRRRRRRmmmmmmmmmrmm"
                        + "mrrrrrrrrrrmrrrrmRmmrmmmmrrrrrrrrmm"
                        + "mmmmmmmmmmmmrmmmmRmmrmmmmrmmmmmmrmm"
                        + "rrrrrrrrrrrmrrrrmRmmrrrrrrrrmmmmrmm"
                        + "rmmmmmmmmmrmmmmrmRmmmmmmmmmrmmmmrmm"
                        + "rrrrrrrmmmrrrrrrmRmmmmmmmmmrrrrrrmm"
                        + "mmmmmmrmmmmmmmmmmRRRRRRRRmmmmmmmmmm"
                        + "mmmmmmrrrrrrrrrrmmmmmmmmRRRRRRRRRRR";
                break;
            case 02: levelLayoutString
                        = "rrrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "rmrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrm"
                        + "rrrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmrrrrrrrrrrrrrrrrrrrrBrmrrrrrmrm"
                        + "mrmrrmmmmmmmmmmmmmmmmmmmmmmrmmmrmrm"
                        + "mrmrmmrrrrrrrrrrrrrrrrrrrHmrmrmrmrm"
                        + "mrmrmrVmmmmmmmmmmmmmmmmmmrmrmrmrmrm"
                        + "mrmrmrmmrrrrrrrrrrrrrrrrrVmBmrmrmrm"
                        + "mrmrmrmrVmmmmmmmmmmmmmmmmmmmmrmrmrm"
                        + "mrmrmrmrmmrrrrrrrrrrrrVrrrrrrrmrmrm"
                        + "mrmrmrmrmrrmmmmmrmrrrrmrmmmrmrmrmrm"
                        + "mrmrmrmrmrmmrrmrrmmrmmmrmrrrmrmrmrm"
                        + "mrmrmrmrrrrrrrrrrrrrmrmrmrmmmrmrmrm"
                        + "mrmrmrmmmmmmmmmmmmmmmrmrmrrrrrmrrrm"
                        + "mrmrmrrrrrrrrrrrrrrrrrmrmmmmmmmmmmm"
                        + "mrmrmmmmmmmmmmmmmmmmmrmrrrrrrrrrrrr"
                        + "mrrrrrrrrrrrrrrrrrrrrrmmmrmmmmmmmmr"
                        + "mmmmmmmmmmmmmmmmmmmmmmmmmrrrrrrrrrr";
  
                break;
            case 03: levelLayoutString
                        = "rrmmmmmmmmmmmmmmmmmmmmmmrrrrrrrrmrm"
                        + "mrrrrrrrrrrrmrrrrrmmrrrrrrmmrrmrmrm"
                        + "mmmmmmmrrmmmmrmmmrmmrmrmmrmmrmmrmrm"
                        + "mrrrrVrmrrrrrrrrmrrrrmrmmrmmrmmrmrm"
                        + "mrmrrmrrmmrmmmmrmrmmrmrrrrmmrmmrmrm"
                        + "mrrmrmmrrmrrrmmrmrmmrmmmmrmrrrrrmrm"
                        + "mrmrrmmmrmmmrmrrmrmmrrrrmrmrmrmrmrm"
                        + "rmrrmmrrrmmmrmrmmrmmmmmmmrmrrrmrmrm"
                        + "mrrmrmrmmmrrrmrrrrmmBrrrrrmmmmmrmrm"
                        + "mrmmrmrmmrrmmmmmmmmmmmmmmmmrrrrrmrm"
                        + "mrmmrmrmmrmrrrrrVrrrrrrrrrrrmmmmmrm"
                        + "mrmmrmrmrrmmmmmrrmmrrmmmmmmmmmrrmrm"
                        + "mrmmrmrrrmmmmmmrrmmrrmmmmmrrrrrmmrm"
                        + "mrmmrmmmrrrrrrrrrrrrrmmmrrrmmrrmmrm"
                        + "mrmrrrrrrmmmrmmmmmmmmmmrrmrmmrmmmrm"
                        + "mVmmmmmmmmrmmmrrrrrrrrrrmrrrmrrrmrm"
                        + "mrrrrrrrrrrrrrrmmmrrmmrmrrmrrmrmmrm"
                        + "mmmmmmmmmmmmmmrrrrmmrrrrrmmrmrrrrrr";
                break;
        }

        return levelLayoutString;
    }

}
