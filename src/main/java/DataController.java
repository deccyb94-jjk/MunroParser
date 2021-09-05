import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DataController implements Controller {

    private static String filePath = "C:\\Users\\deccy\\IdeaProjects\\MunroParser\\src\\main\\resources\\munrotab_v6.2.csv";

    @Override
    public String splitByCategory(String var1, String var2) throws IOException {

        String terminiOutput = null;

        if (var1.equals("1"))
        {
            terminiOutput = "All list data with category of Munro";
            try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                if(var2.equals("Y")) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .withMultilineLimit(10)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    for (int i = 0; i < 10; i++) {
                        Munro currentMunro = beanList.get(i);
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
                else if (var2.equals("N"))
                {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();

                    while (csvUserIterator.hasNext()) {
                        Munro currentMunro = csvUserIterator.next();
                        if (currentMunro.getPost1997().equals("MUN")){
                            String json = new Gson().toJson(
                                    "Name: " + currentMunro.getName()
                                            + " | Height(M): " + currentMunro.getHeightM()
                                            + " | Category: " + currentMunro.getPost1997()
                                            + " | Grid Reference: " + currentMunro.getGridRef());
                            System.out.println(json);
                        }
                    }
                }
                else {
                    terminiOutput = "Incorrect input, please try again";
                }


            }
        }
        else if (var1.equals("2"))
        {
            terminiOutput = "All list data with category of Munro Top";
            // Charset used due to error occurring at line 178 in file with "[ ]" characters
            // UTF-8 appears to not support these characters
            try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {

                if(var2.equals("Y"))
                {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    for(int i = 0; i < 10; i++)
                    {
                        Munro currentMunro = beanList.get(i);
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
                else if(var2.equals("N"))
                {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();

                    while (csvUserIterator.hasNext()) {
                        Munro currentMunro = csvUserIterator.next();
                        if (currentMunro.getPost1997().equals("TOP")){
                            String json = new Gson().toJson(
                                    "Name: " + currentMunro.getName()
                                            + " | Height(M): " + currentMunro.getHeightM()
                                            + " | Category: " + currentMunro.getPost1997()
                                            + " | Grid Reference: " + currentMunro.getGridRef());
                            System.out.println(json);
                        }
                    }
                }
                else{
                    terminiOutput = "Incorrect input, please try again";
                }

            }
        }
        else
        {
            terminiOutput = "Incorrect input, please try again";
        }
        return terminiOutput;
    }

    @Override
    public String sortByHeightAscOrDesc(String var1, String var2) throws IOException {

        String terminiOutput = "Data ordered. ";

        if (var1.equals("1"))
        {
            if (var2.equals("Y"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getHeightM));

                    for(int i = 0; i < 10; i++ )
                    {
                        Munro currentMunro = beanList.get(i);
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);

                    }
                }
            }
            else if (var2.equals("N"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getHeightM));

                    for(Munro currentMunro : beanList){
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
            else
            {
                terminiOutput = "Incorrect input, please try again";
            }

        }
        else if (var1.equals("2"))
        {
            if (var2.equals("Y"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getHeightM).reversed());

                    for(int i = 0; i < 10; i++ )
                    {
                        Munro currentMunro = beanList.get(i);
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);

                    }
                }
            }
            else if (var2.equals("N"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();

                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getHeightM).reversed());

                    for(Munro currentMunro : beanList){
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
            else
            {
                terminiOutput = "Incorrect input, please try again";
            }
        }
        else
        {
            terminiOutput = "Incorrect input, please try again";
        }
        return terminiOutput;
    }

    @Override
    public String sortByAlphabeticalNameAscOrDesc(String var1, String var2) throws IOException {

        String terminiOutput = "Data ordered. ";

        if (var1.equals("1"))
        {
            if (var2.equals("Y"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();
                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getName));

                    for(int i = 0; i < 10; i++){
                        Munro currentMunro = beanList.get(i);
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
            else if (var2.equals("N"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();
                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getName));

                    for(Munro currentMunro : beanList){
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
            else
            {
                terminiOutput = "Incorrect input, please try again";
            }

        }
        else if (var1.equals("2"))
        {
            if (var2.equals("Y"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();
                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getName).reversed());

                    for(int i = 0; i < 10; i++){
                        Munro currentMunro = beanList.get(i);
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
            else if(var2.equals("N"))
            {
                try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                    CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Munro.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSkipLines(1)
                            .build();
                    Iterator<Munro> csvUserIterator = csvToBean.iterator();
                    List<Munro> beanList = new ArrayList<>();

                    while (csvUserIterator.hasNext()) {
                        Munro munro = csvUserIterator.next();
                        beanList.add(munro);
                    }

                    beanList.sort(Comparator.comparing(Munro::getName).reversed());

                    for(Munro currentMunro : beanList){
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
            else
            {
                terminiOutput = "Incorrect input, please try again";
            }

        }
        else
        {
            terminiOutput = "Incorrect input, please try again";
        }
        return terminiOutput;
    }

    @Override
    public String specifyMinHeight(double var1, String var2) throws IOException {
        String terminiOutput = "All data with minimum height specified as: " + var1;

        if (var2.equals("Y"))
        {
            try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Munro.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)
                        .build();
                Iterator<Munro> csvUserIterator = csvToBean.iterator();
                List<Munro> beanList = new ArrayList<>();

                while (csvUserIterator.hasNext()) {
                    Munro munro = csvUserIterator.next();

                    if (munro.getHeightM() > var1 && beanList.size() < 10){
                        beanList.add(munro);
                    }
                }

                for(Munro currentMunro : beanList){
                    String json = new Gson().toJson(
                            "Name: " + currentMunro.getName()
                                    + " | Height(M): " + currentMunro.getHeightM()
                                    + " | Category: " + currentMunro.getPost1997()
                                    + " | Grid Reference: " + currentMunro.getGridRef());
                    System.out.println(json);
                }
            }
        }
        else if (var2.equals("N"))
        {
            try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Munro.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)
                        .build();
                Iterator<Munro> csvUserIterator = csvToBean.iterator();

                while (csvUserIterator.hasNext()) {
                    Munro currentMunro = csvUserIterator.next();
                    if (currentMunro.getHeightM() > var1){
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
        }
        else
        {
            terminiOutput = "Incorrect input, please try again";
        }
        return terminiOutput;
    }

    @Override
    public String specifyMaxHeight(double var1, String var2) throws IOException {

        String terminiOutput = "All data with maximum height specified as: " + var1;

        if (var2.equals("Y"))
        {
            try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Munro.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)
                        .build();
                Iterator<Munro> csvUserIterator = csvToBean.iterator();
                List<Munro> beanList = new ArrayList<>();

                while (csvUserIterator.hasNext()) {
                    Munro munro = csvUserIterator.next();

                    if (munro.getHeightM() < var1 && beanList.size() < 10){
                        beanList.add(munro);
                    }
                }

                for(Munro currentMunro : beanList){
                    String json = new Gson().toJson(
                            "Name: " + currentMunro.getName()
                                    + " | Height(M): " + currentMunro.getHeightM()
                                    + " | Category: " + currentMunro.getPost1997()
                                    + " | Grid Reference: " + currentMunro.getGridRef());
                    System.out.println(json);
                }
            }
        }
        else if (var2.equals("N"))
        {
            try (Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);) {
                CsvToBean<Munro> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Munro.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)
                        .build();
                Iterator<Munro> csvUserIterator = csvToBean.iterator();

                while (csvUserIterator.hasNext()) {
                    Munro currentMunro = csvUserIterator.next();
                    if (currentMunro.getHeightM() < var1){
                        String json = new Gson().toJson(
                                "Name: " + currentMunro.getName()
                                        + " | Height(M): " + currentMunro.getHeightM()
                                        + " | Category: " + currentMunro.getPost1997()
                                        + " | Grid Reference: " + currentMunro.getGridRef());
                        System.out.println(json);
                    }
                }
            }
        }
        else
        {
            terminiOutput = "Incorrect input, please try again";
        }
        return terminiOutput;
    }
}

