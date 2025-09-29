public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        char[] msg = message.toCharArray(); //message in char array form
        String answer = ""; //answer that will be returned at end of function

        // goes through for loop to decrypt each char of message
        for (int i = 0; i < msg.length; i++) {
            char val = msg[i]; //the char being decrypted on this pass
            int idx; //index on rotor

            // goes through backwars rotor logic to find the decrypted value
            idx = rotors[2].indexOf(val);
            val = rotors[1].charAt(idx);
            idx = rotors[0].indexOf(val);
            val = rotors[0].charAt(idx);
            
            // adds result value to answer
            answer += val;

            // rotate rotors
            if (rotors[0].rotateBackwards()) {
                if (rotors[1].rotateBackwards()) {
                    rotors[2].rotateBackwards();
                }
            }
        }
        return answer; //final decrypted message
    }


    
    public String encrypt(String message){
        char[] msg = message.toCharArray(); //message in char array form
        String answer = ""; //answer that will be returned at the end of function

        // goes through for loop to encrypt each char of message
        for (int i = 0; i < msg.length; i++) {
            char val = msg[i]; //the char being converted during this pass
            int idx; //index on rotor

            // goes through rotor logic to find the encrypted value
            idx = rotors[0].indexOf(val);
            val = rotors[1].charAt(idx);
            idx = rotors[2].indexOf(val);
            val = rotors[2].charAt(idx);

            // adds this value to the answer
            // (end of loop will result in a fully encrypted answer)
            answer += val;

            // rotate rotors
            if (rotors[0].rotate()) {
                if (rotors[1].rotate()) {
                    rotors[2].rotate();
                }
            }
        }
        return answer; //final encrypted message
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}