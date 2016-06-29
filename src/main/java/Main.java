import Coordinator.Coordinator;
import RippedLipsPoints.Movement;
import Subtitles.Subtitle;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.Utils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Ido on 11-May-16.
 */
public class Main {
    public static void main(String[] args) {
        Movement movement = Factory.createMovement(args[0]);
        Subtitle subtitle = Factory.createSubtitle(args[0]);
        Utils.Write(new File(args[0]), new Coordinator(movement,subtitle).Coordinate());

    }
}
