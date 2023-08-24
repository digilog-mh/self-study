import java.util.ArrayList;

public class TargetNum{
    static boolean[] seats = {true,true,true,false,true,true,true,true,false,true,true,true};

    static public int solution(int row, String book) {
        int way =0;
        int len = seats.length;
        ArrayList<String> books = new ArrayList<>(); // 예약 목록
        ArrayList<boolean[]> allSeat = new ArrayList<>(); //전체 좌석
        String[] booked = book.split(" ");

        for (String b : booked){
            books.add(b);
        }

        for (int r=1; r <= row; r++){
            allSeat.add(seats);

            for (int b=0; b < books.size(); b++){
                if (books.get(b).contains(Integer.toString(r))){
                    int seatNum = (int)books.get(b).substring(1,2).charAt(0)-65;
                    allSeat.get(r)[seatNum] = false;

                    books.remove(b);
                }
            }

            for (int n =0; n <seats.length; n++){

            }
        }

        return way;
    }

    public static void main(String[] args) {
        int way = 0;
        way = solution(2,"1A 2F 1C");
        System.out.println(way);

        way = solution(1,"");
        System.out.println(way);
    }

}
