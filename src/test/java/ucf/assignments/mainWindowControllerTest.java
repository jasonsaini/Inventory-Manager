/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mainWindowControllerTest {

    // no need to test sorts, functionality within JAVAFx TableView/TableColumns

    @Test
    void stores_at_least_100_items()
    {
        // save a file with 100 items via gui
        // collect size of items array from file
        // assert that size equals 100
    }

    @Test
    void correctly_adds_inventory_item()
    {
        // open gui and save a file with at least one item
        // collect array from file

        // if array size >= 1
            // assert that add item works
        // assert expected (true) against actual (array size >= 1)
    }

    @Test
    void removes_inventory_item()
    {
        // populate a file with one item (via GUI or manually)
        // remove item from inventory file via gui and save it
        // collect array from file
        // assert that array size is 0
    }
    @Test
    void edits_value_of_existing_item()
    {
        // populate file with one item
        // record value of item before edit through GUI
        // change value via gui
        // record new value after edit
        // assert that they are not the same
    }

    @Test
    void edits_serial_number_of_existing_item()
    {
        // populate file with one item
        // record serial number of item before edit through GUI
        // change serial number via gui
        // record new serial number after edit
        // assert that they are not the same
    }

    @Test
    void edits_name_of_existing_item()
    {
        // populate file with one item
        // record value of item before edit through GUI
        // change value via gui
        // record new value after edit
        // assert that they are not the same
    }

    @Test
    void saves_HTML_file()
    {
        // add a predetermined number of items to a new inventory file
        // save file as HTML
        // collect number of items in HTML
        // assert that number of items from HTML equals predetermined number
    }

    @Test
    void saves_JSON_file()
    {
        // add a predetermined number of items to a new inventory file
        // save file as HTML
        // collect number of items in HTML
        // assert that number of items from HTML equals predetermined number
    }

    @Test
    void saves_TSV_file()
    {
        // add a predetermined number of items to a new inventory file
        // save file as HTML
        // collect number of items in HTML
        // assert that number of items from HTML equals predetermined number
    }

    @Test
    void loads_HTML_file()
    {
        // load a pre-made HTML file
        // save the contents to a separate file
        // convert both to strings
        // assert that the file strings are equal
    }

    @Test
    void loads_JSON_file()
    {
        // load a pre-made JSON file
        // save the contents to a separate file
        // convert both to strings
        // assert that the file strings are equal
    }

    @Test
    void loads_TSV_file()
    {
        // load a pre-made TSV file
        // save the contents to a separate file
        // convert both to strings
        // assert that the file strings are equal
    }
}