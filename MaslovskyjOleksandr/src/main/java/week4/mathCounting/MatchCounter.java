package week4.mathCounting;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatchCounter {

    static final Logger LOGGER = Logger.getLogger(MatchCounter.class);

    private File directory;
    private String keyword;
    private int count;

    public MatchCounter(File directory, String keyword) {
        LOGGER.info("INITIALIZE MATCH COUNTER");
        this.directory = directory;
        this.keyword = keyword;
    }

    public int find(){
        count = 0;
        LOGGER.info("CALCULATE QUANTITY OF MATCHES");
        File[] files = directory.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                MatchCounter counter = new MatchCounter(file, keyword);
                count += counter.find();
            }
            else {
                if (search(file)) {count++;}
            }
        }
        return count;
    }

    public boolean search(File file){
        LOGGER.info("SEARCH " + keyword + " IN FILE");
        try (Scanner in = new Scanner(file)){
            boolean found = false;
            while (!found && in.hasNextLine()){
                String line  = in.nextLine();
                if (line.contains(keyword)) {found = true;}
            }
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}