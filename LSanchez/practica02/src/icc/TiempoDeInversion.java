import java.util.Scanner;
public class TiempoDeInversion {
    
    public static void main(String[] args) {
        boolean continuar = false;
        String nombre;
        Double monto;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido!!");
        System.out.println("Ingrese su nombre: ");
        nombre = sc.nextLine();

        do{
        System.out.println("Hola, " + nombre + "!. Cual es su monto a invertir?");
        monto = sc.nextDouble();

        System.out.println("Ingrese el anio de inicio de la inversion (aaaa): ");
        int anioInicio = sc.nextInt();
        System.out.println("Ingrese el mes de inicio de la inversion (mm): ");
        int mesInicio = sc.nextInt();
        System.out.println("Ingrese el dia de inicio de la inversion (dd): ");
        int diaInicio = sc.nextInt();
        Fecha fechaInicio = new Fecha(diaInicio, mesInicio, anioInicio);

        System.out.println("Ingrese el anio de fin de la inversion (aaaa): ");
        int anioFin = sc.nextInt();
        System.out.println("Ingrese el mes de fin de la inversion (mm): ");
        int mesFin = sc.nextInt();
        System.out.println("Ingrese el dia de fin de la inversion (dd): ");
        int diaFin = sc.nextInt();
        Fecha fechaFin = new Fecha(diaFin, mesFin, anioFin);

        int diasInversion = fechaInicio.diferencia(fechaInicio, fechaFin);
        System.out.println("El tiempo de inversion es de " + diasInversion + " dias.");
        double rendimiento = 0.12 * diasInversion / 365;
        double montoFinal = monto * (1 + rendimiento);
        System.out.println("El rendimiento es: " + (monto * rendimiento));
        System.out.println("El monto final de la inversion es: " + montoFinal);

        System.out.println("Desea hacer otra simulacion? (si/no)");
        sc.nextLine();
        String respuesta = sc.nextLine();
        if (respuesta.equals("si") || respuesta.equals("Si") || respuesta.equals("SI")) {
            continuar = true;
        } else {
            continuar = false;
        }
 
        }while (continuar);
    
    }
    
}
