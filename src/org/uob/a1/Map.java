package org.uob.a1;

public class Map {
    private int width;//x-coord
    private int height;//y-coord
    private char[][] miniMap;
    final private char EMPTY = '.'; //CONSTANT

    public Map(int width, int height){  //constructor, creates and fills the miniMap array with dots
        this.width = width;
        this.height = height;
        this.miniMap = new char[height][width];

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                miniMap[y][x] = EMPTY; //fills mini map with dots 
             }//forX
                
        }//forY

    }//Map

    public void placeRoom(Position pos, char symbol){//Position is from Position.java therefore has format (int x, int y)
        int x = pos.x;  //format is coming from Position.java file
        int y = pos.y;

        if(y>= 0 && y < height && x>= 0 && x<width){ //must be greater then 0 to exist on the map, must be smaller then width/height since arrays start at position 0 not1
            miniMap[y][x] = symbol; //assigning the room char to appear on the mini map in its location
        }//if
    }//placeRoom

    public String display(){ //method for displaying the minimap to the user
        String displayMiniMap = "";
        
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                 displayMiniMap += miniMap[y][x];
                
             }//forX
            
            displayMiniMap += "\n"; //seperate rows
        }//forY

        
        return displayMiniMap;
    }//display




    
}//class