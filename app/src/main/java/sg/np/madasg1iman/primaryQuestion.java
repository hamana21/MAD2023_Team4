package sg.np.madasg1iman;

import android.os.Parcel;
import android.os.Parcelable;

public class primaryQuestion implements Parcelable {
    public static final String PRIMARY1 = "Primary 1";
    public static final String PRIMARY2 = "Primary 2";
    public static final String PRIMARY3 = "Primary 3";
    public static final String PRIMARY4 = "Primary 4";
    public static final String PRIMARY5 = "Primary 5";
    public static final String PRIMARY6 = "Primary 6";

    public static final String PRI_ENGLISH = "English";
    public static final String PRI_MATHEMATICS = "Mathematics";
    public static final String PRI_SCIENCE = "Science";

    private String priQuestion;
    private String priOption1;
    private String priOption2;
    private String priOption3;
    private String priOption4;
    private int priAnswerNum;
    private String primaryLevel;
    private String primarySubject;

    public primaryQuestion() {}

    public primaryQuestion(String priQuestion, String priOption1, String priOption2,
                           String priOption3, String priOption4,
                           int priAnswerNum, String primaryLevel, String primarySubject) {
        this.priQuestion = priQuestion;
        this.priOption1 = priOption1;
        this.priOption2 = priOption2;
        this.priOption3 = priOption3;
        this.priOption4 = priOption4;
        this.priAnswerNum = priAnswerNum;
        this.primaryLevel = primaryLevel;
        this.primarySubject = primarySubject;
    }

    protected primaryQuestion(Parcel in) {
        priQuestion = in.readString();
        priOption1 = in.readString();
        priOption2 = in.readString();
        priOption3 = in.readString();
        priOption4 = in.readString();
        priAnswerNum = in.readInt();
        primaryLevel = in.readString();
        primarySubject = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(priQuestion);
        dest.writeString(priOption1);
        dest.writeString(priOption2);
        dest.writeString(priOption3);
        dest.writeString(priOption4);
        dest.writeInt(priAnswerNum);
        dest.writeString(primaryLevel);
        dest.writeString(primarySubject);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<primaryQuestion> CREATOR = new Creator<primaryQuestion>() {
        @Override
        public primaryQuestion createFromParcel(Parcel in) {
            return new primaryQuestion(in);
        }

        @Override
        public primaryQuestion[] newArray(int size) {
            return new primaryQuestion[size];
        }
    };

    public String getPriQuestion() {
        return priQuestion;
    }

    public void setPriQuestion(String priQuestion) {
        this.priQuestion = priQuestion;
    }

    public String getPriOption1() {
        return priOption1;
    }

    public void setPriOption1(String priOption1) {
        this.priOption1 = priOption1;
    }

    public String getPriOption2() {
        return priOption2;
    }

    public void setPriOption2(String priOption2) {
        this.priOption2 = priOption2;
    }

    public String getPriOption3() {
        return priOption3;
    }

    public void setPriOption3(String priOption3) {
        this.priOption3 = priOption3;
    }

    public String getPriOption4() {
        return priOption4;
    }

    public void setPriOption4(String priOption4) {
        this.priOption4 = priOption4;
    }

    public int getPriAnswerNum() {
        return priAnswerNum;
    }

    public void setPriAnswerNum(int priAnswerNum) {
        this.priAnswerNum = priAnswerNum;
    }

    public String getPrimaryLevel() {
        return primaryLevel;
    }

    public void setPrimaryLevel(String primaryLevel) {
        this.primaryLevel = primaryLevel;
    }

    public String getPrimarySubject() {
        return primarySubject;
    }

    public void setPrimarySubject(String primarySubject) {
        this.primarySubject = primarySubject;
    }

    public static String[] getAllPrimaryLevels() {
        return new String[]{
                PRIMARY1,
                PRIMARY2,
                PRIMARY3,
                PRIMARY4,
                PRIMARY5,
                PRIMARY6
        };
    }

    public static String[] getAllPrimarySubjects() {
        return new String[] {
                PRI_ENGLISH,
                PRI_MATHEMATICS,
                PRI_SCIENCE
        };
    }
}
