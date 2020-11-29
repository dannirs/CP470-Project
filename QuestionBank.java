package com.example.studybank;


import java.util.List;

public class QuestionBank {
    int num_questions;
    List<Questions.mc_question> questionList;
    String creator;
    String date_created;

    public void QuestionBank(){

    }

    public void add_to_bank(Questions.mc_question e){
        this.questionList.add(e);
        num_questions++;
    }

    public int getNum_questions() {
        return num_questions;
    }

    public void setNum_questions(int num_questions) {
        this.num_questions = num_questions;
    }

    public List<Questions.mc_question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Questions.mc_question> questionList) {
        this.questionList = questionList;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}
