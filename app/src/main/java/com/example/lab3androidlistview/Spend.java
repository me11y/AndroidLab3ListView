package com.example.lab3androidlistview;

public class Spend {
    private String spent;
    private String category;
    private String comment;


    public Spend(String spent, String category, String comment) {
        this.spent = spent;
        this.category = category;
        this.comment = comment;
    }

    public String getSpent() {
        return spent;
    }

    public void setSpent(String spent) {
        this.spent = spent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
