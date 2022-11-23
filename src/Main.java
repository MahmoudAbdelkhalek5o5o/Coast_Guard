import java.lang.Math;

public class Main {
    public static  int GenerateRandomNumber( int max , int min ){
        return (int)(Math.random()*(max-min+1)+min);
    }

    public static void main(String[] args) {
        int grid_min = 5;
        int grid_max = 15;
        int agent_min = 30;
        int agent_max = 100;
        int passenger_min = 1;
        int passenger_max = 100;


        // Initialize The size of the grid

        int m = GenerateRandomNumber( grid_max , grid_min );
        int n = GenerateRandomNumber( grid_max , grid_min );
        int cells_number = m * n;
        int [][] grid = new int [m][n];
        System.out.println("Cells Number: "+ cells_number);

        // Generate the capacity of coast guard ship
        int agent_capacity = GenerateRandomNumber( agent_max , agent_min );
        System.out.println("agent_capacity: "+ agent_capacity);

        // Generate the location of the coast guard ship
        int agent_row_loc = GenerateRandomNumber( m-1 , 0 );
        int agent_col_loc = GenerateRandomNumber( n-1 , 0 );
        grid[ agent_row_loc ][ agent_col_loc ] = -1;

        // Generate the number of the ships
        int ship_number = GenerateRandomNumber( cells_number , 1 );
        System.out.println("ship_number: "+ ship_number);
        // Generate the number of the stations ( The remaining number after ships and agent)
        int remain_locations = cells_number - ship_number ;
        int station_number = GenerateRandomNumber( remain_locations , 1 );
        System.out.println("station_number: "+ station_number);

        for ( int i = 0; i < ship_number; i++){
            int passenger_number = GenerateRandomNumber( passenger_max , passenger_min );
            boolean flag = true;
            while (flag) {
                int row = GenerateRandomNumber(m - 1, 0);
                int col = GenerateRandomNumber(n - 1, 0);
                if ( grid[row][col] == 0){
                    grid[row][col] = passenger_number;
                    flag = false;
                }
            }

        }

        for ( int i = 0; i < station_number; i++){
            boolean flag = true;
            while (flag) {
                int row = GenerateRandomNumber(m - 1, 0);
                int col = GenerateRandomNumber(n - 1, 0);
                if ( grid[row][col] == 0){
                    grid[row][col] = -55;
                    flag = false;
                }
            }

        }

        String str_first = m+","+n+";"+ agent_capacity + "," + agent_row_loc + "," + agent_col_loc + ";";
        String str_second = "";
        String str_third = "";
        for ( int i = 0; i<m; i++){
            for ( int j = 0; j<n; j++){
                if ( grid[i][j] > 0){
                    str_third += i+"," +j+ "," + grid[i][j] + "," ;
                }
                else if ( grid[i][j] == -55 ){
                    str_second += i + "," + j + "," ;
                }
            }
        }
        StringBuilder str1 = new StringBuilder(str_second);
        str1.setCharAt( str_second.length()- 1, ';');

        StringBuilder str2 = new StringBuilder(str_third);
        str2.setCharAt( str_third.length() - 1, ';');

        String result = str_first + str1 + str2 ;


        System.out.println( result );


        for (int [] x:
                grid) {
            for (int y:
                    x) {
                System.out.print(y + " ");
            }
            System.out.println(" ");
        }
        }


}