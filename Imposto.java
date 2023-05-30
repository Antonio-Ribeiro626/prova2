abstract class Imposto {
    private int id;
    private double taxa;
    private double ipu;

    public Imposto(int id, double taxa) {
        this.id = id;
        this.taxa = taxa;
    }

    public int getId() {
        return id;
    }

    public double getTaxa() {
        return taxa;
    }

    public double getIPU() {
        return ipu;
    }

    public void setIPU(double ipu) {
        this.ipu = ipu;
    }

    public abstract void calcularIPU();

    @Override
    public String toString() {
        return "ID do Imposto: " + id + ", Taxa: " + taxa  + ", IPU: " + ipu +" Kz  ";
    }
}