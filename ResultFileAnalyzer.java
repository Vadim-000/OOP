public class ResultFileAnalyzer {
    private final String path;
    private final String coding;
    private final String word;
    private final int countAllLine;
    private final int countLine;
    private final int countSymbol;
    private final int countWord;

    public ResultFileAnalyzer(String path,String coding,String word,int countLine,int countAllLine,int countSymbol,int countWord){
        this.path=path;
        this.coding=coding;
        this.word=word;
        this.countLine=countLine;
        this.countSymbol=countSymbol;
        this.countAllLine=countAllLine;
        this.countWord=countWord;
    }
    public String getPath() {
        return path;
    }

    public String getCoding() {
        return coding;
    }

    public String getWord() {
        return word;
    }

    public int getCountAllLine() {
        return countAllLine;
    }

    public int getCountLine() {
        return countLine;
    }

    public int getCountSymbol() {
        return countSymbol;
    }

    public int getCountWord() {
        return countWord;
    }
}
