package io.github.ynagarjuna1995.udacityquiz.QuizScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.ynagarjuna1995.udacityquiz.R;

public class QuizScreenActivity extends AppCompatActivity implements QuizScreenContract.IQuizScreenView {

    private QuizScreenPresenter mQuizScreenPresenter;
    @BindView(R.id.cboption_1)
    CheckBox Q3CheckBox1;
    @BindView(R.id.cboption_2)
    CheckBox Q3CheckBox2;
    @BindView(R.id.cboption_3)
    CheckBox Q3CheckBox3;
    @BindView(R.id.cboption_4)
    CheckBox Q3CheckBox4;
    @BindView(R.id.answer_one)
    EditText Q1AnswerTextField;

    private int[] userResponse = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuizScreenPresenter = new QuizScreenPresenter(this);
        ButterKnife.bind(this);
    }

    @Override
    public void setPresenter( QuizScreenPresenter mQuizScreenPresenter) {
        this.mQuizScreenPresenter = mQuizScreenPresenter;
    }

    @Override
    public void showScoreTaost() {
        Toast.makeText(this,"Score for this Quiz is"+Integer.toString(mQuizScreenPresenter.getScore()),
                Toast.LENGTH_LONG).show();
    }



    @OnClick({R.id.q2_option_1,R.id.q2_option_2,R.id.q2_option_3,R.id.q2_option_4,R.id.q4_option_1,R.id.q4_option_2,R.id.q4_option_3,R.id.q4_option_4
    ,R.id.q5_option_1,R.id.q5_option_2,R.id.q5_option_3,R.id.q5_option_4})
    public void RadioQuestionsResponseEvent(View view){
        switch (view.getId()) {
            case R.id.q2_option_1:
                userResponse[2] = 1;
                break;
            case R.id.q4_option_4:
                    userResponse[4] = 1;
                break;
            case R.id.q5_option_3:
                    userResponse[5] = 1;
                break;
            case R.id.q2_option_2 :
                userResponse[2] =0;
                break;
            case  R.id.q2_option_3:
                userResponse[2] =0;
                break;
            case  R.id.q2_option_4 :
                userResponse[2] =0;
                break;
            case R.id.q4_option_1:
                userResponse[4] = 0;
                break;
            case R.id.q4_option_2:
                userResponse[4] =0;
                break;
            case R.id.q4_option_3:
                userResponse[4] =0;
                break;
            case R.id.q5_option_1:
                userResponse[5] =0;
                break;
            case R.id.q5_option_2:
                userResponse[5]=0;
                break;
            case R.id.q5_option_4:
                userResponse[5]=0;
                break;
        }
    }
    @OnClick({R.id.cboption_1,R.id.cboption_2,R.id.cboption_3,R.id.cboption_4})
    public void q3ResponseEvent(View view){
            if(Q3CheckBox1.isChecked() && Q3CheckBox2.isChecked() && Q3CheckBox3.isChecked()) {
                if (Q3CheckBox4.isChecked()) {
                    return;
                } else {
                    userResponse[3] = 1;
                }
            }
    }
    @OnClick(R.id.submitButton)
    public void submitQuiz(){
        if(Q1AnswerTextField.getText().toString().equals("Obama")) {
            Log.d("Q1Answer",Q1AnswerTextField.getText().toString());
            userResponse[1] = 1;
        }
        mQuizScreenPresenter.sendUserResponse(userResponse);
        showScoreTaost();
        mQuizScreenPresenter.resetScore();
        userResponse = null;
        userResponse = new int[6];

    }

}

