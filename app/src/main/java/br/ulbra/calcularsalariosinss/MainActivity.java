package br.ulbra.calcularsalariosinss;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNome, etSalarioBruto, etFilhos;
    RadioGroup radioSexo, radioFilhos;
    RadioButton rbMasculino, rbFeminino, rbTemFilhos, rbNaoTemFilhos;
    Button btnCalcular;
    TextView tvResultado;
    ImageView icFilhos; // Imagem de filhos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes
        etNome = findViewById(R.id.etNome);
        etSalarioBruto = findViewById(R.id.etSalarioBruto);
        etFilhos = findViewById(R.id.etFilhos);
        radioSexo = findViewById(R.id.radioSexo);
        radioFilhos = findViewById(R.id.radioFilhos);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFeminino = findViewById(R.id.rbFeminino);
        rbTemFilhos = findViewById(R.id.rbTemFilhos);
        rbNaoTemFilhos = findViewById(R.id.rbNaoTemFilhos);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        icFilhos = findViewById(R.id.icFilhos); // Inicializando a imagem de filhos

        // Exibe ou oculta o campo de número de filhos
        radioFilhos.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbTemFilhos) {
                etFilhos.setVisibility(View.VISIBLE);
                icFilhos.setVisibility(View.VISIBLE); // Exibe a imagem de filhos
            } else {
                etFilhos.setVisibility(View.GONE);
                icFilhos.setVisibility(View.GONE); // Oculta a imagem de filhos
            }
        });
    }

    public void calcularSalario(View view) {
        try {
            String nome = etNome.getText().toString().trim();
            double salarioBruto = Double.parseDouble(etSalarioBruto.getText().toString().trim());
            int numFilhos = 0;

            // Verifica se o usuário tem filhos
            if (rbTemFilhos.isChecked()) {
                numFilhos = Integer.parseInt(etFilhos.getText().toString().trim());
            }

            if (nome.isEmpty()) {
                Toast.makeText(this, "Por favor, insira o nome do funcionário.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (salarioBruto <= 0 || (rbTemFilhos.isChecked() && numFilhos < 0)) {
                Toast.makeText(this, "Por favor, insira valores válidos para salário e número de filhos.", Toast.LENGTH_SHORT).show();
                return;
            }

            double descontoINSS = calcularINSS(salarioBruto);
            double descontoIR = calcularIR(salarioBruto);
            double salarioFamilia = calcularSalarioFamilia(salarioBruto, numFilhos);

            double salarioLiquido = salarioBruto - (descontoINSS + descontoIR) + salarioFamilia;

            String saudacao = (radioSexo.getCheckedRadioButtonId() == R.id.rbMasculino) ? "Sr. " : "Sra. ";

            // Exibe os resultados, incluindo a quantidade de filhos
            tvResultado.setText(String.format("Nome: %s%s\nINSS: R$ %.2f\nIR: R$ %.2f\nSalário Família: R$ %.2f\nSalário Líquido: R$ %.2f\nNúmero de Filhos: %d",
                    saudacao, nome, descontoINSS, descontoIR, salarioFamilia, salarioLiquido, numFilhos));

        } catch (Exception e) {
            Toast.makeText(this, "Erro ao calcular. Verifique os dados inseridos.", Toast.LENGTH_SHORT).show();
        }
    }

    // Funções para cálculos do INSS, IR e Salário Família
    private double calcularINSS(double salarioBruto) {
        double desconto = 0;
        if (salarioBruto <= 1212.00) {
            desconto = salarioBruto * 0.075;
        } else if (salarioBruto <= 2427.35) {
            desconto = salarioBruto * 0.09;
        } else if (salarioBruto <= 3641.03) {
            desconto = salarioBruto * 0.12;
        } else if (salarioBruto <= 7087.22) {
            desconto = salarioBruto * 0.14;
        }
        return desconto;
    }

    private double calcularIR(double salarioBruto) {
        double desconto = 0;
        if (salarioBruto > 1903.98 && salarioBruto <= 2826.65) {
            desconto = salarioBruto * 0.075;
        } else if (salarioBruto > 2826.65 && salarioBruto <= 3751.05) {
            desconto = salarioBruto * 0.15;
        } else if (salarioBruto > 3751.05 && salarioBruto <= 4664.68) {
            desconto = salarioBruto * 0.225;
        } else if (salarioBruto > 4664.68) {
            desconto = salarioBruto * 0.275; // Ajustei para incluir a faixa acima de R$ 4664.68
        }
        return desconto;
    }

    private double calcularSalarioFamilia(double salarioBruto, int numFilhos) {
        if (salarioBruto <= 1212.00) {
            return numFilhos * 56.47;
        }
        return 0;
    }

    // Função para limpar os campos
    public void limparCampos(View view) {
        etNome.setText("");
        etSalarioBruto.setText("");
        etFilhos.setText("");
        radioSexo.clearCheck();
        radioFilhos.clearCheck();
        icFilhos.setVisibility(View.GONE);
        tvResultado.setText("Resultado será exibido aqui");
    }
}
