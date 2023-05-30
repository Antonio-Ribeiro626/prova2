class Cliente {
    private int id;
    private String nome;
    private Endereco endereco;
    private Contacto contacto;

    public Cliente(int id, String nome, Endereco endereco, Contacto contacto) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contacto getContacto() {
        return contacto;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + "\n" +
                endereco.toString() + "\n" +
                contacto.toString();
    }
}