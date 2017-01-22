package io.github.ynagarjuna1995.udacityquiz.QuizScreen;

import android.view.View;

import io.github.ynagarjuna1995.udacityquiz.base.BasePresenter;
import io.github.ynagarjuna1995.udacityquiz.base.BaseView;

/**
 * Created by Nagarjuna on 21-01-2017.
 */

public interface QuizScreenContract  {
    interface IQuizScreenPresenter extends BasePresenter{
        void submit(View view);
        void buildScoreToast();
        void processAnswers(View view);
    }
    interface IQuizScreenView extends BaseView<QuizScreenPresenter>{
        void showScoreTaost();
    }
}
