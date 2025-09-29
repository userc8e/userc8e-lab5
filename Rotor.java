public class Rotor {

    
    private String rotorValues;
    private char startChar;
    private char[] rotorChars;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        rotorChars = rotorValues.toCharArray();

        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        // creates a new array where the characters will be saved
        char[] newArr = new char[rotorChars.length];

        // sets first char in array to the last char in the old array
        // as per the "circular" motion of rotating
        newArr[0] = rotorChars[rotorChars.length-1];

        // assigns every char a position following the newly added first char
        for (int i = 1; i < rotorChars.length; i++) {
            newArr[i] = rotorChars[i-1];
        }

        // sets new array values to the rotor
        rotorChars = newArr;
        rotorValues = new String(rotorChars);

        // returns boolean for if rotor has made a full rotation
        return (rotorChars[0] == startChar);
    }


    public boolean rotateBackwards() {
        // creates a new array where the characters will be saved
        char[] newArr = new char[rotorChars.length];

        // sets last char in new array to the first char in old array
        newArr[rotorChars.length-1] = rotorChars[0];

        // assigns every char a position that is one step backwards
        // does not include last index
        for (int i = 0; i < rotorChars.length-1; i++) {
            newArr[i] = rotorChars[i+1];
        }

        // sets new array values to the rotor
        rotorChars = newArr;
        rotorValues = new String(rotorChars);

        // returns boolean for if rotor has made a full rotation
        return (rotorChars[0] == startChar);
    }
    

    public int indexOf(char c){
        // goes through every char to find the first instance of c
        // returns the index at which c is located
        for (int i = 0; i < rotorValues.length(); i++) {
            if (charAt(i) == (c)) {
                return i;
            }
        }
        // if c is not found in the string
        return -1;
    }

    public char charAt(int idx){
        // returns the char at the index
        if (idx < rotorValues.length()) {
            return rotorChars[idx];
        }
        // returns empty char if index is out of bounds
        return ' ';
    }
}
    