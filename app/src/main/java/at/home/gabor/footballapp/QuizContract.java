package at.home.gabor.footballapp;

import android.provider.BaseColumns;

final class QuizContract {

    private QuizContract() {}

    static class QuestionsTable implements BaseColumns {
        static final String TABLE_NAME = "quiz_questions";
        static final String COLUMN_QUESTION = "question";
        static final String COLUMN_OPTION1 = "option1";
        static final String COLUMN_OPTION2 = "option2";
        static final String COLUMN_OPTION3 = "option3";
        static final String COLUMN_ANSWER_NR = "answer_nr";
    }

    static class QuestionsTableHun implements BaseColumns {
        static final String TABLE_NAME = "quiz_questions_hun";
        static final String COLUMN_QUESTION = "question";
        static final String COLUMN_OPTION1 = "option1";
        static final String COLUMN_OPTION2 = "option2";
        static final String COLUMN_OPTION3 = "option3";
        static final String COLUMN_ANSWER_NR = "answer_nr";
    }

    static class QuestionsTableEng implements BaseColumns {
        static final String TABLE_NAME = "quiz_questions_eng";
        static final String COLUMN_QUESTION = "question";
        static final String COLUMN_OPTION1 = "option1";
        static final String COLUMN_OPTION2 = "option2";
        static final String COLUMN_OPTION3 = "option3";
        static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}
