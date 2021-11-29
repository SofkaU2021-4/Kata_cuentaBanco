import java.time.LocalDate;





public class Movimiento {

    private LocalDate fecha;

    private double balance;
    private double deposito;
    private double retiro;
    private double transaccion;

    public Movimiento(LocalDate fecha, double balance, String operacion, double deposito) {
        this.balance = balance;
        this.fecha = fecha;
        Operacion(operacion,deposito);
    }

    public void Operacion(String operacion,double deposito){
        switch (operacion){
            case "deposito":this.deposito = deposito;break;
            case "retiro":this.retiro = deposito;break;
            default:this.transaccion = deposito;break;
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getBalance() {
        return balance;
    }

    public double getDeposito() {
        return deposito;
    }

    public double getRetiro() {
        return retiro;
    }
}
