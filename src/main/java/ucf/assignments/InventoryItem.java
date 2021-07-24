/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import java.text.DecimalFormat;

public class InventoryItem {
    String dollarVal;
    String serialNum;
    String name;

    public String getName() {
        return name;
    }

    public String getSerialNum()
    {
        return serialNum;
    }

    public String getDollarVal()
    {
        return dollarVal;
    }

    public void setDollarVal(String val)
    {
        this.dollarVal = val;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setSerialNum(String newSerialNum)
    {
        this.serialNum = newSerialNum.toUpperCase();
    }

    public InventoryItem(String Value, String SerialNumber, String Name)
    {
        this.dollarVal = Value;
        this.serialNum = SerialNumber;
        this.name = Name;
    }

    public static boolean hasInvalidCharacters(String serialString)
    {
        String invalidChars = "~!@#$%^&*()-_+=/?'\"[]{}|;:,<.>";
        for(int i = 0; i < serialString.length(); i++)
        {
            if(invalidChars.contains(String.valueOf(serialString.charAt(i))))
            {
                return true;
            }
        }
        return false;
    }






}
