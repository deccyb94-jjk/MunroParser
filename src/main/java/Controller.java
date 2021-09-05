import java.io.IOException;

public interface Controller {

    String splitByCategory(String var1, String var2) throws IOException;

    String sortByHeightAscOrDesc(String var1, String var2) throws IOException;

    String sortByAlphabeticalNameAscOrDesc(String var1, String var2) throws IOException;

    String specifyMinHeight(double var1, String var2) throws IOException;

    String specifyMaxHeight(double var1, String var2) throws IOException;

}
