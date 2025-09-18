# Sistema de Transporte - Java + Swing + SQLite

Este é meu primeiro projeto em Java 🚀.  
Ele implementa um **sistema de transporte** com interface gráfica em **Swing**, persistência em **SQLite** e organização em camadas (DAO, Model, UI).

## ✨ Funcionalidades
- **Gestor**
  - Cadastro de usuários, veículos e rotas
  - Geração de relatórios
- **Aluno**
  - Marcar presença
  - Consultar horários
- **Motorista**
  - Iniciar e encerrar viagens
- **Autenticação de usuários** com perfis (Aluno, Motorista, Gestor)

## 🛠 Tecnologias
- [Java 17+](https://www.oracle.com/java/)
- [Swing](https://docs.oracle.com/javase/tutorial/uiswing/)
- [SQLite](https://www.sqlite.org/)
- [Maven](https://maven.apache.org/)

## 📂 Estrutura do Projeto
```
Trabalho A3/
 ├── src/
 │   ├── main/java/
 │   │   ├── dao/         # Acesso a dados (Rota, Usuario, Veiculo)
 │   │   ├── database/    # Conexão com SQLite
 │   │   ├── model/       # Entidades: Usuario, Aluno, Motorista, Gestor, Rota, Veiculo
 │   │   ├── ui/          # Telas Swing (Login, Cadastro, Relatórios)
 │   │   └── org/example/ # Main.java
 │   └── main/resources/  # Recursos do sistema
 ├── database.db          # Banco de dados SQLite
 ├── pom.xml              # Configurações Maven
 └── .gitignore
```

## ▶️ Como executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-transporte-java.git
   cd sistema-transporte-java/Trabalho\ A3
   ```
2. Compile e execute com Maven:
   ```bash
   mvn clean package
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```
   ou execute diretamente pelo IntelliJ/Eclipse.

## 📊 Banco de Dados
O sistema usa **SQLite** (arquivo `database.db`).  
As tabelas são criadas automaticamente ao rodar o programa.

👨‍💻 Desenvolvido como projeto acadêmico (A3).
