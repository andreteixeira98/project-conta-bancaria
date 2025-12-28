ContaBanco
Este é um projeto em Java desenvolvido como parte do Bootcamp Bradesco 2025, proposto pela DIO (Digital Innovation One). O programa simula uma aplicação bancária básica que permite ao usuário realizar várias operações financeiras e gerenciar sua conta.

📝 Funcionalidades
O sistema oferece as seguintes opções:
- Abrir Conta: Permite ao usuário criar uma nova conta bancária, fornecendo informações como nome, sobrenome e número da agência.
- Realizar Depósito: O usuário pode adicionar um valor ao saldo da conta.
- Realizar Saque: Permite retirar valores da conta, desde que haja saldo suficiente.
- Transferência: Realizar transferência para outra conta, mediante saldo disponível.
- Consultar Saldo: Exibe o saldo atual da conta.
- Sair: Encerra o sistema.

🚀 Tecnologias Utilizadas
- Java: Linguagem de programação usada no desenvolvimento do sistema.
- Scanner: Utilizado para entrada de dados do usuário.
- Lógica de Programação: Implementação de controle de fluxo com switch e while.

🛠️ Pré-requisitos
- JDK 15 ou superior (para suporte a strings multilinhas com """).
- Editor ou IDE (exemplo: Visual Studio Code, Eclipse).
- Git (caso deseje gerenciar o código-fonte com versionamento).

💻 Como Executar
- Clone o repositório:git clone https://github.com/seu-usuario/ContaBanco.git

- Compile e Execute o código: Navegue até o diretório do projeto e compile o arquivo Java:javac ContaBanco.java
java ContaBanco


🗂 Estrutura do Projeto
ContaBanco/
├── .vscode/              # Configurações do VSCode
├── bin/                  # Arquivos compilados
├── src/                  # Código-fonte Java
│   └── ContaBanco.java   # Classe principal
├── README.md             # Documentação do projeto


📜 Fluxo do Programa
- O programa exibe um menu com as opções disponíveis.
- O usuário escolhe uma opção fornecendo o número correspondente.
- O sistema executa a operação escolhida (com validações, como saldo suficiente).
- Após cada operação, o menu é exibido novamente até que o usuário opte por sair.

📖 Exemplo de Uso
Exemplo: Consultar saldo atual.
Escolha entre uma das opcoes abaixo:
1) Abrir conta
2) Realizar Deposito
3) Realizar Saque
4) Transferencia
5) Saldo
6) Sair
> 5
Seu saldo atual e de R$: 1000.00



🤝 Contribuição
Contribuições são bem-vindas! Para sugerir melhorias ou relatar problemas, abra uma issue ou envie um pull request.
📄 Licença
Este projeto está licenciado sob a MIT License.

