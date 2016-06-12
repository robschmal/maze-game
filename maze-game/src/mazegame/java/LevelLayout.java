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
                        = "rrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                        + "mrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrm"
                        + "mrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrm"
                        + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrr";
                break;
        }

        return levelLayoutString;
    }

}
