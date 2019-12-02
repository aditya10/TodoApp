package com.company;

public class Step {

    int stepId = 0;
    String content = "";
    int difficultyRating = 5;
    boolean isStepComplete = false;

    public Step(int stepId, String content, int difficultyRating, boolean isStepComplete) {
        this.stepId = stepId;
        this.content = content;
        this.difficultyRating = difficultyRating;
        this.isStepComplete = isStepComplete;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(int difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public boolean isStepComplete() {
        return isStepComplete;
    }

    public void setStepComplete(boolean stepComplete) {
        isStepComplete = stepComplete;
    }


}
