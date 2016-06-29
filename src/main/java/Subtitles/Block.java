package Subtitles;

/**
 * Created by Ido on 11-May-16.
 */
public class Block {

    private String id;
    private String startTime;
    private String endTime;
    private String content;

    public Block() {
        content="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        content += text;
        if(content.charAt(0) == ' ')
        {
            content = content.substring(1);
        }
    }


    public String toString()
    {
        return "___________________________\n"+
                id+"\n"+startTime+"\n"+endTime+"\n"
                +content+"\n"+
                "___________________________\n";
    }

}
