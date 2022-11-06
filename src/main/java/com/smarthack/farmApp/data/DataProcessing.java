package com.smarthack.farmApp.data;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
public class DataProcessing {
    Map<String, ScriptProduct> fruits = new HashMap<>();
    Map<String, ScriptProduct> vegetables = new HashMap<>();

    public void executePredictScript() {
        File file = new File("cnn-request/predict.py");
        File file2 = new File("cnn-request");
        String path = file.getAbsolutePath();
        String path2 = file2.getAbsolutePath();
        try{
            System.out.println("Start Predict script");
            ProcessBuilder pb = new ProcessBuilder("python3", path, path2);
            Process p = pb.start();
            p.waitFor();
            System.out.println("Predict script executed");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String readPredictScript() throws FileNotFoundException {
        String word = null;
        File file = new File("cnn-request/filename.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
        }
        return word;
    }

    public void executeSeleniumScript() throws URISyntaxException {
        File megaTest = new File("src/main/resources/selenium-wsl2-ubuntu/run_selenium.py");
        File megaTest2 = new File("src/main/resources/selenium-wsl2-ubuntu");
        String mypath2 = megaTest2.getAbsolutePath();
        String mypath = megaTest.getAbsolutePath();
        try{
            System.out.println("Start Selenium script");
            ProcessBuilder pb = new ProcessBuilder("python3", mypath, mypath2);
            Process p = pb.start();
            p.waitFor();
            System.out.println("Selenium script executed");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void processData() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String line;
        String[] lineArray, wordArray;
        String name, quantity;
        Float price;

        File file = new File("src/main/resources/selenium-wsl2-ubuntu/lista_fructe.txt");
        Scanner read = new Scanner(file);
        while (read.hasNextLine()) {
            line = read.nextLine();
            line = line.replace("*", "&");
            line = line.replace(",", ".");
            lineArray = line.split("&");

            wordArray = lineArray[0].split(" ");
            name = normalize(wordArray[0]);
            name = name.replaceAll("\\p{M}", "");

            wordArray = lineArray[2].split(" ");
            price = Float.parseFloat(wordArray[1]);
            quantity = wordArray[2];

            if (fruits.containsKey(name)) {
                if (price < fruits.get(name).getPrice()) {
                    fruits.get(name).setPrice(price);
                }
            } else {
                ScriptProduct scriptProduct = new ScriptProduct(name, price, quantity);
                fruits.put(name, scriptProduct);
            }
        }

        File file2 = new File("src/main/resources/selenium-wsl2-ubuntu/lista_legume.txt");
        read = new Scanner(file2);
        while (read.hasNextLine()) {
            line = read.nextLine();
            line = line.replace("*", "&");
            line = line.replace(",", ".");
            lineArray = line.split("&");

            wordArray = lineArray[0].split(" ");
            name = normalize(wordArray[0]);
            name = name.replaceAll("\\p{M}", "");

            wordArray = lineArray[2].split(" ");
            price = Float.parseFloat(wordArray[1]);
            quantity = wordArray[2];

            if (vegetables.containsKey(name)) {
                if (price < vegetables.get(name).getPrice()) {
                    vegetables.get(name).setPrice(price);
                }
            } else {
                ScriptProduct scriptProduct = new ScriptProduct(name, price, quantity);
                vegetables.put(name, scriptProduct);
            }
        }
    }

    private String normalize(String input) {
        return input == null ? null : Normalizer.normalize(input, Normalizer.Form.NFKD);
    }
}
