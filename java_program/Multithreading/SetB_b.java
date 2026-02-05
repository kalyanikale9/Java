/*b) Write a program for a simple search engine. Accept a string to be searched. Search for the string in all text files in the current folder.
   Use a separate thread for each file. The result should display the filename,  line number where the string is found.*/

   //Here, you have to create a file with the extension .txt (for example, sample.txt) and write some data into it.
import java.io.*;
import java.util.*;

class SearchThread extends Thread {
    private File file;
    private String searchString;

    public SearchThread(File file, String searchString) {
        this.file = file;
        this.searchString = searchString;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNum = 1;

            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    System.out.println("Found in " + file.getName() +
                                       " at line " + lineNum);
                }
                lineNum++;
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}

public class SimpleSearchEngine {
    public static void main(String[] args) throws IOException {
        
        // Read input search term
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter string to search: ");
        String searchString = input.readLine();

        // Get all .txt files in current folder
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No text files found.");
            return;
        }

        // Create and start a thread for each file
        List<SearchThread> threads = new ArrayList<>();
        for (File file : files) {
            SearchThread t = new SearchThread(file, searchString);
            threads.add(t);
            t.start();
        }

        // Wait for all threads to finish
        for (SearchThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Search completed.");
    }
}


