public class Equipamento{
    private int codigo;
    private String nome;
    private String tipo;
    private int quantidadeHoras;
    private boolean seguro;
    private double valor;
    private boolean disponibilidade;

    private final double PRECO_POR_HORA = 20.0;

    public Equipamento(
       int codigo,
       String nome,
       String tipo,
       int quantidadeHoras,
       boolean seguro
    ) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.seguro = seguro;
        this.disponibilidade = true;
        this.quantidadeHoras = quantidadeHoras;
        if (this.quantidadeHoras < 3) {
            this.quantidadeHoras = 3;
        }

        // Calculo do preço
        double preco = this.PRECO_POR_HORA * this.quantidadeHoras;
        if (this.quantidadeHoras >= 36) {
            preco = preco - (preco * 0.10);
        } else if (this.quantidadeHoras >= 24) {
            preco = preco - (preco * 0.05);
        }

        // Calculo do seguro
        if (this.seguro) {
            preco = preco + (preco * 0.02);
        }

        this.valor = preco;
    }

    public void setCodigo(int codigo){
        this.codigo=codigo;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public void setQuantidadeHoras(int quantidadeHoras){
        this.quantidadeHoras=quantidadeHoras;
    }

    public void setSeguro(boolean seguro){
        this.seguro=seguro;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public void setDisponibilidade(boolean disponivel){
        this.disponibilidade=disponivel;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    public int getQuantidadeHoras(){
        return quantidadeHoras;
    }

    public boolean getSeguro(){
        return seguro;
    }

     public double getValor(){
        return valor;
    }

    public boolean isDisponivel(){
        return disponibilidade;
    }

    public void retirar(){
        if (!disponibilidade) {
            System.out.println("Equipamento indisponível.");
            return;
        }

        disponibilidade = false;
        System.out.println("Equipamento retirado com sucesso!");
    }

    public void devolver(){
        if (disponibilidade) {
            System.out.println("Este equipamento não foi retirado");
            return;
        }

        disponibilidade = true;
        System.out.println("Equipamento devolvido com sucesso");
    }

    public String toString() {
        String seguroStr = "Não contratado";
        if (seguro) {
            seguroStr = "Contratado";
        }

        String disponivel = "Não";
        if (disponibilidade) {
            disponivel = "Sim";
        }

        return  "Equipamento: " + nome + ", Tipo: " + tipo + ", Código: " + codigo + ", Disponível: " + disponivel + " por " + quantidadeHoras + "horas, no valor de: " + valor + ". Seguro: " + seguroStr;
    }
}