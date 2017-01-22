package io.github.ynagarjuna1995.udacityquiz.mainScreen;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.ynagarjuna1995.udacityquiz.QuizScreen.QuizScreenActivity;
import io.github.ynagarjuna1995.udacityquiz.R;


public class MainScreenActivity extends AppCompatActivity implements MainScreenContract.IMainScreenView{

    private MainScreenPresenter mMainScreenPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        ButterKnife.bind(this);
    }

    public void initView(){
        setContentView(R.layout.activity_main);
        mMainScreenPresenter = new MainScreenPresenter(this);
        ButterKnife.bind(this);
        getSupportActionBar().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.top_instructions,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.instructions:
                launchInsructionAlert();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public AlertDialog launchInsructionAlert(){
       AlertDialog instructionAlert = new AlertDialog.Builder(this)
                .setTitle(R.string.instructionsTitle)
                .setMessage(R.string.instructionsMessage)
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
        return instructionAlert;
    }

    @OnClick(R.id.startQuiz)
    @Override
    public void launchQuizActivityIntent() {
        Intent startQuizIntent = new Intent(this, QuizScreenActivity.class);
        startActivityForResult(startQuizIntent,mMainScreenPresenter.getActivityRequestCode());
    }

    @Override
    public void showNumberOfQuizTaken() {

    }

    @Override
    public void showNumberOfCorrectAnswers() {

    }

    @Override
    public void showBestScore() {

    }


    @Override
    public void setPresenter(MainScreenPresenter Presenter) {
        mMainScreenPresenter = Presenter;

    }
}
