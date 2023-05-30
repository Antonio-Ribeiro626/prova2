class ImpostoArrendado extends Imposto {
    private double valorRenda;

    public ImpostoArrendado(int id, double taxa, double valorRenda) {
        super(id, taxa);
        this.valorRenda = valorRenda;
        calcularIPU();
    }

    public double getValorRenda() {
        return valorRenda;
    }

    public void setValorRenda(double valorRenda) {
        this.valorRenda = valorRenda;
        calcularIPU();
    }

    @Override
    public void calcularIPU() {
        setIPU(valorRenda * getTaxa());
    }

    @Override
    public String toString() {
        return "Imposto Arrendado:  "+ super.toString() + ", Valor da Renda: " + valorRenda +"Kz" ;
    }
}
