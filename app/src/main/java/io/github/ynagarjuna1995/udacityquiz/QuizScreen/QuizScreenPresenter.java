package io.github.ynagarjuna1995.udacityquiz.QuizScreen;

import android.view.View;

/**
 * Created by Nagarjuna on 21-01-2017.
 */

public class QuizScreenPresenter implements QuizScreenContract.IQuizScreenPresenter {
    private int score = 0;
    private int[] userResponse;
    private QuizScreenContract.IQuizScreenView mQuizScreenView;

    public QuizScreenPresenter(QuizScreenContract.IQuizScreenView mQuizScreenView) {
        mQuizScreenView.setPresenter(this);
    }
    @Override
    public void start() {

    }

    @Override
    public void submit(View view) {

    }

    @Override
    public void buildScoreToast() {

    }

    @Override
    public void processAnswers(View view) {

    }

    public int getScore(){
        return score ;
    }

    public void sendUserResponse(int[] userResponse){
        for (int userAnswer: userResponse) {
            if (userAnswer == 1){
                incrementScore();
            }
        }
    }

    public void incrementScore(){
        score = getScore() + 20;
    }
    public void resetScore(){
        score =0;
    }
    public void decreaseScore(){
        score = getScore() - 20;
    }
}
