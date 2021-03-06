package OPENCSV;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;import java.io.Reader;import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingCSV {
    public static void main(String[] args) throws IOException, CsvException {
        Reader reader= Files.newBufferedReader(Paths.get("Student.txt"));

        //parser!
        CSVParser parser=new CSVParserBuilder()
                .withSeparator('\t')
                .build();

        CSVReader csvReader=new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build();

        //read the contents of the file!
        List<String[]> data=csvReader.readAll(); //returns a list of Strings from the file

        //3 ways for using data

        for(int row=0;row<4;row++) {
            System.out.println(data.get(row)[0]);// 0th line object
        }

        for(String[] row: data){
            System.out.println(row[0]);
        }

        data.stream()
                .forEach(row-> System.out.println(row[0]));
    }	

}

