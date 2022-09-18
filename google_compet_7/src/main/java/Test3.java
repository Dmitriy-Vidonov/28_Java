public class Test3 {
    public static void main(String[] args) {
        int dlina = 12;
        //for(int i=dlina; i>0; i--) System.out.println(i);  //for i in range(dlina, 0, -1) print(i)

        String s = "апреунде цум гебойген";
      //System.out.println(s.substring(0,2)); //печать ап - двух символов сначала
      //System.out.println(s.substring(2)); //печать за исключением первых двух символов - реунде цум гебойген

        s=s.substring(2);
        System.out.println(s); //по сути из строки убрали два первых символа

    }
}
