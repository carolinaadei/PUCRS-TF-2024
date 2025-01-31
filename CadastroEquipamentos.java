import java.util.ArrayList;

public class CadastroEquipamentos{
    private ArrayList<Equipamento> equipamentos;

    public CadastroEquipamentos(){
        equipamentos = new ArrayList<>();
        adicionarEquipamentosIniciais();
    }

    private void adicionarEquipamentosIniciais(){
        equipamentos.add(new Equipamento(1, "Eletroencefalograma  1", "Eletro", 5, true));
        equipamentos.add(new Equipamento(2, "Raio Laser 1", "Raio Laser", 60, false));
        equipamentos.add(new Equipamento(3, "Dermatologia 1", "Dermatologia", 20, true));
        equipamentos.add(new Equipamento(4, "Eletro 2", "Eletro", 30, true));
        equipamentos.add(new Equipamento(5, "Raio Laser 2", "Raio Laser", 10, false));
        equipamentos.add(new Equipamento(6, "Dermatologia 2", "Dermatologia", 30, true));
    }

    public boolean adicionarEquipamento(Equipamento equipamento){
        if (equipamento == null) {
            System.out.println("Equipamento nulo");
            return false;
        }

        if (this.equipamentos.size() >= 10) {
            System.out.println("Lista de equipamentos lotada");
            return false;
        }

        this.equipamentos.add(equipamento);
        System.out.println("Equipamento " + equipamento.getNome() + " adicionado com sucesso!");
        return true;
    }

    public Equipamento buscarEquipamento(String nome){
        for (Equipamento e : equipamentos){
            if (e.getNome().equalsIgnoreCase(nome)){
                return e;
            }
        }
        return null;
    }

    public void listarEquipamentos(){
        if (equipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado.");
            return;
        }

        for (Equipamento e : equipamentos){
            System.out.println(e.toString());
        }
    }

    public int totalEquipamentosDisponiveis(){
        int total=0;
        for (Equipamento e:equipamentos){
            if (e.isDisponivel()){
                total++;
            }
        }
        return total;
    }

    public void mostrarHistorico(){
        System.out.println("Histórico de Equipamentos Retirados:");
        for (Equipamento e : equipamentos){
            if (!e.isDisponivel()){
                System.out.println("Equipamento retirado: " + e.toString());
            }
        }
    }
}
