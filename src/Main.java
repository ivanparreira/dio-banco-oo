import java.util.Scanner;

import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.ContaCorrente;
import br.com.model.ContaPoupanca;

public class Main {

	public static void main(String[] args) {


		Cliente cliente = new Cliente();
		Scanner scan = new Scanner(System.in);
		int tipoOperacao = 0;
		int continuarOp = 1;
        
		
		
		System.out.println("Insira o nome do Cliente:");
		cliente.setNome(scan.nextLine());
		
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		do {
			
			System.out.println("\nInsira 1 para DEPÓSITO ou 2 para TRANSFERÊNCIA POUPANÇA:");
			tipoOperacao = scan.nextInt();
		
			switch (tipoOperacao) {
			case 1:
				System.out.println("\nInsira o valor a ser depósito: ");
				cc.depositar(scan.nextDouble());
				break;
			case 2:
				System.out.println("\nInsira o valor a ser transferido para poupança: ");
				cc.transferir(scan.nextDouble(), poupanca);
				break;

			default:
				System.out.println("\nOpção inválida!");
				break;
			}
		
			cc.imprimirExtrato();
			poupanca.imprimirExtrato();
			
			System.out.println("\n*****************************************************\n");
			
			System.out.println("Digite 0 para encerrar a operação ou 1 para continuar: ");
			continuarOp = scan.nextInt();
		} while (continuarOp != 0);
		
		
	}

}
