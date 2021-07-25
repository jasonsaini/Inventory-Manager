# Jason's Inventory Manager
This JAVAFX project is a simple way to manage and store inventory items.
# Adding & Removing Items to Inventory
To add an item to the current inventory, fill the appropriate text fields

    Value: 
           Enter a dollar value with the format X.XX.
           Do not add a dollar sign as it will not be accepted.
           Decimal values longer than 2 places will be rounded accordingly.

    Serial Number: 
           You must enter a 10-digit alpha-numeric serial number.
           Entries with special characters will not be accepted.
           Entries that are not exactly 10-digits will not be accepted.
           Duplicate entries will not be accepted.

    Name: 
           A name must be between 2 and 256 letters long. 
           It can contain even special characters.

This application can hold at least 100 items at once.

To remove an item from the inventory,
right-click on the specific item to delete to open a context menu.

From this menu, select "Remove Item".

# Editing Items
All item's attributes can be edited via the context menu. 

To edit a given attribute, right-click on an item and select the corresponding option.

A window will open to enter a new attribute.

Note that the restrictions for inputs outlined in the previous section still apply.

# Sorting Items
Items in an inventory can be sorted by clicking on the column headers.
Each click toggles the sort setting of the given column. 
An arrow (^/v) will appear indicating the status of a sort upon toggle.

    ^ means items are sorted in ascending order (smallest first).
    v means items are sorted in descending order (largest first).
    No arrow means items are listed in the order in which they were added.

# Searching for an Item
Items can be searched by their name or serial number.
To open a search dialog: 

    Search >> By Name

    or...

    Search >> By Serial Number

You can use an incomplete search key to find any matching cases.
You do not need the entire name or serial number to find a relevant item.

# Saving & Loading Files
An inventory can be saved to external storage in the TSV, HTML, & JSON file formats.

To save an item, navigate to "File" in the top left corner. 

    File >> Save >> (Preferred File Format)

This will open a file dialog to choose a file location and name.

To load an item: File >> Load...

This will open a file dialog to select a previously saved inventory file.

Note: HTML files render as a table and are read-only. 
You can load these files into the GUI to change them.



