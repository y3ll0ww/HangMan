import java.util.Arrays;

public class Screen {

    public void Render(char[][] field){
        for(int i = 0; i < field[i].length -1; i++){
            for(int x = 0; x < field[i].length -1; x++){
                System.out.print(field[x][i] + "\t");
            }
            System.out.println();
        }
    }

    public void Start(char[] health, char[][] field){
        Arrays.fill(health, '●');
        this.Visuals(field, 0, health);
    }

    public void Visuals(char[][] field, int attempt, char[] health){
        switch(attempt){
            case 1:
                this.Lives(attempt, health);
                field[0][9] = '|';
                for(int i = 1; i <= 6; i++){
                    field[i][9] = '-';
                }
                this.Render(field);
                break;
            case 2:
                this.Lives(attempt, health);
                for(int i = 1; i<= 8; i++){
                    field[0][i] = '|';
                }
                this.Render(field);
                break;
            case 3:
                this.Lives(attempt, health);
                for(int i = 0; i <= 9; i++){
                    field[i][0] = '-';
                }
                field[2][1] = '/';
                field[1][2] = '/';
                this.Render(field);
                break;
            case 4:
                this.Lives(attempt, health);
                field[8][1] = '|';
                field[8][2] = 'O';
                this.Render(field);
                break;
            case 5:
                this.Lives(attempt, health);
                field[8][3] = '|';
                field[8][4] = '|';
                this.Render(field);
                break;
            case 6:
                this.Lives(attempt, health);
                field[7][3] = '\\';
                field[9][3] = '/';
                this.Render(field);
                break;
            case 7:
                this.Lives(attempt, health);
                field[7][5] = '/';
                field[9][5] = '\\';
                field[8][2] = 'X';
                this.Render(field);
                this.Wipe(field);
                break;
            case 0:
                this.Lives(attempt, health);
                field[3][3] = 'H'; field[4][3] = 'A'; field[5][3] = 'N'; field[6][3] = 'G';
                field[3][4] = 'M'; field[4][4] = 'A'; field[5][4] = 'N'; field[6][4] = '!';
                this.Render(field);
                this.Wipe(field);
        }
    }

    public void Wipe(char[][] screen){
        for(char i = 0; i < screen[i].length -1; i++){
            for(int x = 0; x < screen[i].length -1; x++){
                screen[x][i] = '\u0000';
            }
        }
    }

    public void Lives(int attempt, char[] health){
        if(attempt > 0){
            health[health.length - attempt] = '○';
        }
        System.out.print("\n\n\nLIVES: ");
        System.out.println(health);
    }

}