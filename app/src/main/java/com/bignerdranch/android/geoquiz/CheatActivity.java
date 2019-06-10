package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private final String TAG = "CheatActivity";
    private Button mShowButton;
    private TextView mCheatViewAnswerText;

    public boolean EXTRA_ANSWER_IS_TRUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        EXTRA_ANSWER_IS_TRUE = getIntent().getBooleanExtra("EXTRA_ANSWER_IS_TRUE", false);

        Log.d(TAG, "EXTRA_ANSWER_IS_TRUE: " + EXTRA_ANSWER_IS_TRUE);

        mShowButton = findViewById(R.id.show_answer_button);

        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "show answer button clicked");
                showAnswer();
                setIsCheater();
            }
        });
    }

    private void showAnswer() {
        mCheatViewAnswerText = findViewById(R.id.textViewCheatAnswerText);

        if(this.EXTRA_ANSWER_IS_TRUE) {
            mCheatViewAnswerText.setText(R.string.cheat_answer_is_true);
        } else {
            mCheatViewAnswerText.setText(R.string.cheat_answer_is_false);
        }
    }

    private void setIsCheater() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_IS_CHEATER", true);
        setResult(CheatActivity.RESULT_OK, intent);
    }

}
