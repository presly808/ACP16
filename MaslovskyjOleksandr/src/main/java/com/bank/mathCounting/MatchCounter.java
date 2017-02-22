package com.bank.mathCounting;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
        return runByFiles(files);
    }

    public int find(boolean flag){
        ConcurrentMap<Integer, File> files= new ConcurrentHashMap<>();
        int i = 0;
        for (File file : directory.listFiles()) {
            files.put(i++, file);
        }
        return runByFiles(files);
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

    private int runByFiles(ConcurrentMap<Integer, File> files) {
        LOGGER.info("RUN BY ConcurrentMap");
        for (File file : files.values()) {
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
}