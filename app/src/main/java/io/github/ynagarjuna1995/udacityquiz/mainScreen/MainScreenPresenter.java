package io.github.ynagarjuna1995.udacityquiz.mainScreen;

public class MainScreenPresenter implements MainScreenContract.IMainScreenPresenter {
    private static final int ACTIVITY_REQUEST_CODE = 400;
    private MainScreenContract.IMainScreenView  mMainScreenView;

    public MainScreenPresenter(MainScreenContract.IMainScreenView mMainScreenView){

        mMainScreenView.setPresenter(this);
    }

    @Override
    public void numberOfQuizTakenFromPref() {

    }

    @Override
    public void numberOfCorrectAnswerFromPref() {

    }

    @Override
    public void retreiveBestScoreFromPref() {

    }
    public int getActivityRequestCode(){
        return ACTIVITY_REQUEST_CODE;
    }
    @Override
    public void start() {

    }

    @Override
    public void takeQuiz() {
        if(mMainScreenView != null){
            mMainScreenView.launchQuizActivityIntent();
        }
    }
}
