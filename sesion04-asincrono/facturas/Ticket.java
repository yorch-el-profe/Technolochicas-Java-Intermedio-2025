package facturas;

public class Ticket {
    
    private String codigo;
    private double total;

    public Ticket(String codigo, double total) {
        this.codigo = codigo;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String registro) {
        this.codigo = registro;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
