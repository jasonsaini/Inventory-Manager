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

    public String stringifyDollarValue()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return "$" + df.format(this.dollarVal);
    }

    public boolean hasInvalidCharacters(String serialString)
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
