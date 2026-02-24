import java.io.*;

public class FileAnalyzer {
    private boolean CheckFile(String path){
        File file=new File(path);
        if (!file.exists()) {
            System.out.print("файл не существует");
            return false;
        }
        if (!file.isFile()) {
            System.out.print("указаный путь является директорией");
            return false;
        }
        if (!file.canRead()) {
            System.out.print("файл не доступен для чтения");
            return false;}
        return true;
    }
    public ResultFileAnalyzer analyzer(String path, String coding){
        FileAnalyzer a=new FileAnalyzer();
        ResultFileAnalyzer result=a.analyzer(path,coding,null);
        return result;
    }
    public ResultFileAnalyzer analyzer(String path, String coding,String word ) {//доделат дло 5
        boolean f= word != null;
        int countAllLine=0;
        int countSymbols=0;
        int countLine=0;
        int countWord=0;
        if (CheckFile(path)){
            BufferedReader reader = null;
            try{
                reader=new BufferedReader(new InputStreamReader(new FileInputStream(path),coding));
                String line;
                while ((line=reader.readLine())!=null){
                    countAllLine++;
                    countSymbols+=line.length()-1;
                    if(!line.isBlank())
                        countLine++;
                    if (f && line.contains(word))
                        countWord++;
                }
                System.out.printf("кол-во всех строк "+ countAllLine);
                System.out.printf("кол-во пустых строк "+ countLine);
                System.out.printf("кол-во символов "+ countSymbols);
                if(f)
                    System.out.printf("кол-во слов "+ countWord);
            } catch (UnsupportedEncodingException e){
                System.out.print("неподдерживаемая кодировка"+e.getMessage());
            } catch (IOException e){
                System.out.print("ошибка чтения файла");
            }
            finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        ResultFileAnalyzer result=new ResultFileAnalyzer(path,coding,word,countLine,countAllLine,countSymbols,countWord);
        return result;
    }
}
