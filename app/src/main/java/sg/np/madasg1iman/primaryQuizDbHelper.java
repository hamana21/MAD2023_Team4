package sg.np.madasg1iman;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sg.edu.np.mad.madquizfinal.QuizContract.*;

public class primaryQuizDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PrimaryQuestion.db";
    public static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public primaryQuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                priQuestionsTable.TABLE_NAME + " ( " +
                priQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                priQuestionsTable.COLUMN_QUESTION + " TEXT, " +
                priQuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                priQuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                priQuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                priQuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                priQuestionsTable.COLUMN_ANSWER_NUM + " INTEGER, " +
                priQuestionsTable.COLUMN_PRIMARY_LEVEL + " TEXT, " +
                priQuestionsTable.COLUMN_PRIMARY_SUBJECT + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + priQuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        fillPrimary1EnglishQuestions();
        fillPrimary1MathQuestions();

        fillPrimary2EnglishQuestions();
        fillPrimary2MathQuestions();

        fillPrimary3EnglishQuestions();
        fillPrimary3MathQuestions();
        fillPrimary3ScienceQuestions();

        fillPrimary4EnglishQuestions();
        fillPrimary4MathQuestions();
        fillPrimary4ScienceQuestions();

        fillPrimary5EnglishQuestions();
        fillPrimary5MathQuestions();
        fillPrimary5ScienceQuestions();

        fillPrimary6EnglishQuestions();
        fillPrimary6MathQuestions();
        fillPrimary6ScienceQuestions();
    }

    private void fillPrimary1EnglishQuestions(){
        primaryQuestion pq1e1 = new primaryQuestion("Samad and Ali ____ cleaning the whiteboard.",
                "is", "are", "was", "were", 2,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e1);

        primaryQuestion pq1e2 = new primaryQuestion("Ben eats ____ apple for dinner every day.",
                "a", "an", "the", "that", 2,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e2);

        primaryQuestion pq1e3 = new primaryQuestion("'Please pour the sugar ____ the jar,' said Mrs Lim",
                "in", "into", "through", "on", 2,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e3);

        primaryQuestion pq1e4 = new primaryQuestion("Fiona fell down ____ hurt her knee.",
                "or", "so", "and", "but", 3,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e4);

        primaryQuestion pq1e5 = new primaryQuestion("My mother ____ a cake for me yesterday.",
                "bake", "bakes", "baked", "baking", 3,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e5);

        primaryQuestion pq1e6 = new primaryQuestion("The dogs are barking loudly. ____ are hungry.",
                "It", "He", "They", "Them", 3,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e6);

        primaryQuestion pq1e7 = new primaryQuestion("At noon, Tim went to his grandparents house for ____.",
                "lunch", "dinner", "breakfast", "Supper", 1,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e7);

        primaryQuestion pq1e8 = new primaryQuestion("The cake was so ____ that fifty people could eat it.",
                "big", "small", "heavy", "light", 1,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e8);

        primaryQuestion pq1e9 = new primaryQuestion("Mother ____ some butter on the bread with a knife.",
                "spread", "scooped", "sprinkled", "sprayed", 1,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e9);

        primaryQuestion pq1e10 = new primaryQuestion("The ____ snapped and ate the duck hungrily",
                "lion", "monkey", "tiger", "crocodile", 4,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq1e10);
    }

    private void fillPrimary1MathQuestions() {
        primaryQuestion pq1m1 = new primaryQuestion("Which pair of numbers make 10?",
                "8 and 1", "2 and 6", "3 and 4", "6 and 4", 4,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m1);

        primaryQuestion pq1m2 = new primaryQuestion("2 more than 15 is ____.",
                "13", "14", "17", "18", 3,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m2);

        primaryQuestion pq1m3 = new primaryQuestion("____ - 5 = 13",
                "18", "17", "8", "7", 1,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m3);

        primaryQuestion pq1m4 = new primaryQuestion("14 + 3 = ____",
                "7", "8", "11", "17", 4,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m4);

        primaryQuestion pq1m5 = new primaryQuestion("Sharon has 4 sweets. Wei Ming has 9 sweets. " +
                "How many sweets do they have altogether?",
                "5", "18", "13", "12", 3,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m5);

        primaryQuestion pq1m6 = new primaryQuestion("4 + ____ = 9",
                "10", "1", "4", "5", 4,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m6);

        primaryQuestion pq1m7 = new primaryQuestion("8 + 2 = ____",
                "10", "6", "12", "8", 1,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m7);

        primaryQuestion pq1m8 = new primaryQuestion("1 more than ____ is 4.",
                "4", "3", "2", "1", 2,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m8);

        primaryQuestion pq1m9 = new primaryQuestion("____ is 1 less than 7.",
                "9", "6", "7", "8", 2,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m9);

        primaryQuestion pq1m10 = new primaryQuestion("7 and ____ make 13",
                "5", "12", "7", "6", 4,
                primaryQuestion.PRIMARY1, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq1m10);
    }

    private void fillPrimary2EnglishQuestions() {
        primaryQuestion pq2e1 = new primaryQuestion("This peacock has very beautiful ____.",
                "fur", "hair", "scales", "feathers", 4,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e1);

        primaryQuestion pq2e2 = new primaryQuestion("Beware of the ____! It has very sharp pincers!",
                "crab", "mussel", "scallop", "lobster", 1,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e2);

        primaryQuestion pq2e3 = new primaryQuestion("My father uses a ____ to make holes in the wall.",
                "drill", "hammer", "hair dryer", "screwdriver", 1,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e3);

        primaryQuestion pq2e4 = new primaryQuestion("Yummy! I had a plate of chicken rice yesterday. It was very ____.",
                "terrible", "tasty", "salty", "sour", 2,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e4);

        primaryQuestion pq2e5 = new primaryQuestion("Joe uses a magnet to attract some ____ on the floor.",
                "keys", "iron bolts", "paper clips", "metal rulers", 2,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e5);

        primaryQuestion pq2e6 = new primaryQuestion("My uncle is a fashion designer. That pair of scissors is ____",
                "he", "his", "it", "him", 2,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e6);

        primaryQuestion pq2e7 = new primaryQuestion("'____ cake are you buying for mother's birthday?' asked Cindy's elder sister.",
                "Who", "Where", "Which", "Whose", 3,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e7);

        primaryQuestion pq2e8 = new primaryQuestion("The mouse ran ____ the hole when it saw the cat coming.",
                "on", "under", "into", "above", 3,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e8);

        primaryQuestion pq2e9 = new primaryQuestion("'Can you please turn off ____ black radio over there!' shouted Lisa.",
                "this", "that", "these", "those", 2,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e9);

        primaryQuestion pq2e10 = new primaryQuestion("Ethan started to ____ when he lost his mother in the mall.",
                "cry", "cries", "cried", "crying", 1,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq2e10);
    }

    private void fillPrimary2MathQuestions() {
        primaryQuestion pq2m1 = new primaryQuestion("9 X 3 = ____",
                "6", "12", "3", "27", 4,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m1);

        primaryQuestion pq2m2 = new primaryQuestion("Which one of the following correctly shows 4 groups of 3?",
                "4 - 3", "4 + 3", "4 x 3", "4 divide by 3 ", 3,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m2);

        primaryQuestion pq2m3 = new primaryQuestion("24 divide by 3",
                "6", "8", "21", "27", 2,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m3);

        primaryQuestion pq2m4 = new primaryQuestion("Hazel bought 6 packets of erasers. There were 4 eraser " +
                "in each packet. How many erasers did she buy in all?",
                "10", "2", "3", "24", 4,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m4);

        primaryQuestion pq2m5 = new primaryQuestion("Amanda sold 9 boxes of Cupcakes. " +
                "Each box contained 4 cupcakes. " +
                "How many cupcakes did she sell altogether?",
                "36", "13", "24", "30", 1,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m5);

        primaryQuestion pq2m6 = new primaryQuestion("641 + 238 = ____.",
                "403", "417", "877", "879", 4,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m6);

        primaryQuestion pq2m7 = new primaryQuestion("10 less than 418 is ____.",
                "318", "408", "428", "518", 2,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m7);

        primaryQuestion pq2m8 = new primaryQuestion("____ and ____ are 3-digit odd numbers.",
                "41 and 45", "32 and 37",
                "247 and 275", "301 and 374", 3,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m8);

        primaryQuestion pq2m9 = new primaryQuestion("6 tens and 17 ones is the same as ____.",
                "67", "77", "617", "707", 2,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m9);

        primaryQuestion pq2m10 = new primaryQuestion("30 tens - 2 tens = ____",
                "10", "28", "280", "320", 3,
                primaryQuestion.PRIMARY2, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq2m10);

    }

    private void fillPrimary3EnglishQuestions() {
        primaryQuestion pq3e1 = new primaryQuestion("Mrs Chan ____ me Science last year.",
                "teach", "taught", "teaches", "teaching", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e1);

        primaryQuestion pq3e2 = new primaryQuestion("Sumei stood nervously on stage. She tried to speak but ____ " +
                "words came out of her mouth.",
                "no", "all", "any", "every", 1,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e2);

        primaryQuestion pq3e3 = new primaryQuestion("Elliot is going to the library later, ____ he?",
                "is", "isn't", "does", "doesn't", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e3);

        primaryQuestion pq3e4 = new primaryQuestion("My sister met the President ____ at the National Day Parade " +
                "and shook his hand.",
                "herself", "himself", "yourselves", "themselves", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e4);

        primaryQuestion pq3e5 = new primaryQuestion("Is Ali thinking about ____ us at Sentosa tomorrow.",
                "join", "joins", "joined", "joining", 4,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e5);

        primaryQuestion pq3e6 = new primaryQuestion("Lucy put up ____ of her missing cat all around her " +
                "neighbourhood. She hoped someone would find and return her beloved pet.",
                "posters", "banners", "brochures", "advertisements", 1,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e6);

        primaryQuestion pq3e7 = new primaryQuestion("My father bought the ____ computer model as his current one " +
                "does not have the newest features.",
                "latest", "purest", "largest", "strongest", 1,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e7);

        primaryQuestion pq3e8 = new primaryQuestion("The icy mountain was so slippery that we ____ down the track " +
                "instead of walking on it.",
                "strode", "strolled", "scuttled", "slithered", 4,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e8);

        primaryQuestion pq3e9 = new primaryQuestion("Aminah's house was burgled last week. The police are ____ the case.",
                "looking up", "looking by", "looking for", "looking into", 4,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e9);

        primaryQuestion pq3e10 = new primaryQuestion("Melody waited ____ for her parents to return with her birthday cake.",
                "carefully", "excitedly", "frantically", "gracefully", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq3e10);
    }

    private void fillPrimary3MathQuestions() {
        primaryQuestion pq3m1 = new primaryQuestion("Which of the following is the same as 7535?",
                "700 + 50 + 3 + 5", "700 + 50 + 30 + 5",
                "7000 + 500 + 3 + 5", "7000 + 500 + 30 + 5", 4,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m1);

        primaryQuestion pq3m2 = new primaryQuestion("Which one of the following numbers has the smallest value?",
                "7504", "7405", "7540", "7450", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m2);

        primaryQuestion pq3m3 = new primaryQuestion("A box contained 7 doughnuts. Jane bought 9 boxes of doughnuts " +
                "How many doughnuts were there altogether?",
                "16", "56", "63", "79", 3,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m3);

        primaryQuestion pq3m4 = new primaryQuestion("What is the value of the digit 7 in the number 9837?",
                "7", "70", "700", "7000", 1,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m4);

        primaryQuestion pq3m5 = new primaryQuestion("Fanny had 3 ten-dollar notes and 2 fifty-cent coins." +
                "She bought a toy which cost $6.50. How much money had she left?",
                "$24.50", "$25.50", "$35.50", "$37.50", 1,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m5);

        primaryQuestion pq3m6 = new primaryQuestion("9 Km 80m = ____m.",
                "908", "980", "9080", "9800", 3,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m6);

        primaryQuestion pq3m7 = new primaryQuestion("3000 + 700 + 8 = ____.",
                "3078", "3708", "3780", "3870", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m7);

        primaryQuestion pq3m8 = new primaryQuestion("302 + 5503 = ____.",
                "5201", "5805", "5905", "8523", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m8);

        primaryQuestion pq3m9 = new primaryQuestion("607 x 8 = ____.",
                "4048", "4806", "4856", "4930", 3,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m9);

        primaryQuestion pq3m10 = new primaryQuestion("Peter had 58 apples. He packed them into boxes of 7." +
                "How many apples were left unpacked?",
                "7", "2", "8", "9", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq3m10);
    }

    private void fillPrimary3ScienceQuestions() {
        primaryQuestion pq3s1 = new primaryQuestion("What of the following group of animal gives birth to their young?",
                "Bird", "Reptile", "Mammal", "Amphibian", 3,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq3s1);

        primaryQuestion pq3s2 = new primaryQuestion("Which of the following statements about bacteria is correct?",
                "All bacteria are harmful.", "Bacteria come in different shapes.",
                "All bacteria can be seen without a microscope.", "Bacteria do need air, food and water to survive", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq3s2);

        primaryQuestion pq3s3 = new primaryQuestion("Which object can be used to make into an electromagnet?",
                "gloves", "steel rod", "silver coin", "rubber band", 2,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq3s3);

        primaryQuestion pq3s4 = new primaryQuestion("Which of the following organism can only be seen through a microscope?",
                "Bacteria and yeast", "Moss and yeast",
                "Mould and ferns", "Mushroom and bacteria", 1,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq3s4);

        primaryQuestion pq3s5 = new primaryQuestion("The ____ system of the human body works together " +
                "with the digestive system to transport digested food to different parts of the body.",
                "skeletal", "muscular", "circulatory", "respiratory", 3,
                primaryQuestion.PRIMARY3, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq3s5);
    }

    private void fillPrimary4EnglishQuestions(){
        primaryQuestion pq4e1 = new primaryQuestion("'She didn't complete her homework, ____ she?' " +
                "questioned the teacher in a stem voice.",
                "did", "has", "does", "didn't", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e1);

        primaryQuestion pq4e2 = new primaryQuestion("'My soup is too bland. Can I add ____ pepper?' " +
                "Jamie asked.",
                "some", "many", "a few", "much", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e2);

        primaryQuestion pq4e3 = new primaryQuestion("Sheila's painting is both vibrant ____ fascinating.",
                "and", "yet", "but", "or", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e3);

        primaryQuestion pq4e4 = new primaryQuestion("Mrs Ong told me to carry ____ books here to the classroom.",
                "this", "that", "those", "these", 4,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e4);

        primaryQuestion pq4e5 = new primaryQuestion("John ____ to his friend when his sister tapped him on his " +
                "shoulder.",
                "talk", "talks", "is talking", "was talking", 4,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e5);

        primaryQuestion pq4e6 = new primaryQuestion("Tom has been selected to ____ in the 100-metre race " +
                "after coming in first in the heats.",
                "join", "attempt", "practice", "compete", 4,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e6);

        primaryQuestion pq4e7 = new primaryQuestion("The official blew the whistle to ____ to the timekeeper " +
                "to stop the basketball game.",
                "signal", "connect", "highlight", "emphasise", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e7);

        primaryQuestion pq4e8 = new primaryQuestion("Ahmad cried out in fear as he was ____ by the cockroach " +
                "crawling towards him.",
                "excited", "terrified", "charmed", "disheartened", 2,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e8);

        primaryQuestion pq4e9 = new primaryQuestion("Benjamin looked ____ when he received his results as he did not do as well " +
                "as he had expected.",
                "relieved", "confused", "fascinated", "disappointed", 4,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e9);

        primaryQuestion pq4e10 = new primaryQuestion("The principle made an ____ to confirm the date of the annual Sports " +
                "Day during morning assembly.",
                "argument", "advertisement", "announcement", "acknowledgement", 3,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq4e10);
    }

    private void fillPrimary4MathQuestions() {
        primaryQuestion pq4m1 = new primaryQuestion("Which one of the following numbers have the greatest value?",
                "83 714", "87 341", "87 431", "83 741", 3,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m1);

        primaryQuestion pq4m2 = new primaryQuestion("Which one of the following number when rounded off to the nearest" +
                "hundred is 6000?",
                "6138", "6087", "5986", "5092", 3,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m2);

        primaryQuestion pq4m3 = new primaryQuestion("Which one of the following is not a common factor of 18 and 36?",
                "6", "18", "3", "36", 4,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m3);

        primaryQuestion pq4m4 = new primaryQuestion("A sticker can print 7680 stickers in 6 hours. How many stickers " +
                "can the printer print in 4 hours",
                "1280", "1920", "2560", "5120", 4,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m4);

        primaryQuestion pq4m5 = new primaryQuestion("How many one-fifths are there in 6 wholes?",
                "30", "11", "6", "5", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m5);

        primaryQuestion pq4m6 = new primaryQuestion("What is the value of digit 6 in 42 650?",
                "6", "60", "600", "6000", 3,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m6);

        primaryQuestion pq4m7 = new primaryQuestion("What is the product of 2109 and 3?",
                "73", "703", "6327", "6357", 3,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m7);

        primaryQuestion pq4m8 = new primaryQuestion("The value of the digit 2 in 36 205 is ____.",
                "20", "200", "2000", "20 000", 2,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m8);

        primaryQuestion pq4m9 = new primaryQuestion("2 ten thousands + 5 tens + 8 ones = ____",
                "2058", "2580", "20 058", "20 508", 3,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m9);

        primaryQuestion pq4m10 = new primaryQuestion("In the number 87 326, which digit is in the thousands place?",
                "7", "2", "3", "8", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq4m10);
    }

    private void fillPrimary4ScienceQuestions() {
        primaryQuestion pq4s1 = new primaryQuestion("Which statement is correct?",
                "All plants grow from spores.", "A young plant has a similar life cycle to its parent.",
                "A young plant has more leaves than an adult plant.",
                "The life cycle of a plant comes to an end when the plants becomes an adult.", 2,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq4s1);

        primaryQuestion pq4s2 = new primaryQuestion("Which is matter?",
                "wind", "music", "sound", "shadow", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq4s2);

        primaryQuestion pq4s3 = new primaryQuestion("Which human body system is involved in the exchanging " +
                "of gases with the surrounding?",
                "skeletal", "muscular", "circulatory", "respiratory", 4,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq4s3);

        primaryQuestion pq4s4 = new primaryQuestion("Which of the following statements about heat is true?",
                "Heat is a form of energy.", "Heat loss causes an increase in temperature",
                "Heat travels from a colder place to a hotter place.",
                "Heat is a measurement of the degree of hotness of an object.", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq4s4);

        primaryQuestion pq4s5 = new primaryQuestion("What do solids, liquids, and gasses have in common?",
                "They have mass and occupy space.", "They occupy space and have no mass.",
                "They have definite shape and definite volume.",
                "They have definite volume but no definite shape", 1,
                primaryQuestion.PRIMARY4, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq4s5);
    }

    private void fillPrimary5EnglishQuestions() {
        primaryQuestion pq5e1 = new primaryQuestion("____ the bad reviews, the band kept performing to sell-out crowds.",
                "With", "Due to", "Despite", "Although", 3,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e1);

        primaryQuestion pq5e2 = new primaryQuestion("Joe never gets home on time, ____?",
                "did he", "didn't he", "does he", "doesn't he", 3,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e2);

        primaryQuestion pq5e3 = new primaryQuestion("Ashley felt beads of perspiration ____ down his back due " +
                "to the intense heat.",
                "trickle", "trickled", "had trickled", "was trickling", 1,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e3);

        primaryQuestion pq5e4 = new primaryQuestion("'If someone is injured in an accident you ____ call for an " +
                "ambulance intermediately,' said the camp instructor.",
                "could", "might", "would", "should", 4,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e4);

        primaryQuestion pq5e5 = new primaryQuestion("Everyone, except Caleb and Cain, ____ volunteered to help the teachers.",
                "do", "has", "does", "have", 2,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e5);

        primaryQuestion pq5e6 = new primaryQuestion("'Jane's done her homework, ____ she?' asked Mrs Lim.",
                "isn't", "wasn't", "hasn't", "doesn't", 3,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e6);

        primaryQuestion pq5e7 = new primaryQuestion("Mother reminded the boys to take care of ____ " +
                "when they were out.",
                "myself", "himself", "ourselves", "themselves", 4,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e7);

        primaryQuestion pq5e8 = new primaryQuestion("The salesgirl spoke ____ such a soft voice that the customer " +
                "could hardly hear.",
                "in", "at", "on", "through", 1,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e8);

        primaryQuestion pq5e9 = new primaryQuestion("Jia Min loves to exercise. she ____ every Friday.",
                "swim", "swims", "swum", "swimming", 2,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e9);

        primaryQuestion pq5e10 = new primaryQuestion("Siti, ____ interest is in drawing, has recently won the " +
                "art competition.",
                "who", "whom", "who's", "whose", 4,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq5e10);
    }

    private void fillPrimary5MathQuestions() {
        primaryQuestion pq5m1 = new primaryQuestion("Find the value of (100 + 250 / 10) x 3.",
                "105", "175", "325", "375", 4,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m1);

        primaryQuestion pq5m2 = new primaryQuestion("Which of the following numbers when rounded to the nearest " +
                "hundred becomes 61 400?",
                "61 349", "61 449", "61 450", "61 495", 2,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m2);

        primaryQuestion pq5m3 = new primaryQuestion("A typist can type 160 words in 5 minutes. At this rate, " +
                "how long does the typist take to type 320 words.",
                "10 minutes", "2 minutes", "32 minutes", "64 minutes", 1,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m3);

        primaryQuestion pq5m4 = new primaryQuestion("Find the value of 28 x 7000.",
                "196", "1960", "19 600", "196 000", 4,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m4);

        primaryQuestion pq5m5 = new primaryQuestion("Find the value of 300 + 100 / 5 - 12 x 5.",
                "20", "260", "340", "1540", 2,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m5);

        primaryQuestion pq5m6 = new primaryQuestion("What digit in 23.479 is in the tenths place?.",
                "7", "2", "9", "4", 4,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m6);

        primaryQuestion pq5m7 = new primaryQuestion("6 hundreds, 9 tens and 3 thousandths is ____.",
                "690.3", "690.003", "609.3", "609.003", 2,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m7);

        primaryQuestion pq5m8 = new primaryQuestion("Find the difference between 85 812 and 23 167. " +
                "Round your answers to the nearest hundred.",
                "62 000", "62 600", "62 700", "63 000", 2,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m8);

        primaryQuestion pq5m9 = new primaryQuestion("3/7 of a number is 42. What is 1/2 of this number?",
                "18", "21", "49", "98", 3,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m9);

        primaryQuestion pq5m10 = new primaryQuestion("In an exhibition hall, there were 140 adults. 28 were women. " +
                "What is the ratio of the number of men to the number of women.",
                "1 : 4", "1 : 5", "4 : 1", "5 : 1", 3,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq5m10);
    }

    private void fillPrimary5ScienceQuestions() {
        primaryQuestion pq5s1 = new primaryQuestion("Which statement is correct about yeast?",
                "it is a type of bacteria", "it is used to make bread",
                "it can make its own food", "it is not a microorganism", 2,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq5s1);

        primaryQuestion pq5s2 = new primaryQuestion("Which of the following is a function of the human skeletal system?",
                "protects organs in the body", "protects the muscular system",
                "transports blood around the body", "transports food in the digestive system", 1,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq5s2);

        primaryQuestion pq5s3 = new primaryQuestion("Which one of the following organisms is not a fungus?",
                "fern", "yeast", "mould", "mushroom", 1,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq5s3);

        primaryQuestion pq5s4 = new primaryQuestion("For an adult plant to produce seeds, which of the following process " +
                "must take place.",
                "germination only", "cross-pollination only",
                "pollination and fertilization", "germination and pollination", 3,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq5s4);

        primaryQuestion pq5s5 = new primaryQuestion("Which one of the following statements is wrong?",
                "Digestion of food ends in the large intestine.", "Food is broken down into smaller pieces " +
                "in the mouth",
                "Food is transported from the mouth to the stomach through the gullet.",
                "Digestive juices in the stomach breaks down food into simpler substances.", 1,
                primaryQuestion.PRIMARY5, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq5s5);
    }

    private void fillPrimary6EnglishQuestions() {
        primaryQuestion pq6e1 = new primaryQuestion("'He's hardly the person for the job, ____?' said the manager, " +
                "shaking his head",
                "is he", "can he", "isn't he", "can't he", 1,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e1);

        primaryQuestion pq6e2 = new primaryQuestion("During his stay on the farm, all he did was ____ the farmers plough the " +
                "field",
                "watch", "watches", "watched", "watching", 1,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e2);

        primaryQuestion pq6e3 = new primaryQuestion("Catherine's knowledge of computers ___ so extensive that everybody " +
                "wants her to be in their project group",
                "is", "are", "was", "were", 1,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e3);

        primaryQuestion pq6e4 = new primaryQuestion("The studious boy preserved despite being told that he was making " +
                "____ progress in his work",
                "few", "little", "some", "several", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e4);

        primaryQuestion pq6e5 = new primaryQuestion("I am teaching at Everit Enrichment center, ____ is just s stone's throw. " +
                "away from your school",
                "who", "which", "whom", "where", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e5);

        primaryQuestion pq6e6 = new primaryQuestion("The pain on my ankle gradually ____. Soon, I would be able to walk " +
                "without the aid of a walking stick.",
                "wore on", "wore off", "wore out", "wore away", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e6);

        primaryQuestion pq6e7 = new primaryQuestion("After you have a clear idea of the play, we can start thinking about the cast " +
                "____",
                "accordingly", "expectantly", "presumably", "simultaneously", 1,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e7);

        primaryQuestion pq6e8 = new primaryQuestion("The young actor ____ the question by talking about something that " +
                "was absolutely unrelated.",
                "alerted", "evaded", "averted", "escaped", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e8);

        primaryQuestion pq6e9 = new primaryQuestion("She is always giving orders and expecting others to obey. No one likes her " +
                "because of her ____ manner.",
                "hasty", "reckless", "impulsive", "imperious", 4,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e9);

        primaryQuestion pq6e10 = new primaryQuestion("Tim decided to ____ and face his fear of water by jumping out of the " +
                "boat and into the sea.",
                "bite the bullet", "make a comeback",
                "survive the test of time", "set the wheel in motion", 1,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_ENGLISH);
        addQuestion(pq6e10);
    }

    private void fillPrimary6MathQuestions() {
        primaryQuestion pq6m1 = new primaryQuestion("Round 324 458 to the nearest hundred.",
                "320 000", "320 060", "324 400", "324 500", 4,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m1);

        primaryQuestion pq6m2 = new primaryQuestion("Express 0.375 as a percentage.",
                "375%", "37.5%", "3.75%", "0.375%", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m2);

        primaryQuestion pq6m3 = new primaryQuestion("Arrange these fractions in descending order 11/12, 5/6, 3/4, 7/9.",
                "3/4, 5/6, 7/9, 11/12", "11/12, 7/9, 5/6, 3/4",
                "3/4, 7/9, 5/6, 11/12", "11/12, 5/6, 7/9, 3/4", 4,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m3);

        primaryQuestion pq6m4 = new primaryQuestion("How many seconds are in 3/5 hour?",
                "36", "60", "2160", "6000", 3,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m4);

        primaryQuestion pq6m5 = new primaryQuestion("340 x 2.2 = 340 x ____ x 22. What is missing in the blank?",
                "1.00", "0.10", "0.01", "10.0", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m5);

        primaryQuestion pq6m6 = new primaryQuestion("Mr Low planted 120 pots of orchids and roses. 3/5 of the pots were orchids. " +
                "Among the roses, there was an equal number of pots of red and pots of yellow roses. " +
                "How many pots of yellow roses were there?",
                "20", "24", "36", "80", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m6);

        primaryQuestion pq6m7 = new primaryQuestion("The Average age of 3 dogs was 12 years old. The age of each dog was different. " +
                "The youngest dog was 8 years old. Which one of the following was a possible " +
                "age of the oldest dog",
                "15", "14", "13", "12", 1,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m7);

        primaryQuestion pq6m8 = new primaryQuestion("Jeff is facing north. He makes a 1/4 turn clockwise followed by " +
                "1/2 turn anticlockwise. From here, he makes a final turn to face south-east. " +
                "Find the angle that he has to make for the final turn.",
                "135 anticlockwise", "45 anticlockwise",
                "135 clockwise", "45 clockwise", 1,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m8);

        primaryQuestion pq6m9 = new primaryQuestion("Which digit in 15.89 is in the tenths place?",
                "1", "5", "8", "9", 3,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m9);

        primaryQuestion pq6m10 = new primaryQuestion("There were 585 640 visitors to a museum last year. " +
                "Round this number to the nearest thousand.",
                "585 000", "586 000", "590 000", "600 000", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_MATHEMATICS);
        addQuestion(pq6m10);
    }

    private void fillPrimary6ScienceQuestions() {
        primaryQuestion pq6s1 = new primaryQuestion("Which one of the following characteristics can be used to " +
                "differentiate between birds and mammals?",
                "number of legs", "presence of wings",
                "types of body coverings", "methods of reproduction", 3,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq6s1);

        primaryQuestion pq6s2 = new primaryQuestion("Global warming is harmful to our environment. " +
                "Which of the following is the cause of global warning?",
                "flooding", "soil erosion", "deforestation",
                "melting of icebergs", 3,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq6s2);

        primaryQuestion pq6s3 = new primaryQuestion("Which of the following statements about evaporation " +
                "is correct?",
                "It occurs at fixed temperature.", "It involves heat gain to the surroundings.",
                "It is affected by the surrounding temperature.",
                "It involves a change from gaseous to liquid state.", 3,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq6s3);

        primaryQuestion pq6s4 = new primaryQuestion("Which one of the following is a similarity between " +
                "mushroom and bacteria?",
                "Both can make food.", "Both are decomposers.",
                "Both reproduce by spores.", "Both are microscopic organisms.", 2,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq6s4);

        primaryQuestion pq6s5 = new primaryQuestion("Which of the following is a function of the human " +
                "muscular system?",
                "breaks down food", "protects organs in the body",
                "enables different parts of the body to move",
                "transports waste materials away from different parts of the body", 3,
                primaryQuestion.PRIMARY6, primaryQuestion.PRI_SCIENCE);
        addQuestion(pq6s5);
    }


    private void addQuestion(primaryQuestion pq) {
        ContentValues cv = new ContentValues();
        cv.put(priQuestionsTable.COLUMN_QUESTION, pq.getPriQuestion());
        cv.put(priQuestionsTable.COLUMN_OPTION1, pq.getPriOption1());
        cv.put(priQuestionsTable.COLUMN_OPTION2, pq.getPriOption2());
        cv.put(priQuestionsTable.COLUMN_OPTION3, pq.getPriOption3());
        cv.put(priQuestionsTable.COLUMN_OPTION4, pq.getPriOption4());
        cv.put(priQuestionsTable.COLUMN_ANSWER_NUM, pq.getPriAnswerNum());
        cv.put(priQuestionsTable.COLUMN_PRIMARY_LEVEL, pq.getPrimaryLevel());
        cv.put(priQuestionsTable.COLUMN_PRIMARY_SUBJECT, pq.getPrimarySubject());
        db.insert(priQuestionsTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public ArrayList<primaryQuestion>getAllPrimaryQuestions() {
        ArrayList<primaryQuestion> priQuestionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + priQuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()){
            do {
                primaryQuestion primaryquestion = new primaryQuestion();
                primaryquestion.setPriQuestion(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_QUESTION)));
                primaryquestion.setPriOption1(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION1)));
                primaryquestion.setPriOption2(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION2)));
                primaryquestion.setPriOption3(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION3)));
                primaryquestion.setPriOption4(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION4)));
                primaryquestion.setPriAnswerNum(c.getInt(c.getColumnIndex(priQuestionsTable.COLUMN_ANSWER_NUM)));
                primaryquestion.setPrimaryLevel(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_PRIMARY_LEVEL)));
                primaryquestion.setPrimarySubject(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_PRIMARY_SUBJECT)));
                priQuestionList.add(primaryquestion);
            } while (c.moveToNext());
        }

        c.close();
        return priQuestionList;
    }

    @SuppressLint("Range")
    public ArrayList<primaryQuestion>getPrimaryQuestions(String primaryLevel, String primarySubject) {
        ArrayList<primaryQuestion> priQuestionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = priQuestionsTable.COLUMN_PRIMARY_LEVEL + " = ? " +
                " AND " + priQuestionsTable.COLUMN_PRIMARY_SUBJECT + " = ? ";
        String[] selectionArgs = new String[]{primaryLevel, primarySubject};

        Cursor c = db.query(
                priQuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()){
            do {
                primaryQuestion primaryquestion = new primaryQuestion();
                primaryquestion.setPriQuestion(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_QUESTION)));
                primaryquestion.setPriOption1(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION1)));
                primaryquestion.setPriOption2(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION2)));
                primaryquestion.setPriOption3(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION3)));
                primaryquestion.setPriOption4(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_OPTION4)));
                primaryquestion.setPriAnswerNum(c.getInt(c.getColumnIndex(priQuestionsTable.COLUMN_ANSWER_NUM)));
                primaryquestion.setPrimaryLevel(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_PRIMARY_LEVEL)));
                primaryquestion.setPrimarySubject(c.getString(c.getColumnIndex(priQuestionsTable.COLUMN_PRIMARY_SUBJECT)));
                priQuestionList.add(primaryquestion);
            } while (c.moveToNext());
        }

        c.close();
        return priQuestionList;
    }
}

