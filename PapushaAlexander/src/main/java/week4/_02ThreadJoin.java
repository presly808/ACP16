package week4;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alex on 22.02.17.
 */
public class _02ThreadJoin {
    public static void main(String[] args) {

        File folder = new File("/home/alex/IdeaProjects/ACP16");

        File[] files = folder.listFiles();

        List<Thread> threads = new ArrayList<>();
        List<AsynchFileSearchTask> tasks = new ArrayList<>();
        List<File> results = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                AsynchFileSearchTask task = new AsynchFileSearchTask(file, "TestThread");
                Thread thread = new Thread(task);

                threads.add(thread);
                tasks.add(task);
                thread.start();

            }
        }
        for (Thread thread : threads) {

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (AsynchFileSearchTask task : tasks){
            List<File> result = task.getRes();
            results.addAll(result);
        }

        results.forEach(System.out::println);
    }
}

class AsynchFileSearchTask implements Runnable{

    private File root;
    private String keyWord;
    private List<File> searchResult;

    public AsynchFileSearchTask(File root, String keyWord) {
        this.keyWord = keyWord;
        this.root = root;
        searchResult = new ArrayList<>();
    }

    @Override
    public void run() {
        recSearch(root);

    }
    public void recSearch(File dir){
        if (dir == null){
            return;
        }

        File[] files = dir.listFiles();
        if (files == null || files.length == 0){
            return;
        }

        Arrays.stream(files)
                .forEach(file ->{
                    if (file.isDirectory()){
                        recSearch(file);
                    } else if (file.getName().contains(keyWord)){
                        searchResult.add(file);
                    }
                });
    }

    public List<File> getRes(){
        return searchResult;
    }
}
