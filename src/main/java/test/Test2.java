package test;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test2 {

    public static void main(String[] args)  {

        try {
            FileStore fileStore = Files.getFileStore(Paths.get(args[0]));
            System.out.println(fileStore.getTotalSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
