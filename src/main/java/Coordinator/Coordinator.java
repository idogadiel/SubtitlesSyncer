package Coordinator;

import RippedLipsPoints.Frame;
import RippedLipsPoints.Movement;
import RippedLipsPoints.Point;
import Subtitles.Block;
import Subtitles.Subtitle;
import org.json.simple.JSONObject;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ido on 11-May-16.
 */
public class Coordinator {
    Movement movement;
    Subtitle subtitle;

    public Coordinator(Movement mvn, Subtitle sub) {
        this.movement = mvn;
        this.subtitle = sub;
    }

    public List<JSONObject> Coordinate() {
        int frameNum;
        List<JSONObject> blocksJsonObject = new LinkedList<JSONObject>();
        List<Block> subtitleBlocks = subtitle.getBlocks();
        for (Block block : subtitleBlocks) {
            frameNum = 0;
            JSONObject blockJson = new JSONObject();
            blockJson.put("Content", block.getContent());
            blockJson.put("Start", block.getStartTime());
            blockJson.put("End", block.getEndTime());
            JSONObject framesJson = new JSONObject();
            List<Frame> frames = getSyncedFrames(block);
            for (Frame frame : frames) {
                frameNum++;
                JSONObject frameJson = new JSONObject();
                frameJson.put("Talking", frame.getTalking());
                frameJson.put("Time", frame.getTime());
                frameJson.put("Points", getCoords(frame.getPoints()));
                framesJson.put(frameNum, frameJson);
            }
            blockJson.put("Frames", framesJson);
            blocksJsonObject.add(blockJson);       // print every block - e.i every sentence
        }
        return blocksJsonObject;
    }

    public List<Frame> getSyncedFrames(Block block) {

        List<Frame> allFrames = movement.getFrames();
        List<Frame> syncedFrames = new LinkedList<Frame>();

        String blockStartTime = block.getStartTime();   // 00:04:21,400
        String blockEndTime = block.getEndTime();       // 00:04:24,060

        double blockStartTimeInSeconds = getTimeInSeconds(blockStartTime);
        double blockEndTimeInSeconds = getTimeInSeconds(blockEndTime);

        for(Frame currentFrame : allFrames)
        {
            double frameTimeInSecond = Double.valueOf(currentFrame.getTime());  // 0.633333
            if(blockStartTimeInSeconds <= frameTimeInSecond && frameTimeInSecond <= blockEndTimeInSeconds)
            {
                syncedFrames.add(currentFrame);
            }
        }
        return syncedFrames;
    }


    private JSONObject getCoords(List<Point> points) {
        JSONObject lipsCoordsJson = new JSONObject();
        try {
            Class noparams[] = {};
            Class cls = Class.forName("RippedLipsPoints.Point");

            for (Point point : points)
                for (int i = 0; i < points.size(); i++) {
                    Point p = points.get(i);
                    String MethodName = "getPoint"+(i+1);
                    Method method = cls.getDeclaredMethod(MethodName, noparams);
                    Object invokedMethodOutputObj = method.invoke(p, null);
                    lipsCoordsJson.put(i+1, invokedMethodOutputObj.toString());

                }
            return lipsCoordsJson;

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return lipsCoordsJson;
    }


    private double getTimeInSeconds(String timeAsString)
    {
        double result;
        String[] timeArr = timeAsString.split(":");
        double hoursAsSeconds = Double.valueOf(timeArr[0])*60*60;
        double minutesAsSeconds = Double.valueOf(timeArr[1])*60;
        String[] secondsArr = timeArr[2].split(",");
        double secondsAsSeconds = Double.valueOf(secondsArr[0]);
        double milisecondsAsSeconds = Double.valueOf(secondsArr[1])/1000;

        result = hoursAsSeconds + minutesAsSeconds +secondsAsSeconds+milisecondsAsSeconds;
        return result;

    }

}