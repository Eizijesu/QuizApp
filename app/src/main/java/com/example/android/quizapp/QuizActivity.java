package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class QuizActivity extends AppCompatActivity {
    private static ImageView iv_image;
    private static RadioGroup radiogup;
    private static RadioButton opt_selected;

    private static RadioButton radOptA;
    private static RadioButton radOptB;
    private static RadioButton radOptC;
    private static RadioButton radOptD;
    private static TextView tv_quest;
    private static TextView nScoreView;
    private static Button subBut;

    private static String ans;
    private int currentQuesIndex;
    private int nScore = 0;

    private ArrayList<QuestionPage> quests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.initialize();
    }

    private void initialize() {
        nScoreView = (TextView)findViewById(R.id.score1);
        iv_image = (ImageView) findViewById(R.id.image_iv);
        tv_quest = (TextView) findViewById(R.id.questions_tv);
        radiogup = (RadioGroup) findViewById(R.id.radgup);
        radOptA = (RadioButton) findViewById(R.id.radioOptA);
        radOptB = (RadioButton) findViewById(R.id.radioOptB);
        radOptC = (RadioButton) findViewById(R.id.radioOptC);
        radOptD = (RadioButton) findViewById(R.id.radioOptD);
        subBut = (Button) findViewById(R.id.subBut);

        currentQuesIndex = 0;
        quests = new ArrayList<QuestionPage>();

        quests.add(new QuestionPage(R.drawable.pythonlogo, "1. Which of the following data types is not supported in Python?",
                "Numbers", "String", "List", "Space", "D"));
        quests.add(new QuestionPage(R.drawable.ooout, "2. Pick the Odd one Out",
                "Theater", "School", "Movie", "Ticket", "B"));
        quests.add(new QuestionPage(R.drawable.python, "3. n = [[9, 8, 7], [6, 5, 4], [3, 2, 1]]\n" + "print n[2]",
                "[6, 5, 4]", "2", "7", "[3, 2, 1]", "D"));
        quests.add(new QuestionPage(R.drawable.coderedkid, "4. In Python, if you write: A = ‘5’ + ‘5’\n" +
                "The value of A is: ", "10", "55", "'55'", "10", "C"));
        quests.add(new QuestionPage(R.drawable.sports2024x716,"5. What is the most popular sport throughout the world?",
                "Cricket", "Soccer", "Football", "Volleyball", "B"));
        quests.add(new QuestionPage(R.drawable.hottestcontinet,"6. What is the hottest continent on Earth?",
                "Africa", "Asia", "Europe", "South America", "A"));
        quests.add(new QuestionPage(R.drawable.card_game,"7. How many cards are there in a complete pack of cards?",
                "20", "32", "40", "52", "D"));
        quests.add(new QuestionPage(R.drawable.trees,"8. What type of tree do dates grow on?",
                "coconut", "pine", "palm", "birch", "C"));
        quests.add(new QuestionPage(R.drawable.planet,"9. How many planets are there in our solar system?",
                "7", "8", "9", "5", "B"));
        quests.add(new QuestionPage(R.drawable.cubeim,"10. How many straight edges does a cube have?",
                "12", "8", "6", "10", "A"));


        this.displayQuests(currentQuesIndex);

        subBut.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (this.ansisCorrect()) {
                            nScore = nScore + 1;
                            updateScore(nScore);
                            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                            nxtques();
                        } else {
                            Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();

                        }

                    }

                    private boolean ansisCorrect() {
                        char ans = 'x';
                        int id = radiogup.getCheckedRadioButtonId();
                        opt_selected = (RadioButton) findViewById(id);
                        if (opt_selected == radOptA) ans = 'A';
                        if (opt_selected == radOptB) ans = 'B';
                        if (opt_selected == radOptC) ans = 'C';
                        if (opt_selected == radOptD) ans = 'D';
                        return quests.get(currentQuesIndex).isCorrectAns(String.valueOf(ans));


                    }
                }
        );

    }

    private void displayQuests ( int index){

        iv_image.setImageResource(quests.get(currentQuesIndex).getImageID());
        tv_quest.setText(quests.get(currentQuesIndex).getQuestionTxt());
        radOptA.setText(quests.get(currentQuesIndex).getOptionA());
        radOptB.setText(quests.get(currentQuesIndex).getOptionB());
        radOptC.setText(quests.get(currentQuesIndex).getOptionC());
        radOptD.setText(quests.get(currentQuesIndex).getOptionD());
        radiogup.clearCheck();
    }

    private void nxtques() {
        currentQuesIndex = (currentQuesIndex + 1) % quests.size();
        displayQuests(currentQuesIndex);


    }

    private void updateScore(int point) {
        nScoreView.setText("" + nScore);


    }
}



