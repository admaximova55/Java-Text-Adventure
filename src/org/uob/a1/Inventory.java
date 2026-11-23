package org.uob.a1;

public class Inventory {
    final int MAX_ITEMS = 10;
    public int currentNumberItems;
    public String[] inventory;

    //constructor
    public Inventory(){  
        inventory = new String[MAX_ITEMS]; //inventory can have up to 10 items
        currentNumberItems = 0;
    }//inventory


    public void addItem(String item){
        if(currentNumberItems < MAX_ITEMS){
            inventory[currentNumberItems] = item;
            currentNumberItems++;
        }//if

    }//addItem
    

    public int hasItem(String item){
        int position = -1;
            for(int i = 0; i < currentNumberItems; i++){
                if (inventory[i].equals(item)){
                    position = i;
                    break;
                }//if
            }//for
    return position;
    }//hasItem
    

    public void removeItem(String item){
        int position = hasItem(item);
        if (position != -1){
            for(int i = position; i < currentNumberItems -1; i++){//do -1 since currentNumberItems is yechnically showing the next empty item
                inventory[i] = inventory[i+1]; //moves the remaining items down so there arent empty gaps in inventory
            }//for
            inventory[currentNumberItems -1] = null; //this position still holds prev value so need to manually change to a blank
            currentNumberItems -= 1;
        }//if
    }//removeItem

    public String displayInventory(){
        String displayMessage = "";
        for(int i =0; i < currentNumberItems; i++ ){
            displayMessage = displayMessage + inventory[i] + " ";
        }//for
        return displayMessage;
    }//displayInventory


    

}//class