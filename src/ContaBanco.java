import java.io.IOException;
import java.math.BigDecimal;
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
                        lastName.concat(" ").concat(nomeCompleto[i]);
                 }
                }


                Conta novaConta= new Conta(
                    firstName, 
                    lastName, 
                    BigDecimal.ZERO, 
                    ++ContaBanco.contadorAgencia, 
                    ++ContaBanco.contadorConta);
                
                Banco.add(novaConta);
                //TO DO
                System.out.println("Conta Criada com sucesso para o Cliente: "+ firstName + "" + lastName);
                System.out.println("Agencia:"+novaConta.numeroAgencia);
                System.out.println("conta:"+novaConta.numeroConta);

                

            }

            else if(opcao==5){


                int numeroConta= 0;
                int numeroAgencia =0;
                System.out.println("Digite o numero da agencia:\n");

                numeroAgencia = Integer.parseInt(scan.nextLine());

                System.out.println("Digite o numero  da Conta:\n");
                numeroConta= Integer.parseInt(scan.nextLine());

                Conta contaProcurada= null;

                for(Conta c: Banco){
                    if(c.numeroAgencia==numeroAgencia && c.numeroConta==numeroConta){
                        contaProcurada = c;
                        break;
                    }
                }

                if (contaProcurada==null) {
                    System.out.println("Conta Não encontrada!");
                }else{
                    System.out.println("Saldo: R$ "+contaProcurada.Saldo);
                }
            }

            else if(opcao==6) {
                sair=true;
                System.out.println("Saindo ... ");
                System.out.println(System.getProperty("os.name"));
                Thread.sleep(2000);
               for (int i = 0; i < 60; i++) System.out.println();
                //System.out.print("\033[H\033[2J");
                scan.close();
            }
            

        } while (sair!=true);

        


        


        }

    
}
