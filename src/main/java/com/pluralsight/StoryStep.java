package com.pluralsight;

public class StoryStep {
    private int id;
    private String storyText;
    private String option1Text;
    private int optionNextStepId;
    private String option2Text;
    private int option2NextStepId;

    public StoryStep (int id, String storyText, String option1Text, String option2Text, int optionNextStepId, int option2NextStepId){
        this.id = id;
        this.storyText = storyText;
        this.option1Text = option1Text;
        this.option2Text = option2Text;
        this.optionNextStepId = optionNextStepId;
        this.option2NextStepId = option2NextStepId;
    }

    //getters
    public int getId(){return id;}
    public int getOption2NextStepId() {return option2NextStepId;}
    public int getOptionNextStepId() {return optionNextStepId;}
    public String getStoryText() {return storyText;}
    public String getOption2Text() {return option2Text;}
    public String getOption1Text() {return option1Text;}

    //setters
    public void setId(int id) {this.id = id;}
    public void setOption2NextStepId(int option2NextStepId) {this.option2NextStepId = option2NextStepId;}
    public void setOption1Text(String option1Text) {this.option1Text = option1Text;}
    public void setOption2Text(String option2Text) {this.option2Text = option2Text;}
    public void setOptionNextStepId(int optionNextStepId) {this.optionNextStepId = optionNextStepId;}
    public void setStoryText(String storyText) {this.storyText = storyText;}
}
