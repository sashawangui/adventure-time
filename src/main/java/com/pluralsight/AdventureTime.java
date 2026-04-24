package com.pluralsight;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AdventureTime {
    public static void main(String[] args) {
        ArrayList<StoryStep> adventureSteps = loadAdventure("adventue1.csv");
        homeScreen(adventureSteps);
    }

    public static ArrayList<StoryStep> loadAdventure(String adventureFile) {
        ArrayList<StoryStep> steps = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(adventureFile);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] columns = line.split("\\|");

                int id = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns[2];
                int option1NextId = Integer.parseInt(columns[3]);
                String option2Text = columns[4];
                int option2NextId = Integer.parseInt(columns[5]);

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

    public static StoryStep findStep(ArrayList<StoryStep> steps, int id) {
        for (StoryStep step : steps) {
            if (step.getId() == id) return step;
        }
        return null;
    }

    public static void gameScreen(ArrayList<StoryStep> steps, int id) {
        int nextId = id;

        while (nextId != -1) {
            StoryStep step = findStep(steps, nextId);
            Scanner scanner = new Scanner(System.in);

            if (step == null) {
                System.out.println("Step not found.");
                break;
            }

            System.out.println(step.getStoryText());
            System.out.println("1) " + step.getOption1Text());
            System.out.println("2) " + step.getOption2Text());

            String choice = scanner.nextLine().strip();

            switch (choice) {
                case "1":
                    nextId = step.getOption1NextStepId();
                    break;
                case "2":
                    nextId = step.getOption2NextStepId();
                    break;
            }
        }
    }
}