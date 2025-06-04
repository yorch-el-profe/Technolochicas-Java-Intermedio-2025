package facturas;

public class FacturaFirmada extends Factura {
    
    private String selloDigital;

    public FacturaFirmada(String codigo, double total, String selloDigital) {
        super(codigo, total);
        this.selloDigital = selloDigital;
    }

    public String getSelloDigital() {
        return selloDigital;
    }

    public void setSelloDigital(String selloDigital) {
        this.selloDigital = selloDigital;
    }

    @Override
    public String toString() {
        return "Factura Firmada SAT [total = $" + this.getCodigo() + ", folio = " + this.getFolio() + ", sello = " + this.getSelloDigital() + "]";
    }
}
