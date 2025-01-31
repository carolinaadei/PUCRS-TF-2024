import java.util.Scanner;

public class AppEmpresa{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        CadastroEquipamentos cadastroEquipamentos = new CadastroEquipamentos();
        CadastroCliente cadastroCliente = new CadastroCliente();
        int opcao;

        do{
            System.out.println("Menu:");
            System.out.println("1 - Incluir cliente");
            System.out.println("2 - Mostrar os clientes cadastrados");
            System.out.println("3 - Pesquisar clientes pelo nome");
            System.out.println("4 - Incluir equipamento");
            System.out.println("5 - Mostrar os equipamentos cadastrados");
            System.out.println("6 - Pesquisar equipamentos pelo nome");
            System.out.println("7 - Retirar equipamento");
            System.out.println("8 - Devolução de equipamento");
            System.out.println("9 - Total de equipamentos disponíveis");
            System.out.println("10 - Histórico de empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String addCliente=in.nextLine();
                    System.out.print("Digite a empresa do cliente: ");
                    String getEmpresa=in.nextLine();

                    Cliente novoCliente=new Cliente(cadastroCliente.getTotalClientes() + 1, addCliente, getEmpresa);
                    if (cadastroCliente.addCliente(novoCliente)){
                        System.out.println("Cliente adicionado com sucesso!");
                    } else {
                        System.out.println("Falha ao adicionar o cliente. Limite máximo de clientes atingido.");
                    }
                    break;

                case 2:
                    System.out.println("Total de clientes cadastrados: " + cadastroCliente.getTotalClientes());
                    break;

                case 3:
                    System.out.print("Digite o nome do cliente para buscar: ");
                    String buscaNomeCliente=in.nextLine();
                    Cliente clienteEncontrado=cadastroCliente.buscaClienteNome(buscaNomeCliente);

                    if (clienteEncontrado!= null){
                        System.out.println("Cliente encontrado: " + clienteEncontrado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o código do equipamento: ");
                    int codigo=in.nextInt();
                    in.nextLine();
                    System.out.print("Digite o nome do equipamento: ");
                    String nomeEquipamento = in.nextLine();
                    System.out.print("Digite o tipo de equipamento: ");
                    String tipoEquipamento=in.nextLine();
                    System.out.print("Digite a quantidade de horas que deseja locar: ");
                    int quantidadeHoras = in.nextInt();
                    in.nextLine();
                    System.out.println("Digite 1 para seguro e 0 para sem seguro:");
                    String seguroStr = in.nextLine();

                    boolean seguro = seguroStr.equals("1");

                    Equipamento novoEquipamento= new Equipamento(codigo, nomeEquipamento, tipoEquipamento, quantidadeHoras, seguro);
                    if (cadastroEquipamentos.adicionarEquipamento(novoEquipamento)){
                        System.out.println("Equipamento adicionado!");
                    } else {
                        System.out.println("Falha ao adicionar equipamento.");
                    }
                    break;

                case 5:
                    cadastroEquipamentos.listarEquipamentos();
                    break;

                case 6:
                    System.out.print("Digite o nome do equipamento para buscar: ");
                    String buscaNomeEquipamento=in.nextLine();
                    Equipamento equipamentoEncontrado=cadastroEquipamentos.buscarEquipamento(buscaNomeEquipamento);

                    if (equipamentoEncontrado != null){
                        System.out.println(equipamentoEncontrado);
                    } else {
                        System.out.println("Equipamento não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o nome do cliente: ");
                    String clienteRetiraNome=in.nextLine();
                    Cliente clienteRetira = cadastroCliente.buscaClienteNome(clienteRetiraNome);

                    if (clienteRetira.getNome() == null) {
                        System.out.println("Falha ao encontrar cliente");
                        break;
                    }

                    if (clienteRetira.getEquipamentoRetirado() != null) {
                        System.out.println("O cliente já possui um equipamento retirado");
                        break;
                    }

                    System.out.println("Digite o nome do equipamento:");
                    String equipamentoRetiraNome = in.nextLine();
                    Equipamento equipamentoRetirado = cadastroEquipamentos.buscarEquipamento(equipamentoRetiraNome);
                    if (equipamentoRetirado == null) {
                        System.out.println("Falha ao encontrar equipamento com o nome " + equipamentoRetiraNome);
                        break;
                    }

                    if (!equipamentoRetirado.isDisponivel()) {
                        System.out.println("O equipamento selecionado não está disponível");
                        break;
                    }

                    equipamentoRetirado.retirar();
                    clienteRetira.setEquipamentoRetirado(equipamentoRetirado);
                    System.out.println("O cliente " + clienteRetiraNome + " retirou o equipamento " + equipamentoRetiraNome);
                    break;


                case 8:
                    System.out.print("Digite o nome do cliente: ");
                    String clienteDevolveNome = in.nextLine();
                    Cliente clienteDevolve=cadastroCliente.buscaClienteNome(clienteDevolveNome);
                    if (clienteDevolve == null) {
                        System.out.println("Falha ao encontrar cliente");
                        break;
                    }

                    if (clienteDevolve.getEquipamentoRetirado() == null) {
                        System.out.println("Este cliente não retirou nenhum equipamento");
                        break;
                    }

                    Equipamento equipamentoDevolve=clienteDevolve.getEquipamentoRetirado();
                    equipamentoDevolve.devolver();
                    clienteDevolve.setEquipamentoRetirado(null);

                    break;

                case 9:
                    int totalDisponiveis=cadastroEquipamentos.totalEquipamentosDisponiveis();
                    System.out.println("Total de equipamentos disponíveis: " + totalDisponiveis);
                    break;

                case 10:
                    cadastroEquipamentos.mostrarHistorico();

                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao!=0);
    }
}