/**
 * Clase que permite crear, representar y manipular fechas.
 * Incluye métodos para calcular diferencias entre fechas,
 * sumar o restar días y obtener información del calendario.
 *
 * @author Luis Daniel Sanchez Diaz
 * @version 1a edicion
 */
public class Fecha {
    int dia, mes, anio;

    /** Constructor por omision. Construye la fecha 1/1/2026
    */
    public Fecha(){
        this(1,1,2026);
    }

    /** Constructor de una Fecha a partir de los valores de dia, mes y anio
    *@param d - valor para el dia
    *@param m - valor para el mes
    *@param a - valor para el anio
    */
    public Fecha(int d, int m, int a){
        setDia(d);
        setMes(m);
        setAnio(a);
    }

    /** Constructor de una Fecha a partir de los valores de dia, anio y el nombre del mes
    *@param d - valor para el dia
    *@param a - valor para el anio
    *@param m - valor para el mes en String 
    */
    public Fecha(int d, int a, String m){
        setDia(d);
        setAnio(a);
        setMes(nmes(m));
    }

    /*Metodo para asignar el dia de la fecha
    *@param d - el dia para el objeto fecha
    */
    public void setDia(int d){
        dia=d;
    }

    /*Metodo para asignar el mes de la fecha
    *@param m - el mes para el objeto fecha
    */
    public void setMes(int m){
        mes=m;
    }

    /*Metodo para asignar el anio de la fecha
    *@param a - el anio para el objeto fecha
    */
    public void setAnio(int a){
        anio=a;
    }

    /*Metodo para obtener el dia de la fecha
    *@return el dia del objeto fecha
    */
    public int getDia(){
        return dia;
    }

    /*Metodo para obtener el mes de la fecha
    *@return el mes del objeto fecha
    */
    public int getMes(){
        return mes;
    }
    
    /*Metodo para obtener el anio de la fecha
    *@return el anio del objeto fecha
    */
    public int getAnio(){
        return anio;
    }

    /** Metodo para calcular la diferencia en dias entre dos fechas
    *@param f - la primera fecha
    *@param f2 - la segunda fecha
    *@return int - la diferencia en dias entre las dos fechas
    */
    public int diferencia(Fecha f, Fecha f2){
        int dif=0;
        int anios=f2.getAnio()-f.getAnio();
        int sumaa=0;
        do{
        if (anios<0){
            anios*=-1;
        }
        if (f.getAnio()==f2.getAnio()){ 
        dif += f2.diast(f2)-f.diast(f);
        if (dif<0){
            dif*=-1;
        }
       }else{
        dif+= -1*(f.diast(f)-365)+f2.diast(f2);
        if(f.bisiesto(f.getAnio()+sumaa) || f2.bisiesto(f2.getAnio()+sumaa)){
            dif++;
        }
        anios--;
        sumaa++;
    }
    }while(anios!=0);
    return dif;
}

    /** Metodo para sumar o restar dias a una fecha
    *@param f - la fecha a la que se le sumaran o restaran dias
    *@param d - el numero de dias a sumar o restar.
    *@return String - la fecha resultante de la suma o resta de dias
    */
    public String sorDias(Fecha f, int d){
        int mes=f.getMes();
        int anio=f.getAnio();
        int dias=f.getDia();
        dias+=d;
        do{
        if (dias>diasMes(mes, anio)){
            dias-=diasMes(mes, anio);
            mes++;
            if (mes>12){
                mes=1;
                anio++;
            }
        }
        if (dias<1){
            mes--;
            if (mes<1){
                mes=12;
                anio--;
            }
            dias=diasMes(mes, anio)+dias;
        }}while (dias>diasMes(mes, anio));
        new Fecha(dias, mes, anio);
        return dias+"/"+smes(mes)+"/"+anio;
    }

    /**Metodo para determinar si dos fechas son iguales
     * @param f - Fecha con la que se va a comparar
     * @return boolean - true si son iguales, false en caso contrario
     */
    public boolean equalsf(Object f){
        Fecha fecha=(Fecha)f;
        return dia==fecha.getDia() && mes==fecha.getMes() && anio==fecha.getAnio();
    }

    /** Metodo para convertir el nombre de un mes en su número correspondiente.
     * @param m - el nombre del mes
     * @return int - el número del mes correspondiente
     */
    public int nmes(String m){
        if (m.equals("Enero")) return 1;
        if (m.equals("Febrero")) return 2;
        if (m.equals("Marzo")) return 3;
        if (m.equals("Abril")) return 4;
        if (m.equals("Mayo")) return 5;
        if (m.equals("Junio")) return 6;
        if (m.equals("Julio")) return 7;
        if (m.equals("Agosto")) return 8;
        if (m.equals("Septiembre")) return 9;
        if (m.equals("Octubre")) return 10;
        if (m.equals("Noviembre")) return 11;
        if (m.equals("Diciembre")) return 12;
        return -1;
    }
    
    /** Metodo para convertir el número de un mes en su nombre correspondiente.
     * @param n - el número del mes
     * @return String - el nombre del mes correspondiente al número
    */
    public String smes(int n){
        if (n==1) return "Enero";
        if (n==2) return "Febrero";
        if (n==3) return "Marzo";
        if (n==4) return "Abril";
        if (n==5) return "Mayo";
        if (n==6) return "Junio";
        if (n==7) return "Julio";
        if (n==8) return "Agosto";
        if (n==9) return "Septiembre";
        if (n==10) return "Octubre";
        if (n==11) return "Noviembre";
        if (n==12) return "Diciembre";
        return "Error";
    }

    /** Metodo para calcular el número de días transcurridos desde el inicio del año hasta la fecha especificada.
     * @param f - la fecha para la cual se calcularán los días transcurridos
     * @return int - el número de días transcurridos desde el inicio del año hasta la fecha
    */
    public int diast(Fecha f){
        int dias=0;
        int mes1=f.getMes();
        do {
            dias += diasMes(mes1, f.getAnio());
            mes1 -= 1;
        } while (mes1>0);
                dias -= diasMes(f.getMes(), f.getAnio())-f.getDia();
        return dias;
    }

    /** Metodo para determinar si un año es bisiesto.
     * @param a - el año a evaluar
     * @return boolean - true si el año es bisiesto, false en caso contrario
    */
    public boolean bisiesto(int a){
        if (a%4==0 && (a%100!=0 || a%400==0)) {
            return true;
        }
        return false;
    }

    /** Metodo para obtener el número de días en un mes específico de un año determinado.
     * @param m - el número del mes (1-12)
     * @param a - el año
     * @return int - el número de días en el mes especificado
    */
    public int diasMes(int m, int a){
        if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
            return 31;
        }else if (m==4 || m==6 || m==9 || m==11) {
            return 30;
        }else if (m==2 && !bisiesto(a)){
            return 28;
        }else {
        return 29;
    }
    }
    
    /** Metodo para convertir una fecha a cadena de caracteres
     * @return String - la fecha en formato de cadena
    */
    public String toString(){
        return dia+"/"+smes(mes)+"/"+anio;
    }

}