package io.github.ynagarjuna1995.udacityquiz.mainScreen;

import android.support.v7.app.AlertDialog;

import io.github.ynagarjuna1995.udacityquiz.base.BasePresenter;
import io.github.ynagarjuna1995.udacityquiz.base.BaseView;

public interface MainScreenContract {
    interface IMainScreenView extends BaseView<MainScreenPresenter>{
        void showNumberOfQuizTaken();
        void showNumberOfCorrectAnswers();
        void showBestScore();
        void launchQuizActivityIntent();
        AlertDialog launchInsructionAlert();
    }

    interface IMainScreenPresenter extends BasePresenter {
        void numberOfQuizTakenFromPref();
        void numberOfCorrectAnswerFromPref();
        void retreiveBestScoreFromPref();
        void takeQuiz();



    }
}
