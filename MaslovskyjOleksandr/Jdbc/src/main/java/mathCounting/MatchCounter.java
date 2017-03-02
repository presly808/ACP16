package mathCounting;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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

    public MatchCounter(File directory) {
        this.directory = directory;
    }

    public int find(){
        count = 0;
        LOGGER.info("CALCULATE QUANTITY OF MATCHES");

        File[] files = directory.listFiles();
        return runByFiles(files);
    }

    public Long findQuantityOf() throws IOException {
        LOGGER.info("CALCULATE QUANTITY OF MATCHES");
        return getFileList().parallelStream().filter(File -> search(File)).collect(Collectors.counting());
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

    private int runByFiles(File[] files) {
        LOGGER.info("RUN BY ARRAY");
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

    private List<File> getFileList() throws IOException {
        return Files.walk(Paths.get(directory.getPath()))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

}