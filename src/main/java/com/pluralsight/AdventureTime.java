package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class AdventureTime {
    public static void main(){

    }

    public static void loadAdventure(){
        try{
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (Exception e){

        }
    }
}
