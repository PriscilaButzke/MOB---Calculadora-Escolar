package br.ulbra.appescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nome, disciplina, numAulas, numFaltas, n1, n2;
    Button BResultado, btnLimpar;
    TextView TResultado;

    public void iniciarComponentes() {
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.edtNome);
        disciplina = findViewById(R.id.edtDisciplina);
        numAulas = findViewById(R.id.edtNumAulas);
        numFaltas = findViewById(R.id.edtNumFaltas);
        n1 = findViewById(R.id.edtNota1);
        n2 = findViewById(R.id.edtNota2);
        TResultado = findViewById(R.id.txtResultado);
        btnLimpar = findViewById(R.id.btnLimpar);
        BResultado = findViewById(R.id.btnResultado);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniciarComponentes();
        BResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double media, freq, nota2, nota1, faltas, aulas;

                nota1 = Double.parseDouble(n1.getText().toString());
                nota2 = Double.parseDouble(n2.getText().toString());
                faltas = Double.parseDouble(numFaltas.getText().toString());
                aulas = Double.parseDouble(numAulas.getText().toString());

                media = (nota1 * 2 + nota2 * 4) / 6;
                freq = (aulas - faltas) / aulas * 100;

                if (media >= 7 && freq > 75) {
                    TResultado.setText("Nome do aluno: " + nome.getText() + "\nDisciplina: " + disciplina.getText()
                            + "\nSituação: " + "Aprovado" + "\nMédia: " + media + "\nFrequência: " + freq);
                } else {
                    TResultado.setText("Nome do aluno: " + nome + "\nDisciplina: " + disciplina + "\nSituação: " + "Reprovado"
                            + "\nMédia: " + media + "\nFrequência: " + freq);
                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome.setText("");
                disciplina.setText("");
                numAulas.setText("");
                numFaltas.setText("");
                n1.setText("");
                n2.setText("");
                TResultado.setText("");

                Toast.makeText(MainActivity.this, "Limpo com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}