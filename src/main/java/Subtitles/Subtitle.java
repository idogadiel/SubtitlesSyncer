package Subtitles;

import Subtitles.Block;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ido on 11-May-16.
 */
public class Subtitle {
    File path;

    public List<Block> getBlocks() {
        return blocks;
    }

    public File getPath() {
        return path;
    }

    List<Block> blocks;
    

    public Subtitle(File path) {
        this.path = path;
        blocks = new ArrayList<Block>();
        try {
            parse(readFile());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void parse(List<String> lines)
    {
        Block block = new Block();
        int index=0;
        for(String currentLine : lines)
        {
            index++;
            if(currentLine.isEmpty())
            {
                index=0;
                blocks.add(block);
                block = new Block();
            }

            else
            {
                if(index==1)
                {
                    block.setId(currentLine);
                }

                else if(index==2)
                {
                    String start = currentLine.substring(0,currentLine.indexOf("-->"));
                    String end = currentLine.substring(currentLine.indexOf("-->")+4);
                    block.setStartTime(start);
                    block.setEndTime(end);
                }
                else
                {
                    block.setContent(cleanContent(currentLine));
                }
            }
        }
    }

    private String cleanContent(String dirtyString)
    {
        String cleanString = dirtyString.replaceAll("\\<[^>]*>", " ");
        return cleanString;
    }

    private List<String> readFile() throws IOException {
        List<String> linesInFile = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        while ((line = br.readLine()) != null) {
            linesInFile.add(line);
        }
        br.close();
        return linesInFile;
    }

    public void print()
    {
        for(Block b : blocks)
        {
            System.out.println(b.toString());
        }
    }

}