package facturas;

public class Factura extends Ticket {
    private String folio;

    public Factura(String codigo, double total) {
        super(codigo, total);
        this.folio = codigo + "-FACT";
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
}
