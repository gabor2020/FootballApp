package at.home.gabor.footballapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import at.home.gabor.footballapp.QuizContract.QuestionsTable;
import at.home.gabor.footballapp.QuizContract.QuestionsTableEng;
import at.home.gabor.footballapp.QuizContract.QuestionsTableHun;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FootballApp.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" + ")";

        final String SQL_CREATE_QUESTIONS_TABLE_HUN = "CREATE TABLE " +
                QuestionsTableHun.TABLE_NAME + " ( " +
                QuestionsTableHun._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTableHun.COLUMN_QUESTION + " TEXT, " +
                QuestionsTableHun.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTableHun.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTableHun.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTableHun.COLUMN_ANSWER_NR + " INTEGER" + ")";

        final String SQL_CREATE_QUESTIONS_TABLE_ENG = "CREATE TABLE " +
                QuestionsTableEng.TABLE_NAME + " ( " +
                QuestionsTableEng._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTableEng.COLUMN_QUESTION + " TEXT, " +
                QuestionsTableEng.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTableEng.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTableEng.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTableEng.COLUMN_ANSWER_NR + " INTEGER" + ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE_HUN);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE_ENG);

        fillQuestionsTableHun();
        fillQuestionsTableEng();
        fillQuestionsTable();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }


    private void fillQuestionsTable() {
        Question q1 = new Question("A ist richtig", "A", "B", "C", 1);
        addQuestion(q1);
        Question q2 = new Question("B ist richtig", "A", "B", "C", 2);
        addQuestion(q2);
        Question q3 = new Question("C ist richtig", "A", "B", "C", 3);
        addQuestion(q3);
        Question q4 = new Question("A ist richtig wieder", "A", "B", "C", 1);
        addQuestion(q4);
        Question q5 = new Question("B ist richtig wieder", "A", "B", "C", 2);
        addQuestion(q5);
    }

    private void fillQuestionsTableHun() {
        Question q1 = new Question("A a helyes", "A", "B", "C", 1);
        addQuestionHun(q1);
        Question q2 = new Question("B a helyes", "A", "B", "C", 2);
        addQuestionHun(q2);
        Question q3 = new Question("C a helyes", "A", "B", "C", 3);
        addQuestionHun(q3);
        Question q4 = new Question("A a helyes megint", "A", "B", "C", 1);
        addQuestionHun(q4);
        Question q5 = new Question("B a helyes megint", "A", "B", "C", 2);
        addQuestionHun(q5);
    }

    private void fillQuestionsTableEng() {
        Question q1 = new Question("A is correct", "A", "B", "C", 1);
        addQuestionEng(q1);
        Question q2 = new Question("B is correct", "A", "B", "C", 2);
        addQuestionEng(q2);
        Question q3 = new Question("C is correct", "A", "B", "C", 3);
        addQuestionEng(q3);
        Question q4 = new Question("A is correct again", "A", "B", "C", 1);
        addQuestionEng(q4);
        Question q5 = new Question("B is correct again", "A", "B", "C", 2);
        addQuestionEng(q5);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    private void addQuestionHun(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTableHun.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTableHun.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTableHun.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTableHun.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTableHun.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTableHun.TABLE_NAME, null, cv);
    }

    private void addQuestionEng(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTableEng.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTableEng.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTableEng.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTableEng.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTableEng.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTableEng.TABLE_NAME, null, cv);
    }


    List<Question> getAllQuestionsHun() {
        List<Question> questionList = new ArrayList<>();


        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTableHun.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTableHun.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();


        return questionList;
    }

    List<Question> getAllQuestionsEng() {
        List<Question> questionList = new ArrayList<>();


        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTableEng.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTableEng.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();


        return questionList;
    }

    List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();


        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();


        return questionList;
    }

}