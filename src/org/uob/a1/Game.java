package org.uob.a1;

import java.util.Scanner; 

public class Game {  
    private Position position; //for labelling room positions
    private Room[] arrayRooms; //1D array to store all room info in 1 place, you can loop through array to then find matching room and output its eg. description
    private Map map;
    private Inventory inventory; 
    private Score score;
    private Position currentPosition; //keeping track of player movement

    //CONSTRUCTORS (for initialising)
    public Game(){
        score = new Score(100); 
        map = new Map (5,5);
        inventory = new Inventory(); //ARRAY w 10 possible positions 
        currentPosition = new Position(2,4); //player starting position
       
        
        
        Position pStart = new Position(2,4); //define positions of rooms
        Position p1 = new Position(2,3);
        Position p2 = new Position(3,3);
        Position p3 = new Position(1,3);
        Position p4 = new Position(2,2);
        Position p5 = new Position(3,2);
        Position p6 = new Position(1,2);
        Position p7 = new Position(2,1);
        Position p8 = new Position(1,1);
        Position pEnd = new Position(2,0);

        Room roomStart = new Room("Your Cell", "You are in a dark prison cell with nothing but a door to the north. Aha luckily door seems to be open", 'S', pStart);  //defining the room info - room name, description, symbol and position
        Room room1 = new Room("Hallway", "You are in the Prison Hall, theres prison cell 2 to the east, prison cell 3 to the west and a metal door north.", 'H', p1);
        Room room2 = new Room("Prison Cell 2", "Prison cell 2, its a small room with nothing but a table.", '2', p2);
        Room room3 = new Room("Prison Cell 3", "Prison cell 3, its a small room, theres a shelf in corner of the room.", '3', p3);
        Room room4 = new Room("Common Area", "You are in the prison common area. Its connected to 2 other cells: cell 5 to the east and cell 6 to the west. Theres also big door with a metal lock on it. ", 'C', p4);
        Room room5 = new Room("Prison Cell 5", "Prison cell 5, its a trashed room perhaps the prison riot started her. There doesn't seem to be anything significant about this room.", '5', p5);
        Room room6 = new Room("Prison Cell 6", "Prison cell 6, a room with twin beds. You can see a crowbar under one of the beds; Someone likely left it in chaos of the riot", '6', p6);
        Room room7 = new Room("Prison Entrance", "You are standing in the prison entrance area, this is where everyone enters the prison but never leaves. To the west there is a guard room, the door to which is slightly open. To the north is the main entrance of the prison! That's it thats your exit! However, there appears to be a control panel to operate it", 'E', p7);
        Room room8 = new Room("Guard Room", "You are in a big guard room, tens on security camera feeds are shown on the walls. The room is a mess and theres a big pile of documents on the floor.", 'G', p8);
        Room roomEnd = new Room("Outside", "You are outside! Time to make a run for it!", 'O', pEnd);

        arrayRooms = new Room[10]; //assigning the rooms into the array that stores all of them together
        arrayRooms[0] = roomStart;
        arrayRooms[1] = room1;
        arrayRooms[2] = room2;
        arrayRooms[3] = room3;
        arrayRooms[4] = room4;
        arrayRooms[5] = room5;
        arrayRooms[6] = room6;
        arrayRooms[7] = room7;
        arrayRooms[8] = room8;
        arrayRooms[9] = roomEnd;
        
         map.placeRoom( currentPosition, arrayRooms[0].getSymbol()); //places symbol of starting room right away so its shown on the mini map (need to intialize here after positioning rooms in array otherwise doesnt work)
    }//Game
    

    //base commands


    public void enterPassword(String password){ //checks if you have the password item (so you arent just entering random numbers) and are in right room and are inputting correct code
        if(inventory.hasItem("password") != -1 && currentPosition.x == 2 && currentPosition.y == 1){
            if(password.equals("1234")){
                System.out.println("The control panels beeps and turns green. The prison gate norht opens. Quick escape while you have time!"); }
            else{
                System.out.println("Control panel turns red: incorrect password."); }
        }//if
        else{
            System.out.println("Nothing happens."); }
        
    }//enterPassword

    public void useCrowbar(){ //makes sure you have crowbar and are in right room to break the lock
        if (inventory.hasItem("crowbar") != -1 && currentPosition.x == 2 && currentPosition.y == 2){
            inventory.removeItem("crowbar");
            System.out.println("You break the lock with the crowbar. Great the door north is now open."); }
            
    }//useCrowbar

    public void redBlue(){ //makes sure you have both keys and are in right room to open the lock
        if (inventory.hasItem("red key") != -1 && inventory.hasItem("blue key") != -1 && currentPosition.x == 2 && currentPosition.y == 3){
            inventory.removeItem("red key");
            inventory.removeItem("blue key");
            System.out.println("You use the 2 keys on the door. The metal door north opens."); }
        else {
            System.out.println("Nothing happens."); }
        
    }//redBlue
    
    public void hint(){  //based on room gives extra instructions if players are stuck
        if(currentPosition.x == 2 && currentPosition.y == 4){
            System.out.println("Theres nothing significant about the room. Try going north through the open door. "); }//start
            
        else if (currentPosition.x == 2 && currentPosition.y == 3){
            System.out.println("The door infront of you requires 2 keys. If you have obtained those input: use red and blue key"); }//room1
            
        else if (currentPosition.x == 3 && currentPosition.y == 3){
            System.out.println("Check the table using the <look feature> command and input table."); }//room2
            
        else if (currentPosition.x == 1 && currentPosition.y == 3){
            System.out.println("Check the shelf using the <look feature> command and input shelf."); }//room3
            
        else if (currentPosition.x == 2 && currentPosition.y == 2){
            System.out.println("The doors lock needs to be broken, find an item to break it with and input: use <item>."); }//room4
            
        else if (currentPosition.x == 3 && currentPosition.y == 2){
            System.out.println("There's nothing that you need from this room."); }//room5
            
        else if (currentPosition.x == 1 && currentPosition.y == 2){
            System.out.println("Take the crowbar thats under the bed. It can be used to break the lock.");  }//room6
            
        else if (currentPosition.x == 2 && currentPosition.y == 1){
            System.out.println("You need the password for the control panel. When you have the password input: enter password."); }//room7
            
        else if (currentPosition.x == 1 && currentPosition.y == 1){
            System.out.println("To obtain the password in this room you need to use the <look feature>"); }//room8
            
    }//hint

    public void takeItem(String item){ //to take item you must want to take an existing item and be in correct room
        if(item.equals("red key") && currentPosition.x == 3 && currentPosition.y == 3 && inventory.hasItem(item) == -1){ //checks if player is in correct room to take item and makes sure that user doesnt already have that item in their inventory
            inventory.addItem(item);
            System.out.println( item + " has been added to your inventory.");  }
            
        else if(item.equals("blue key") && currentPosition.x == 1 && currentPosition.y == 3 && inventory.hasItem(item) == -1){
            inventory.addItem(item);
            System.out.println( item + " has been added to your inventory.");}
                
        else if(item.equals("crowbar") && currentPosition.x == 1 && currentPosition.y == 2 && inventory.hasItem(item) == -1){
            inventory.addItem(item);
            System.out.println( item + " has been added to your inventory."); }
            
        else if(item.equals("password") && currentPosition.x == 1 && currentPosition.y == 1 && inventory.hasItem(item) == -1){
            inventory.addItem(item);
            System.out.println( item + " has been added to your inventory.");    }
            
        else {
            System.out.println("Can't take this item.");  }
        
    }//takeItem


    

    public void lookFeature(String feature){  //for looking at things in rooms it checks if your in apropriate room to be checking this
        if (feature.equals("metal door") && currentPosition.x == 2 && currentPosition.y == 3){
           System.out.println("The big metal door infront of you appears to have 2 key slots. Look around maybe you can find the keys somewhere."); }
            
        else if (feature.equals("table") && currentPosition.x == 3 && currentPosition.y == 3 ){
            System.out.println("The dusty wooden table seems insignificant however when you look under it theres a small red key taped to the bottom.");
        }
        else if (feature.equals("shelf") && currentPosition.x == 1 && currentPosition.y == 3 ){
            System.out.println("The shelf seems to be littered with all kinds of things. When you shuffle through the items you find a small blue key.");
        }
        else if (feature.equals("metal lock") && currentPosition.x == 2 && currentPosition.y == 2 ){
            System.out.println("The large door infront of you has a giant heavy mental lock its a strange type of lock you had never seen before. Perhaps it would be easier to break it then figure out how it opens.");
        }
        else if (feature.equals("bed") && currentPosition.x == 1 && currentPosition.y == 2 ){
            System.out.println("You look through the sheets of the beds but theres nothing that would be of use. The crowbar under the bed would probably be useful though. ");
        }
        else if (feature.equals("control panel") && currentPosition.x == 2  && currentPosition.y == 1 ){
            System.out.println(" The small control panel attached to the exit is for entering a 4 digit code. You try to look for fingerprint residue but its unclear. Look around surely the guards keep a copy somewhere.");
        }
        else if (feature.equals("pile") && currentPosition.x == 1  && currentPosition.y == 1 ){
            System.out.println("As you look through the piles of documents you come across a sticky note with a password written on it.");
        }
        else{
            System.out.println("This feature is insignificant or isn't present in the room.");}
        
    }//lookFeature

    public void look(){ //cross refrences your position and position of rooms in array to find correlating describtion of the room you are currently in
        for(int i = 0; i < arrayRooms.length; i++){
            if (arrayRooms[i].getPosition().x == currentPosition.x && arrayRooms[i].getPosition().y == currentPosition.y ){  //here im cross refrencing the current coords w room coords to pull up appropriate description
                System.out.println(arrayRooms[i].getDescription());
                break;
            }//if
            
        }//for
        
    }//look

    public void move(String direction){ //based on where you move you current position x y is edited
        int x = currentPosition.x;
        int y = currentPosition.y;

        if(direction.equals("move north")){
            y -= 1; }
        else if(direction.equals("move east")){
            x += 1; }
        else if(direction.equals("move south")){
            y += 1; }
        else if(direction.equals("move west")){
            x -= 1; }

        currentPosition = new Position(x,y); //updates currentPosition to new value(s)
        for(int i = 0; i < arrayRooms.length; i++){
            if (arrayRooms[i].getPosition().x == currentPosition.x && arrayRooms[i].getPosition().y == currentPosition.y){
                map.placeRoom( currentPosition, arrayRooms[i].getSymbol());
                break; }//if
            
        }//for
        
        System.out.println("You " + direction);
        score.visitRoom(); //updates the num rooms vsited so you can calculate score

        if(currentPosition.x == 2 && currentPosition.y == 0){
            System.out.println("You've Escpaed! Great job, see your <score> or <quit>."); }
    }//move

    public void lookItem(String item){ //checks that your inventory isnt empty first, then checks if you have the item to tell you the describtion
        if(inventory.hasItem(item) != -1){
            if(item.equals("red key")){
                System.out.println("A rusty red key, theres nothing significant about it.");
            }
            else if(item.equals("blue key")){
                System.out.println("A rusty blue key, theres nothing significant about it.");
            }
            else if(item.equals("crowbar")){
                System.out.println("A metal crowbar, could probably be used to wack something open.");
            }
            else if(item.equals("password")){
                System.out.println("A very old and delicate piece of paper, it has numbers written on it: 1234.");
            }
        }//if
        else{
            System.out.println("Mentioned item not in inventory. (Hint: check your inventory or check your spelling)");
        }//else
    }//lookItem

    public void printInventory(){
        System.out.println("You currently have: " + inventory.displayInventory());
    }//printInventory

    public void printScore(){
        System.out.println("Score: " + score.getScore());
    }//printScore

    public void printMap(){
         System.out.println(map.display());
    }//printMap
    
    public void help(){
        System.out.println("Valid commands are: <look>, <move> <direction>, <look feature>, <look item>, <take item>, <help>, <inventory>, <map>, <score>, <hint> and <quit>");
    }//help

    public boolean quit(){
        return true;
    }//quit







    
    public static void main(String args[]) {
        
        Game game = new Game();
        Scanner userInput = new Scanner(System.in);
        boolean quit = false;

        System.out.println("You open your eyes to a dark prison cell. It seem you were knocked out when a riot began. The alarms are still blarring and not a single guard can be heard. Your cell door north seems to be open. Quick this migh be your chance at escaping. ");

        while(!quit){ //game loops until player inputs quit which changes the quit command to true which end the loop
            String input = userInput.nextLine();
            input = input.toLowerCase();


            
            if(input.equals("quit")){
                quit = game.quit();     }
                
            else if(input.equals("help")){
                game.help();  }

            else if(input.equals("score")){
                game.printScore(); }

            else if(input.equals("map")){
                game.printMap(); }

            else if(input.equals("inventory")){
                game.printInventory(); }

            else if(input.equals("look item")){
                System.out.println("What item do you want to look at:");
                String itemInput = userInput.nextLine();
                itemInput = itemInput.toLowerCase();
                game.lookItem(itemInput); }

            else if(input.equals("move north")){
                 game.move("move north"); }

            else if(input.equals("move east")){
                game.move("move east"); }

            else if(input.equals("move south")){
                game.move("move south"); }
                
            else if(input.equals("move west")){
                game.move("move west"); }

            else if(input.equals("look feature")){
                System.out.println("What feature in the room do you want to look at:");
                String featureInput = userInput.nextLine();
                featureInput = featureInput.toLowerCase();
                game.lookFeature(featureInput); }

            else if(input.equals("look")){
                game.look(); }

            else if(input.equals("take item")){
                System.out.println("What is the item you want to take?");
                String takeInput = userInput.nextLine();
                takeInput = takeInput.toLowerCase();
                game.takeItem(takeInput); }

            else if (input.equals("hint")){ //depending on the room a diffrent hint will be given
                game.hint(); }

            else if (input.equals("use red and blue key")){
                game.redBlue(); }

            else if (input.equals("use crowbar")){
                game.useCrowbar(); }

            else if (input.equals("enter password")){
                System.out.println("What do you enter into the control panel:");
                String passwordInput = userInput.nextLine();
                game.enterPassword(passwordInput);   }
                
            else {
                System.out.println("Nothing happens. (try <help> for possible commands)"); }


            
        }//while
        System.out.println("Game Over");
        
    }//main



    
}//GAME CLASS