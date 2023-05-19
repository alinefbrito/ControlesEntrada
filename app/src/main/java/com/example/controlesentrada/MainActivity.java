package com.example.controlesentrada;

import static com.example.controlesentrada.R.id.rdBtn1;
import static com.example.controlesentrada.R.id.rdBtn2;
import static com.example.controlesentrada.R.id.rdBtn3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	
	//componentes de tela(views) implementados na activity
    TextView resultado;
    ToggleButton toggle;
    SwitchCompat switcher;
    RadioButton rbd1, rbd2,rbd3;
    CheckBox chk1, chk2,chk3;
    Spinner sp;
    List<String> list;
    Button btn;
    EditText vlr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.textView3);
        toggle = (ToggleButton) findViewById(R.id.toggleButton);
        switcher = (SwitchCompat) findViewById(R.id.swtValor);
        rbd1 = findViewById(rdBtn1);
        rbd2 = findViewById(rdBtn2);
        rbd3 = findViewById(rdBtn3);
        chk1 = findViewById(R.id.chkValor1);
        chk2 = findViewById(R.id.chkValor2);
        chk3 = findViewById(R.id.chkValor3);
        btn = findViewById(R.id.button);
        vlr = findViewById(R.id.editTextEntr);
        //adiciona a ação de um evento via código
        // se não for definido nas propriedades do elemento deve constar no onCreate
        defineListeners();
        alimentaSpinner();
        //cria uma lista que receberá os valores


    }

    //demonstração de evento de click do Botão
    public void botaoClick(View v)
    {

    }
    public void checkboxClick(View view) {

        String check = "";

        if (chk1.isChecked()) {
            check = check.concat("Checkbox 1 Selecionado \n");
        }

        if (chk2.isChecked()) {
            check = check.concat("Checkbox 2 Selecionado \n");
        }
        if (chk3.isChecked()) {
            check = check.concat("Checkbox 3 Selecionado \n");
        }
        if (check.equals(""))
            check = " Nenhum checkbox foi selecionado";


        resultado.setText(check);
    }

    public void radioBtnClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        String check = "";
        // Check which radio button was clicked
        switch(view.getId()) {
            case rdBtn1:
                if (checked)
                {
                    check = check.concat("Radio Button 1 Selecionado \n");
                }
                    break;
            case rdBtn2:
                if (checked)
                {
                    check = check.concat("Radio Button 2 Selecionado \n");
                }
                break;
            case rdBtn3:
                    if (checked) {
                        check = check.concat("Radio Button 3 Selecionado \n");
                    }
                    break;


        }
        resultado.setText(check);
    }

    public void switchClick(View v) {
        if (switcher.isChecked())
            resultado.setText(R.string.switch_ligado);
        else
            resultado.setText(R.string.switch_desligado);

    }

    public void defineListeners() {

        //toggle listener
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                resultado.setText(R.string.toggle_button_ligado);
            } else {
                resultado.setText(R.string.toggle_button_desligado);
            }
        });

        btn.setOnClickListener(v -> {
            String texto = String.valueOf(vlr.getText());
            Toast.makeText(MainActivity.this, "Texto da EditText é: " + texto, Toast.LENGTH_LONG).show();
        });
    }

    public void alimentaSpinner() {
        list = new ArrayList<>();
        list.add("Vermelho");
        list.add("Verde");
        list.add("Azul");
        sp = findViewById(R.id.spinnerCores);
        spinerAddItens();
        spinerListener();
    }

    public void spinerAddItens() {


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);

    }

    public void spinerListener() {
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
                if (position >= 0 && position < (list.size() - 1)) {
                    resultado.setText(list.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
