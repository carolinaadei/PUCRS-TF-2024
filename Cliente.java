import java.util.ArrayList;

public class Cliente{
    private int matricula;
    private String nome;
    private String empresa;
    private Equipamento equipamentoRetirado;
    private ArrayList<Equipamento> historicoEmprestimos;

    public Cliente(int matricula, String nome, String empresa){
        this.matricula=matricula;
        this.nome=nome;
        this.empresa=empresa;
        this.equipamentoRetirado=null;
        this.historicoEmprestimos=new ArrayList<>();
    }

    public void setMatricula(int matricula){
        this.matricula=matricula;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setEmpresa(String empresa){
        this.empresa=empresa;
    }

    public void setEquipamentoRetirado(Equipamento equipamento){
        if (equipamento == null) {
            this.equipamentoRetirado = null;
            return;
        }

        this.equipamentoRetirado = equipamento;
        historicoEmprestimos.add(equipamento);
        System.out.println("Equipamento " + equipamento.getNome() + " retirado com sucesso.");
    }

    public void setHistoricoEmprestimos(ArrayList<Equipamento> historicoEmprestimos){
        this.historicoEmprestimos = historicoEmprestimos;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getNome(){
        return nome;
    }

    public String getEmpresa(){
        return empresa;
    }

    public Equipamento getEquipamentoRetirado(){
        return equipamentoRetirado;
    }

    public void exibirHistoricoEmprestimos(){
        if (historicoEmprestimos.isEmpty()){
            System.out.println("O cliente " + nome + " não possui histórico de empréstimos.");
            return;
        }

        System.out.println("Histórico de empréstimos do cliente " + nome + ":");
        for (Equipamento equipamento:historicoEmprestimos) {
            System.out.println(equipamento.toString());
        }
    }

    public String toString() {
        return "O cliente " + nome + ", de matrícula " + matricula + ", da empresa " + empresa + (equipamentoRetirado != null ? "retirou o equipamento " + equipamentoRetirado.getNome() + "." : "não retirou nenhum equipamento.");
    }
}