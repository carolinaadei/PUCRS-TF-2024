import java.util.ArrayList;

public class CadastroCliente{
    private ArrayList<Cliente> clientes;
    private int totalClientes;

    public CadastroCliente(){
        clientes = new ArrayList<>();
        totalClientes = 0;
    }

    public boolean addCliente(Cliente cliente){
        if (cliente==null){
            System.out.println("Cliente inválido!");
            return false;
        }

        if (clientes.size() < 100) {
            clientes.add(cliente);
            totalClientes++;
            return true;
        }

        System.out.println("Limite de clientes atingido.");
        return false;
    }

    public Cliente buscaClienteNome(String nome){
        if (nome==null || nome.trim().isEmpty()){
            System.out.println("Nome de cliente inválido.");
            return null;
        }

        for (Cliente cliente:clientes){
            if (cliente.getNome().equalsIgnoreCase(nome)){
                return cliente;
            }
        }

        System.out.println("Cliente não encontrado.");
        return null;
    }

    public int getTotalClientes(){
        return totalClientes;
    }

    public void mostraClientes(){
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }
    }
}