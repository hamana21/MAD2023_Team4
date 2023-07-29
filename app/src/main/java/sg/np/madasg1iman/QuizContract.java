package sg.edu.np.mad.madquizfinal;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract() {}

    public static class priQuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quizQuestions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NUM = "answerNum";
        public static final String COLUMN_PRIMARY_LEVEL = "primaryLevel";
        public static final String COLUMN_PRIMARY_SUBJECT = "primarySubject";
    }

    public static class secQuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quizQuestions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NUM = "answerNum";
        public static final String COLUMN_SECONDARY_LEVEL = "secondaryLevel";
        public static final String COLUMN_SECONDARY_SUBJECT = "secondarySubject";
    }
}
