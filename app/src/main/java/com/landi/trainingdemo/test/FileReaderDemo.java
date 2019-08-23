package com.landi.trainingdemo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by guoj on 2019/7/12.
 */

public class FileReaderDemo {
    public static void main(String[] args) {
        File file = new File("E:/ajavatest/a.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] chars = new char[1024];
            while (fileReader.read(chars) != -1) {
                System.out.print(new String(chars));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
