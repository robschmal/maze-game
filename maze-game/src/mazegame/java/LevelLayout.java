package mazegame.java;

/**
 *
 * @author Rob
 */
public class LevelLayout {

    public String getLevelLayoutString(int levelNumber) {

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
                        + "mrmrrrrrmmrrrrrrrrmmmmRmmmmmmmmmrmm"
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
                        = "rrrrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "rmmrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrm"
                        + "rmmrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "rrrmrrrrrrrrrrmrrrrrrrrrrrrrrrrrmrm"
                        + "mrmrrmmmmmmmmmmmmmmmmmmmmrmmmmmrmrm"
                        + "mrmrmmrrrrrrrrrrrrrrrrrrrrmrmmmrmrm"
                        + "mrmrmrrmmmmmmmmmmmmmmmmmmrmrmmmrmrm"
                        + "mrmrmrmmrrrrrrrrrrrrrrrrrrmrmmmrmrm"
                        + "mrmrmrmrrmmmmmmmmmmmmmmmmmmrmrmrmrm"
                        + "mrmrmrmrmmrrrrrrrrrrrrrrrrrrrrmrmrm"
                        + "mrmrmrmrmrrmrmmmrmrrrrmrmmmrmrmrmrm"
                        + "mrmrmrmrrrmmrrmrrmmrmmmrmrrrmrmrmrm"
                        + "mrmrmrmrrrrrrrrrrrrrmrmrmrmmmrmrmrm"
                        + "mrmrmrmmmmmmmmmmmmmmmrmrmrrrrrmrrrm"
                        + "mrmrmrrrrrrrrrrrrrrrrrmrmmmmmmmmmmm"
                        + "mrmrmmmmmmmmmmmmmmmmmrmrrrrrrrrrmmm"
                        + "mrrrrrrrrrrrrrrrrrrrrrmmmrmrmrmrrrm"
                        + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrr";
  
                break;
            case 03: levelLayoutString
                        = "rrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mrrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmrrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmrrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmrrmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmrrmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmrrmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmrrmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmrrmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmrrmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmmrrmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmmmrrmmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmmmmrrmmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmmmmmrrmmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmmmmmmrrmmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmmmmmmmrrmmmmmmmmmmmmmmmmmm"
                        + "mmmmmmmmmmmmmmmmrrrrrrrrrrrrrmmmmmm"
                        + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmrrrrrrr";
                break;
        }

        return levelLayoutString;
    }

}
