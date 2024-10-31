# Calculadora de Salários e INSS

Um aplicativo Android para calcular salários e INSS de forma simples e eficiente.

## 📱 Descrição

O Calculadora de Salários e INSS permite que os usuários calculem rapidamente o valor líquido de um salário com base no salário bruto informado e nos descontos do INSS.

## 🔧 Funcionalidades
- [x] Entrada de dados (salário bruto)
- [x] Cálculo do INSS e salário líquido
- [x] Exibição detalhada dos descontos
- [x] Interface amigável e responsiva
- [x] Suporte a diferentes faixas de desconto do INSS
 
## 🚀 Tecnologias Utilizadas
- [x] **Android Studio** (Bumblebee | 2024.1.2)
- [x] **Java** para desenvolvimento
- [x] ConstraintLayout para interface responsiva
- [x] TextView e EditText para entrada e exibição de dados


## 🛠️ Como Rodar o Projeto

Siga os passos abaixo para rodar o projeto localmente:

1. Clone este repositório:
    ```bash
   https://github.com/Cassielbr/CalcularSalariosInss
    ```
2. Abra o projeto no Android Studio.

3. Compile e execute o projeto em um emulador ou dispositivo físico.

## 📂 Estrutura do Projeto
```bash
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/br/ulbra/calcularsalariosinss
│   │   │   │   ├── MainActivity.java                   # Atividade principal com cálculo de salário
│   │   │   │   ├── SalaryCalculator.java               # Lógica para cálculo de salários e INSS
│   │   │   ├── res
│   │   │   │   ├── drawable
│   │   │   │   │   ├── calculator.png                 # Ícone do aplicativo
│   │   │   │   │   ├── money.png                      # Ícone representativo de dinheiro
│   │   │   │   │   ├── gender.png                     # Ícone para seleção de gênero
│   │   │   │   │   ├── baby.png                       # Ícone opcional para interface
│   │   │   │   │   ├── name.png                       # Ícone para interface nome
│   │   │   │   │   ├── button1_background.xml         # Fundo personalizado para botões
│   │   │   │   │   ├── button2_background.xml         # Outro fundo para botões
│   │   │   │   │   ├── button_selector.xml            # Selector para estados dos botões
│   │   │   │   │   ├── ic_launcher_background.xml      # Fundo do ícone do aplicativo
│   │   │   │   │   └── ic_launcher_foreground.xml      # Ícone em primeiro plano do aplicativo
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_main.xml              # Layout da tela principal
│   │   │   │   └── values
│   │   │   │       ├── strings.xml                    # Strings usadas no app
│   │   │   │       ├── colors.xml                     # Cores definidas no projeto
│   │   │   │       ├── dimens.xml                     # Dimensões utilizadas no layout
│   └── build.gradle                                   # Configuração do Gradle
└── README.md                                          # Este arquivo

```

# 🖥️ Telas do Aplicativo. 
## Tela Principal
![image](https://github.com/Cassielbr/CalcularSalariosInss/blob/master/assets/Principal.png)

## Tem Filhos
![image](https://github.com/Cassielbr/CalcularSalariosInss/blob/master/assets/tem%20filhos.png)

## 👨‍💻 Desenvolvedores – 
**Cassiel** - Desenvolvedor - [GitHub](https://github.com/Cassielbr)

## 📄 Licença 
Este projeto está licenciado sob os termos da licença MIT. Para mais detalhes, veja o arquivo [LICENSE](https://github.com/Cassielbr/CalcularSalariosInss/blob/master/LICENSE).
