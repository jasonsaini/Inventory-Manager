package ucf.assignments;

public class inventoryItem {
    double dollarVal;
    String serialNum;
    String name;

    public String getName() {
        return name;
    }

    public String getSerialNum()
    {
        return serialNum;
    }

    public double getDollarVal()
    {
        return dollarVal;
    }

    public void setDollarVal(double val)
    {
        this.dollarVal = val;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setSerialNum(String newSerialNum)
    {

        if(newSerialNum.length() != 10 || hasInvalidCharacters(newSerialNum))
        {
            this.serialNum = null;
        }
        this.serialNum = newSerialNum.toUpperCase();
    }

    private boolean hasInvalidCharacters(String serialString)
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
