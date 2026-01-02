import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;


public class ContaBanco {

    static int contadorConta =0;
    static int contadorAgencia=0;
    static boolean sair = false;

    static class Conta{
        String firstName;
        String LastName;
        BigDecimal Saldo ;
        int numeroAgencia;
        int numeroConta;

        Conta(String firstName, String LastName, BigDecimal saldo, int numeroAgencia, int numeroConta){
            this.firstName=firstName;
            this.LastName=LastName;
            this.Saldo=saldo;
            this.numeroAgencia=numeroAgencia;
            this.numeroConta=numeroConta;
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Conta> Banco = new ArrayList<>();
        MathContext metodoOperacaoMatematica = new MathContext(16,RoundingMode.HALF_EVEN);

        do{
            int opcao;
            System.out.println("\n Escolha uma opção:");
            System.out.println("\n 1 - Criar Conta\n 2 - Depositar\n 3 - Saque\n 4 - Transferir\n 5 - Consultar Saldo\n 6 - Sair\n");
            opcao = Integer.parseInt(scan.nextLine());

            if(opcao==1){
                System.out.println("Digite o nome completo ex.: Fulano de Tal :");

                String fullname= scan.nextLine();

                if(fullname.length()<=0){
                    System.out.println("o nome nao pode ser vazio!\n");
                }

                String[] nomeCompleto =fullname.trim().split("\\s+");

                String firstName=nomeCompleto[0];
                String lastName= "";
                if(nomeCompleto.length>1){
                    for(int i=1; i<nomeCompleto.length;i++){
                       lastName = lastName.concat(" ").concat(nomeCompleto[i]);
                 }
                }
                Conta novaConta= new Conta(
                    firstName, 
                    lastName, 
                    BigDecimal.ZERO, 
                    ++ContaBanco.contadorAgencia, 
                    ++ContaBanco.contadorConta);
                
                Banco.add(novaConta);
                System.out.println("Conta Criada com sucesso para o Cliente: "+ firstName + "" + lastName);
                System.out.println("Agencia:"+novaConta.numeroAgencia);
                System.out.println("conta:"+novaConta.numeroConta);  

            }else if(opcao==2){
                int numeroAgencia=0;
                int numeroConta=0;
                BigDecimal valorDeposito=BigDecimal.ZERO;

                System.out.println("Digite o numero da Agencia:");
                numeroAgencia = Integer.parseInt(scan.nextLine());

                System.out.println("Digite o numero da Conta:");
                numeroConta = Integer.parseInt(scan.nextLine());

                System.out.println("Digite o valor do Deposito: ex.: 10.50");
                String valorDepositoString = scan.nextLine().replace(",", ".");
                valorDeposito = new BigDecimal(valorDepositoString);

                if(valorDeposito.compareTo(BigDecimal.ZERO) >0){
                   boolean isDepositado = false;

                   for (Conta conta : Banco) {
                        if(conta.numeroAgencia==numeroAgencia && conta.numeroConta==numeroConta){
                            
                            conta.Saldo= conta.Saldo.add(valorDeposito,metodoOperacaoMatematica).setScale(2,RoundingMode.HALF_EVEN);
                            isDepositado = true;
                            break;
                        }
                   }
                   if (isDepositado) System.out.println("Transação realizada com sucesso!");
                   else System.out.println("Conta nao encontrada!");

                }else System.out.println("Valor "+valorDeposito + " Invalido!");

            }else if(opcao==3){
              int numeroAgencia = 0;
              int numeroConta = 0;
              BigDecimal valorSaque = BigDecimal.ZERO;  

              System.out.println("Digite o numero da Agencia:");
              numeroAgencia= Integer.parseInt(scan.nextLine());

              System.out.println("Digite o numero da Conta:");
              numeroConta = Integer.parseInt(scan.nextLine());

              System.out.println("Digite o Valor do saque: ex.: 100,00");

              String valorsaqueString = scan.nextLine().replace(",", ".");
              valorSaque = new BigDecimal(valorsaqueString).setScale(3,RoundingMode.HALF_EVEN);


              if(valorSaque.compareTo(BigDecimal.ZERO) > 0){
                boolean contaAptaParaSaque = false;
                

                for (Conta conta : Banco) {
                    if(conta.numeroAgencia==numeroAgencia && conta.numeroConta==numeroConta && conta.Saldo.compareTo(valorSaque) >=0){
                        conta.Saldo = conta.Saldo.subtract(valorSaque, metodoOperacaoMatematica).setScale(2,RoundingMode.HALF_EVEN);
                        contaAptaParaSaque = true;
                        break;
                    }
                }

                if(contaAptaParaSaque) System.out.println("Saque realizado com Sucesso!");
                else  System.out.println("Conta nao encontrada ou nao apta para essa operação!");

                }else System.out.println("Valor Saque Inválido!");
              
            }else if(opcao == 4){
                try {
                    int numeroAgenciaOrigem;
                    int numeroContaOrigem;

                    int numeroContaDestino;
                    int numeroAgenciaDestino;

                    BigDecimal valorTransferencia;



                    System.out.println("Digite o numero da Agencia de Origem:");
                    numeroAgenciaOrigem = Integer.parseInt(scan.nextLine());

                    System.out.println("Digite o numero da Conta de Origem:");

                    numeroContaOrigem = Integer.parseInt(scan.nextLine());

                    System.out.println("Digite o numero da Agencia de destino:");
                    numeroAgenciaDestino = Integer.parseInt(scan.nextLine());

                    System.out.println("Digite o numero da Conta de destino:");
                    numeroContaDestino = Integer.parseInt(scan.nextLine());

                    System.out.println("Digite o Valor da transferencia:");
                    String valorTransferenciaNormalizado = scan.nextLine();
                    valorTransferencia = new BigDecimal(valorTransferenciaNormalizado).setScale(2,RoundingMode.HALF_EVEN);

                    boolean contaOrigemAptaParaTransferencia = false;
                    boolean contaDestinoAptaparaTransferencia = false;
                    
                    if (valorTransferencia.compareTo(BigDecimal.ZERO) == 0) {
                        throw new IllegalArgumentException("o valor " + valorTransferencia + " não tem um aspecto valido para essa transação!");
                    }
                    
                    for (Conta conta : Banco) {
                        if(numeroAgenciaOrigem == conta.numeroAgencia && numeroContaOrigem == conta.numeroConta ){
                            if(conta.Saldo.compareTo(valorTransferencia) >= 0){
                                contaOrigemAptaParaTransferencia = true;
                                for (Conta conta2 : Banco) {
                                    if(conta2.numeroAgencia == numeroAgenciaDestino && conta2.numeroConta == numeroContaDestino ){
                                        contaDestinoAptaparaTransferencia = true;
                                        conta.Saldo = conta.Saldo.subtract(valorTransferencia,metodoOperacaoMatematica).setScale(2, RoundingMode.HALF_EVEN);
                                        conta2.Saldo = conta2.Saldo.add(valorTransferencia, metodoOperacaoMatematica).setScale(2,RoundingMode.HALF_EVEN);
                                        break;

                                    }
                                }
                            }else{
                                throw new IllegalArgumentException("Saldo Insuficiente!");
                            }
                        break;
                        }
                    }

                    if(!contaOrigemAptaParaTransferencia || !contaDestinoAptaparaTransferencia){
                        System.out.println("Conta Origem ou Destino nao encontrada!");
                    }else System.out.println("Tranferencia realizada com sucesso!");

                    


                    
                } catch (Exception e) {
                    System.out.println("error na operacao : "+e.getMessage());
                    // TODO: handle exception
                }
                



            }else if(opcao==5){
                int numeroAgencia;
                int numeroConta;
                System.out.println("Digite o numero da agencia:\n");

                numeroAgencia = Integer.parseInt(scan.nextLine());

                System.out.println("Digite o numero da Conta:\n");
                numeroConta= Integer.parseInt(scan.nextLine());
                Conta contaProcurada= null;

                for(Conta c: Banco){
                    if(c.numeroAgencia==numeroAgencia && c.numeroConta==numeroConta){
                        contaProcurada = c;
                        break;
                    }
                }

                if (contaProcurada==null) System.out.println("Conta Não encontrada!");
                else System.out.println("Saldo: R$ "+contaProcurada.Saldo);
            }else if(opcao==6) {
                sair=true;
                System.out.println(System.getProperty("os.name"));
                System.out.println("Saindo ...");                 
               //for (int i = 0; i < 50; i++) System.out.println();
                //System.out.print("\033[H\033[2J");
                scan.close();
            }else System.out.println("opção Inválida!");

            Thread.sleep(1700);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
        } while (sair!=true);

    }
}
