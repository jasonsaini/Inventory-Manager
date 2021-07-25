/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class mainWindowControllerTest {

    // no need to test sorts, functionality within JAVAFx TableView/TableColumns

    @Test
    void stores_at_least_100_items()
    {
        // save a file with 100 items via gui
        File saves100testFile = new File("src/test/java/ucf/assignments/test-files/saves100.tsv");
        // collect size of items array from file
        int itemCount = 0;
        try {
            Scanner fileScanner = new Scanner(saves100testFile);

            while(fileScanner.hasNextLine())
            {
                itemCount++;
                fileScanner.nextLine();
            }
            System.out.println(itemCount);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // assert that size equals 100
        boolean has100minimum = (itemCount >= 100);
        assertEquals(true,has100minimum);
    }

    @Test
    void correctly_adds_inventory_item()
    {
        // open gui and save a file with at least one item
        File addsItemTestFile = new File("src/test/java/ucf/assignments/test-files/addsItem.tsv");
        // collect lines from file
        boolean works = true;
        try {
            Scanner fileScanner = new Scanner(addsItemTestFile);
            String lineToParse = fileScanner.nextLine();
            String[] arrayToParse = lineToParse.split("\t");
            for(int i = 0; i < arrayToParse.length; i++)
            {
                if(arrayToParse[i].length() < 2)
                {
                    works = false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // assert expected (true) against actual (array size >= 1)
        assertEquals(true,works);
    }

    @Test
    void removes_inventory_item()
    {
        // populate a file with one item (via GUI or manually)
        // remove item from inventory file via gui and save it
        File removesItemTestFile = new File("src/test/java/ucf/assignments/test-files/removesItem.tsv");
        boolean works = true;
        try {
            Scanner fileScanner = new Scanner(removesItemTestFile);
            // if there are no lines in the file, remove item has worked
            if(fileScanner.hasNextLine())
            {
               works = false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(true,works);
    }
    @Test
    void edits_value_of_existing_item()
    {
        // populate file with one item and save
        File editsItemValueTestFile1 = new File("src/test/java/ucf/assignments/test-files/editsItemValue.tsv");
        String oldVal = "";
        try {
            Scanner fileScanner = new Scanner(editsItemValueTestFile1);
            oldVal = fileScanner.nextLine().split("\t")[0];
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // load and edit value of item via gui
        // save this to a new file
        File editsItemValueTestFile2 = new File("src/test/java/ucf/assignments/test-files/editsItemValue2.tsv");
        String newVal = "";
        try {
            Scanner fileScanner = new Scanner(editsItemValueTestFile2);
            newVal = fileScanner.nextLine().split("\t")[0];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // compare the value strings of each file
        boolean expected = true, actual = !newVal.equals(oldVal);
        assertEquals(expected,actual);
    }


    @Test
    void edits_serial_number_of_existing_item()
    {
        // populate file with one item and save
        File editsItemSNTestFile1 = new File("src/test/java/ucf/assignments/test-files/editsItemSN.tsv");
        String oldSN = "";
        try {
            Scanner fileScanner = new Scanner(editsItemSNTestFile1);
            oldSN = fileScanner.nextLine().split("\t")[1];
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // load and edit serial number of item via gui
        // save this to a new file
        File editsItemSNTestFile2 = new File("src/test/java/ucf/assignments/test-files/editsItemSN2.tsv");
        String newSN = "";
        try {
            Scanner fileScanner = new Scanner(editsItemSNTestFile2);
            newSN = fileScanner.nextLine().split("\t")[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // compare the serial number strings of each file
        boolean expected = true, actual = !newSN.equals(oldSN);
        assertEquals(expected,actual);
    }

    @Test
    void edits_name_of_existing_item()
    {
        // populate file with one item and save
        File editsItemNameTestFile1 = new File("src/test/java/ucf/assignments/test-files/editsItemName.tsv");
        String oldName = "";
        try {
            Scanner fileScanner = new Scanner(editsItemNameTestFile1);
            oldName = fileScanner.nextLine().split("\t")[2];
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // load and edit name of item via gui
        // save this to a new file
        File editsItemSNTestFile2 = new File("src/test/java/ucf/assignments/test-files/editsItemName2.tsv");
        String newName = "";
        try {
            Scanner fileScanner = new Scanner(editsItemSNTestFile2);
            newName = fileScanner.nextLine().split("\t")[2];
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // compare the name strings of each file
        boolean expected = true, actual = !newName.equals(oldName);
        assertEquals(expected,actual);
    }

    @Test
    void saves_HTML_file()
    {
        // add a predetermined number of items to a new inventory file
        int expected = 2;
        // save file as HTML via GUI
        File HTMLFile = new File("src/test/java/ucf/assignments/test-files/savesHTML.html");
        String HTMLString = "";
        try {
            HTMLString = Files.readString(Path.of(HTMLFile.getPath()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        // collect number of items in HTML
        // divide numbers of td strings by six to get number of items in HTML file
        int actual = (StringUtils.countMatches(HTMLString,"td"))/6;
        // assert that number of items from HTML equals predetermined number
        assertEquals(expected, actual);
    }

    @Test
    void saves_JSON_file()
    {
        // add a predetermined number of items to a new inventory file
        int expected = 2;
        // save file as JSON
        JSONObject curObject = parseJSONFile("src/test/java/ucf/assignments/test-files/savesJSON.json");
        JSONArray inventoryList = (JSONArray) curObject.get("inventory");
        // collect number of items in JSON
        int actual = inventoryList.size();
        // assert that number of items from HTML equals predetermined number
        assertEquals(expected,actual);
    }

    @Test
    void saves_TSV_file()
    {
        // add a predetermined number of items to a new inventory file
        int expected = 2;
        int actual = 0;
        // save file as .tsv
        File savesTSVFileTest = new File("src/test/java/ucf/assignments/test-files/savesTSV.tsv");
        try {
            Scanner fileScanner = new Scanner(savesTSVFileTest);
            // collect number of items in TSV
            while(fileScanner.hasNextLine())
            {
                actual++;
                fileScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // assert that number of items from TSV equals predetermined number
        assertEquals(expected,actual);
    }

    @Test
    void loads_HTML_file()
    {
        // load a pre-made HTML file
        File preMadeHTML = new File("src/test/java/ucf/assignments/test-files/preMadeHTML.html");
        // save the contents to a separate file via GUI
        File savedHTML = new File("src/test/java/ucf/assignments/test-files/savesHTML.html");
        // convert both to strings
        String expected = "", actual = " ";
        try {
            expected = Files.readString(Path.of(preMadeHTML.getPath()));
            actual =  Files.readString(Path.of(savedHTML.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // assert that the file strings are equal
        assertEquals(expected,actual);
    }

    @Test
    void loads_JSON_file()
    {
        // load a pre-made JSON file
        File preMadeJSON = new File("src/test/java/ucf/assignments/test-files/preMadeJSON.json");
        // save the contents to a separate file
        File savedJSON = new File("src/test/java/ucf/assignments/test-files/loadsJSON.json");
        // convert both to strings
        String expected ="", actual = " ";
        try
        {
            expected = Files.readString(Path.of(preMadeJSON.getPath()));
            actual = Files.readString(Path.of(savedJSON.getPath()));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        // assert that the file strings are equal
        assertEquals(expected,actual);
    }

    @Test
    void loads_TSV_file()
    {
        // load a pre-made TSV file
        File preMadeTSV = new File("src/test/java/ucf/assignments/test-files/preMadeTSV.tsv");
        // save the contents to a separate file
        File savedTSV = new File("src/test/java/ucf/assignments/test-files/loadsTSV.tsv");
        // convert both to strings
        String expected = "", actual = " ";
        // assert that the file strings arde equal
        try
        {

            expected = Files.readString(Path.of(preMadeTSV.getPath()));
            actual = Files.readString(Path.of(savedTSV.getPath()));
        }
        catch (IOException e)
        {

        }
        assertEquals(expected,actual);
    }



    public JSONObject parseJSONFile(String dir)
    {   // instantiate file directory and object
        File testFile = new File(dir);
        Object obj = new Object();
        // try parsing json file
        try {
            obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // return JSON Object
        JSONObject object = (JSONObject)obj;
        return object;
    }
}