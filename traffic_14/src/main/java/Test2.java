public class Test2 {
    public static void main(String[] args){
        int red = 2;
        int green = 2;
        int odometer = 5+2;
        int result = 0;
        boolean activeLight = true; // true = red, false = green
        int wait = 0;

        System.out.println(odometer/(red + green)); // = 2. Целочисленное деление. Если odometer меньше суммы, то = 0
        System.out.println(odometer - ((red + green) * (odometer / (red + green)))); // = 7. Остаток от деления

        result = odometer - ((red + green) * (odometer / (red + green))); //находим остаток от деления для анализа цвета

        if(result > red) { //1-5 - red, 6-10 - green
            activeLight = false; //проверка на активный свет светофора. false - это green
        } else {
            wait = red - result; //если мы стоим на красном, время ожидания = red - result
        }
        System.out.println("red? - " + activeLight);
        System.out.println("how much to wait? - " + wait);
    }
}
