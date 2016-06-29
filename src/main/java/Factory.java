import RippedLipsPoints.Movement;
import Subtitles.Subtitle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ido on 11-May-16.
 */
public class Factory {

    public static Movement createMovement(String path)
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Movement obj = mapper.readValue(new File(path+File.separator+"json.txt"), Movement.class);
            return obj;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Subtitle createSubtitle(String path) {
        return new Subtitle(new File(path+File.separator+"subtitle.srt"));
    }
}
