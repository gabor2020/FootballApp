package at.home.gabor.footballapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" + ")";

        final String SQL_CREATE_QUESTIONS_TABLE_HUN = "CREATE TABLE " +
                QuestionsTableHun.TABLE_NAME + " ( " +
                QuestionsTableHun._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTableHun.COLUMN_QUESTION + " TEXT, " +
                QuestionsTableHun.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTableHun.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTableHun.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTableHun.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTableHun.COLUMN_ANSWER_NR + " INTEGER" + ")";

        final String SQL_CREATE_QUESTIONS_TABLE_ENG = "CREATE TABLE " +
                QuestionsTableEng.TABLE_NAME + " ( " +
                QuestionsTableEng._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTableEng.COLUMN_QUESTION + " TEXT, " +
                QuestionsTableEng.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTableEng.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTableEng.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTableEng.COLUMN_OPTION4 + " TEXT, " +
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
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTableHun.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTableEng.TABLE_NAME);
        onCreate(db);
    }


    private void fillQuestionsTable() {
        Question q1 = new Question("Welcher Spieler hat bisher die meisten Spiele im deutschen Nationaltrikot bestritten?", "Lothar Matthäus", "Miroslav Klose", "Franz Beckenbauer", "Thomas Müller", 1);
        addQuestion(q1);
        Question q2 = new Question("Welcher deutsche Bundestrainer wurde sowohl als Spieler, als auch als Trainer Weltmeister?", "Jürgen Klinsmann", "Helmut Schön", "Joachim Löw", "Franz Beckenbauer",4);
        addQuestion(q2);
        Question q3 = new Question("Welcher Spieler erzielte in der Geschichte der WM die meisten Tore?", "Ronaldo", "Gerd Müller", "Zlatan Ibrahimovic", "Miroslav Klose",4);
        addQuestion(q3);
        Question q4 = new Question("Welches Land war der erste Fußballweltmeister?", "Brazilien", "England", "Italien", "Uruguay",4);
        addQuestion(q4);
        Question q5 = new Question("Wer schoss das schnellste Tor nach Anstoß in einem WM-Spiel?", "Clint Dempsey", "Hakan Şükür", "Michael Ballack", "Ronaldinho",2);
        addQuestion(q5);
        Question q6 = new Question("Wer erzielte beim 7:1 von Deutschland gegen Brasilien 2014 das einzige Tor für Brasilien?", "Neymar", "Hulk", "David Luiz", "Oscar",4);
        addQuestion(q6);
        Question q7 = new Question("Das bekannteste Fußballsportereignis im Jahr 1954 ging in die Geschichte ein als...?", "Der Skandal von Wien", "Der Kaisersieg von München", "Das Wembley-Tor von London", "Das Wunder von Bern",4);
        addQuestion(q7);
        Question q8 = new Question("Wer wurde Torshützenkönig der WM-Endrunde 1954?", "Sándor Kocsis", "Helmut Rahn", "Max Morlock", "Ferenc Puskás",1);
        addQuestion(q8);
        Question q9 = new Question("Wer gewann die meisten WM-Titel?", "Deutschland", "Italien", "Brasilien", "Argentinien",3);
        addQuestion(q9);
        Question q10 = new Question("Wer gewann die EM in 2004?", "Deutschland", "Frankreich", "Griechenland", "Spanien",3);
        addQuestion(q10);
        Question q11 = new Question("Wer schoss bei der EM 2012 das letzte Tor?", "Mario Gomez", "Juan Mata", "Andres Iniesta", "Rudi Völler",2);
        addQuestion(q11);
        Question q12 = new Question("Wer spielte im WM-Finale 1938?", "Österreich gegen Frankreich", "Ungarn gegen Italien", "Schweden gegen Schweiz", "Italien gegen Brasilien",2);
        addQuestion(q12);
        Question q13 = new Question("Welche Mannschaft gewann die UEFA Europa League am häufigsten?", "Atletico Madrid", "FC Sevilla", "FC Liverpool", "Juventus Turin",2);
        addQuestion(q13);
        Question q14 = new Question("Welche Mannschaft gewann 2012/2013 zum 5. Mal Die UEFA Champions League?", "FC Bayern München", "Real Madrid", "FC Barcelona", "Inter Mailand",1);
        addQuestion(q14);
        Question q15 = new Question("Wie oft hat Real Madrid die Champions League gewonnen?", "7 Mal", "13 Mal", "15 Mal", "9 Mal",2);
        addQuestion(q15);
        Question q16 = new Question("Welcher Spieler gilt als Rekordtorschützer der UEFA Champions League?", "Cristiano Ronaldo", "Paolo Maldini", "Iker Casillas", "Lionel Messi",1);
        addQuestion(q16);
        Question q17 = new Question("Wer wurde Torschützenkönig der deutschen Fußballbundesliga 2018/19?", "Robert Lewandownski", "Thomas Müller", "Marco Reus", "Timo Werner",1);
        addQuestion(q17);
        Question q18 = new Question("Wer ist der Trainer der österreichischen Fußballnationalmannschaft?", "Franco Foda", "Marcel Koller", "Hans Krankl", "Dietmar Constantini",1);
        addQuestion(q18);
        Question q19 = new Question("Welche Mannschaft ist Rekordmeister der österreichischen Bundesliga?", "SK Rapid Wien", "FK Austria Wien", "FC Red Bull Salzburg", "FC Tirol Inssbruck",1);
        addQuestion(q19);
        Question q20 = new Question("Wie oft gewann SK Sturm Graz die österreichische Fußballmeisterschaft?", "5 mal", "2 Mal", "3 Mal", "1 Mal",3);
        addQuestion(q20);
        Question q21 = new Question("Welcher Spieler hat dem Namen 'Il Fenomeno' von der italienischen Presse erhalten?", "Zinedine Zidane", "Ronaldo", "Pelé", "Luis Suárez",2);
        addQuestion(q21);
        Question q22 = new Question("In welchem WM Spiel schoß Diego Maradona das berühmte 'Hand Gottes' Tor?", "1986 Argentinien-England", "1982 Argentinien-Belgien", "1982 Argentinien-Brasilien", "1986 Argentinien-Deutschland",1);
        addQuestion(q22);
    }

    private void fillQuestionsTableHun() {
        Question q1 = new Question("Melyik játékos játszotta a legtöbb mérkőzést a német válogatott színeiben?", "Lothar Matthäus", "Miroslav Klose", "Franz Beckenbauer", "Thomas Müller", 1);
        addQuestionHun(q1);
        Question q2 = new Question("Melyik német edző nyert játékosként és szövetségi kapitányként is világbajnokságot?", "Jürgen Klinsmann", "Helmut Schön", "Joachim Löw", "Franz Beckenbauer",4);
        addQuestionHun(q2);
        Question q3 = new Question("Melyik játékos lőtte a legtöbb gólt a Vb-k történetében?", "Ronaldo", "Gerd Müller", "Zlatan Ibrahimovic", "Miroslav Klose",4);
        addQuestionHun(q3);
        Question q4 = new Question("Ki nyerte az első Világbajnokságot?", "Brazília", "Anglia", "Olaszország", "Uruguay",4);
        addQuestionHun(q4);
        Question q5 = new Question("Ki lőtte a Vb-történelem leggyorsabb gólját?", "Clint Dempsey", "Hakan Şükür", "Michael Ballack", "Ronaldinho",2);
        addQuestionHun(q5);
        Question q6 = new Question("Ki lőtte a brazilok egyetlen gólját Németországnak a 2014-es 7:1-re elvesztett meccsen?", "Neymar", "Hulk", "David Luiz", "Oscar",4);
        addQuestionHun(q6);
        Question q7 = new Question("Az 1954-es év emlékezetes eseménye úgy is ismert a futballtörténelemben, mint...", "A bécsi botrány", "A müncheni győzelem", "A londoni Wembley-gól", "A berni csoda",4);
        addQuestionHun(q7);
        Question q8 = new Question("Ki volt az 1954-es Világbajnokság gólkirálya?", "Kocsis Sándor", "Helmut Rahn", "Max Morlock", "Puskás Ferenc",1);
        addQuestionHun(q8);
        Question q9 = new Question("Melyik ország nyerte a legtöbb világbajnoki címet?", "Németország", "Olaszország", "Brazília", "Argentína",3);
        addQuestionHun(q9);
        Question q10 = new Question("Melyik ország nyerte a 2004-es Európa-bajnokságot?", "Németország", "Franciaország", "Görögország", "Spanyolország",3);
        addQuestionHun(q10);
        Question q11 = new Question("Ki lőtte a 2012-es Európa-bajnokság utolsó gólját?", "Mario Gomez", "Juan Mata", "Andres Iniesta", "Rudi Völler",2);
        addQuestionHun(q11);
        Question q12 = new Question("Milyen mérkőzést játszottak az 1938-as Világbajnokság döntőjében?", "Ausztria-Franciaország", "Magyarország-Olaszország", "Svédország-Svájc", "Olaszország-Brazília",2);
        addQuestionHun(q12);
        Question q13 = new Question("Melyik csapat nyerte legtöbbször az UEFA Európa Ligát?", "Atletico Madrid", "Sevilla", "Liverpool", "Juventus",2);
        addQuestionHun(q13);
        Question q14 = new Question("Melyik csapat nyerte meg 2012/13-ban története során ötödször a Bajnokok ligáját?", "FC Bayern München", "Real Madrid", "FC Barcelona", "Internazionale",1);
        addQuestionHun(q14);
        Question q15 = new Question("Hányszor nyerte meg a Real Madrid a Bajnokok ligáját?", "Hétszer", "Tizenháromszor", "Tizenötször", "Kilencszer",2);
        addQuestionHun(q15);
        Question q16 = new Question("Ki lőtte a legtöbb gólt a Bajnokok ligája történetében?", "Cristiano Ronaldo", "Paolo Maldini", "Iker Casillas", "Lionel Messi",1);
        addQuestionHun(q16);
        Question q17 = new Question("Ki volt a Bundesliga gólkirálya 2018/19-ben?", "Robert Lewandownski", "Thomas Müller", "Marco Reus", "Timo Werner",1);
        addQuestionHun(q17);
        Question q18 = new Question("Ki az osztrák válogatott szövetségi kapitánya?", "Franco Foda", "Marcel Koller", "Hans Krankl", "Dietmar Constantini",1);
        addQuestionHun(q18);
        Question q19 = new Question("Ki nyerte legtöbbször az osztrák bajnokságot?", "SK Rapid Wien", "FK Austria Wien", "FC Red Bull Salzburg", "FC Tirol Inssbruck",1);
        addQuestionHun(q19);
        Question q20 = new Question("Hányszor volt osztrák bajnok az SK Sturm Graz?", "Ötször", "Kétszer", "Háromszor", "Egyszer",3);
        addQuestionHun(q20);
        Question q21 = new Question("Melyik játékos kapta az olasz sajtótól az 'Il Fenomeno' becenevet?", "Zinedine Zidane", "Ronaldo", "Pelé", "Luis Suárez",2);
        addQuestionHun(q21);
        Question q22 = new Question("Melyik Vb-mérkőzésen szerezte Diego Maradona hírhedt 'Isten keze' gólját?", "1986 Argentína-Anglia", "1982 Argentína-belgium", "1982 Argentína-Brazília", "1986 Argentína-Németország",1);
        addQuestionHun(q22);
    }

    private void fillQuestionsTableEng() {
        Question q1 = new Question("Which player played the most games in the German national football team?", "Lothar Matthäus", "Miroslav Klose", "Franz Beckenbauer", "Thomas Müller", 1);
        addQuestionEng(q1);
        Question q2 = new Question("Which German coach won the World Cup as player and as national team trainer?", "Jürgen Klinsmann", "Helmut Schön", "Joachim Löw", "Franz Beckenbauer",4);
        addQuestionEng(q2);
        Question q3 = new Question("Which player shot the most World Cup goals in history?", "Ronaldo", "Gerd Müller", "Zlatan Ibrahimovic", "Miroslav Klose",4);
        addQuestionEng(q3);
        Question q4 = new Question("Who won the first World Cup?", "Brazil", "England", "Italy", "Uruguay",4);
        addQuestionEng(q4);
        Question q5 = new Question("Who shot the fastest goal after kick off in a Worl Cup?", "Clint Dempsey", "Hakan Şükür", "Michael Ballack", "Ronaldinho",2);
        addQuestionEng(q5);
        Question q6 = new Question("Who shot the only goal for Brazil against Germany in the 2014 7:1 game?", "Neymar", "Hulk", "David Luiz", "Oscar",4);
        addQuestionEng(q6);
        Question q7 = new Question("A memorable moment of football history happened in 1954 and known as...", "The scandal of Vienna", "The win of Munich", "The Wembley-goal of London", "The miracle of Bern",4);
        addQuestionEng(q7);
        Question q8 = new Question("Who was the top goalscorer of World Cup 1954?", "Sándor Kocsis", "Helmut Rahn", "Max Morlock", "Ferenc Puskás",1);
        addQuestionEng(q8);
        Question q9 = new Question("Which coutry has won the most World Cups?", "Germany", "Italy", "Brazil", "Argentina",3);
        addQuestionEng(q9);
        Question q10 = new Question("Which country won Euro 2004?", "Germany", "France", "Greece", "Spain",3);
        addQuestionEng(q10);
        Question q11 = new Question("Who shot the last goal of Euro 2012?", "Mario Gomez", "Juan Mata", "Andres Iniesta", "Rudi Völler",2);
        addQuestionEng(q11);
        Question q12 = new Question("Who played the final of the World Cup 1938?", "Austria vs France", "Hungary vs Italy", "Sweden vs Switzerland", "Italy vs Brazil",2);
        addQuestionEng(q12);
        Question q13 = new Question("Who has won the most Europa League titles?", "Atletico Madrid", "Sevilla FC", "Liverpool FC", "Juventus",2);
        addQuestionEng(q13);
        Question q14 = new Question("Which team won the Champions League in 2012/13 for the 5th time in their history?", "FC Bayern Munich", "Real Madrid", "FC Barcelona", "Inter Milan",1);
        addQuestionEng(q14);
        Question q15 = new Question("How many times won Real Madrid the Champions League?", "7", "13", "15", "9",2);
        addQuestionEng(q15);
        Question q16 = new Question("Who shot the most goals in the Champions League?", "Cristiano Ronaldo", "Paolo Maldini", "Iker Casillas", "Lionel Messi",1);
        addQuestionEng(q16);
        Question q17 = new Question("Who scored the most goals in the 2018/19 Bundesliga season?", "Robert Lewandownski", "Thomas Müller", "Marco Reus", "Timo Werner",1);
        addQuestionEng(q17);
        Question q18 = new Question("Who is the manager of the Austrian national team?", "Franco Foda", "Marcel Koller", "Hans Krankl", "Dietmar Constantini",1);
        addQuestionEng(q18);
        Question q19 = new Question("Which team won the Austrian Bundesliga the most times?", "SK Rapid Wien", "FK Austria Wien", "FC Red Bull Salzburg", "FC Tirol Inssbruck",1);
        addQuestionEng(q19);
        Question q20 = new Question("How many times won SK Sturm Graz the Austrian Bundesliga?", "5 times", "2 times", "3 times", "1 time",3);
        addQuestionEng(q20);
        Question q21 = new Question("Who was nicknamed 'Il Fenomeno' by the Italian press?", "Zinedine Zidane", "Ronaldo", "Pelé", "Luis Suárez",2);
        addQuestionEng(q21);
        Question q22 = new Question("At which World Cup game did Diego Maradona shoot his infamous 'Hand of God' goal?", "1986 Argentina vs England", "1982 Argentina vs Belgium", "1982 Argentina vs Brazil", "1986 Argentina vs Germany",1);
        addQuestionEng(q22);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    private void addQuestionHun(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTableHun.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTableHun.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTableHun.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTableHun.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTableHun.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTableHun.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTableHun.TABLE_NAME, null, cv);
    }

    private void addQuestionEng(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTableEng.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTableEng.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTableEng.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTableEng.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTableEng.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTableEng.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTableEng.TABLE_NAME, null, cv);
    }


    ArrayList<Question> getAllQuestionsHun() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTableHun.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question("A ist richtig", "A", "B", "C", "D", 1);
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTableHun.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTableHun.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    ArrayList<Question> getAllQuestionsEng() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTableEng.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question("A ist richtig", "A", "B", "C", "D", 1);
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTableEng.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTableEng.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question("A ist richtig", "A", "B", "C", "D", 1);
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

}