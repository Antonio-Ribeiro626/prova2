class ImpostoNaoArrendado extends Imposto {
    private double valorPatrimonial;

    public ImpostoNaoArrendado(int id, double taxa, double valorPatrimonial) {
        super(id, taxa);
        this.valorPatrimonial = valorPatrimonial;
        calcularIPU();
    }

    public double getValorPatrimonial() {
        return valorPatrimonial;
    }

    public void setValorPatrimonial(double valorPatrimonial) {
        this.valorPatrimonial = valorPatrimonial;
        calcularIPU();
    }

    @Override
    public void calcularIPU() {
        if (valorPatrimonial > 5000000) {
            setIPU((valorPatrimonial - 5000000) * getTaxa());
        } else {
            setIPU(0);
        }
    }

    @Override
    public String toString() {
        if (super.getIPU() == 0) {
            return "Imposto Não Arrendado: " + super.toString() + ", Valor Patrimonial: " + valorPatrimonial +" Kz  "  +"\nEstá isento de pagar imposto, pois o Seu valor patrimonial não é superior a 5.000.000,00 Kz (5 milhões)";            
        }else{
            return "Imposto Não Arrendado: " + super.toString() + ", Valor Patrimonial: "  + valorPatrimonial +" Kz  ";
        }


    }
}