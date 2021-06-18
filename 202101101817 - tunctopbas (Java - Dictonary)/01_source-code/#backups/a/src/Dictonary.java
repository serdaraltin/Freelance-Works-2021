
public class Dictonary {

    private String lesson;
    private String word;
    private String meaning;

    public Dictonary() {
    }

    public Dictonary(String lesson, String word, String meaning) {
        this.lesson = lesson;
        this.word = word;
        this.meaning = meaning;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "\nLesson  : " + lesson + "\nWord    : " + word + "\nMeaning : " + meaning;
    }

    public String writeString() {
        return lesson + "," + word + "," + meaning;
    }

}
