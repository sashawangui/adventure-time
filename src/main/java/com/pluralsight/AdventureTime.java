package com.pluralsight;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AdventureTime {
    public static void main(String[] args) {
        ArrayList<StoryStep> adventureSteps = loadAdventure();
        homeScreen(adventureSteps);
    }

    public static ArrayList<StoryStep> loadAdventure() {
        ArrayList<StoryStep> steps = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();

            while (line != null) {
                String[] columns = line.split("\\|");

                int id             = Integer.parseInt(columns[0]);
                String storyText   = columns[1];
                String option1Text = columns[2];
                int option1NextId  = Integer.parseInt(columns[3]);
                String option2Text = columns[4];
                int option2NextId  = Integer.parseInt(columns[5]);

                StoryStep step = new StoryStep(id, storyText, option1Text, option2Text, option1NextId, option2NextId);
                steps.add(step); // ← was missing

                line = br.readLine();
            }
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return steps;
    }

    public static void homeScreen(ArrayList<StoryStep> steps) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Adventure Time");
        System.out.println("Choose one: (P)lay or (Q)uit");

        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("p")) {
            gameScreen(steps, 1);
        }
    }

    public static void gameScreen(ArrayList<StoryStep> steps, int id) {
        for (int i = 0; i < steps.size(); i++) {
            StoryStep step = steps.get(i);

            if(step.getId() == id){
                System.out.println("Story Text" + step.getStoryText() + "\n");
                System.out.println("1. " + step.getOption1Text());
            }
        }
    }
}