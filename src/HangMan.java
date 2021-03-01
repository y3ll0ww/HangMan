public class HangMan {
    public static void main(String args[]){
        Functions game = new Functions();

        System.out.println("Welcome to...\n" +
                "HH  HH   AAAA   NN  NN  GGGGGG\n" +
                "HH  HH  AA  AA  NNN NN  GGGGGG\n" +
                "HHHHHH  AA  AA  NNN NN  GG\n" +
                "HHHHHH  AAAAAA  NN NNN  GG  GG\n" +
                "HH  HH  AA  AA  NN NNN  GGGGGG\n" +
                "HH  HH  AA  AA  NN  NN  GGGGGG\n\n" +
                "M    M   AAAA   NN  NN  !!!!!!\n" +
                "MM  MM  AA  AA  NNN NN  !!!!!!\n" +
                "MMMMMM  AA  AA  NNN NN  !!!!!!\n" +
                "MM  MM  AAAAAA  NN NNN  !!!!!!\n" +
                "MM  MM  AA  AA  NN NNN\n" +
                "MM  MM  AA  AA  NN  NN  !!!!!!");

        game.Menu();
    }
}
