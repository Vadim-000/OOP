package main;

import java.util.List;
import java.util.regex.Pattern;

public abstract class Rule {
    protected String nameRule;
    protected Pattern pattern;

    public Rule(String nameRule, String regex) {
        this.nameRule = nameRule;
        this.pattern = Pattern.compile(regex, Pattern.MULTILINE);
    }

    public abstract List<Problem> check(String content,int line);

    protected Problem createProblem(int line,int collum,String message){
        return new Problem(message,line,collum);
    }

    public String getNameRule(){
        return nameRule;
    }
}
