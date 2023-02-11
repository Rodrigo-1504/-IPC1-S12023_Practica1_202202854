/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package practica1;

import java.util.Scanner;
/**
 *
 * @author Rodri
 */
public class Practica1 {
        static String producto[][] = new String[20][1]; //guardar los nombres de los productos para usarlo en cualquier metodo
        static double precio[][] = new double[20][1]; //guardar el precio de los productos para usarlo en cualquier metodo
        static String cupones[][] = new String[20][1]; //guardar el nombre de los cupones para usarlo en cualquier metodo
        static double descuento[][] = new double[20][1]; //guardar el valor de descuento para usarlo en cualquier metodo
        static double subtotales[][] = new double[20][1]; //guardar los valores de subtotales para luego guardarlos
        static String nom [] = new String[1];//Guardar el nombre del cliente
        static int cantidades [][] = new int[20][1];//Guardar cantidades
        static String NIT [] = new String[1];//Guardar NIT
        static int mas = 0;
        static int mas1 = 0;
        static int mas2 = 0;
        static int nose []= new int [1];
    public static void main(String[] args) {
        usuario(); //todo comienza desde el metodo usuario
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void Menu(){
        Scanner Inicio = new Scanner(System.in);
            //menu de inicio
            System.out.println("\n Bienvenidos al Menú");
            System.out.println("1 Agregar nuevos productos");
            System.out.println("2 Agregar cupones de descuento");
            System.out.println("3 Realizar ventas");
            System.out.println("4 Realizar reporte");
            System.out.println("  Salir");
            System.out.println("¿Qué desea realizar?");
            int opcion = Inicio.nextInt();
            
            switch(opcion){
                case 1:
                    ayuda1();
                    break;
                case 2:
                    ayuda2();
                    break;
                case 3:
                    ventas();
                    break;
                case 4:
                    reporte();
                    break;
                default:
                    System.out.println("No existe esta opción");
                    break;
            }
        
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void nuevosproductos(){
        Scanner P = new Scanner(System.in);
        
        System.out.println("Ingreso de Nuevos productos");
        
        if (mas<20) {//mientras mas sea menor a 20 que es el tamaño de mi matriz hara funcionar lo que esta dentro
            String prod=" ";
            double prec=0;
            boolean si = true;
            
            while(si==true){
                System.out.println(mas+" Ingrese el nombre del Producto");
                prod = P.nextLine();
                boolean norep = norepetir(prod);
                if (norep==false) {
                    System.out.println("No se aceptan productos repetidos");
                }else if (norep==true) {
                    si = false;
                }
            }
            
            do {
                System.out.println(mas+" Ingrese el precio del Producto");
                prec = P.nextDouble();
                if (prec == 0) {
                    System.out.println("No se pueden ingresar valores igual a 0");
                }
            } while (prec==0);
            
            producto[mas][0]=prod; //ej. producto[0][0]=ropa, producto[1][0] = papel, etc... 
            precio[mas][0]=prec;   //mismo comentario de arriba solo que con precios
            
            mas = mas +1; //para que cada vez que se guarde un dato en una matriz, el valor de la matriz sea diferente y asi no meter todos los datos en un solo espacio de matriz
            
        }else{
            System.out.println("No se aceptan más datos lastimosamente"); //mas llego a mas de 20 o a 20
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void cupones(){
        //similar al metodo de nuevosproductos()
        Scanner C = new Scanner(System.in);
        
        System.out.println("Ahora ingrese los cupones");
        if (mas1<20) {
            String cupon=" ";
            double porcentaje;
            
            do {
                System.out.println(mas1+" Ingrese el nombre del Cupon, solo de 4 digitos");
                cupon = C.nextLine();
            } while (cupon.length()>4);
            
            do {
                System.out.println(mas1+" Ingrese el porcentaje del valor del cupon entre 1 a 100 :");
                porcentaje = C.nextDouble();
            } while (porcentaje==0 || porcentaje >100);
            
            cupones[mas1][0]=cupon;
            descuento[mas1][0]=porcentaje;
         
            mas1 = mas1+1;
        }else{
            System.out.println("No se aceptan más datos lastimosamente");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void ventas(){
        Scanner v = new Scanner(System.in);
        String NIT1;
        
        System.out.print("Nombre del Cliente: ");
        String nombre  = v.nextLine();
        nom[0]=nombre;
        System.out.println("¿Desea NIT?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        NIT1 = v.nextLine();
        
        switch(NIT1){
            case "1": 
                System.out.print("NIT: ");
                NIT1 = v.nextLine();
                NIT[0]=NIT1;
                break;
            default:
                NIT[0]="C/F";
                System.out.println("C/F");
                break;
        }
        ayuda3();//luego de pedir los datos del cliente, lo lleva a un metodo que cumple otra funcion
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void reporte(){
        for (int i = 0; i <20; i++) {
            System.out.print("Producto: "+producto[i][0]+"      ");
            System.out.print("Cantidad: "+cantidades[i][0]);
            System.out.println("");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void ayuda1(){
        Scanner ayuda = new Scanner(System.in);
        
        String seguir = "0";
        
        do {
            nuevosproductos();           
            System.out.println("¿Desea ingresar mas productos?");
            System.out.println("0 SI");
            System.out.println("1 NO");
            seguir = ayuda.nextLine();
        } while (seguir.equals("0"));
        Menu();
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void ayuda2(){
        Scanner ayuda1 = new Scanner(System.in);
        
        String seguir = "0";
        
        do {
            cupones();
            
            System.out.println("¿Desea ingresar mas cupones?");
            System.out.println("0 SI");
            System.out.println("1 NO");
            seguir = ayuda1.nextLine();
        } while (seguir.equals("0"));
        Menu();
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void listado(){
        
        Scanner l = new Scanner(System.in);
        String prod;
        
        System.out.println("--Listado de Productos--");
        
        for (int i = 0; i <20; i++) {//le muestra los productos que hay y el precio
                System.out.print("Productos: "+i+" "+producto[i][0]+"         ");
                System.out.print("Precio: "+i+" "+precio[i][0]+" ");
                System.out.println("\n");
        }
        if (mas2<20) {
            System.out.println("¿Cuales de estos productos desea?");
            System.out.println("Escriba el nombre del Producto que usted quiere: ");
            prod = l.nextLine();
            
            prod = devolver(producto);
            
            
            System.out.println("Ingrese la cantidad que desea: ");
            int cantidad = l.nextInt();
            cantidades[mas2][0]=cantidad;
            
            double sub = precio[mas2][0]*cantidades[mas2][0];
           subtotales[mas2][0]=sub;
           mas2= mas2+1;
        }else{
            System.out.println("No hay mas espacio");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void ayuda3(){
        Scanner ayuda1 = new Scanner(System.in);
        
        String seguir = "0";
        
        do {
            listado();
            
            System.out.println("¿Desea elegir mas productos?");
            System.out.println("0 SI");
            System.out.println("1 NO");
            seguir = ayuda1.nextLine();
        } while (seguir.equals("0"));
        total();
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void total(){
        Scanner t = new Scanner(System.in);
        
        double suma = 0;
        double desc1;
        double total=0;
        double resta = 0;
        
        for (int i = 0; i < 20; i++) {
            suma += subtotales[i][0];
        }
        System.out.println("El subtotal es: "+suma);
        
        System.out.println("¿Tiene algun cupon de descuento de estos?");
        for (int i = 0; i <20; i++) {//le muestra los productos que hay y el precio
                System.out.println("Cupon: "+i+" "+cupones[i][0]+" ");
        }
        System.out.println("0 SI ");
        System.out.println("1 NO");
        int siono = t.nextInt();
        if (siono == 0) {
            System.out.println("Numero de cupon");
            nose[0] = t.nextInt();
            System.out.println("Este es el descuento del cupon: "+precio[nose[0]][0]);
            desc1 = precio[nose[0]][0]/100;
            total =suma*desc1;
            resta = suma-total;
            System.out.println("Valor total: "+resta);
        }else{
            total=suma;
        }
        System.out.println("---Emitiendo factura---\n\n");
        System.out.println("Nombre de la empresa: SUPER-25");
        System.out.println("Cajero: Rodrigo Tahuite");
        System.out.println("Cliente "+nom[0]);
        System.out.println("Numero de NIT: "+NIT[0]);
        for (int i = 0; i < 20; i++) {
            System.out.print("Productos: "+producto[i][0]+"      ");
            System.out.print("Precio: "+precio[i][0]+"      ");
            System.out.println("Cantidad: "+cantidades[i][0]);
        }
        System.out.println("Subtotal: "+suma);
        if (siono==0) {
            System.out.println("Porcentaje del cupon: "+precio[nose[0]][0]+"%");
        }else{
            System.out.println("No hay descuento");
        }
        System.out.println("Total: " +resta);
        
        Menu();
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean norepetir(String prod){
        for (int i = 0; i < 20; i++) {
            if ((producto[i][0] != null))
                if((producto[i][0].equals(prod)))
                    return false;
        }
        return true;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*public static boolean norepetir1(String cupon){
        for (int i = 0; i < 20; i++) {
            if ((cupones[i][0] != null))
                if ((cupones[i][0].equals(cupon)))
                    return true;
        }
        return false;
    }*/
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static String devolver(String[][] producto){
        for (int i = 0; i < 20; i++) {
            if (producto[i][0] != null){
                if (producto[i][0].equals(producto)) {
                    return producto[i][0] ;
                }
            }
        }
        return "Se pudo ;D";
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static double devolver1(double [][] precio){
        for (int i = 0; i < 20; i++) {
            if ((precio[i][0]==(nose[0])))
                return precio[nose[0]][0] ;
        }
        return 0;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void usuario(){
        Scanner A = new Scanner(System.in);
        
        String usuario1 = "cajero_202202854";//usuario correcto
        String contraseña = "ipc1_202202854";//contraseña correcta
        
        //Entrar al sistema o cerrarlo
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Ingresar al Sistema");
        System.out.println("2. No ingresar al Sistema");
        int sistem = A.nextInt();
        
        System.out.println("");//salto de linea
        
        //eleccion de si entrar o cerrar
        switch(sistem){
            case 1:
                //ingreso de usuario y de contraseña
                System.out.println("Ingrese su usuario");
                String usuario = A.next();
                System.out.println("Ingrese su contraseña");
                String contra = A.next();
        
                while(usuario.equals(usuario1)==false || contra.equals(contraseña)==false){
                System.out.println("\n Datos incorrectos");
                System.out.println("Ingrese su usuario");
                usuario = A.next();
                System.out.println("Ingrese su contraseña");
                contra = A.next();
                }
                if (usuario.equals(usuario1)==true && contra.equals(contraseña)==true) {
                    Menu();
                }
                break;
            case 2:
                break; //cerrar sistema
                
            default:
                System.out.println("Opción no valida");
                break; //cerrar sistema
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
