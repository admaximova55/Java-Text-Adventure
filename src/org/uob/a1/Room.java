package org.uob.a1;

public class Room {
    private String name;
    private String description;
    private char symbol;
    private Position position;

    public Room(String name, String description, char symbol, Position position){
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
  
     }//room

    public String getName(){
        return name;
    }//getName

    public String getDescription(){
        return description;
    }//getDescription

    public char getSymbol(){
        return symbol;
    }//getSymbol

    public Position getPosition(){
        return position;
    }//getPosition

}//class