import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Account {


    private double balance = 0;
    private List<Movimiento> movimientos =new ArrayList<>();
    private String historial = "";


    public void transaction(int valor, String fecha) {
        balance-=valor;
        movimientos.add(new Movimiento(cambiarFecha(fecha),balance,"transaction",valor));
    }

    public void withdraw(int valor, String fecha) {
        balance-=valor;
        movimientos.add(new Movimiento(cambiarFecha(fecha),balance,"retiro",valor));
    }


    public void deposit(int valor, String fecha) {
        balance+=valor;
        movimientos.add(new Movimiento(cambiarFecha(fecha),balance,"deposito",valor));
    }

    public LocalDate cambiarFecha(String fecha) {
        fecha=fecha.replace("/","-");
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void printStatements() {
        movimientos.stream().sorted(Comparator.comparing(Movimiento::getFecha).reversed()).forEach(x->statements(x));
        mostrar();
    }

    private void statements(Movimiento movimiento){
        historial+=""+movimiento.getFecha()+"     "+movimiento.getDeposito()+"     "+movimiento.getRetiro()+"     "+movimiento.getBalance()+"\n";
    }

    void mostrar(){
        System.out.println("    "+"Date"+"     "+"Credit"+"     "+"Debit"+"     "+"Balance"+"\n"+historial);
    }


}
