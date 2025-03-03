# **StockFlow - Inventory Management System**

**StockFlow** é um sistema de gerenciamento de estoque simples, desenvolvido em **Java** com uma interface gráfica utilizando **Swing**. Ele permite adicionar, remover, editar e visualizar produtos no estoque.

## **Funcionalidades**

- **Adicionar Produto**: Permite ao usuário adicionar novos produtos ao estoque, informando o nome, preço e quantidade.
- **Remover Produto**: Permite remover um produto do estoque, baseado no nome.
- **Visualizar Estoque**: Exibe todos os produtos cadastrados no estoque.
- **Editar Produto**: Permite editar a quantidade e o preço de um produto existente no estoque.

## **Estrutura do Projeto**

### **Classes**

1. **`Main`**
   - Ponto de entrada do programa.
   - Cria e exibe a janela principal da interface gráfica.

2. **`MainWindow`** (GUI)
   - Responsável pela interface gráfica do sistema.
   - Contém botões para realizar operações como adicionar, remover, editar e visualizar produtos no estoque.

3. **`Products`** (Entities)
   - Representa um produto no sistema.
   - Contém atributos como nome, preço e quantidade, além de métodos para manipular essas informações.

4. **`InventoryControl`** (Services)
   - Controla a lógica do estoque.
   - Gerencia a adição, remoção, modificação e visualização dos produtos.

## **Como Executar**

### **Requisitos**
- **JDK 8 ou superior** instalado.
- **IDE recomendada**: IntelliJ IDEA, Eclipse ou VS Code com plugin Java.

- 1. Clone o repositório:
   ```bash
   git clone https://github.com/FelipLiborio/StockFlow-project.git

Navegue até o diretório do projeto:
 
- 2. Após clonar o repositório, navegue até a pasta do projeto com o comando:

cd StockFlow

- 3. Execute a classe Main já compilada:

java -cp target/classes main.Main



# **StockFlow - Inventory Management System**

**StockFlow** is a simple inventory management system developed in **Java** with a graphical interface using **Swing**. It allows users to add, remove, edit, and view products in the inventory.

## **Features**

- **Add Product**: Allows the user to add new products to the inventory, providing the name, price, and quantity.
- **Remove Product**: Allows the user to remove a product from the inventory based on its name.
- **View Inventory**: Displays all products currently in the inventory.
- **Edit Product**: Allows the user to edit the quantity and price of an existing product in the inventory.

## **Project Structure**

### **Classes**

1. **`Main`**
   - Entry point of the program.
   - Creates and displays the main window of the graphical interface.

2. **`MainWindow`** (GUI)
   - Responsible for the graphical interface of the system.
   - Contains buttons for performing operations like adding, removing, editing, and viewing products in the inventory.

3. **`Products`** (Entities)
   - Represents a product in the system.
   - Contains attributes like name, price, and quantity, along with methods to manipulate these details.

4. **`InventoryControl`** (Services)
   - Handles the inventory logic.
   - Manages adding, removing, modifying, and viewing products.

## **How to Run**

### **Requirements**
- **JDK 8 or higher** installed.
- **Recommended IDE**: IntelliJ IDEA, Eclipse, or VS Code with the Java plugin.

1. **Clone the repository**:
    ```bash
   git clone https://github.com/FelipLiborio/StockFlow-project.git


2. After cloning the repository, go to the project folder:

cd StockFlow

3. Run the already compiled Main class:

java -cp target/classes main.Main






