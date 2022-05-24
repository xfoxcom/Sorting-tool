package sorting;

public class Pair {
   public int count;
   public int data;
   public String word;
    public Pair(int count, int data) {
        this.count = count;
        this.data = data;
    }
    public Pair(int count, String word) {
        this.count = count;
        this.word = word;
    }
    public int getCount() {
        return count;
    }
    public int getData() {
        return data;
    }
    public String getWord() {
        return word;
    }
}
