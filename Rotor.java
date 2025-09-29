public class Rotor {

    
    private String rotorValues;
    private char startChar;
    private char[] rotorChars;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());

        rotorChars = rotorValues.toCharArray();
            
    }
    
    public boolean rotate(){
        char[] newArr = new char[rotorChars.length];

        newArr[0] = rotorChars[rotorChars.length-1];
        for (int i = 1; i < rotorChars.length; i++) {
            newArr[i] = rotorChars[i-1];
        }
        rotorChars = newArr;
        rotorValues = new String(rotorChars);

        if (rotorChars[0] == startChar) {
            return true;
        } else {
            return false;
        }
    }
    

    public int indexOf(char c){
        for (int i = 0; i < rotorValues.length(); i++) {
            if (charAt(i) == ('c')) {
                return i;
            }
        }

        // if c is not found in the string
        return -1;
    }

    public char charAt(int idx){
        if (idx >= rotorValues.length()) {
            return rotorChars[idx];
        }
        return '\0';
    }
}
    